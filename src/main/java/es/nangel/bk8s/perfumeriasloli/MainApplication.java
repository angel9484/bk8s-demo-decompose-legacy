package es.nangel.bk8s.perfumeriasloli;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    private static Class<MainApplication> mainApplicationClass = MainApplication.class;

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(mainApplicationClass, args);
    }
}
