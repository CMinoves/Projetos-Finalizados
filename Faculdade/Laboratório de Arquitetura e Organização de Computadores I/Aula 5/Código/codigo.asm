
addi $t0,$zero,31
addi $t1,$zero,34
jal func
add $t2,$zero,$v0 #igualando o valor do retorno da função a variável resultado
j terminou
func:

addi $sp,$sp,-8 #empilhamento dos parâmetros
sw $t1, 4 ($sp) #y = $a1 
sw $t0, 0 ($sp) #x = $a0
.data
vec: .word 1,2,3,4,32,43,12,98,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
.text
la $t0,vec #endereço base do array
add $t1,$zero,$a0 # variável i

teste:

slt $t2,$t1,$a1
bne $t2,$zero, fim
add $t2,$zero,$zero
add $t2,$t1,$t1
add $t2,$t1,$t1 #multiplicando o valor de t1 por 4 para acessos de memoria no array
add $t3, $t1,$a1
sw $t3,0($t0)
addi $t1,$t1,1 # i++
j teste

fim:
move $v0,$a1 #movimenta o valor final
lw $t1, 4 ($sp) #voltando os valores de parâmetro para os seus registradores
lw $t0, 0 ($sp) 
addi $sp,$sp,8 #desempilhando a pilha de procedimentos
jr $ra #retornando a chamada de função
terminou:

