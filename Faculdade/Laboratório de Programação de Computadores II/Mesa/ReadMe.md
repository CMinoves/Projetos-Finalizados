# CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS

## DEPARTAMENTO DE COMPUTAÇÃO

### CURSO ENGENHARIA DE COMPUTAÇÃO - PROGRAMAÇÃO DE COMPUTADORES II

## Atividade 5 – Baralho

1. Implemente em Java uma simulação de um jogo de baralho, sabendo que um baralho possui 52 cartas, e que cada carta possui um naipe e um valor numérico, implemente as classes **Carta**, **Baralho** e  **Jogador** conforme:
* A classe Carta deverá ter dois campos privados: naipe, do tipo String e valor, do tipo inteiro;
* A classe Baralho deverá ter um grupo de cartas, que serão criadas até que o baralho esteja completo, isto é, até que existam quatro sequências de 13 cartas dos quatro naipes válidos.
* A classe Jogador deverá ter um grupo de cartas de tamanho a ser definido pelo usuário;

A classe **Baralho** terá a responsabilidade de embaralhar as cartas e distribuir as cartas.
A classe Jogador terá a responsabilidade de identificar, dentre o grupo de cartas recebidas, a carta de maior valor.
Faça um aplicativo Java denominado Mesa para simular o jogo entre dois jogadores A e B. Ao iniciar o jogo, os jogadores deverão receber cinco cartas. Dentre estas cartas, cada jogador deverá selecionar a maior carta e exibi-la.
Vencerá o jogo o jogador que tiver exibido a carta de maior valor. Caso ocorra empate, vencerá o jogo o jogador que tiver com a carta de Ouros.
Exemplo da console após execução do aplicativo Mesa:

```
Mesa embaralhando............

Informe o número de cartas a distribuir para os jogadores:
5
Mesa distribui as 5 cartas para jogador A e para o jogador B.

O jogador A joga a carta de naipe Copas e de valor 10

O jogador B joga a carta de naipe Paus e de valor 10

Como os valores das cartas são iguais e nenhum jogador tem carta de Ouros,
o jogo ficou empatado!

Jogando novamente...

Mesa embaralhando............

Informe o número de cartas a distribuir para os jogadores:
5
Mesa distribui as 5 cartas para jogador A e para o jogador B.

O jogador A joga a carta de naipe Ouros e de valor 13

O jogador B joga a carta de naipe Paus e de valor 12

O jogador A venceu o jogo.
```
Dicas:
1. Na classe Baralho, crie um array com os nomes dos naipes, conforme:
```
    String[] naipes={“Copas”,”Ouros”,”Paus”,”Espadas”};
```
2. Embaralhar significa que as posições das cartas devem ser trocadas de forma aleatória.
    _Utilize a classe SecureRandom para isso._
