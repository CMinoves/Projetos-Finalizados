
.data
vec: .word 0, 1, 1,0,1,1,1,0,1,1,0 #carregando o vetor teste a ser usado

tam: .word 11
.text

la $t0, vec #possui o primeiro elemento
la $t5,tam
lw $t5,0($t5)

lw $t1,0($t0) #esse registrador possui o primeiro valor da lista
lw $t0, 0($t0)
addi $t6,$zero,2
ateofim: #aqui será armazenado o ultimo valor do array
lw $t1, 4($t1) #possui o ultimo elemento após terminar 
addi $t6,$t6,1
bne $t6,$t5, ateofim

addi $t6,$zero,2
div $t5,$t6
mflo $t2 #esse valor servirá como ponto de parada, ou seja, indicando a metade do array
addi $t3, $zero,0 #Esse registrador fará o controle dos testes

loop: #Aqui é feita a chegagem de cada número
bne $t0,$t1,diferente #caso eles sejam diferentes
addi $t3,$t3,1
beq $t3,$t2, igual #caso termine os testes
lw $t0,4($t0)
lw $t1, -4($t1)
j loop

diferente:
add $t3,$zero,$zero #o registrador receberá "0", indicando que a lista não é palíndroma
j final

igual:
addi $t3,$zero,1 #o registrador receberá "1", indicando que a lista é palíndroma

final:#esse boloco serve para chegar de novo até o final da lista de números.
lw $t1,0($t0) #esse registrador possui o primeiro valor da lista
addi $t6,$zero,2
ateofim2: #aqui será armazenado o ultimo valor do array
lw $t1, 4($t1) #possui o ultimo elemento após terminar 
addi $t6,$t6,1
bne $t6,$t5, ateofim2

sw $t3,4($t1) #colocando o resultado do processo no local de memória imediatamente posterior ao final da lista




