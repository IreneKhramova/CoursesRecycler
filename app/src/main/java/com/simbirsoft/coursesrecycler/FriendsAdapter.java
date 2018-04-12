package com.simbirsoft.coursesrecycler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;
import static android.support.v4.content.ContextCompat.startActivity;

public class FriendsAdapter extends
    RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder> {

    private List<Friend> friends = new ArrayList<>();

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
        notifyDataSetChanged();//использовать и др.методы
    }

    @Override
    public FriendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friend_item, parent, false);
        return new FriendsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendsViewHolder holder, int position) {
        holder.setFriend(friends.get(position));
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }


    public class FriendsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView message;
        private TextView name;
        private RoundedImageView avatar;
        private TextView date;
        private TextView messages_badge;

        FriendsViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            message = itemView.findViewById(R.id.message);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            messages_badge = itemView.findViewById(R.id.messages_badge);
            itemView.setOnClickListener(this);
        }

        void setFriend(Friend friend) {
            message.setText(friend.getMessage());
            name.setText(friend.getName());
            date.setText(friend.getDate());
            messages_badge.setText(friend.getMessages_badge());
            Picasso.get().load(friend.getAvatar()).into(avatar);
        }

        @Override
        public void onClick(View v) {
            //переход в др активити
            //Intent intent = new Intent(getActivity(),MessagesListActivity.class);
            //startActivity(intent);
          //  MessagesListActivity.start();

            final Context a = v.getContext();//getActivity();
            Intent intent = new Intent(a, MessagesListActivity.class);
            a.startActivity(intent);
        }
    }
}
