package ex3ALU
import chisel3._
class full_adder_onebit extends Module {
    val io = IO{ new Bundle() {
        val carry_in = Input(Bool())
        val a = Input(Bool())
        val b = Input(Bool())
        val sum = Output(Bool())
        val carry_out = Output(Bool())
    }
    }
    io.sum := (io.a && io.b) || (io.carry_in && (!io.a || !io.b))
    io.carry_out := ((! io.carry_in) || (!io.a || !io.b ))
}
