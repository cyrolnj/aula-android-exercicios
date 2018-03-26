package com.solutions.oryc.consuma;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickLogin(View view) {

        Boolean error = false;
        Context context = getApplicationContext();
        CharSequence message = "";
        int duration = Toast.LENGTH_LONG;

        EditText txtEmail = this.findViewById(R.id.txtEmail);
        EditText txtPassword = this.findViewById(R.id.txtPassword);

        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();

        if (!isValidEmail(email)) {
            error = setEditTextError(txtEmail, "Email inválido");
        }

        if (!isValidPassword(password)) {
            error = setEditTextError(txtPassword, "Senha inválida");
        }

        if (!error) {
            message = "Login realizado com sucesso";

            if (!message.equals("")) {
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
            }

            Intent desktopIntent = new Intent(this, DesktopActivity.class);
            startActivity(desktopIntent);

        }

    }

    public void onClickCreateAccount (View view) {
        Intent createAccountIntent = new Intent(this, CreateAccountActivity.class);
        startActivity(createAccountIntent);
    }

    public final static boolean isValidEmail(String email) {
        try {
            return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        } catch (Exception e) {
            return false;
        }
    }

    public final static boolean isValidPassword(String password) {
        try {
            return (!TextUtils.isEmpty(password) && password.length() >= 8);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean setEditTextError(EditText editText, String message) {
        editText.setError(message);
        return true;
    }

}




































