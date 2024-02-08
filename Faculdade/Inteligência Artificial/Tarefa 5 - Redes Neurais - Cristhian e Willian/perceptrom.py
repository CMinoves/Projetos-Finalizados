import random
import numpy as np
import math 

def rotulo(classificacao,rotulos):
    for i in range(len(rotulos)):
        if(classificacao==rotulos[i][0]):
            return rotulos[i][1]

def inicializar(n,m):
    v = np.zeros([n,m])
    for i in range(n):
        for j in range(m):
            v[i][j]=random.randrange(-100,100)/1000
    return v

def ler_dados(entrada,nclass,rotulos):
    arquivo = open(entrada)
    Entradas= list()
    f=[]
    for linha in arquivo:
        f=linha.split(' ')
        d=f[-1]
        d=d.replace('\n','')
        x=np.array(list(map(float,f[:-1]))),rotulo(d,rotulos)
        Entradas.append(x)
    arquivo.close
    # Gerando W e B aleatorio
    w=inicializar(nclass,len(Entradas[0][0]))
    b=inicializar(1,nclass)
    return Entradas,w,b

def separar_amostra(Entradas,p1,p2,rotulos):
    D=[0]
    j=0
    for i in range(len(rotulos)-1):
        while True:
          if(Entradas[j][1]==rotulos[i+1][1]):
            D.append(j)
            break
          j+=1
    D.append(-1)
    dados=Entradas.copy()
    dados.append('fim')

    #Separando por doença
    separacoes=[]
    for i in range(len(D)-1):
        separacao=dados[D[i]:D[i+1]].copy()
        separacoes.append(separacao)

    #Embaralhando
    for section in separacoes:
        random.shuffle(section)
    Entradas_treino=[]
    for section in separacoes:
        Entradas_treino+=section[:round(p1*len(section)/p2)]
    Entradas_teste=[]
    for section in separacoes:
        Entradas_teste+=section[round(p1*len(section)/p2):]
    random.shuffle(Entradas_treino)
    return Entradas_treino,Entradas_teste

def fx(x,W,B,modo,teste = 0):
  y = (W.dot(x)+B)[0]
  #print(y)
  saida=np.zeros([len(W)])
  if(modo=='degrau'):
    for i in range(len(saida)):
      if(y[i]>=0):
        saida[i]=1
      else:
        saida[i]=0
  elif(modo=='sigmo'):
    tmp=np.zeros([len(W)])
    for i in range(len(saida)):
      try:
       saida[i]=1/(1+math.exp(-y[i]))
      except OverflowError:
        saida[i]= 0
    if(teste == 1):
      k = 0
      for i in range(len(saida)):
        if(saida[k]<saida[i]):
          k = i
      for i in range(len(saida)):
        if(i != k):
          saida[i] = 0
        else:
          saida[i] = 1
  return saida

def preceptron_treino(x,W,B,alfa=0.01,max_int=20,modo='degrau'):
  t=1
  E={}
  E[t]=1
  y=np.array([0,0,0])
  e=np.array([0,0,0])
  while t<max_int and E[t]>0:
    E[t]=0
    for i in range(len(x)):
      y=fx(x[i][0],W,B,modo)
      #print(f'Interação: {t} resposta esperada:{x[i][1]} resposta y:{y}---{modo}---amostra:{i+1}')
      e=x[i][1]-y
      W[0]+=alfa*e[0]*(x[i][0])
      W[1]+=alfa*e[1]*(x[i][0])
      W[2]+=alfa*e[2]*(x[i][0])
      #print(f'{W}\n O  erro nessa amostar foi {e}')

      B[0][0]+=alfa*e[0]
      B[0][1]+=alfa*e[1]
      B[0][2]+=alfa*e[2]
      
      E[t]+=sum(e*e)
      #print(f'Erro atual da interação {t}: {E[t]}')
    t+=1
    E[t] = 1
  return W,B,E

def preceptron_teste(W,B,x,modo='degrau'):
  t=1
  y=np.array([0,0,0])
  e=np.array([0,0,0])
  classCorreta = 0
  classErrada = 0
  E=0
  for i in range(len(x)):
    y=fx(x[i][0],W,B,modo,teste = 1)
    #print(y,modo)
    #print(f'Interação: {t} resposta esperada:{x[i][1]} resposta y:{y}---{modo}---amostra:{i+1}')
    e=x[i][1]-y
    if(e.dot(e) == 0):
      classCorreta +=1
    else:
      classErrada += 1
    E+=sum(e*e)
    #print(f'Erro atual da interação {t}: {E[t]}')
  return E,f'Acuracia={classCorreta/(classErrada+classCorreta)}'
