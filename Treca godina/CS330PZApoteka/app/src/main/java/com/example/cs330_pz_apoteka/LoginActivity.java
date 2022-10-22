package com.example.cs330_pz_apoteka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import com.example.cs330_pz_apoteka.database.DBHelper;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private com.example.cs330_pz_apoteka.database.DBHelper dbHelper = new DBHelper(this);
    private NestedScrollView nestedScrollView;

    private TextInputLayout layoutEmail;
    private TextInputLayout layoutPassword;

    private TextInputEditText textEmail;
    private TextInputEditText textPassword;

    private AppCompatButton buttonLogin;
    private AppCompatTextView registerLink;

    private InputValidation inputValidation;
    private DBHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initViews();
        initListeners();
        initObjects();
    }

    private void initViews(){
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        layoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        layoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

        textEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);

        buttonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);
        registerLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewRegisterLink);
    }

    private void initListeners(){
        buttonLogin.setOnClickListener(this);
        registerLink.setOnClickListener(this);
    }

    private void initObjects(){
        DBHelper = new DBHelper(this);
        inputValidation = new InputValidation(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.appCompatButtonLogin:
                login();
                break;
            case R.id.appCompatTextViewRegisterLink:
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    public void login(){
        if(!inputValidation.isInputEditTextFilled(textEmail, layoutEmail, getString(R.string.error_message_email))){
            return;
        }
        if(!inputValidation.isInputEditTextEmail(textEmail, layoutEmail, getString(R.string.error_message_email))){
            return;
        }
        if(!inputValidation.isInputEditTextFilled(textPassword, layoutPassword, getString(R.string.error_message_password))){
            return;
        }

        String email = textEmail.getText().toString().trim();
        String password = textPassword.getText().toString().trim();

        if(DBHelper.checkUser(email, password)){
            Intent mainIntent = new Intent(this, MainActivity.class);
            String username = dbHelper.getUserByEmail(email);
            mainIntent.putExtra("NAME", username);
            mainIntent.putExtra("EMAIL", email);
            mainIntent.putExtra("PASSWORD", password);
            emptyInputEditText();
            startActivity(mainIntent);
        } else{
            Snackbar.make(findViewById(android.R.id.content), getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }

    public void emptyInputEditText(){
        textEmail.setText(null);
        textPassword.setText(null);
    }
}
