package com.example.shouflihaldocteurv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomingPage extends AppCompatActivity {
    FirebaseAuth auth;
    Button button,btn_rdv;

    TextView textView;
    FirebaseUser User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcoming_page);

        btn_rdv = ( Button) findViewById(R.id.button6);
        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        textView = findViewById(R.id.user_details);
        User = auth.getCurrentUser();

        if(User==null){
            Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
            startActivity(intent);
            finish();
        }
        else {
            textView.setText(User.getEmail());

        }

        btn_rdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRdvPage1();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void openRdvPage1(){
        Intent intent = new Intent(this,Rendez_vous.class);
        startActivity(intent);
        finish();
    }

}