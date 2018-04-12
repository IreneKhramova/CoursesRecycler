package com.simbirsoft.coursesrecycler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.util.List;

public class MessagesListActivity extends AppCompatActivity {
    //private List<Message> messagesList;
    private MessagesList messagesList;
    private String senderId = "37a9dc91cad07ee8c9d57157ff9ee2ce";
    //private ImageLoader imageLoader;
    //private MessagesListAdapter<Message> adapter;
    MessageInput input;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages_list);

        //senderId = getIntent().getExtras().getString("senderId");

        this.messagesList = findViewById(R.id.messagesList);

        input = findViewById(R.id.input);
        //input.setInputListener(this);

       /* imageLoader = new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, String url) {
                Picasso.with(MessagesListActivity.this).load(url).into(imageView);
            }
        };*/

        final MessagesListAdapter<Message> adapter = new MessagesListAdapter<>(senderId, /*imageLoader*/null);
        messagesList.setAdapter(adapter);

        final MessagesRepository messagesRepository = new MessagesRepository();
        messagesRepository.loadMessages(new MessagesRepository.MessagesLoadListener() {
            @Override
            public void onMessagesReceived(Message messages) {
                adapter.addToStart(messages, true);
            }

            @Override
            public void onError(Throwable error) {
                //Toast.makeText(this, throwable.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        input.setInputListener(new MessageInput.InputListener() {
            @Override
            public boolean onSubmit(CharSequence input) {
                //validate and send
                //adapter.addToStart(message, true);

                messagesRepository.addMessage(input.toString());

                return true;
            }
        });
    }
}
