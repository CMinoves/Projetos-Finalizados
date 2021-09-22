transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/Cristhian/Documents/CEFET/3\ Semestre/LSD/I\ -\ Flip\ Flop\ de\ Registrador\ 06_06 {C:/Users/Cristhian/Documents/CEFET/3 Semestre/LSD/I - Flip Flop de Registrador 06_06/FlipFlopRegistrador.v}

