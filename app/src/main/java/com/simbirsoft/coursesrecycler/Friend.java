package com.simbirsoft.coursesrecycler;

// TODO: добавить все необходимые поля в класс
public class Friend {
    private String avatar;
    //private String id;//messages_badge;
    private Long id;
    private String date;
    private String message;
    private String name;

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;/*messages_badge;*/
    }

    public String getAvatar() {
        return avatar;
    }
}
