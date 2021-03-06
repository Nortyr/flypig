package com.uino.flypig.basis.aboutReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

/**
 * 能够分析类能力的程序称为反射
 * 反射包下的类：
 *      AccessibleObject AccessibleObject类是Field，Method和Constructor对象的基类。
 *      Array Array类提供静态方法来动态创建和访问Java数组。
 *      Constructor<T> Constructor提供了一个类的单个构造函数的信息和访问权限。
 *      Executable 方法和Constructor的共同功能的共享超类 。
 *      Field A Field提供有关类或接口的单个字段的信息和动态访问。
 *      Method A Method提供有关类和接口上单个方法的信息和访问。
 *      Modifier Modifier类提供了 static方法和常量来解码类和成员访问修饰符。
 *      Parameter 有关方法参数的信息。
 *      Proxy Proxy提供了创建动态代理类和实例的静态方法，它也是由这些方法创建的所有动态代理类的超类。
 *      ReflectPermission 反思操作的权限类。
 *
 * 反射概念：
 * 提供用于获取关于类和对象的反射信息的类和接口。
 *
 * 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
 * 对于任意一个对象，都能够调用它的任意一个方法和属性；
 * 这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
 *
 * 反射机制主要提供了以下功能：
 * 　　在运行时判断任意一个对象所属的类；
 * 　　在运行时构造任意一个类的对象；
 * 　　在运行时判断任意一个类所具有的成员变量和方法；
 * 　　在运行时调用任意一个对象的方法；
 * 　　生成动态代理。
 *
 */
public class AboutReflectionTest {
    public static void main(String[] args) {
        Class c=getClassObject();
        Class superC=c.getSuperclass();
        String modifiers= Modifier.toString(c.getModifiers());
        if(modifiers.length()>0) {
            System.out.print(modifiers+"  ");
        }
        System.out.println("class Date");
        if(superC!=null &&superC !=Object.class){
            System.out.print("extends"+superC.getName());
        }
        System.out.println("\n{");
        printConstructors(c);
        System.out.println();
        printMethods(c);
        System.out.println();
        printFields(c);
        System.out.println("}");
    }

    private static void printFields(Class c) {
        Field[] fs=c.getDeclaredFields();
        for (Field f:fs) {
            Class type=f.getType();
            String name=type.getName();
            System.out.print("  ");
            String modifiers=Modifier.toString(f.getModifiers());
            if(modifiers.length()>0){
                System.out.print(modifiers+" ");
            }
            System.out.print(type.getName()+" "+name+";");
        }
    }

    private static void printMethods(Class c) {
        Method[] methods=c.getDeclaredMethods();
        for (Method m:methods) {
            Class retType=m.getReturnType();
            String name=m.getName();
            System.out.print("   ");
            String modifiers=Modifier.toString(m.getModifiers());
            if(modifiers.length()>0){
                System.out.println(modifiers+"  ");
            }
            System.out.println(retType.getName()+" "+name+"(");
            Class[] paramTypes=m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if(i>0){
                    System.out.print(",");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.print(");");
        }
    }

    private static void printConstructors(Class c) {
        Constructor[] constructors=c.getConstructors();
        for (Constructor con:constructors) {
            String name=c.getName();
            System.out.print("   ");
            String modifiers=Modifier.toString(c.getModifiers());
            if (modifiers.length()>0){
                System.out.print(modifiers+"  ");
                System.out.print(name+"(");
            }
            Class[] paramTypes=con.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if(i>0){
                    System.out.print(",");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.print(");");
        }
    }

    public static Class getClassObject(){
        //1
//        Date date=new Date();
//        Class c=date.getClass();
        //2
//        Class c = null;
//        try {
//            c=Class.forName("java.util.Date");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        // 3
        Class c=Date.class;
        return c;
    }
}
