package com.heguodong.singleton;

import android.util.Log;

/**
 * Created by 何国栋 on 2018/3/19.
 *
 * 测试静态属性，静态代码块，静态内部类的加载时机和加载次数
 【①】调用第一次，得到输出日志：
 *
 2018-03-19 17:51:42.395 3467-3467/com.heguodong.singleton E/static:  ==>  Test 1 Construct!
 2018-03-19 17:51:42.395 3467-3467/com.heguodong.singleton E/static:  ==>  Test Static
 2018-03-19 17:51:42.395 3467-3467/com.heguodong.singleton E/static:  ==>  Test 2 Construct!
 2018-03-19 17:51:42.395 3467-3467/com.heguodong.singleton E/static:  ==>  TestInner Static!
 2018-03-19 17:51:42.395 3467-3467/com.heguodong.singleton E/static:  ==>  Test 3 Construct!
 *
 *
 *
 【②】先后创建两次调用，输出日志：
 *
 2018-03-19 17:53:09.605 3559-3559/? E/static:  ==>  Test 1 Construct!
 2018-03-19 17:53:09.605 3559-3559/? E/static:  ==>  Test Static
 2018-03-19 17:53:09.605 3559-3559/? E/static:  ==>  Test 2 Construct!
 2018-03-19 17:53:09.605 3559-3559/? E/static:  ==>  TestInner Static!
 2018-03-19 17:53:09.606 3559-3559/? E/static:  ==>  Test 3 Construct!
 2018-03-19 17:53:09.606 3559-3559/? E/static:  ==>  Test 2 Construct!
 *
 *
【总结】
 * ①通过 debug ，得到代码执行调用的次序是：
 * 当前类静态块/静态属性(按照代码书写顺序加载)-> 类成员属性？？？ -> 类构造方法 -> 静态内部类的静态块/静态属性(按照代码书写顺序加载)-> 静态内部类成员属性？？？
 *
 *
 * ②通过多次执行代码，得到代码执行调用加载次数 ：
 * 当前类的 静态属性 or 静态代码块 一旦加载，则不会再次初始化
 * 当前类的静态内部类一旦加载，以后不会被再次初始化。
 *
 *
 * 引用 http://www.oschina.net/question/2273217_217864
 */

public class Singleton {

    //类非静态属性
    public String TAG = "heguodong";

    //类静态属性
    public static Singleton testOut = new Singleton(1);

    //类静态块
    static {
        Log.e("static"," ==>  " + "Test Static");
    }

    //构造器
    public Singleton(int i ) {
        Log.e("static"," ==>  " + "Test " + i +" Construct! ");
    }

    //静态内部类
    public static class Inner{

        static {
            Log.e("static"," ==>  TestInner Static!");
        }

        public final static Singleton testInstance = new Singleton(3);

    }

    public static Singleton getInstance(){
        return Inner.testInstance;
    }


  /*    public static void main(String args[]){
        Singleton t = new Singleton(2);
        Singleton.getInstance();
    }*/

}
