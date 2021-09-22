transcript on
if {[file exists rtl_work]} {
	vdel -lib rtl_work -all
}
vlib rtl_work
vmap work rtl_work

vlog -vlog01compat -work work +incdir+C:/Users/Cristhian/Documents/CEFET/6\ Semestre\ (ERE)/LAOC\ II/Pr√°tica\ 02/Pratica\ bruno\ 2\ fix/Pratica\ bruno\ 2/Pratica\ bruno\ 2 {C:/Users/Cristhian/Documents/CEFET/6 Semestre (ERE)/LAOC II/Pr·tica 02/Pratica bruno 2 fix/Pratica bruno 2/Pratica bruno 2/pratica2.v}
vlog -vlog01compat -work work +incdir+C:/Users/Cristhian/Documents/CEFET/6\ Semestre\ (ERE)/LAOC\ II/Pr√°tica\ 02/Pratica\ bruno\ 2\ fix/Pratica\ bruno\ 2/Pratica\ bruno\ 2 {C:/Users/Cristhian/Documents/CEFET/6 Semestre (ERE)/LAOC II/Pr·tica 02/Pratica bruno 2 fix/Pratica bruno 2/Pratica bruno 2/memory2.v}

