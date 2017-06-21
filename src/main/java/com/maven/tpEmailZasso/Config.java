package com.maven.tpEmailZasso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by martin on 13/06/17.
 */
@Configuration
public class Config {

    @Autowired
    AuthFilter authFilter;

    @Bean(name = "conexion")
    public Connection getConnection(@Value("${db.name}")String dbName, @Value("${db.host}")String hst, @Value("${db.port}")int puerto, @Value("${db.username}")String Usrname, @Value("${db.password}")String pass)
    {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+hst+":"+puerto+"/"+dbName+"", Usrname, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(authFilter);
        registration.addUrlPatterns("/api/*");
        return registration;
    }

}
