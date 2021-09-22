## CENTRO FEDERAL DE EDUCAÇÃO TECNOLÓGICA DE MINAS GERAIS

## DEPARTAMENTO DE COMPUTAÇÃO - PROGRAMAÇÃO DE COMPUTADORES II

## ENGENHARIA DE COMPUTAÇÃO

## Atividade 2 - Enquete

Você deverá construir um sistema simplificado para registrar uma pesquisa de satisfação dos
clientes (alunos) a respeito da comida do bandejão do CEFET/MG.
Para isso, implemente uma classe em Java denominada **Enquete**, que deverá ser responsável
por registrar as notas dos alunos pesquisados.

A pesquisa é anônima, isto é, só serão registradas as notas, que podem variar de 1 a 10, sendo 1
para pouco satisfeito e 10 para muito satisfeito.

Na classe **Enquete**, deverão constar métodos capazes de:

* informar a frequência de ocorrência das notas;
* calcular a nota média;
* informar o número de clientes entrevistados;
Crie também uma classe **Teste** com o método **main()** para testar o funcionamento da classe
**Enquete**. Na classe **Teste**, leia do teclado o número de clientes (alunos) pesquisados e gere
notas aleatórias, utilizando para isso a classe **SecureRandom** do pacote **java.util.**

A classe **SecureRandom** possui um método para gerar números inteiros pseudoaleatórios:

```
public int nextInt(int limiteSuperior)
```

O método nextInt retorna o próximo número pseudoaleatório, uniformemente distribuído, isto é,
todos os valores inteiros são produzidos com probabilidade (aproximadamente) igual. O número
gerado estará entre 0 (zero) e o valor do limite superior, informado no parâmetro (não incluído).

Para chamar o método **nextInt()**, crie um objeto do tipo **Random.**

Exemplo:
```
SecureRandom gerador = new SecureRandom();
int numeroGerado = gerador.nextInt(11);
```
Para ler um valor do teclado, utilize a classe **Scanner** do pacote **java.util.

A classe Scanner tem métodos diferenciados para ler valores do tipo String, inteiro e double do
teclado. Verifique o método que vai atender a cada situação.
Exemplo:

```
Scanner input = new Scanner(System.in);
int numeroLido = input.nextInt();
String palavraLida = input.next();
```
Exiba mensagens informativas na tela solicitando os respectivos valores para orientar o usuário.

OBSERVAÇÃO:

* Ao utilizar classes do pacote util, lembre-se de fazer o import dessas:
    * import java.util.Scanner;
    * import java.util.SecureRandom;
