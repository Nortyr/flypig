package com.uino.flypig.basis.aboutExtend;

import lombok.Data;

@Data
public class Son extends Father{
    private int b;
    public void consoleLog(){
        /**
         * super中a是私有，如果是public或protected可以用super.a
         */
        System.out.println(super.getA());
        System.out.println(super.getB());
        System.out.println(this.getB());


    }
}
