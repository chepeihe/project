package com.test.project.com.test.param;

import com.test.project.com.test.annotation.MyAnnotation;

/**
 * @program: project
 * @description: Hello
 * @author: chepeihe
 * @create: 2020-01-20 16:30
 **/
public class Hello {

    public void sayHello(@MyAnnotation String name, @MyAnnotation String start) {
        System.out.println("hello "+name);
        System.out.println(start);
    }

}
