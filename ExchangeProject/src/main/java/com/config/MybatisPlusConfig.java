package com.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.enums.DBTypeEnum;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * MybatisPlus配置
 */
@Configuration
public class MybatisPlusConfig {

    // 分页拦截器
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    //定义db1
    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")//与配置文件中的层次结构相同
    public DataSource db1() {
        return DruidDataSourceBuilder.create().build();
    }
    //定义db2
    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")//与配置文件中的层次结构相同
    public DataSource db2() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源配置
     * @return
     */
    @Bean
    @Primary
    public DataSource multipleDataSource(@Qualifier("db1") DataSource db1, @Qualifier("db2") DataSource db2) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.db1.getValue(), db1);
        targetDataSources.put(DBTypeEnum.db2.getValue(), db2);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(db1);
        return dynamicDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        //***导入MybatisSqlSession配置***
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        //指明数据源
        sqlSessionFactory.setDataSource(multipleDataSource(db1(), db2()));
        //指明mapper.xml位置(配置文件中指明的xml位置会失效用此方式代替，具体原因未知)
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/**Mapper.xml"));
        //指明实体扫描(多个package用逗号或者分号分隔)
        sqlSessionFactory.setTypeAliasesPackage("javademo.tyh.model.base;javademo.tyh.model.hotel");

        //***导入Mybatis配置***
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setPlugins(new Interceptor[]{paginationInterceptor()});

        return sqlSessionFactory.getObject();
    }
}
