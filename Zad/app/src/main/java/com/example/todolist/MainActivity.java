package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button add;
    Button edit;
    Button delete;
   ArrayList<String> listItem;




    SQLiteManager db = new SQLiteManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItem = new ArrayList<>();
        list = findViewById(R.id.lista);

        viewData();

        add = findViewById(R.id.btnDodaj);
        edit = findViewById(R.id.btnEytuj);
        delete = findViewById(R.id.btnUsun);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dodaj = new Intent(getApplicationContext(), AddList.class);
                startActivity(dodaj);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edytuj = new Intent(getApplicationContext(), EditList.class);
                startActivity(edytuj);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usun = new Intent(getApplicationContext(), DeleteList.class);
                startActivity(usun);
            }
        });

    }
    public void viewData(){
        Cursor cursor = db.viewData();
        if(cursor.getCount() == 0){
            Toast.makeText(MainActivity.this, "Nie ma żadnych informacji", Toast.LENGTH_SHORT).show();
        } else{
            while (cursor.moveToNext()){
                listItem.add("ID:"+cursor.getString(0)+"\n Tytul:"+cursor.getString(1)+"\n Opis:"+cursor.getString(2)+"\n Data rozpoczecia:"+cursor.getString(3));
            }
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem);
            list.setAdapter(adapter);
        }
    }
}
