package com.doozycod.creatorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button addtextButton, addEditText, addRadioButton, addCheckbox, addButton;
    int number = 4, num = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addEditText = findViewById(R.id.edittext);
        addtextButton = findViewById(R.id.textView);
        addRadioButton = findViewById(R.id.RadioButtons);
        addCheckbox = findViewById(R.id.checkbox);
        addButton = findViewById(R.id.submit_btn);

        addEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEditText();
            }
        });
        addtextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTextView();
            }
        });
        addRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRadioGroup();
            }
        });
        addCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCheckbox();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addButton();
            }
        });
    }


    private void addEditText() {
        LinearLayout layout = findViewById(R.id.edittextContainer);
        EditText editText = new EditText(this);
        editText.setHint("Text is here");
        editText.setId(number);
        Log.e("editText", editText.getId() + "");
        editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(editText);
    }

    private void addTextView() {
        LinearLayout layout = findViewById(R.id.edittextContainer);
        TextView tv = new TextView(this);
        tv.setText("Text is here");
        tv.setId(num);
        Log.e("TEXT", tv.getId()+"");

        tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(tv);
    }

    private void addRadioGroup() {
        LinearLayout layout = findViewById(R.id.edittextContainer);
        RadioGroup rg = new RadioGroup(this);
        rg.setId(rg.generateViewId());
        rg.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(rg);
    }

    private void addCheckbox() {
        LinearLayout layout = findViewById(R.id.edittextContainer);
        CheckBox cb = new CheckBox(this);
        cb.setId(cb.generateViewId());
        cb.setText("Checkbox");
        cb.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(cb);
    }

    private void addButton() {
        LinearLayout layout = findViewById(R.id.edittextContainer);
        Button button = new Button(this);
        button.setText("Submit");
        button.setId(button.generateViewId() + 1);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(button);
    }


}
