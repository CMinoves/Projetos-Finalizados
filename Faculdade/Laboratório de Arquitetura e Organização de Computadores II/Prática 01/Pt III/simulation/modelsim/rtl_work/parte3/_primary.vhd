library verilog;
use verilog.vl_types.all;
entity parte3 is
    port(
        clock           : in     vl_logic;
        dataIn          : in     vl_logic_vector(2 downto 0);
        address         : in     vl_logic_vector(4 downto 0);
        hit             : out    vl_logic;
        write_enable    : in     vl_logic;
        via0            : out    vl_logic;
        via1            : out    vl_logic;
        via2            : out    vl_logic;
        via3            : out    vl_logic;
        out_data        : out    vl_logic_vector(8 downto 0)
    );
end parte3;
