library verilog;
use verilog.vl_types.all;
entity state_machine2 is
    port(
        acao            : in     vl_logic_vector(1 downto 0);
        writeback       : out    vl_logic;
        clock           : in     vl_logic;
        abort           : out    vl_logic
    );
end state_machine2;
