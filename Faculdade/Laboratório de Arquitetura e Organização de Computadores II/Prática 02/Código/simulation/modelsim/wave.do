onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate /processor/Resetn
add wave -noupdate /processor/Clock
add wave -noupdate /processor/DIN
add wave -noupdate -radix hexadecimal /processor/Bus
add wave -noupdate /processor/Tstep_Q
add wave -noupdate /processor/IRin
add wave -noupdate -radix hexadecimal /processor/R0
add wave -noupdate -radix hexadecimal /processor/R1
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {106 ps} 0}
quietly wave cursor active 1
configure wave -namecolwidth 150
configure wave -valuecolwidth 100
configure wave -justifyvalue left
configure wave -signalnamewidth 0
configure wave -snapdistance 10
configure wave -datasetprefix 0
configure wave -rowmargin 4
configure wave -childrowmargin 2
configure wave -gridoffset 0
configure wave -gridperiod 1
configure wave -griddelta 40
configure wave -timeline 0
configure wave -timelineunits ns
update
WaveRestoreZoom {0 ps} {704 ps}
view wave 
wave clipboard store
wave create -driver freeze -pattern clock -initialvalue 1 -period 100ps -dutycycle 50 -starttime 0ps -endtime 100ps sim:/processor/Resetn 
wave modify -driver freeze -pattern constant -value 1 -starttime 0ps -endtime 100ps Edit:/processor/Resetn 
wave modify -driver freeze -pattern constant -value 0 -starttime 100ps -endtime 1000ps Edit:/processor/Resetn 
wave create -driver freeze -pattern clock -initialvalue 0 -period 100ps -dutycycle 50 -starttime 0ps -endtime 1000ps sim:/processor/Clock 
wave create -driver freeze -pattern repeater -initialvalue 0 -period 50ps -sequence { 0000000000000000 0000000001000000 0000000000000010  } -repeat never -range 15 0 -starttime 0ps -endtime 1000ps sim:/processor/DIN 
WaveExpandAll -1
wave modify -driver freeze -pattern repeater -initialvalue 0000000000000000 -period 100ps -sequence { 0000000000000000 0000000001000000 0000000000000010  } -repeat never -range 15 0 -starttime 0ps -endtime 1000ps Edit:/processor/DIN 
wave modify -driver freeze -pattern repeater -initialvalue 0000000000000000 -period 100ps -sequence { 0000000000000000 0000000001000000 0000000000000010 0000000001001000 0000000000000011  } -repeat never -range 15 0 -starttime 0ps -endtime 1000ps Edit:/processor/DIN 
WaveCollapseAll -1
wave clipboard restore
