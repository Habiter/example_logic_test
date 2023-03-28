package ex3ALU
import chisel3._
import chisel3.util._
class ALU_Simple4 extends Module {
    val io = IO{new Bundle() {
        val a = Input(SInt(4.W))
        val b = Input(SInt(4.W))
        val func_select = Input(UInt(3.W))

        val c = Output(UInt(4.W))
    }}
    switch(io.func_select){
        is(0.U(3.W)){ // plus
            io.c := io.a + io.b
        }
        is(1.U(3.W)) { // minus
            io.c := io.a - io.b
        }
        is(2.U(3.W)) { // not
            io.c := ~io.a
        }
        is(3.U(3.W)) { // and
            io.c := io.a & io.b
        }
        is(4.U(3.W)) { // or
            io.c := io.a | io.b
        }
        is(5.U(3.W)) { // xor
            io.c := io.a ^ io.b
        }
        is(6.U(3.W)) { // compare a<b 1 a>=b 0
            when(io.a > io.b){
                io.c := 1.U(3.W)
            }.otherwise{
                io.c := 0.U(3.W)
            }
        }
        is(7.U(3.W)) { // isequal
            when(io.a === io.b){
                io.c := 1.U(3.W)
            }.otherwise{
                io.c := 0.U(3.W)
            }
        }
    }
}
