package com.simbirsoft.coursesrecycler;

import android.support.annotation.NonNull;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MessagesRepository {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("messages");

    public void loadMessages(@NonNull final MessagesRepository.MessagesLoadListener messagesLoadListener) {
        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                messagesLoadListener.onMessagesReceived(toMessageList(dataSnapshot));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                messagesLoadListener.onError(databaseError.toException());
            }
        });*/
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                messagesLoadListener.onMessagesReceived(toMessageList(dataSnapshot).get(0));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public interface MessagesLoadListener{
        void onMessagesReceived(Message messages);
        void onError(Throwable error);
    }

    public void addMessage(String text) {
        String id = UUID.randomUUID().toString();
        Message msg = new Message(id,text, Calendar.getInstance().getTime(),
                new Author("37a9dc91cad07ee8c9d57157ff9ee2ce", "Iren", ""));
        myRef.child(id).setValue(msg);
    }

    private List<Message> toMessageList(DataSnapshot dataSnapshot) {
        List<Message> messages = new ArrayList<>();

        Message message = dataSnapshot.getValue(Message.class);
        messages.add(message);

        ////for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
          //  Message msg = new Message();
            /*HashMap s = (HashMap) snapshot.child("createdAt").getValue();

            Date date = new Date((long) s.get("time"));

            msg.setCreatedAt(date);

            msg.setId((String) snapshot.child("id").getValue());
            msg.setText((String) snapshot.child("text").getValue());
            Author user = snapshot.child("user").getValue(Author.class);
            msg.setUser(user);*/
            //msg=snapshot.getValue(Message.class);

            //messages.add(msg);
        //}

        return messages;
    }
}
