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
  @property
    
  def __lt__(self,other:object) -> bool:
    return self.aptidao<other.aptidao
  def __eq__(self, other: object) -> bool:
      return self.aptidao==other.aptidao
  def __str__(self):
    return f'{self.x} -> {self.aptidao}'
  def __repr__(self):
    return str(self);

class Populacao:
  def __init__(self,quantidade:int,n:int=2,limite_inf:float=0.0,limite_sup:float=10.0,max=True):
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


def selecao(n1:int, p:Populacao):
  selecao=p.population.copy()
  selecao.sort(reverse=True)
  selecao = selecao[:n1]
  return selecao

def clones(original:Tuple[float,float],Nc:int):
  lista_clone=[]
  for i in range(int(Nc)):
    lista_clone.append(Amostra(original))
  return lista_clone

def normalizacao(rank:int, N:int, max:float, min:float):
      return min+(max- min)*(N-rank)/(N-1)

def mutacao(selecionados:List['Amostra'], rho:float, Nc:int, N:int,max:float, min:float):
  Dmax=max
  mutados=[]
  for rank,amostra in enumerate(selecionados):
    melhor=amostra
    #print(f'individuo {rank+1}: {melhor}')
    D=normalizacao(rank+1,N,max,min)/Dmax
    l_rank=clones(amostra.x,Nc)
    alfa=math.exp(-rho*D)
    #print(alfa)
    for ind in l_rank:
      if random.random()<alfa:
        delta= random.random()/5 # delta de .0 a .2  
        #print(f'mutou x1 ,delta {delta}')
        tmpx1=coin_flip()*delta*ind.x[0]+ind.x[0]
        if tmpx1<0:
          tmpx1=0.0
        elif tmpx1>10.0:
          tmpx1=10.0
        ind.x[0]=tmpx1
      if random.random()<alfa:
        delta= random.random()/5 # delta de .0 a .2  
        #print(f'mutou x2 ,delta {delta}')
        tmpx2=coin_flip()*delta*ind.x[1]+ind.x[1]
        if tmpx2<0:
          tmpx2=0.0
        elif tmpx2>10.0:
          tmpx2=10.0
        ind.x[1]=tmpx2
      #print(ind)
      if ind>melhor:
        #print('-----novo melhor------')
        melhor=ind
    mutados.append(melhor)
  return mutados

def plotarCN(populacao:List[Amostra]=[], x=[],z=[]):
  fig,ax=plt.subplots(1,1)
  cp = ax.contourf(x            [0], x[1],z)
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