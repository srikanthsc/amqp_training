package lernejo.chat;

import java.util.LinkedList;
import java.util.List;

public class ChatMessageRepository {
    List<String> mymessage_list = new LinkedList<>();

    public void addChatMessage(String message) {

        mymessage_list.add(message);
    }

    public List<String> getLastTenMessages() {
        List<String> mylist =

            new LinkedList<>();

        if (mymessage_list.size() > 10 -1) {
            for (int i = mymessage_list.size() - 10; i

                < mymessage_list.size(); i++) {



                mylist.add(mymessage_list.get(i));
            }
        } else {


            mylist.addAll(mymessage_list);

        }

        return mylist;
    }
}
