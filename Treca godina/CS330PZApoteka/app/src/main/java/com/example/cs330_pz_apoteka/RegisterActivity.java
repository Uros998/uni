package com.example.cs330_pz_apoteka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import com.example.cs330_pz_apoteka.database.DBHelper;
import com.example.cs330_pz_apoteka.entities.User;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout layoutName;
    private TextInputLayout layoutEmail;
    private TextInputLayout layoutPassword;
    private TextInputLayout layoutConfirmPassword;

    private TextInputEditText textName;
    private TextInputEditText textEmail;
    private TextInputEditText textPassword;
    private TextInputEditText textConfirmPassword;

    private AppCompatButton buttonRegister;
    private AppCompatTextView loginLink;

    private InputValidation inputValidation;
    private User user;

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        layoutName = (TextInputLayout) findViewById(R.id.textInputLayoutName);
        layoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        layoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);
        layoutConfirmPassword = (TextInputLayout) findViewById(R.id.textInputLayoutConfirmPassword);

        textName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);

        buttonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);
        loginLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);
    }

    private void initListeners() {
        buttonRegister.setOnClickListener(this);
        loginLink.setOnClickListener(this);
    }

    private void initObjects() {
        db = new DBHelper(activity);
        inputValidation = new InputValidation(activity);
        user = new User();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonRegister:
                register();
                break;
            case R.id.appCompatTextViewLoginLink:
                Intent intentRegister = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    public void register() {
        if (!inputValidation.isInputEditTextFilled(textName, layoutName, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textEmail, layoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textPassword, layoutPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textPassword, textConfirmPassword, layoutPassword, getString(R.string.error_password_match))) {
            return;
        }

        String name = textName.getText().toString().trim();
        String email = textEmail.getText().toString().trim();
        String password = textPassword.getText().toString().trim();

        if (!db.checkUser(email)) {

            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            db.addUser(user);

            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();
        } else {
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }
    }

    public void emptyInputEditText() {
        textName.setText(null);
        textEmail.setText(null);
        textPassword.setText(null);
        textConfirmPassword.setText(null);
    }
}
