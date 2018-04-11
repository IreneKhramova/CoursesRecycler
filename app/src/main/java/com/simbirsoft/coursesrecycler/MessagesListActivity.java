package com.simbirsoft.coursesrecycler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.messages.MessageInput;

public class MessagesListActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_messages_list);

        /*ImageLoader imageLoader = new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, String url) {
                Picasso.with(MessagesListActivity.this).load(url).into(imageView);
            }
        };

        MessagesListAdapter adapter = new MessagesListAdapter(senderId, imageLoader);
        messagesList.setAdapter(adapter);*/

        //here?
        /*inputView.setInputListener(new MessageInput.InputListener() {
            @Override
            public boolean onSubmit(CharSequence input) {
                //validate and send
                adapter.addToStart(message, true);
                return true;
            }
        });*/
    }
}
