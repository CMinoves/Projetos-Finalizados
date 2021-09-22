# Aula 05 - Implementação de Funções em Assembly no MIPS

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


1. Utilize o código fonte fornecido como base (modelo) para seu código.
2. Carregue-o no simulador Mars: java -jar Mars4_5.jar
3. Crie um código que implemente em Assembly do MIPS a seguinte função em C:
```
int g(int x, int y){
  int a[32] = {1,2,3,4,32,43,12,98}; // a[8] até a[31] = 0
  int i;
  for(i = x; i < y; i++){
    a[i] = i + y;
  }
  return(a[i-1]);
}

void main(){
  int result = g(31, 34);
}
```
### O que deve ser respondido


1. Quais conceitos foram utilizados para implementar esta tradução?
2. O que acontece se o valor de y for 34? Qual o valor retornado para uma
chamada g(31,34)? Aponte os valores intermediários assumidos por “a[i]” e por
“i” durante uma chamada com esses valores ( g(31,34) ).
3. O que poderia acontecer se a função “g” guardasse o seu endereço de retorno
na pilha (para poder efetuar uma chamada a outro procedimento, por
exemplo)?

**OBS:** para facilitar a observação do evento ocorrido na chamada g(31,34),
atualize o valor em memória das variáveis (via instrução “store” / sw) sempre
que o conteúdo do registrador correspondente for alterado, e carregue (via
instrução “load” / lw) o valor atualizado em memória para o registrador
correspondente à variável, sempre que o conteúdo da variável for usado.
