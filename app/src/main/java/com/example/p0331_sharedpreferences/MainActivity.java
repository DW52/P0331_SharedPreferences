package com.example.p0331_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    EditText etText;
    EditText etText2;
    EditText etText3;
    EditText etText4;
    Button btnSave, btnLoad, button;

    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";
    final String Saved_Text2 = "saved_text2";
    final String Saved_Text3 = "saved_text3";
    final String Saved_Text4 = "saved_text4";


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = (EditText) findViewById(R.id.etText);
        etText2 = (EditText) findViewById(R.id.etText2);
        etText3 = (EditText) findViewById(R.id.etText3);
        etText4 = (EditText) findViewById(R.id.etText4);


        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        loadText();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
        String Login = intent.getStringExtra("login");
        String Password = intent.getStringExtra("password");
        String Email = intent.getStringExtra("email");
        String Phone = intent.getStringExtra("phone");
        intent.putExtra("login", etText.getText().toString());
        intent.putExtra("password", etText2.getText().toString());
        intent.putExtra("email", etText3.getText().toString());
        intent.putExtra("phone", etText4.getText().toString());
        startActivity(intent);
    }

    void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.putString(Saved_Text2, etText2.getText().toString());
        ed.putString(Saved_Text3, etText3.getText().toString());
        ed.putString(Saved_Text4, etText4.getText().toString());
        ed.commit();

        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        etText.setText(savedText);
        String savedText2 = sPref.getString(Saved_Text2, "");
        etText2.setText(savedText2);
        String savedText3 = sPref.getString(Saved_Text3, "");
        etText3.setText(savedText3);
        String savedText4 = sPref.getString(Saved_Text4, "");
        etText4.setText(savedText4);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
}

