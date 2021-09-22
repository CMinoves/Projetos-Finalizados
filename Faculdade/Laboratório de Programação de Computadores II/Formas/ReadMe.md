# CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS

## DEPARTAMENTO DE COMPUTAÇÃO

### CURSO ENGENHARIA DE COMPUTAÇÃO - PROGRAMAÇÃO DE COMPUTADORES II

## Atividade 9 – Formas

1. Na aula de hoje você deverá implementar a hierarquia Forma mostrada no diagrama de
    classes abaixo:

<p align="center"
    <img src = "/Imagens/Imagem 01.png">
</p>

  * Cada FormaBidimensional deve conter o método obterArea para calcular a área da forma
bidimensional.
  * Cada FormaTridimensional deve ter métodos obterArea e obterVolume para calcular a
área e o volume, respectivamente, da forma tridimensional.
  * Crie um programa TrataFormas que utiliza uma coleção de referências Forma para
objetos de cada classe concreta na hierarquia. O programa deve imprimir uma descrição
de texto do objeto ao qual o elemento da coleção se refere. Além disso, no loop que
processa todas as formas da coleção, determine se cada forma é uma
FormaBidimensional ou uma FormaTridimensional. Se uma forma for bidimensional, exiba
sua área. Se uma forma for tridimensional, exiba sua área e seu volume.

2. Modifique a implementação feita - criando um novo pacote – para que não seja necessário
    verificar o tipo da forma ao processar a coleção. Deverá ser exibido sempre a área e o volume
    de cada Forma. Entretanto, como não é possível calcular o volume para formas
    bidimensionais, crie um método obterVolume para formas bidimensionais que lança uma
    exceção NãoExisteVolumeException. Trate esta exceção exibindo uma mensagem ao usuário.
