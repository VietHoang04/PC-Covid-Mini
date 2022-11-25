package com.example.pccovidmini;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.text.TextUtils;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;

    private EditText editName;
    private EditText editDateOfBirth;
    private EditText editSocialInsurance;
    private EditText editNationalID;
    private EditText editAddress;
    private EditText editPhoneNumber;
    private EditText editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        context = this;

        connectView();
    }



    private void connectView() {
        editName = (EditText) findViewById(R.id.et_name);
        editDateOfBirth = (EditText) findViewById(R.id.et_dateOfBirth);
        editSocialInsurance = (EditText) findViewById(R.id.et_social_isurance);
        editNationalID = (EditText) findViewById(R.id.et_nationalID);
        editAddress = (EditText) findViewById(R.id.et_address);
        editPhoneNumber = (EditText) findViewById(R.id.et_phoneNum);
        editEmail = (EditText) findViewById(R.id.et_email);

        findViewById(R.id.tv_continue).setOnClickListener(this);
        findViewById(R.id.ic_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.tv_continue:
                loginContinue();
                break;
            case R.id.ic_back:
                super.onBackPressed();
                break;
        }
    }

    private void loginContinue() {
        boolean error = false;
        String Name = editName.getText().toString().trim();
        String DateOfBirth = editDateOfBirth.getText().toString().trim();
        String SocialInsurance = editSocialInsurance.getText().toString().trim();
        String NationalID = editNationalID.getText().toString().trim();
        String Address = editAddress.getText().toString().trim();
        String PhoneNum = editPhoneNumber.getText().toString().trim();
        String Email = editEmail.getText().toString().trim();



        if (TextUtils.isEmpty(Name)) {
            editName.requestFocus();
            editName.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }


        if (TextUtils.isEmpty(DateOfBirth)) {
            editDateOfBirth.requestFocus();
            editDateOfBirth.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }
        if (TextUtils.isEmpty(SocialInsurance)) {
            editSocialInsurance.requestFocus();
            editSocialInsurance.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }


        if (TextUtils.isEmpty(NationalID)) {
            editNationalID.requestFocus();
            editNationalID.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }
        if (TextUtils.isEmpty(Address)) {
            editAddress.requestFocus();
            editAddress.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }


        if (TextUtils.isEmpty(PhoneNum)) {
            editPhoneNumber.requestFocus();
            editPhoneNumber.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }
        if (TextUtils.isEmpty(Email)) {
            editEmail.requestFocus();
            editEmail.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }
        // all data is ok

        if (!error) {
            // create intent to show Main Activity
            Intent intent = new Intent(context, LoginActivity.class);

            // send data if need
            intent.putExtra("Name", Name);
            intent.putExtra("DateOfBirth", DateOfBirth);
            intent.putExtra("SocialInsurance", SocialInsurance);
            intent.putExtra("NationalID", NationalID);
            intent.putExtra("Address", Address);
            intent.putExtra("PhoneNum", PhoneNum);
            intent.putExtra("Email",  Email);

            // start Main Activity
            startActivity(intent);
        }
    }
}
