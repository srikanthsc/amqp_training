package lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {
    public static ChatMessageRepository myrepo = new ChatMessageRepository();
    public void onMessage(String message) {
        //System.out.println(message);
        myrepo.addChatMessage(message);
    }
}
