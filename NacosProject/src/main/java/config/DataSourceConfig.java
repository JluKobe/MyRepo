package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${db1.url}")
    private String db1Url;

    @Value("${db1.username}")
    private String db1Username;

    @Value("${db1.password}")
    private String db1Password;

    @Value("${driver}")
    public String driver;

    @Bean(name = "db1")
    public DataSource db1() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(db1Url);
        dataSourceBuilder.username(db1Username);
        dataSourceBuilder.password(db1Password);
        dataSourceBuilder.driverClassName(driver);
        return dataSourceBuilder.build();
    }
}
