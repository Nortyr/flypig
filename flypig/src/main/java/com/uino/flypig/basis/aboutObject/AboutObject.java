package com.uino.flypig.basis.aboutObject;

public class AboutObject {
    public static void main(String[] args) {
        cantChangeReferenceTest();
    }



    private static void cantChangeReferenceTest(){
        Object testA=new TestA();
        cantChangeReference(testA);
        System.out.println(testA instanceof TestA);
        System.out.println(testA instanceof TestB);
    }

    /**
     * 相当于一个值传递
     * @param object
     */
    private static void cantChangeReference(Object object) {
        object=new TestB();

    }
}
