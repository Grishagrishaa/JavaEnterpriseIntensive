package org.example.JavaEnterpriseIntensive.telegraph.service;

import org.example.JavaEnterpriseIntensive.telegraph.core.dto.Message;
import org.example.JavaEnterpriseIntensive.telegraph.core.dto.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MessageService {
    private UsersService usServ = UsersService.getInstance();
    private Map<User, List<Message>> messagePool = new HashMap<>();
    private StatisticService statistic = StatisticService.getInstance();

    public void sendMessage(HttpServletRequest req, String recipientLogin, String text){
        User sender = (User) req.getSession().getAttribute("user");
        User recipient = usServ.findUserByLogin(recipientLogin);

        if(recipient == null){
            throw new IllegalArgumentException("Получатель не найден");
        }

        if (sender == null){
            throw new RuntimeException("ПОЛЬЗОВАТЕЛЬ НЕ НАЙДЕН");
        }

        Message message = new Message(sender,recipient, text);

        if(!messagePool.containsKey(recipient)){
            ArrayList<Message> clearList = new ArrayList<>();
            clearList.add(message);

            statistic.messagesCountIncrement();
            messagePool.put(recipient,clearList);
        }else {
            statistic.messagesCountIncrement();
            getMessageBox(recipient).add(message);
        }
    }

    public List<Message> getMessageBox(String login){
        User recipient = usServ.findUserByLogin(login);

        for (Map.Entry<User, List<Message>> userEntry : messagePool.entrySet()) {
            if(userEntry.getKey().equals(recipient)){
                return userEntry.getValue();
            }
        }
        return Collections.emptyList();
    }

    public List<Message> getMessageBox(User recipient){

        for (Map.Entry<User, List<Message>> userEntry : messagePool.entrySet()) {
            if(userEntry.getKey().equals(recipient)){
                return userEntry.getValue();
            }
        }
        return Collections.emptyList();
    }
}
