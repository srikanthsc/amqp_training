package fr.lernejo.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

class menu{
    public void menu(){
        System.out.println("menu pour les touches");
        //System.out.println("saisissez un msg pour l'envoyer");
        //System.out.println("pour quitter le programme appuyer sur q");
        System.out.println("Input a message, we will send it for you (q to quit)");
    }
}

class donesended{
    public void sended() {
        System.out.print("Message sent. ");
    }
}
@SpringBootApplication
public class Launcher {
private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu m = new menu();
        donesended ds =new donesended();
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate objet = annotationConfigApplicationContext.getBean(RabbitTemplate.class);

        String userInput;
        boolean again = true;
        m.menu();
        userInput = sc.nextLine();
        objet.convertAndSend("", "chat_messages", userInput);

        while (again) {
  m.menu();
            userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("q")) {
                again = false;
                continue;
            }
            objet.convertAndSend("", "chat_messages", userInput);
            ds.sended();
        }
    }
}
