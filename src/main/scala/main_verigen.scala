import chisel3._
import ex1Mux._
import ex4Cnt._
import java.io._
object main extends App {
    println(s"hello scala")
    println(s"hello chisel")
    val str_cnt_addon = getVerilogString(new cnt_addon(32))
    println(str_cnt_addon)
    //chisel function
    //emitVerilog(new mux())
    //scala function
    val Filename = ""
    val path = ""
    //val HDLWriter = new PrintWriter(new File())
    val mux_gen = new HDLWriter(str_cnt_addon,s"cnt_addon",s"ex4Cnt")
    mux_gen.generate()
}
