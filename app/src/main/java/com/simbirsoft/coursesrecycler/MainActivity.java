package com.simbirsoft.coursesrecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FriendsAdapter friendsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: добавить сюда кода инициализации ресайклера
        RecyclerView recyclerView = findViewById(R.id.friends_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        friendsAdapter = new FriendsAdapter();
        recyclerView.setAdapter(friendsAdapter);



        final FriendsRepository friendsRepository = new FriendsRepository();
        friendsRepository.loadFriends(new FriendsRepository.FriendsLoadListener() {
            @Override
            public void onFriendsLoaded(List<Friend> friends) {
                friendsAdapter.setFriends(friends);
            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }
}
