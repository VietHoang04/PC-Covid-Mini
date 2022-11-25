package com.example.pccovidmini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    // creating variables for our edit text and buttons.
    private Context context;
    private EditText editNationalID;
    private Button  loginBtn, registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;

        connectView();
    }
    private void connectView() {
        editNationalID = (EditText) findViewById(R.id.et_date1);

        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.btn_register).setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_register:
                register();
                break;
        }
    }
    private void login() {
        boolean error = false;




        // get data
        String nationalID = editNationalID.getText().toString().trim();


        // National ID empty
        if (TextUtils.isEmpty(nationalID)) {
            editNationalID.requestFocus();
            editNationalID.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        // all data is ok

        if (!error) {
            // create intent to show Main Activity
            Intent intent = new Intent(context, otp_code.class);

            // send data if need
            intent.putExtra("National ID", nationalID);

            // start Main Activity
            startActivity(intent);
        }
    }

    private void register() {
        Intent intent = new Intent(context, RegisterActivity.class);

        // send data if need

        // start Main Activity
        startActivity(intent);
    }

}