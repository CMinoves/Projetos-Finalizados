# Demonstração de algumas instruções MIPS simples

	# Declara main como uma função global
	.globl main

	# Todo o código do programa é colocado após a diretiva .text
	.text

# O label 'main' representa o ponto de início
main:
  li $t0, 25            # Não existe. Montador traduz para "addiu $t0, $0, 25"
  
  lw $t1, value         # Montador traduz para "lw $t1, 0($0)". OBS: 0 é o
                        # deslocamento da variável "value" à partir do início
                        # do segmento de dados
  
  lw $t2, value2($zero) # Montador traduz para "lw $t2, 4($0)". OBS: 4 é o
                        # deslocamento da variável "value2" à partir do início
                        # do segmento de dados
  
  la $t3, value3        # Carrega o endereço de "value3" em t3 (não existe)
                        # Montador traduz para "addiu $t3, $0, 8". OBS: 8 é o
                        # deslocamento da variável "value2" à partir do início
                        # do segmento de dado.
  lw $t4, 0($t3)        # Carrega o valor de "value3" (-1) em t4

L1:                     # Label para marcar destino de desvio(s)

  subi $t5,$t5,1        # t5--
  
  srl $t7,$t7,3         # Desloca t7 3 bits à direita, mantendo o sinal do valor
                        # (Shift Right Logical). Equivale a divisão inteira por 8.

  sll $t8,$t8,3         # Desloca t8 3 bits à esquerda, inserindo 0s à direita
                        # (Shift Left Logical). Equivale a multiplicar por 8.

  slt $t6,$t4,$t5       # t6 = (t4 < t5)? 1:0
  
  bne $t6,$zero,L1      # Salta para L1 se t6 != 0 (ou seja, se t4 < t5)
      
  j L1                  # Salta para L1

  li $v0, 10            # Carrega 10 em v0 para executar chamada de sistema para "exit"
  syscall               # Executa chamada de sistema. Função (exit) depende do valor em v0.

	.data

value:	.word 12         # variável inicializada com 12
value2:	.word 0xffffffff # variável inicializada com -1
                         # (se o valor for interpretado como iteiro com sinal)
value3:	.word 0xffffffff # variável inicializada com -1
                         # (se o valor for interpretado como iteiro com sinal)
