library verilog;
use verilog.vl_types.all;
entity state_machine2 is
    port(
        acao            : in     vl_logic_vector(1 downto 0);
        escrita         : out    vl_logic_vector(1 downto 0);
        clock           : in     vl_logic;
        dataWriteBack   : in     vl_logic;
        dataValueReply  : out    vl_logic;
        sharers         : out    vl_logic_vector(1 downto 0)
    );
end state_machine2;
