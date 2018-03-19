package com.heguodong.singleton;

/**
 * Created by 何国栋 on 2018/3/19.
 *
 * 饿汉式单例
 */

public class SingletonEhan {

    /**
     * 饿汉式单例类.在类初始化时，已经自行实例化供系统使用，以后不再改变，所以天生是线程安全的
     */
    private SingletonEhan(){}

    private static final SingletonEhan single = new SingletonEhan();

    public static SingletonEhan getSingletonEhanInstance(){
        return single;
    }

}
