package com.example.radiobuttonexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    List<String> list;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        button = findViewById(R.id.button);

        list = new ArrayList<String>();
        list.add("Dog");
        list.add("Cat");

        radioGroup = findViewById(R.id.radiogroup);

        for (int i = 0; i < list.size(); i ++) {
          //  RadioButton rb = (RadioButton) inflater.inflate(R.layout.radio_butt, null);
            RadioButton rb = (RadioButton) inflater.inflate(R.layout.radio_butt, radioGroup, false);

            rb.setText(list.get(i));
            rb.setId(i);
            // rb.setId(View.generateViewId());
            radioGroup.addView(rb);
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "Jeppojee" + radioButton.getText(), Toast.LENGTH_SHORT).show();
                button.setEnabled(true);

            }
        });
    }
}
