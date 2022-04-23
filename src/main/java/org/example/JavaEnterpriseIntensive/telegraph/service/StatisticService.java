package org.example.JavaEnterpriseIntensive.telegraph.service;

import java.util.concurrent.atomic.AtomicInteger;

public class StatisticService {
    private static StatisticService statisticService;

    private AtomicInteger usersCount = new AtomicInteger(0);
    private AtomicInteger messagesCount = new AtomicInteger(0);

    private StatisticService() {
    }


    public AtomicInteger getUsersCount() {
        return usersCount;
    }

    public AtomicInteger getMessagesCount() {
        return messagesCount;
    }

    public void usersCountIncrement(){
        usersCount.incrementAndGet();
    }

    public void usersCountDecrement(){
        usersCount.decrementAndGet();
    }

    public void messagesCountIncrement(){
        messagesCount.incrementAndGet();
    }




    public static StatisticService getInstance(){
        if(statisticService == null){
            statisticService = new StatisticService();
        }
        return statisticService;
    }
}
