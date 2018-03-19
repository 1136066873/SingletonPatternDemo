package com.heguodong.singleton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Singleton t0 = new Singleton(2);
        Singleton.getInstance();

        Singleton t1 = new Singleton(2);
        Singleton.getInstance();

        SingletonDengji single3 = SingletonDengji.getInstance(null);
        System.out.println(single3.about());

    }
}
