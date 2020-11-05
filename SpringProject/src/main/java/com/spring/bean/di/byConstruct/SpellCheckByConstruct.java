package com.spring.bean.di.byConstruct;

public class SpellCheckByConstruct {
    public SpellCheckByConstruct() {
        System.out.println("Inside SpellCheckByConstruct constructor");
    }

    public void checkSpelling() {
        System.out.println("Inside checkSpelling");
    }
}
