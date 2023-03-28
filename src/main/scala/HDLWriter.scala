import java.io._
import java.io.File
class HDLWriter(text:String         //待写入文本
                ,Filename:String    //文本名，无需.v
                ,Path:String        //写入路径
               ) {
    private val Pathname =  s"/src/test/Verilator/"+ Path + s"/" + Filename + s".v"
    def generate (): Unit = {
        val file = new File("")
        val location_name = file.getAbsolutePath()
        println(Pathname)
        println(s"\n")
        val Pathname_full = location_name + Pathname
        println(Pathname_full)
        println(s"\n")
        val writer = new PrintWriter(new File(Pathname_full))
        println(s"writer ok\n")
        writer.write(text)
        println(s"write ok\n")
        writer.close()
        println(s"file close ok\n")
        println("Generate Done")
    }

}
