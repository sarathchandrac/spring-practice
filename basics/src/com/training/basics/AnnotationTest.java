package com.training.basics;

import com.training.basics.Annotation.A;

import java.lang.reflect.Constructor;

public class AnnotationTest {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello World");

        // Solution : Use reflection API to solve problem
        try{
            Class<A> c = A.class;
            Constructor<A> constructor = c.getDeclaredConstructor();
            constructor.setAccessible(true);
            A a1 = constructor.newInstance();
            System.out.println(a1);
        }
        catch (Exception e){
            System.out.println("exception");
        }

    }

}
