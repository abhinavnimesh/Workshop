package com.workshop.workshop;

/**
 * Created by ANIMATOR ABHI on 31/03/2017.
 */

public class ChatMessages {
    String name;
    String message;

    public ChatMessages(String name, String message) {
        this.name = name;
        this.message = message;
    }


    public ChatMessages() {
    }


    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
