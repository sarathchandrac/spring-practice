package com.training.basics.Annotation;

public class A {
    private A(){
        System.out.println("In private class A constructor");
    }

    @Override
    public String toString() {
        return "A{}";
    }
}
