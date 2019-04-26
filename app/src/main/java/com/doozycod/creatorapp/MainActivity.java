package com.doozycod.creatorapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button addtextButton, addEditText, addRadioButton, addCheckbox, addButton, save_button;
    int et_ids, tv_ids, checkbox_ids, btn_ids;
    String et, tv_btn, checkbox_btn, btn;
    DBHelper dbHelper;
    List<String> inputString = new ArrayList<>();
    List<String> inputType = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        addEditText = findViewById(R.id.edittext);
        addtextButton = findViewById(R.id.textView);
        addRadioButton = findViewById(R.id.RadioButtons);
        addCheckbox = findViewById(R.id.checkbox);
        addButton = findViewById(R.id.submit_btn);
        save_button = findViewById(R.id.save_btn);

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
//                addRadioGroup();
            }
        });
        addCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertCheckBox();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addButton();
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Save form");

        final EditText input = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);
        builder.setCancelable(true);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getApplicationContext(), "Text entered is " + input.getText().toString(), Toast.LENGTH_SHORT).show();
                Log.e("DB Data", inputString + "----- " + et_ids + "--" + tv_btn + " " + tv_ids + "--" + checkbox_btn + " " + checkbox_ids + "--" + btn + " " + btn_ids);

//                dbHelper.insert(input.getText().toString(), );
            }
        });
        builder.show();
    }

    private void showAlertCheckBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Checkbox Name");

        final EditText input = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);
        builder.setCancelable(true);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getApplicationContext(), "Text entered is " + input.getText().toString(), Toast.LENGTH_SHORT).show();
                addCheckbox(input.getText().toString());


            }
        });
        builder.show();

    }

    private void addEditText() {
        et = "et";
        inputString.add(et);
        et_ids = et_ids + 1;
        LinearLayout layout = findViewById(R.id.edittextContainer);
        EditText editText = new EditText(this);
        editText.setHint("Text is here");
        editText.setId(et_ids);
        Log.e("editText", editText.getId() + "");
        editText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(editText);

    }

    private void addTextView() {
        tv_btn = "tv";

        tv_ids = tv_ids + 1;
        LinearLayout layout = findViewById(R.id.edittextContainer);
        TextView tv = new TextView(this);
        tv.setText("Text");
        tv.setId(tv_ids);
        Log.e("TEXT", tv.getId() + "");

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

    private void addCheckbox(String checkbox) {
        checkbox_btn = "cb";
        checkbox_ids = checkbox_ids + 1;
        LinearLayout layout = findViewById(R.id.edittextContainer);
        CheckBox cb = new CheckBox(this);
        cb.setId(checkbox_ids);
        cb.setText(checkbox);
        cb.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(cb);
    }


    private void addButton() {
        btn = "btn";
        btn_ids = btn_ids + 1;
        if (btn_ids == 1) {
            LinearLayout layout = findViewById(R.id.edittextContainer);
            Button button = new Button(this);
            button.setText("Submit");
            button.setId(btn_ids);
            Log.e("Button", button.getId() + "");
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            layout.addView(button);
        } else {
            Toast.makeText(this, "Use only one", Toast.LENGTH_SHORT).show();
        }
        btn_ids = 1;
    }


}
