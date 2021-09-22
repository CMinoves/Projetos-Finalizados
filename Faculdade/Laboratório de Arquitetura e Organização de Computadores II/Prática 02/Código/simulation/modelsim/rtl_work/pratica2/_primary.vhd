library verilog;
use verilog.vl_types.all;
entity pratica2 is
    port(
        Resetn          : in     vl_logic;
        PClock          : in     vl_logic;
        MClock          : in     vl_logic;
        Run             : in     vl_logic;
        \Bus\           : out    vl_logic_vector(15 downto 0);
        Done            : out    vl_logic
    );
end pratica2;
