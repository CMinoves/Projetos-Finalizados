library verilog;
use verilog.vl_types.all;
entity choose_data is
    port(
        d0              : in     vl_logic_vector(8 downto 0);
        d1              : in     vl_logic_vector(8 downto 0);
        d2              : in     vl_logic_vector(8 downto 0);
        d3              : in     vl_logic_vector(8 downto 0);
        l0              : in     vl_logic;
        l1              : in     vl_logic;
        l2              : in     vl_logic;
        l3              : in     vl_logic;
        s               : out    vl_logic_vector(8 downto 0)
    );
end choose_data;
