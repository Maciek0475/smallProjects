package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddList extends AppCompatActivity {
    Button btnPow;
    Button btnAdd;
    EditText TitleTxt;
    EditText DescTxt;
    EditText DataTxt;
    EditText Done;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj);
        btnAdd = findViewById(R.id.btnAdd);
        TitleTxt = findViewById(R.id.textTytul);
        DescTxt = findViewById(R.id.textOpis);
        DataTxt = findViewById(R.id.textData);
        Done = findViewById(R.id.zrobine);
        SQLiteManager db = new SQLiteManager(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String tytul = TitleTxt.getText().toString();
               String opis = DescTxt.getText().toString();
               String data = DataTxt.getText().toString();
               String zrob = Done.getText().toString();
               if(!tytul.equals("") && !opis.equals("") && !data.equals("") && !zrob.equals("")&& db.insertData(tytul,opis,data, zrob)){
                   Toast.makeText(AddList.this, "Dodano do bazy", Toast.LENGTH_SHORT).show();
               }
                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);
            }
        });
    }

    public boolean insertData(String tytułTestowy, String opisTestowy, String dataTestowa) {
        return false;
    }
}