package maria.hei.gestion_location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"maria.hei.gestion_location", "maria.hei.gestion_location.controller"})
public class GestionLocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionLocationApplication.class, args);
    }
}
