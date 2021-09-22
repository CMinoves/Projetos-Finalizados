
# Aula 04 - Programando em Assembly no MIPS

## Centro Federal de Educação Tecnológica de Minas Gerais - Departamento de Computação

## Laboratório de Arquitetura e Organização de Computadores I

## Professor: Mateus Felipe Tymburibá Ferreira


## Instruções:


### O que deve ser entregue


* Arquivo compactado nomeado “Aula-X-Lab-AOC1_nome-completo-aluno.zip”.
Certifique-se de que o arquivo não está corrompido.
* Este arquivo deverá conter uma pasta com todos os arquivos utilizados na
prática (códigos fontes, imagens, resultados, etc, sempre que for o caso).
* Escreva em texto simples e conciso as suas análises e considerações.
* Responda às perguntas realizadas na prática, quando for o caso.

### O que deve ser feito

1. Utilize o código fonte fornecido como base (modelo) para seu código;
2. Carregue-o no simulador Mars: "java -jar Mars4_5.jar"
3. Utilize instruções aritméticas com imediatos (ex: addi, subi, divi) e instruções de
controle de fluxo para implementar um código que execute o seguinte pseudo-
código:
```
Var1 = 2344
Enquanto Var1 não for igual a 1
  Se Var1 > 80; Var1 = Var1 – 2;
  Caso contrário se Var1 <= 80; Var1 = Var1/4;
Saia
```

### O que deve ser respondido


1. Quais instruções utilizadas são aritméticas? Quais são de operação de
transferência de memória? Quais são de controle de fluxo?
2. Explique o funcionamento do código acima.
3. Este código possui algum erro ou pode ser melhorado? Justifique. (Dica: repare
que o tipo da variável “Var1” não foi definido!).
