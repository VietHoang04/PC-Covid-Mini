package com.example.pccovidmini;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.text.TextUtils;
public class otp_code extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private EditText editOTPCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_code);
        context = this;

        connectView();
    }

    private void connectView() {
        editOTPCode = (EditText) findViewById(R.id.editOTPCode);

        findViewById(R.id.btn_continue).setOnClickListener(this);
        findViewById(R.id.ic_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_continue:
                LoginMain_OTP();
                break;
            case R.id.ic_back:
                super.onBackPressed();
                break;
        }
    }

    private void LoginMain_OTP() {
        boolean error = false;
        String otp = editOTPCode.getText().toString().trim();



        if (TextUtils.isEmpty(otp)) {
            editOTPCode.requestFocus();
            editOTPCode.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }


        // all data is ok

        if (!error) {
            // create intent to show Main Activity
            Intent intent = new Intent(context, MainActivity.class);

            // send data if need
            intent.putExtra("OTP", otp);


            // start Main Activity
            startActivity(intent);
        }
    }
}