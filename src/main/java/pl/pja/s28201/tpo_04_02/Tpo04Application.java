package pl.pja.s28201.tpo_04_02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.pja.s28201.tpo_04_02.controller.ProgramController;
import pl.pja.s28201.tpo_04_02.service.ConsoleService;
import pl.pja.s28201.tpo_04_02.service.MockService;

@SpringBootApplication
public class Tpo04Application {

    public static void main(String[] args) {
        SpringApplication.run(Tpo04Application.class, args);
    }

    @Bean
    public CommandLineRunner run(ProgramController controller) {
        return args -> {
            controller.startProgram();
        };
    }

}
