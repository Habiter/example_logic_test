package ex1Mux
import chisel3._
class mux extends Module {
    val io = IO{ new Bundle() {
        val a = Input(Bool())
        val b = Input(Bool())
        val s = Input(Bool())
        val y = Output(Bool())
    }}
    io.y := (io.a && (!io.s)) || (io.b && (io.s))
}
