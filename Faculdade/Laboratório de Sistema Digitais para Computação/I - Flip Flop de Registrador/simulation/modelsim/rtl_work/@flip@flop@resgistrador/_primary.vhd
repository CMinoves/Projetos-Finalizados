library verilog;
use verilog.vl_types.all;
entity FlipFlopResgistrador is
    port(
        q3              : out    vl_logic;
        q2              : out    vl_logic;
        q1              : out    vl_logic;
        q0              : out    vl_logic;
        reset           : in     vl_logic;
        clock           : in     vl_logic;
        \in\            : in     vl_logic
    );
end FlipFlopResgistrador;
