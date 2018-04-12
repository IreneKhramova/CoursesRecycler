package com.simbirsoft.coursesrecycler;

import java.util.List;

// TODO: класс для получения сущностей. Добавить код загрузки пользователей
public class FriendsRepository {
    public interface FriendsLoadListener{
        void onFriendsLoaded(List<Friend> friends);
        void onError(Throwable error);
    }
}
