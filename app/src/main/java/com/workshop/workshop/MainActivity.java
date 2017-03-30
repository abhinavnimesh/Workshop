package com.workshop.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    String user,message;
    TextView tv;
    EditText msg;
    ScrollView sc;
    String disp="Messages: \n";
    private FirebaseDatabase database;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Intent intent=getIntent();
        tv= (TextView) findViewById(R.id.textView2);
        tv.setText(disp);
        send=(Button) findViewById(R.id.button1);
        sc=(ScrollView) findViewById(R.id.scroll);
        msg= (EditText) findViewById(R.id.textMessage);
        user=intent.getStringExtra("username");
        database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference().child("chat");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message=msg.getText().toString();
              ChatMessages chat=new ChatMessages(user,message);
               // ref.setValue(chat);
             //   ref.child("message").push().setValue(chat);
                ref.push().setValue(chat);
                msg.setText("");
                sc.fullScroll(View.FOCUS_DOWN);
            }
        });


        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChatMessages chat=dataSnapshot.getValue(ChatMessages.class);

                disp=disp+chat.getName()+" : "+chat.getMessage()+"\n";
                tv.setText(disp);

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
}
