package com.heguodong.singleton;

import android.util.Log;

/**
 * Created by 何国栋 on 2018/3/19.
 *
 * 懒汉式单例
 */

public class SingletonLanhan {

    /**
     * 写法三
     * 使用静态内部类(既实现了线程安全，又避免了同步带来的性能影响)
     *
     * */

    private SingletonLanhan(){
        Log.e("heguodong","构造方法只会调用打印一次。");
    }

    private static class LazyHolder{
        private static final SingletonLanhan INSTANCE = new SingletonLanhan();
    }

    public static final SingletonLanhan getSingletonLanhanInstance(){
        return LazyHolder.INSTANCE;
    }

    private void test(){
        Log.e("heguodong","方法调用成功。");
    }



    /**
     * 写法二
     * 1，在 getInstance 方法上加同步；
     * 2，双重检查锁定；
     * 但是还有 终极写法，如上面的写法三，使用静态内部类(既实现了线程安全，又避免了同步带来的性能影响)。
     *
     *

     private SingletonLanhan(){
          Log.e("heguodong","构造方法只会调用打印一次。");
     }

     private static SingletonLanhan singletonLanhan = null ;

     public static SingletonLanhan getSingletonLanhanInstance(){
        if (singletonLanhan == null){
            synchronized (SingletonLanhan.class){
                singletonLanhan = new SingletonLanhan();
            }
        }
        return singletonLanhan;
     }

     private void test(){
        Log.e("heguodong","方法调用成功。");
     }


 */





/**
 * 写法一
 * 一般懒汉式单例模式会写成这样，但是这种写法没有考虑线程安全问题，它是线程不安全的。并发环境下，可能
 * 会出现多个 SingletonLanhan 的实例，要想实现线程安全，有写法二，在多个方面保证懒汉式单例的线程安全。
 *
 *  private SingletonLanhan(){
        Log.e("heguodong","构造方法只会调用打印一次。");
    }

    private static SingletonLanhan singletonLanhan = null;

    public static SingletonLanhan getSingletonLanhanInstance(){
        if (singletonLanhan == null){
            singletonLanhan = new SingletonLanhan();
        }
        return singletonLanhan;
    }

    private void test(){
        Log.e("heguodong","方法调用成功。");
    }


 */

}
