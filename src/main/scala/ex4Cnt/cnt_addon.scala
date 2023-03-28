package ex4Cnt
import chisel3._
import chisel3.util._
class cnt_addon(n:Int) extends Module {
    val io = IO{new Bundle() {
        val frezze = Input(Bool())

        val outnum = Output(UInt(n.W))
    }}
    val cntReg = Reg(UInt(n.W))
    when(!io.frezze){
        cntReg := cntReg + 1.U(n.W)
    }.otherwise{
        cntReg := cntReg
    }
    when(cntReg === "d100".U(n.W)){
        cntReg := 0.U(n.W)
    }
    io.outnum := cntReg

}
