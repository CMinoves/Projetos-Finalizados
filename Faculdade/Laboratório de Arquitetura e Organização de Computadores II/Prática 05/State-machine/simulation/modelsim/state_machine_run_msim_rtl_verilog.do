transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/Cristhian/Documents/CEFET/6\ Semestre\ (ERE)/LAOC\ II/Prática\ 05/State-machine {C:/Users/Cristhian/Documents/CEFET/6 Semestre (ERE)/LAOC II/Pr�tica 05/State-machine/state_machine2.v}

