transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/Cristhian/Documents/CEFET/3\ Semestre/LSD/C\ -\ Decodificador\ BCD\ para\ display\ de\ 7\ segmentos/Booleano {C:/Users/Cristhian/Documents/CEFET/3 Semestre/LSD/C - Decodificador BCD para display de 7 segmentos/Booleano/decodificadorMARAvilhoso.v}

