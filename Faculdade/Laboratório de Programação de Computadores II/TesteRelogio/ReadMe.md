# CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS

## DEPARTAMENTO DE COMPUTAÇÃO

### CURSO ENGENHARIA DE COMPUTAÇÃO - PROGRAMAÇÃO DE COMPUTADORES II

## Atividade 03 - Relógio

1. Você deverá implementar um relógio digital em Java. Para isso, você deverá criar três classes, a saber:

* **Contador;**
* **Relogio;**
* **TesteRelogio:** para testar a execução (aplicativo Java);

Nas classes Contador e Relogio deverão constar os métodos modifcadores e métodos de acesso para os atributos criados.
O resultado da sua execução deverá exibir todos os horários possíveis do relógio, exemplo:
Formato 24 horas
```
00:00
00:01
00:02
00:03
00:04
00:05
.
.
.
23:59
```
Formato 12 horas
```
00:00 a.m.
00:01 a.m.
00:02 a.m.
.
.
.
11:54 p.m.
11:55 p.m.
11:56 p.m.
11:57 p.m.
11:58 p.m.
11:59 p.m.
00:00 a.m.
```
Deverá existir uma opção para exibir as horas no formato 12 horas ou 24 horas. Caso seja feita a seleção para exibir no formato
de 12 horas, deverá ser exibido a.m. ou p.m. conforme o caso.

* **Dicas:**

1. _Ainda que você possa visualizar um relógio digital que exibe as horas no formato_
    _HH:MM, p. ex: 11:03, como um mostrador de quatro dígitos, para facilitar a_
    _implementação em Java, você deverá considerá-lo como dois contadores de dois_
    _dígitos (um par para as horas e um par para os minutos). Um par inicia em zero,_
    _aumenta a cada hora e volta para zero após alcançar seu limite de 23. O outro faz o_
    _mesmo, porém a cada minuto, até alcançar seu limite de 59._
2. _Na classe_ Contador _deverá constar um método para incrementar o valor,_
    _respeitando o limite defnido. (método incrementar())_
3. _Na classe_ Relogio _deverá constar um método que atualize as horas, caso o_
    _contador de minutos seja zerado. (método_ TicTac() _)_
4. _Para que um número nunca exceda um determinado valor, você poderá utilizar o_
    _resto inteiro da divisão – função mod._
       _Exemplo: para que A + B nunca seja maior que 100, em Java faça_
       _(A + B) % 100._
