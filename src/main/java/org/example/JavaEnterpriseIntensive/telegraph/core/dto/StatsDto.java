package org.example.JavaEnterpriseIntensive.telegraph.core.dto;

public class StatsDto {
    private int usersCount;
    private int messagesCount;

    public StatsDto(int usersCount, int messagesCount) {
        this.usersCount = usersCount;
        this.messagesCount = messagesCount;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getMessagesCount() {
        return messagesCount;
    }
}
