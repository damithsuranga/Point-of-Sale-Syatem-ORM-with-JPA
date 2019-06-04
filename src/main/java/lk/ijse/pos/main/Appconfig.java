package lk.ijse.pos.main;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(JPAconfig.class)
@Configuration
@ComponentScan("lk.ijse.pos")
public class Appconfig {


}
