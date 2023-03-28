package ex1Mux
import chisel3._
class mux4to1 extends Module {
    val io = IO(new Bundle() {
        val a = Input(UInt(2.W))
        val b = Input(UInt(2.W))
        val c = Input(UInt(2.W))
        val d = Input(UInt(2.W))

        val select = Input(UInt(2.W))

        val out = Output(UInt(2.W))
    })
    when(io.select === "b00".U){
        io.out := io.a
    }.elsewhen(io.select === "b01".U) {
        io.out := io.b
    }.elsewhen(io.select === "b10".U) {
        io.out := io.c
    }.elsewhen(io.select === "b11".U){
        io.out := io.d
    }
}
