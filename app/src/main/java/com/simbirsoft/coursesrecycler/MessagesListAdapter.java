package com.simbirsoft.coursesrecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessagesListAdapter extends
    RecyclerView.Adapter<MessagesListAdapter.MessagesListViewHolder> {

        private List<Message> messages;
        private String senderId;
        private ImageLoader imageLoader;

        /*public void setMessages(List<Message> messages) {
            this.messages = messages;
            notifyDataSetChanged();//использовать и др.методы
        }*/
        public MessagesListAdapter(String senderId, ImageLoader imageLoader) {
            this.senderId = senderId;
            this.imageLoader = imageLoader;
            this.messages = new ArrayList<>();
        }

//////////////
        @Override
        public MessagesListAdapter.MessagesListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_messages_list, parent, false);
            return new MessagesListAdapter.MessagesListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MessagesListAdapter.MessagesListViewHolder holder, int position) {
            holder.setMessage(messages.get(position));
        }

        @Override
        public int getItemCount() {
            return messages.size();
        }


        public class MessagesListViewHolder extends RecyclerView.ViewHolder {
            private String id;
            private String text;
            private Date createdAt;
            private Author author;//????????????????????

            MessagesListViewHolder(View itemView) {
                super(itemView);
                //avatar = itemView.findViewById(R.id.avatar);
                /*message = itemView.findViewById(R.id.message);
                name = itemView.findViewById(R.id.name);
                date = itemView.findViewById(R.id.date);
                messages_badge = itemView.findViewById(R.id.messages_badge);*/
            }

            void setMessage(Message message) {
                /*message.setText(friend.getMessage());
                name.setText(friend.getName());
                date.setText(friend.getDate());
                messages_badge.setText(friend.getMessages_badge());
                Picasso.get().load(message.getUser().getAvatar()).into(avatar);*/
            }
        }
    }