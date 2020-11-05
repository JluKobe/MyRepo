package com.spring.bean.di.useAnno.autowired;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Autowired注解的几种使用方式
 * 1、应用于构造函数
 * 2、应用于 setter 方法
 * 3、应用于具有任意名称和多个参数的方法
 * 4、应用于字段，或者将其与构造函数混合
 */
public class MovieRecommender {
    private CustomerPreferenceDao customerPreferenceDao;

    private MovieFinder movieFinder;

    //@Autowired 注释应用于字段，或者将其与构造函数混合
    @Autowired
    private MovieCatalog movieCatalog;

    //@Autowired 注释应用于构造函数
    @Autowired
    public MovieRecommender(CustomerPreferenceDao customerPreferenceDao) {
        this.customerPreferenceDao = customerPreferenceDao;
    }

    //@Autowired 注释应用于 setter 方法
    @Autowired
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    //@Autowired 注释应用于具有任意名称和多个参数的方法
    @Autowired
    public void prepare(MovieCatalog movieCatalog, CustomerPreferenceDao customerPreferenceDao) {
        this.movieCatalog = movieCatalog;
        this.customerPreferenceDao = customerPreferenceDao;
    }
}
