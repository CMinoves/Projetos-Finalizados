transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/Sala\ Minoves/Documents/Cristhian/CEFET/LAOC\ II/Prática\ 01_2 {C:/Users/Sala Minoves/Documents/Cristhian/CEFET/LAOC II/Pr�tica 01_2/Ex2.v}

