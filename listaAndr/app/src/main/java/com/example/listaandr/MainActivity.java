package com.example.listaandr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.list);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Zakupy: chleb, masło, ser");
        arrayList.add("Do zrobienia: obiad, umyć podłogi");
        arrayList.add("weekend: kino, spacer z psem");
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
    }
    public void add(View v){
        arrayAdapter.add(String.valueOf(editText.getText()));
    }
}