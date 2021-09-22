/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixeiroviajantegenetico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cristhian
 * Algoritmo baseado no encontrado em http://www.tuliofaria.net/arquivos/algoritmogenetico.java
 */
public class CaixeiroViajanteGenetico {
    public static int NUMERO_CIDADES = 8;
	public static int NUMERO_POPULACAO = 10;
	public static void main(String[] args) {

		// definicoes iniciais
		boolean mostrarEvolucao = true;
		float taxaMortalidade = (float) 0.5;
		int numeroEvolucoes = 10000;
		Scanner input = new Scanner(System.in);
                //fim das definições iniciais
        int no = 0;
        int fim = 0;
        String nomearq = "";
        System.out.println("Digite qual grafo usar: ");
        System.out.println("1 - pa561");
        System.out.println("2 - si535");
        System.out.println("3 - si1032");
        int op = input.nextInt();
        switch (op) {
            case 1:
                nomearq = "pa561.tsp";
                no = 561;
                fim = 9;
                break;
            case 2:
                nomearq = "si535.tsp";
                no = 535;
                fim = 7;
                break;
            case 3:
                nomearq = "si1032.tsp";
                no = 1032;
                fim = 7;
            break;
        }
        //bloco de leitura do arquivo

        int teste = 0;
        int j = 0;
        int i = 0;
        int[][]matadjtotal = new int[no][no];
        try {
            FileReader arq = new FileReader(nomearq);
            BufferedReader lerArq = new BufferedReader(arq);
            int aux = 0;
            String linha;
            String[]separado;
            for(int o = 0;o<fim;o++){
                linha = lerArq.readLine();
            }

               while ((linha = lerArq.readLine())!= null) {
                   separado = linha.split(" ");
                   if(op==1){
                   for(j = 0;j<separado.length;j++){

                       matadjtotal[i][j] = Integer.valueOf(separado[j]);
                       matadjtotal[j][i] = Integer.valueOf(separado[j]);
                       
                   }
                   i++;
                   teste ++;
                   }else{
                       for(j=1;j<separado.length;j++){
                           if(aux == no){
                               i++;
                               aux = i;
                           }
                        matadjtotal[i][aux] = Integer.valueOf(separado[j]);
                        matadjtotal[aux][i] = Integer.valueOf(separado[j]);
                        aux++;
                       }
                   }
               }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        //fim da leitura do arquivo
        /*a fim de manter a cidade inicial a de número 0, a matriz de adjacencia usada será
        uma que não contenha a cidade 0, a qual será adicionada ao fim de toda a recombinação
        */
        no--;//como será usado um mapa com uma cidade a menos, é decrescido o valor dos nos
        long inicio = System.nanoTime();
        int[][]matadj = new int[no][no];
        for(int x = 1;x<no-1;x++){
            for(int y = 1;y<no-1;y++){
                matadj[x][y] = matadjtotal[x][y];
            }
        }
		int[][] cromossomos = new int[NUMERO_POPULACAO][no];
		int[] resultados = new int[no];

		gerarCromossomosAleatoriamente(cromossomos, no);
		calcularResultado(cromossomos, resultados, matadj, no);
		ordenar(cromossomos, resultados);
		if (mostrarEvolucao)
			imprimir(cromossomos, resultados, no);

		int a;
		for (a = 0; a < numeroEvolucoes; a++) {
			renovarCromossomos(cromossomos, resultados, taxaMortalidade, no);
			calcularResultado(cromossomos, resultados, matadj, no);
			ordenar(cromossomos, resultados);
			if (mostrarEvolucao) {
				System.out.println("Geracao: " + (a + 1));
				imprimir(cromossomos, resultados, no);
			}
		}
		// mostrando resultado encontrado, acrescendo o no inicio  e no fim o no de partida
		resultadoFinal(cromossomos, resultados, no, matadjtotal);
                long end = System.nanoTime();
                end = (end-inicio);
                System.out.println();
                System.out.println("Tempo de execução: ");
                System.out.println("Nanosegundos: "+end);
                System.out.println("Microsegundo: "+(end/1000));
                System.out.println("Milissegundo: "+(end/1000000));
                System.out.println("Segundo: "+(end/1000000000));
	}
        
        private static void resultadoFinal(int[][] cromossomos, int[] resultados, int no, int[][]matadjtotal) {
		int i, i2;
		i=0;
                System.out.println("");
                System.out.println("");
                System.out.println("Caminho final: ");
                System.out.print("0 => ");
		for (i2 = 0; i2 < no; i2++) {
			System.out.print(cromossomos[i][i2] + " => ");
		}
		System.out.print("0 ");
                resultados[i]+= matadjtotal[0][cromossomos[i][0]];
                resultados[i]+=matadjtotal[cromossomos.length-1][0];
                System.out.println("");
		System.out.println(" Resultado: " + resultados[i]);

	}

	public static void renovarCromossomos(int[][] cromossomos,
			int[] resultados, float taxaMortalidade, int no) {

		int inicioExcluidos = (int) (taxaMortalidade * 10);

		int i, i2 = 0;

		for (i = inicioExcluidos; i < 10; i++) {

			boolean valido = false;

			while (!valido) {

				int[] c_tmp = resetaCromossomo(no);

				// pegando 2 pais aleatoriamente
				int pai1, pai2;

				pai1 = new Random().nextInt(inicioExcluidos);
				do {
					pai2 = new Random().nextInt(inicioExcluidos);
				} while ((pai1 == pai2)
						&& (resultados[pai1] != resultados[pai2]));

				// pegando 3 caracteristicas do pai 1 aleatoriamente
				for (i2 = 0; i2 < (int) no / 4; i2++) {
					int pos;
					pos = new Random().nextInt(no);
					c_tmp[pos] = cromossomos[pai1][pos];
				}
				// pegando restante do pai 2
				for (i2 = 0; i2 < (int) no / 4; i2++) {
					int pos = new Random().nextInt(no);
					if (c_tmp[pos] == -1) {
						if (valorValidoNoCromossomo(cromossomos[pai2][pos],
								c_tmp, no)) {
							c_tmp[pos] = cromossomos[pai2][pos];
						}
					}
				}

				// preenchendo o restante com aleatorios
				for (i2 = 0; i2 < no; i2++) {
					if (c_tmp[i2] == -1) {
						int crom_temp = valorValidoNoCromossomo(c_tmp,no);
						c_tmp[i2] = crom_temp;
					}
				}

				// verificando se é valido
				valido = cromossomoValido(c_tmp, cromossomos,no);
				if (valido) {
					cromossomos[i] = c_tmp;
				}
			}
		}

	}

	private static int[][] gerarCromossomosAleatoriamente(int[][] cromossomos, int no) {

		// inicializando cromossomos aleatoriamente
		int[] c_tmp = new int[no];

		int i, i2;
		for (i = 0; i < NUMERO_POPULACAO; i++) {
			boolean crom_valido = false;
			while (!crom_valido) {
				crom_valido = true;
				c_tmp = resetaCromossomo(no);

				// gerando cromossomo - ok
				for (i2 = 0; i2 < no; i2++) {
					c_tmp[i2] = valorValidoNoCromossomo(c_tmp,no);
				}
				crom_valido = cromossomoValido(c_tmp, cromossomos,no);
			}
			cromossomos[i] = c_tmp;
		}
		return cromossomos;
	}

	private static int[] resetaCromossomo(int no) {
		int[] c = new int[no];
		int i;
		for (i = 0; i < no; i++) {
			c[i] = -1;
		}
		return c;
	}

	private static int valorValidoNoCromossomo(int[] c_tmp, int no) {
		int crom_temp;
		boolean valido;
		do {
			crom_temp = new Random().nextInt(no);
			valido = true;
			for (int ii = 0; ii < no; ii++) {
				if (c_tmp[ii] == crom_temp)
					valido = false;
			}
		} while (!valido);
		return crom_temp;
	}

	private static boolean valorValidoNoCromossomo(int valor, int[] c_tmp, int no) {
		int crom_temp = valor;
		boolean valido;

		valido = true;
		for (int ii = 0; ii < no; ii++) {
			if (c_tmp[ii] == crom_temp)
				valido = false;
		}

		return valido;
	}

	private static boolean cromossomoValido(int[] c_tmp, int[][] cromossomos, int no) {
		int j, j2;
		boolean crom_valido = true;

		for (j = 0; j < NUMERO_POPULACAO; j++) {
			int n_iguais = 0;
			for (j2 = 0; j2 < no; j2++) {
				if (c_tmp[j2] == cromossomos[j][j2]) {
					n_iguais++;
				}
			}

			if (n_iguais == NUMERO_CIDADES)
				crom_valido = false;
		}
		return crom_valido;
	}

	private static void imprimir(int[][] cromossomos, int[] resultados, int no) {
		int i, i2;
		for (i = 0; i < NUMERO_POPULACAO; i++) {
			for (i2 = 0; i2 < no-1; i2++) {
				System.out.print(cromossomos[i][i2] + " => ");
			}
			System.out.print(cromossomos[i][no-1] + " ");
			System.out.println(" Resultados: " + resultados[i]);
		}
	}

	private static void calcularResultado(int[][] cromossomos,
			int[] resultados, int[][] mapa,int no) {
		int i, i2;
		// calculando o resultado
		for (i = 0; i < NUMERO_POPULACAO; i++) {
			int resTmp = 0;
			for (i2 = 0; i2 < no - 1; i2++) {
				resTmp += mapa[cromossomos[i][i2]][cromossomos[i][i2 + 1]];
			}
			resultados[i] = resTmp;
		}

	}

	private static void ordenar(int[][] cromossomos, int[] resultados) {
		// ordenando
		int i, i2;
		for (i = 0; i < 10; i++) {
			for (i2 = i; i2 < 10; i2++) {
				if (resultados[i] > resultados[i2]) {
					int vTmp;
					int[] vvTmp = new int[10];
					vTmp = resultados[i];
					resultados[i] = resultados[i2];
					resultados[i2] = vTmp;

					vvTmp = cromossomos[i];
					cromossomos[i] = cromossomos[i2];
					cromossomos[i2] = vvTmp;
				}
			}
		}
	}

}