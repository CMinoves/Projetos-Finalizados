# CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS

## DEPARTAMENTO DE COMPUTAÇÃO

## CURSO ENGENHARIA DE COMPUTAÇÃO - PROGRAMAÇÃO DE COMPUTADORES II

## Atividade 7 – Planner

1. Implemente em Java uma agenda de compromissos diária, um planner. Esta agenda contemplará uma semana de compromissos diários. Considere que:

* cada semana possui apenas 5 dias úteis, de Segunda-feira até Sexta-feira
*cada dia terá horários disponíveis no intervalo de 09:00 às 18:00, isto é, um dia pode comportar até 10 compromissos de 1 hora de duração.
Portanto, 09:00 é o primeiro horário disponível, 10:00 é o segundo horário disponível e assim por diante;
* cada compromisso terá, no mínimo, 1 hora de duração;

Implemente as classes Compromisso, Dia e Semana. A classe Compromisso terá dois campos privados: duração e descrição do compromisso.
A classe Dia terá um grupo de compromissos e a classe Semana um grupo de dias. No construtor de cada classe, lembre-se de inicializar
corretamente respectivos campos defnidos.
A classe Dia terá a responsabilidade de adicionar os compromissos no horário informado, além de exibir todos os horários, tanto livres
quando os já ocupados.
A classe Semana conterá métodos que farão o acesso aos métodos para adicionar compromissos (para um dia informado) e exibir horários
para todos os dias da semana, conforme métodos implementados na classe Dia.

Faça um aplicativo Java denominado TesteAgenda que permita ao usuário:
* inserir compromissos para um dia da uma semana;
* imprimir a agenda de compromissos da semana;
Exemplos de agendamentos:

<p align="center"
  <img src = "/Imagens/Imagem 01.png">
</p>

**OBS:** O seu programa deverá validar a tentativa de incluir um compromisso que coincida com um
horário que não esteja livre, exemplo:
1. Para a semana em questão, o programa não permitirá agendar um compromisso para
segunda-feira para inciar às 14:00;
2. O programa não deverá permitir também um compromisso para segunda-feira que inicie
às 12:00 que tenha mais de 02 horas de duração;

**Dicas:** Na classe Semana, crie um array de nomes dos dias da semana, conforme:
```
String[] nomes={“Segunda-feira”,Terça-feira”,”Quarta-feira”,”Quinta-feira”,”Sexta-feira”}
```
