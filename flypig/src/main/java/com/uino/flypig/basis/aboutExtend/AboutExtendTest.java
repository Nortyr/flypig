package com.uino.flypig.basis.aboutExtend;

public class AboutExtendTest {
    public static void main(String[] args) {
        easyTestAboutExtend();
    }

    /**
     * 简单的测试吧，关于继承，总结一下，子类有用子类的，子类没有用父类的。
     *
     * 多态：一个变量可以指向多种实际类型。
     * 动态绑定：运行时能自动选择调用哪个方法。
     */
    public static void easyTestAboutExtend(){
        Father father=new Son();
        father.setA(1);
        father.setB(1);
        father.getCurrentAandB();
        Son son=(Son)father;
        son.consoleLog();

    }
}
