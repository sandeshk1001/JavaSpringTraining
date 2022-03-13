package SpringBasic.Day12;

import SpringBasic.Day12.Dependencies_Injection_Sorting.InsertionSort;
import SpringBasic.Day12.Dependencies_Injection_Sorting.Sorting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("bean-config.xml")
public class MyConfiguration {

    @Bean
    public Sorting getInsertionSort(){
        return new InsertionSort();
    }

}
/*
These beans go into Application context and then we can fetch them
from Application Context
 */