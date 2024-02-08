import math 
infinito = math.inf
import numpy as np 
import random
from functools import total_ordering
import pandas as pd
from typing import*
import matplotlib.pyplot as plt

@total_ordering
class Formiga:
  def __init__(self,pos:int,matriz_dist:np.array(np.array),matriz_fero:np.array(float),Q=1,alpha=1,beta=1):
    self.trajeto=[pos]
    self.matriz_dist=matriz_dist
    self.matriz_fero=matriz_fero
    self.alpha=alpha
    self.beta=beta
    self.Q=Q
  def __str__(self) -> str:
      return f'{self.trajeto} {self.distancia_trajeto}'
  def __repr__(self) -> str:
      return str(self)
  @property
  def distancia_trajeto(self):
    soma=0
    for i in range(len(self.trajeto)-1):
      soma+=self.matriz_dist[self.trajeto[i]][self.trajeto[i+1]]
    return soma
  def calcula_prob(self,origem,destino):
    soma=0
    for i in range(len(self.matriz_dist)):
      if i not in self.trajeto:
        soma+=(self.matriz_fero[origem][i]**self.alpha)*(1/(self.matriz_dist[origem][i]))**self.beta
    num=(self.matriz_fero[origem][destino]**self.alpha)*(1/(self.matriz_dist[origem][destino]))**self.beta
    return num/soma
  
  def lista_prob(self):
    listaP=[]
    #print(self.trajeto)
    for i in range(len(self.matriz_dist)):
      if i not in self.trajeto:
        listaP.append([self.calcula_prob(self.trajeto[-1],i),i])
    return listaP.copy()

  def selecao(self,lista_prob:List[float]):
    #print(len(lista_prob),lista_prob,lista_prob==[])
    if lista_prob==[]:
      return None
    selecionado=random.random()
    #print(selecionado)
    lista_prob.sort(reverse=True)
    #print(lista_prob)
    for i in range(len(lista_prob)-1):
      #print(i+1)
      lista_prob[i+1][0]+=lista_prob[i][0]
    #print(lista_prob)
    #print(selecionado)
    for i in range(len(lista_prob)):
      if selecionado < lista_prob[i][0]:
        #print(i)
        return lista_prob[i][1] 
  
  def gerar_trajeto(self): 
    while True:
      l=self.lista_prob()
      prox=self.selecao(l.copy())
      #print(prox)
      if prox is None:
        break
      self.trajeto.append(prox)
    self.trajeto.append(self.trajeto[0])

  def __lt__(self,o):
    return self.distancia_trajeto<o.distancia_trajeto

  def __eq__(self, o):
    return self.distancia_trajeto==o.distancia_trajeto


def atualiza_fer(matriz_fero,listaF,rho=0.4):
  for i in  range(len(matriz_fero)):
    for j in range(len(matriz_fero)):
      matriz_fero[i][j]*=(1-rho)
  for formiga in listaF:
    for i in range(len(formiga.trajeto)-1):
      v1=formiga.trajeto[i]
      v2=formiga.trajeto[i+1]
      matriz_fero[v1][v2]+=formiga.Q/formiga.distancia_trajeto
      matriz_fero[v2][v1]+=formiga.Q/formiga.distancia_trajeto
      
