package com.simbirsoft.coursesrecycler.repo;

import com.simbirsoft.coursesrecycler.domain.Friend;

import java.util.List;

public class FriendsRepository {
    public interface FriendsLoadListener{
        void onFriendsLoaded(List<Friend> friends);
        void onError(Throwable error);
    }
}
