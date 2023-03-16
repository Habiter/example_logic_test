import chisel3._
import ex1Mux._
object main extends App {
    println(s"hello scala")
    println(s"hello chisel")
    val str_mux = getVerilogString(new mux())
    println(str_mux)
}
