library verilog;
use verilog.vl_types.all;
entity mux_41 is
    port(
        l1              : in     vl_logic;
        l2              : in     vl_logic;
        l3              : in     vl_logic;
        l4              : in     vl_logic;
        a               : in     vl_logic;
        b               : in     vl_logic;
        S               : out    vl_logic
    );
end mux_41;
