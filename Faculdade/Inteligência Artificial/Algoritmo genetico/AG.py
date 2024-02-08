from functools import total_ordering
from typing import*
import math 
import random
import numpy as np
import matplotlib.pyplot as plt
from matplotlib import cm
from mpl_toolkits.mplot3d import Axes3D

def  f_objetivo(x)->float:
    result=1
    try:
      for i in range(len(x)):
        result*=x[i]**(1/2)*math.sin(x[i])
    except TypeError:
      result*=x**(1/2)*math.sin(x)
    return result
    
def coin_flip():
  return (-1)**random.randrange(1,3)

@total_ordering
class Amostra:
  def __init__(self,x:tuple()):
    self.x=np.array(x)

  @property
  def aptidao(self):
    return f_objetivo(self.x)
    
  def __lt__(self,other:object) -> bool:
    return self.aptidao<other.aptidao
  def __eq__(self, other: object) -> bool:
      return self.aptidao==other.aptidao
  def __str__(self):
    return f'{self.x} -> {self.aptidao}'
  def __repr__(self):
    return str(self);

class Populacao:
    def __init__(self,n:int=2,limite_inf:float=0.0,limite_sup:float=10.0,quantidade:int=20,max=True):
        self.n=n
        self.limite_inf=limite_inf
        self.limite_sup=limite_sup
        self.quantidade=quantidade
        self.max=max
        self.population=[]

    def iniciar_p(self):
        while len(self.population)<self.quantidade:
          tmp=[]
          for i in range(self.n):
            tmp.append(self.limite_inf+self.limite_sup*random.random())
          candidata=Amostra(tmp.copy())
          if candidata not in self.population:
            self.population.append(candidata)

    def normalizacao(self,rank:int):
          min=1.0
          max=100
          return min+(max- min)*(self.quantidade-rank)/(self.quantidade-1)

    def ranking(self):
        dict_rank={}
        l_rank=self.population.copy()
        l_rank.sort(reverse=self.max)
        for i in range(len(l_rank)):
          dict_rank[i+1]=l_rank[i],self.normalizacao(i+1)
        return dict_rank

x=[]
x.append(np.outer(np.linspace(0, 10, 30), np.ones(30)))
x.append(x[0].T)
z =np.sin(x[0])*np.sqrt(x[0])*np.sin(x[1])*np.sqrt(x[1])

def plot_alpine():
    fig = plt.figure()
    ax = plt.axes(projection='3d')

    ax.plot_surface(x[0], x[1], z,cmap='viridis', edgecolor='none')
    ax.set_title('Alpine n=2')
    plt.show()

def plotarCN(populacao:List[Amostra]=[]):
  fig,ax=plt.subplots(1,1)
  cp = ax.contourf(x[0], x[1],z)
  fig.colorbar(cp) # Add a colorbar to a plot
  if len(populacao)>0:
    for i in range(len(populacao)-1):
      plt.plot(populacao[i+1].x[0],populacao[i+1].x[1],"m*")
      #print(i)
    plt.plot(populacao[0].x[0],populacao[0].x[1],"k*",label='melhor')
    plt.legend()
    

  ax.set_title('Filled Contours Plot')
  fig.set_figheight(8)
  fig.set_figwidth(12)
  ax.set_xlabel('x1')
  ax.set_ylabel('x2')

  
  plt.show()

class Genetico:
    def __init__(self,populacao,taxa_cross:float=0.7,taxa_mutacao:float=0.05,elitismo=False):
        self.populacao=populacao
        self.taxa_cross=taxa_cross
        self.taxa_mutacao=taxa_mutacao
        self.alfa=self.alfa()
        self.elitismo=elitismo
        self.dict_rank={}

    def alfa(self):
        return random.random()

    def roleta(self,mostrar):
        l_somada=[]
        soma_atual=0
        self.dict_rank=self.populacao.ranking()
        for i in range(len(self.dict_rank)):
          soma_atual+=self.dict_rank[i+1][1]
          l_somada.append(soma_atual)
        sorteio=random.random()*soma_atual
        if mostrar:
            print(sorteio)
            print(l_somada)
        for i in range(len(l_somada)):
          if l_somada[i]>=sorteio:
            return i+1

    def selecao(self,mostrar=False):
        selecionados=[]
        while len(selecionados)<self.populacao.quantidade:
          selecionados.append(self.roleta(mostrar))
        return selecionados

    def crossover(self,selecionados,mostrar=False):
        filhos=[]
        #print(f'seleção: {selecionados}')
        if mostrar:
            print(f'alfa:{self.alfa}')
        if self.elitismo:
          filhos.append(self.dict_rank[1][0])
          #print(f'Selecionado por elitismo {filhos[0].x}')
        for i in range(math.floor(len(selecionados)/2)):
          #print(f'pais: {selecionados[2*i]}--{selecionados[2*i+1]}')
          if random.random() < self.taxa_cross:
            if mostrar:
                print('Cross')
            P1=self.dict_rank[selecionados[2*i]][0]
            P2=self.dict_rank[selecionados[2*i+1]][0]
            if mostrar:
                print(P1.x,P2.x)
            v_alfa=np.array([self.alfa,1-self.alfa])
            M_pais = np.array([P1.x,P2.x]).T
            F1=Amostra(M_pais.dot(v_alfa))
            F2=Amostra(M_pais.dot(1-v_alfa))
          else:
            if mostrar:
                print('Not Cross')
            F1=self.dict_rank[selecionados[2*i]][0]
            F2=self.dict_rank[selecionados[2*i+1]][0]
            if mostrar:
                print(F1.x,F2.x)
          filhos.append(F1)
          filhos.append(F2)

        if self.elitismo:
          filhos.sort(reverse=True)
          #print(f'removendo o ponto -->{filhos[-1]}')
          filhos=filhos[:-1]
        #print(f'filhos:')
        #for filho in filhos:
          #print(filho)
        return filhos

    def mutacao(self,filhos,delta,mostrar=False):
        try:
          for filho in range(len(filhos)):
            for coordenada in range(len(filhos[filho].x)):
              if random.random() < self.taxa_mutacao:
                if mostrar:
                    print(f'filho {filhos[filho].x} mutou para ',end='')
                x_delta=filhos[filho].x[coordenada]+coin_flip()*delta*filhos[filho].x[coordenada]
                if x_delta > self.populacao.limite_sup:
                  x_delta=self.populacao.limite_sup
                elif x_delta < self.populacao.limite_inf:
                  x_delta = self.populacao.limite_inf
                filhos[filho].x[coordenada]=x_delta
                if mostrar:
                    print(filhos[filho].x)
        except TypeError: # caso a amostra tenha apenas uma coordenada
          for filho in range(len(filhos)):
             if random.random() < self.taxa_mutacao:
               #print(f'filho {filhos[filho].x} mutou para ',end='')
               x_delta=filhos[filho].x+coin_flip()*delta*filhos[filho].x
               if x_delta > self.populacao.limite_sup:
                  x_delta=self.populacao.limite_sup
               elif x_delta < self.populacao.limite_inf:
                  x_delta = self.populacao.limite_inf
               filhos[filho].x=x_delta
               #print(filhos[filho].x)
        #print('Mutação:')
        return filhos

    def new_generation(self,delta_mutacao):
        selecionados=self.selecao()
        filhos=self.crossover(selecionados)
        mutados=self.mutacao(filhos,delta_mutacao)
        self.populacao.population=mutados

def rodar_genetico(g,p,geracao,melhores,piores,medias,lista):
  geracao +=1
  g.new_generation(random.random()/5)
  p.population.sort(reverse=True)
  lista=p.population
  melhores[geracao] = lista[0].aptidao
  piores[geracao] = lista[-1].aptidao
  soma=0
  for amostra in lista:
    soma+=amostra.aptidao
  medias[geracao] = soma/len(lista)
  print(geracao)
  print(f'melhor:{lista[0]}')
  print(f'{melhores[geracao]}\n{piores[geracao]}\n{medias[geracao]}')
  plotarCN(lista)
  return geracao  



