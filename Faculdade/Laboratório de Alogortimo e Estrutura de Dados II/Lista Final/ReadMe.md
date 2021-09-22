
#﻿ Exercício Final - Trabalho Prático

## Centro Federal de Educação Tecnológica de Minas Gerais - Departamento de Computação

## Laboratório de Algoritmos e Estruturas de Dados II - Professores: Amadeu Almeida e Thiago Rodrigues


## Instruções:
**Objetivo:** Implementar um algoritmo de força bruta e duas heurísticas para o problema do
Caixeiro Viajante.

O trabalho é composto por duas partes: (i) a aplicação do algoritmo de **_força bruta_** em
instâncias do problema do caixeiro viajante; e (ii) o desenvolvimento de duas **_heurísticas_** que
objetivam solucionar três instâncias do mesmo problema.

O problema do Caixeiro Viajante consiste em, dado um conjunto de cidades onde
existe um caminho entre cada par de cidades com uma distância positiva, encontrar um
caminho que, a partir de uma cidade, visita-se todas as cidades e retorna à inicial percorrendo
a menor distância possível.

**Parte 1:**

1. Implementar o método de **_força bruta_** para solucionar o problema, ou seja, um
    algoritmo que determina todas as possíveis rotas e escolhe a melhor, ou seja, a menor;
2. Gerar instâncias de tamanho **_2_** à **_n_** e aplicar o método implementado no item 1;
3. Computar o tempo de execução durante a aplicação de **_força bruta_** em cada uma das
    instâncias geradas. A aplicação do método deve ser realizada em quantas instâncias
    forem possíveis (o mais provável é que o tamanho máximo gire em torno de 10 à 14
    cidades);

**Obs.:** as instâncias devem ser geradas de forma automática onde os pesos possuem
valores aleatórios. Pode-se utilizar qualquer tipo de representação de grafos que se
desejar.

**Parte 2:**

1. Implementar duas heurísticas que têm como objetivo encontrar soluções para o
problema do caixeiro viajante:
  a. Uma de programação gulosa.
  b. Uma à escolha do grupo que não seja fundamentada na técnica do item
  anterior.
2. Aplicar os métodos implementados no item anterior em três instâncias do problema
disponíveis no Moodle.

* a. **_si535.tsp_** : o problema possui **_535_** cidades e as distâncias estão disponíveis em
forma de matriz de adjacência, mas somente a **_diagonal superior_** desta matriz;
* b. **_pa561.tsp_** : o problema possui **_561_** cidades e as distâncias estão disponíveis em
forma de matriz de adjacência, mas somente a **_diagonal inferior_** desta matriz;
* c. **_si1032.tsp:_** o problema possui **_1032_** cidades e as distâncias estão disponíveis
em forma de matriz de adjacência, mas somente a **_diagonal superior_** desta
matriz;
* d.Verificar as distâncias calculadas por cada uma de suas heurísticas.


**O que deve ser entregue:**
* Postar no Moodle os códigos fontes comentados de todas as implementações;
* Um relatório **via Moodle** contendo:
  * Uma descrição que inclua **_pelo menos_** :
    * As características, a complexidade e as principais aplicações do
    caixeiro viajante;
    * Uma breve revisão bibliográfica deste problema;
  * A explicação da implementação dos três algoritmos;
  * Um gráfico mostrando o crescimento exponencial do tempo necessário
  para resolver o caixeiro viajante pelo crescimento do tamanho do problema
  - utilizando o procedimento de **_força bruta_** ;
  * Os experimentos computacionais que comparam o desempenho de cada
  heurística para as três instâncias definidas no item 2 da segunda parte
  deste trabalho.

**Obs.:** o trabalho pode ser feito em grupo de até 3 pessoas;

**Bom trabalho!!**
