.globl main

.text

main:
	addi $s0, $0, 2334 #valor inicial de var1
loop1:
	beq $s0,1, exit
	addi $t0,$0,80
	slt $t0,$t0,$s0
	bne $t0,$0,cond
	div $s0,$s0,4
	j loop1
cond:
	subi $s0,$s0,3
	j loop1
exit: