package ru.tronin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.tronin.Controllers.ConsoleController;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConsoleController controller = context.getBean("consoleController", ConsoleController.class);
        while (true) {
            controller.handleConsoleMsg();
        }

    }
}
