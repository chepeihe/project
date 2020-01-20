package com.test.project.com.test.cglib;


import com.test.project.com.test.annotation.MyAnnotation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @program: project
 * @description: 参数校验
 * @author: chepeihe
 * @create: 2020-01-20 16:25
 **/
public class HelloServiceCgLib implements MethodInterceptor {

    private Class target;

    public Object getInstance(Class target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        System.out.println("我是CGLIB的动态代理");
        System.out.println("我准备执行了");
        if (!check(method,objects)) {
            System.out.println("我没能成功执行");
            return false;
        }
        Object returnObj = proxy.invokeSuper(object, objects);
        System.out.println("我已经正确执行过了");
        return returnObj;
    }

    /**
     * 对参数校验的方法
     * @param method 目标方法
     * @param objects 相关参数值
     * @return
     */
    public  boolean check(Method method,Object[] objects)  {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i <parameters.length; i++) {
            Parameter parameter = parameters[i];
            if (parameter.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = parameter.getAnnotation(MyAnnotation.class);
                if (objects==null ||objects[i]==null) {
                    System.out.println(parameter.getName()+annotation.msg());
                    return false;
                }
            }
        }
        return true;
    }


}
