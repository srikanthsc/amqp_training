package fr.lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class  ChatMessageListener {
private String message;
    public String onMessage(String message){
        this.message=message;
          System.out.println(message);
          return message;

    }
}
