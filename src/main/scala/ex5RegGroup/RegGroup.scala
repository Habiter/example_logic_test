package ex5RegGroup
import chisel3._
import chisel3.util._
class RegGroup extends Module {
    val io = IO{new Bundle() {
        val data_in = Input(UInt(32.W))

        val data_out = Output(UInt(32.W))
    }}
    //val
}
