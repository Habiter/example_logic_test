package ex1Mux
import chisel3._
class encoder_priority_8to3 extends Module {
    val io = IO{
        new Bundle() {
            val in_code = Input(UInt(8.W))
            val enable = Input(Bool())
            val out_code = Output(UInt(3.W))
            val done = Output(Bool())
        }
    }

    when(io.enable === true.B){
        when(io.in_code(0) === "1".U(1.W)){
            io.out_code := "b000".U
        }.elsewhen(io.in_code(1) === "1".U(1.W)){
            io.out_code := "b001".U
        }.elsewhen(io.in_code(2) === "1".U(1.W)) {
            io.out_code := "b010".U
        }.elsewhen(io.in_code(3) === "1".U(1.W)) {
            io.out_code := "b011".U
        }.elsewhen(io.in_code(4) === "1".U(1.W)) {
            io.out_code := "b100".U
        }.elsewhen(io.in_code(5) === "1".U(1.W)) {
            io.out_code := "b101".U
        }.elsewhen(io.in_code(6) === "1".U(1.W)) {
            io.out_code := "b110".U
        }.elsewhen(io.in_code(7) === "1".U(1.W)) {
            io.out_code := "b111".U
        }
        io.done := true.B
    }.otherwise{
        io.out_code := "h00".U
        io.done := false.B
    }

}
