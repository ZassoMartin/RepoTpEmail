package com.maven.tpEmailZasso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App
        {

            public static void main( String[] args )
            {
                System.out.println( "Hello World!" );

                SpringApplication.run(App.class,args);
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.maven.tpEmailZasso.Modelo");
//        DaoUsuarios dao = applicationContext.getBean("repo1", DaoUsuarios.class);
//        System.out.println(dao.listarUsuarios());


    }
}
