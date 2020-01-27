package com.uino.flypig.basis.aboutExtend;

import lombok.Data;

@Data
public class Father {
    private int a;
    private int b;

    /**
     * 这个就是打印的父类的，也就是省略了this
     */
    public  final void getCurrentAandB(){
        System.out.println(a+"   "+b);
    }
}
