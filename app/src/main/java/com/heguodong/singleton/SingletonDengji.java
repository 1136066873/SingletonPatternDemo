package com.heguodong.singleton;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 何国栋 on 2018/3/19.
 *登记式单例
 *
 * 类似Spring里面的方法，将类名注册，下次从里面直接获取。
 * http://blog.csdn.net/jason0539/article/details/23297037
 *
 * 登记式单例实际上维护了一组单例类的实例，将这些实例存放在一个Map（登记薄）中，
 * 对于已经登记过的实例，则从Map直接返回，对于没有登记的，则先登记，然后返回。
 *
 * 实际应用中，它用的比较少，另外其实内部实现还是用的饿汉式单例，因为其中的static方法块，
 * 它的单例在类被装载的时候就被实例化了。
 */

public class SingletonDengji {

    private static Map<String,SingletonDengji> map = new HashMap<>();

    static{
        SingletonDengji single = new SingletonDengji();
        map.put(single.getClass().getName(), single);
    }

    private SingletonDengji(){}

    //静态工厂方法,返还此类惟一的实例
    public static SingletonDengji getInstance(String name) {
        if(name == null) {
            name = SingletonDengji.class.getName();
            // name == null--->name=com.heguodong.singleton.SingletonDengji
            Log.e("SingletonDengji","name == null" + "--->name=" + name);
        }
        if(map.get(name) == null) {
            try {
                map.put(name, (SingletonDengji) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }

    //一个示意性的商业方法
    public String about() {
        return "Hello, I am RegSingleton.";
    }

    public static void main(String[] args) {
        SingletonDengji single3 = SingletonDengji.getInstance(null);
        System.out.println(single3.about());
    }
}

