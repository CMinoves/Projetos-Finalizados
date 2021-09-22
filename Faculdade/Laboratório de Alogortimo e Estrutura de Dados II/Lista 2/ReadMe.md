
# Exercício 02 - Árvores SBB

## Centro Federal de Educação Tecnológica de Minas Gerais - Departamento de Computação

## Laboratório de Algoritmos e Estruturas de Dados II - Professores: Amadeu Almeida e Thiago Rodrigues


## Instruções:

### Exercício 1: Classe Item

Este exercício objetiva escrever os métodos da classe **Item** que implementa um tipo abstrato de dados utilizado

para representar a chave de cada nó da árvore binária.

1. Abra um projeto chamado **Lista2**. Em seguida, crie um arquivo nomeado Item.java.

2. Implemente a classe **Item** conforme especiﬁcada abaixo.
```
package lista1;

public class Item {

private int chave;

public Item(int chave) {

this.chave = chave;

}

public int compara(Item it) {

Item item = it;

if (this.chave < item.chave)

return -1;

else if (this.chave > item.chave)

return 1;

return 0;

}

public int getChave () {

return chave;

}

}

```

### Exercício 2: Classe ArvoreSBB

Este exercício visa implementar uma classe que representa uma Arvore SBB aplicando os conceitos aprendidos

durante a disciplina teórica.

1. No projeto **Lista 2**, crie um arquivo chamado **ArvoreSBB.java**.

2. Implemente a classe **No** conforme especiﬁcada abaixo. Essa classe deve ser inserida dentro da classe

**ArvoreSBB** de modo que cada nó da árvore seja um objeto da classe **No**.
```
private static class No {

Item reg;

No esq , dir;

byte incE , incD;

}

```

3. Inclua os métodos auxiliares **ee**, **ed**, **dd** e **de**. O objetivo destas funções é balancear a Arvore SBB durante

as inserções das chaves.
```
private No ee(No ap) {

No ap1 = ap.esq;

ap.esq = ap1.dir;

ap1.dir = ap;

ap1.incE = Vertical;

ap.incE = Vertical;

ap = ap1;

return ap;

}

private No ed(No ap) {

No ap1 = ap.esq;

No ap2 = ap1.dir;

ap1.incD = Vertical;

ap.incE = Vertical;

ap1.dir = ap2.esq;

ap2.esq = ap1;

ap.esq = ap2.dir;

ap2.dir = ap;

ap = ap2;

return ap;

}

private No dd(No ap) {

No ap1 = ap.dir;

ap.dir = ap1.esq;

ap1.esq = ap;

ap1.incD = Vertical;

ap.incD = Vertical;

ap = ap1;

return ap;

}

private No de(No ap) {

No ap1 = ap.dir;

No ap2 = ap1.esq;

ap1.incE = Vertical;

ap.incD = Vertical;

ap1.esq = ap2.dir;

ap2.dir = ap1;

ap.dir = ap2.esq;

ap2.esq = ap;

ap = ap2;

return ap;

}
```

4. Implemente os atributos da classe **ArvoreSBB**:

* private No raiz

* private long nosVisitados

* private int quantidadeNiveisArvore

* private static ﬁnal byte Horizontal = 0;

* private static ﬁnal byte Vertical = 1;

* private boolean propSBB;

5. Implemente os métodos da classe **ArvoreSBB**:

* public ArvoreSBB(): inicializa o nó raiz.

* private No insere(Item reg, No pai, No ﬁlho, boolean ﬁlhoEsq): insere uma chave na Arvore SBB e

balanceia-a.

* private Item pesquisa(Item reg, No p): busca uma chave na Arvore SBB.

* public void insere(Item reg): inicializa o processo de inserção de uma chave à partir do nó raiz.

* public void pesquisa(Item reg): inicia a busca por um elemento da árvore a partir do nó raiz.

* public long getNosVisitados(): retorna o número de nós visitados durante a busca de um registro.

* public int getQuantidadeNiveisArvore(): retorna a quantidade de níveis em uma Arvore SBB.

6. Transcreva os métodos que calculam a quantidade de níveis de uma árvore SBB.
```
private void calculaTamanho(No p, int nivel) {

if (p == null) {

return;

}

if (this.primeiraFolha) {

if (this.tamanhoArvore < nivel) {

this.tamanhoArvore = nivel;

}

}

if (p.esq == null && p.dir == null) {

if (this.primeiraFolha) {

this.primeiraFolha = false;

}

}

if (p.incE == Horizontal) {

this.calculaTamanho(p.esq , nivel);

} else {

this.calculaTamanho(p.esq , nivel + 1);

}

if (p.incD == Horizontal) {

this.calculaTamanho(p.dir , nivel);

} else {

this.calculaTamanho(p.dir , nivel + 1);

}

}

public void retornaQuantidadeNiveis () {

this.tamanhoArvore = 0;

this.primeiraFolha = true;

this.calculaTamanho(this.raiz , 1);

}
```
7. Explique o objetivo de cada um dos métodos implementados nos itens 3, 5 e 6 por meio de comentários

no próprio código.

### Exercício 3: Experimentos e gráﬁcos

O objetivo deste exercício é testar a eﬁcácia do método de pesquisa da classe **ArvoreSBB** em diferentes

tamanhos de árvores.

1. Experimento 1:

(a) Crie 10 árvores binárias diferentes contendo N elementos **ORDENADOS**, ou seja, inseridos em

ordem crescente, no qual N varia em intervalos de 10.000, entre os números 10.000 e 100.000.

(b) Para cada uma das árvores geradas no exercício (a), pesquise por um elemento não pertencente à

árvore e retorne o número de nós visitados.

(c) Utilize o método **retornaQuantidadeNiveis** para calcular quantos níveis cada árvore gerada no

exercício (a) possui.

2. Experimento 2:

(a) Conceba 10 árvores binárias diferentes contendo N elementos **ALEATORIOS**, entre 1 e 500.000,

no qual N varia em intervalos de 10.000, entre os números 10.000 e 100.000.

(b) Para cada uma das árvores geradas no exercício (a), pesquise por um elemento não pertencente à

árvore e retorne o número de nós visitados.

(c) Calcule a quantidade de níveis em cada árvore criada no exercício (a).

3. Experimento 3:

(a) Gere 10 árvores binárias diferentes contendo N elementos **ALEATORIOS** entre 1 e 500.000, no qual

N contém os seguintes valores: {5, 10, 50, 100, 500, 1.000, 5.000, 10.000, 50.000, 100.000}. Durante a

construção da árvore, utilize a classe **Random** do pacote java.util para gerar os valores randômicos.

(b) Compute quantos níveis tem em cada árvore concebida no exercício (a).

4. Faça três gráﬁcos:

* Um que mostre, para cada valor de N, o número de comparações feitas durante as buscas dos

experimentos 1 e 2 desta lista. Neste gráﬁco, o eixo X refere-se ao número de elementos de cada

árvore (N) enquanto o numero de comparações é retratado pelo eixo Y. Em seguida, indique porque

os números de comparações são similares em ambos os casos.

* Um que exponha, para cada valor de N, o número de comparaçõeses realizadas durante as pesquisas

dos experimentos 1 das listas 1 e 2. O eixo X deste gráﬁco contem o número de elementos de cada

árvore (N) e o eixo Y é composto pela quantidade de comparações. Depois, explique porque os

números de comparações são consideravelmente maiores para um dos dois casos.

* Um que relaciona cada valor de N com o tamanho de sua respectiva Arvore SBB obtido no experimento 3

desta lista. Neste gráﬁco, o eixo X refere-se ao número de elementos de cada árvore (N)

enquanto o eixo Y descreve o tamanho da árvore. Em seguida, descreva a relação entre o tamanho

da árvore e a complexidade do algoritmo de pesquisa em uma árvore SBB.
