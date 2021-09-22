library verilog;
use verilog.vl_types.all;
entity counter is
    port(
        Resetn          : in     vl_logic;
        Clock           : in     vl_logic;
        n               : out    vl_logic_vector(4 downto 0)
    );
end counter;
