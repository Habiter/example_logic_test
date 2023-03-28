#include <Verilated.h>
#include "verilated_vcd_c.h" //生成波形时调用
#include "Vcnt_addon.h"
#define MAX_SIM_TIME 2000
uint64_t main_time = 0;
int main(int argc, char** argv, char** env){
    if (false && argc && argv && env) {}
    Verilated::commandArgs(argc,argv);//打开
    Verilated::traceEverOn(true);
    Vcnt_addon* top = new Vcnt_addon;
    top->trace(tfp,5);
    tfp->open("wave.vcd");
    top->rst = 1;
    while(main_time < MAX_SIM_TIME )
    {
        /* code */
        top->clk ^= 1;

        if(main_time == 100){
            top->rst = 0;
            top->io_frezze = 0b0;
        }else if(main_time == 1800){
            top->io_frezze = 0b1;
        }

        top->eval();
        tfp->dump(main_time);
        main_time++;
    }
    tfp->close();
    delete top;
    exit(EXIT_SUCCESS);
    return 0;
}