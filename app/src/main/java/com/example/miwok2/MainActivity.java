package com.example.miwok2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView number = (TextView) findViewById(R.id.numbers);
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentn = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(intentn);
            }
        });
        TextView fam=(TextView)findViewById(R.id.family);
        TextView col=(TextView)findViewById(R.id.colors);
        TextView phrases=(TextView)findViewById(R.id.phrases);
        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FamilyMembersActivity.class);
                startActivity(intent);
            }
        });
        col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(intent);
            }
        });
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(intent);
            }
        });
    }
    }
