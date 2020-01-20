package com.test.project.com.test.param;

import com.test.project.com.test.cglib.HelloServiceCgLib;

/**
 * @program: project
 * @description: AnnotationTest
 * @author: chepeihe
 * @create: 2020-01-20 16:30
 **/
public class AnnotationTest {

    public static void main(String[] args) {
        HelloServiceCgLib helloServiceCgLib = new HelloServiceCgLib();
        Hello proxy = (Hello) helloServiceCgLib.getInstance(Hello.class);
        proxy.sayHello("world","test");
    }

}
