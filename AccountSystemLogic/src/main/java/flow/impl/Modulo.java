package flow.impl;

public class Modulo {
    public Integer doMod(int minus, int minusedby) {
        if(minusedby == -1){
            throw new RuntimeException("Miles cannot be minused by negative number!")
        }

        return minus - minusedby;
    }

}
