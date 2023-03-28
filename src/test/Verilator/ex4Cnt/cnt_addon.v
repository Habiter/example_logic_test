module cnt_addon(
  input         clock,
  input         reset,
  input         io_frezze,
  output [31:0] io_outnum
);
`ifdef RANDOMIZE_REG_INIT
  reg [31:0] _RAND_0;
`endif // RANDOMIZE_REG_INIT
  reg [31:0] cntReg; // @[cnt_addon.scala 10:21]
  wire [31:0] _cntReg_T_1 = cntReg + 32'h1; // @[cnt_addon.scala 12:26]
  assign io_outnum = cntReg; // @[cnt_addon.scala 19:15]
  always @(posedge clock) begin
    if (cntReg == 32'h64) begin // @[cnt_addon.scala 16:35]
      cntReg <= 32'h0; // @[cnt_addon.scala 17:16]
    end else if (~io_frezze) begin // @[cnt_addon.scala 11:21]
      cntReg <= _cntReg_T_1; // @[cnt_addon.scala 12:16]
    end
  end
// Register and memory initialization
`ifdef RANDOMIZE_GARBAGE_ASSIGN
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_INVALID_ASSIGN
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_REG_INIT
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_MEM_INIT
`define RANDOMIZE
`endif
`ifndef RANDOM
`define RANDOM $random
`endif
`ifdef RANDOMIZE_MEM_INIT
  integer initvar;
`endif
`ifndef SYNTHESIS
`ifdef FIRRTL_BEFORE_INITIAL
`FIRRTL_BEFORE_INITIAL
`endif
initial begin
  `ifdef RANDOMIZE
    `ifdef INIT_RANDOM
      `INIT_RANDOM
    `endif
    `ifndef VERILATOR
      `ifdef RANDOMIZE_DELAY
        #`RANDOMIZE_DELAY begin end
      `else
        #0.002 begin end
      `endif
    `endif
`ifdef RANDOMIZE_REG_INIT
  _RAND_0 = {1{`RANDOM}};
  cntReg = _RAND_0[31:0];
`endif // RANDOMIZE_REG_INIT
  `endif // RANDOMIZE
end // initial
`ifdef FIRRTL_AFTER_INITIAL
`FIRRTL_AFTER_INITIAL
`endif
`endif // SYNTHESIS
endmodule
