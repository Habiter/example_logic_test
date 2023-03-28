package ex3ALU
import chisel3._
class full_adder_nbit(n:Int,m:Int) extends Module {
    assert(m>(n+1),"Wrong bitwidth")
    val io = IO{ new Bundle() {
        val a = Input(SInt(n.W))
        val b = Input(SInt(n.W))
        val sum = Output(SInt(m.W))
    }}
    io.sum := io.a + io.b
}
