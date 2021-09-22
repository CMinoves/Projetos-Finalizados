transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/Cristhian/Documents/CEFET/6\ Semestre\ (ERE)/LAOC\ II/Pr√°tica\ 040/Pr√°tica\ 04/State\ Machine {C:/Users/Cristhian/Documents/CEFET/6 Semestre (ERE)/LAOC II/Pr·tica 040/Pr·tica 04/State Machine/state_machine2.v}

