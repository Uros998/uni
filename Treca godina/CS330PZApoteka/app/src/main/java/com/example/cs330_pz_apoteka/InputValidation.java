package com.example.cs330_pz_apoteka;

import android.app.Activity;
import android.content.Context;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class InputValidation {
        private Context context;

        public InputValidation(Context context){
            this.context = context;
        }

        public boolean isInputEditTextFilled(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
            String value = textInputEditText.getText().toString().trim();
            if(value.isEmpty()){
                textInputLayout.setError(message);
                hideKeyboardForm(textInputEditText);
                return false;
            } else{
                textInputLayout.setErrorEnabled(false);
            }
            return true;
        }

        public boolean isInputEditTextEmail(TextInputEditText textInputEditText, TextInputLayout textInputLayout, String message){
            String value = textInputEditText.getText().toString().trim();
            System.out.println("Patterns.EMAIL_ADDRESS.matcher(value).matches()" + value  + Patterns.EMAIL_ADDRESS.matcher(value).matches());
            if(value.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(value).matches()){
                textInputLayout.setError(message);
                hideKeyboardForm(textInputEditText);
                return false;
            } else {
                textInputLayout.setErrorEnabled(false);
            }
            return true;
        }

        public boolean isInputEditTextMatches(TextInputEditText textInputEditText1, TextInputEditText textInputEditText2, TextInputLayout textInputLayout, String message){
            String value1 = textInputEditText1.getText().toString().trim();
            String value2 = textInputEditText2.getText().toString().trim();
            if(!value1.contentEquals(value2)){
                textInputLayout.setError(message);
                hideKeyboardForm(textInputEditText2);
                return false;
            } else{
                textInputLayout.setErrorEnabled(false);
            }
            return true;
        }

        private void hideKeyboardForm(View view){
            InputMethodManager inm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }
}
