package com.solutions.oryc.consuma;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void onClickCreateAccount(View view) {

        Boolean error = false;
        Context context = getApplicationContext();
        CharSequence message = "";
        int duration = Toast.LENGTH_LONG;

        EditText txtName = this.findViewById(R.id.txtName);
        EditText txtEmail = this.findViewById(R.id.txtEmail);
        EditText txtPassword = this.findViewById(R.id.txtPassword);
        EditText txtRepeatPassword = this.findViewById(R.id.txtRepeatPassword);

        String name = txtName.getText().toString();
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        String repeatPassword = txtRepeatPassword.getText().toString();


        if (!isValidName(name)) {
            error = setEditTextError(txtName, "Informe seu nome");
        }

        if (!isValidEmail(email)) {
            error = setEditTextError(txtEmail, "Email inválido");
        }

        if (!isValidPassword(password)) {
            error = setEditTextError(txtPassword, "Senha inválida");
        }

        if (!isValidPassword(repeatPassword)) {
            error = setEditTextError(txtRepeatPassword, "Senha inválida");
        }

        if (isValidPassword(password) && isValidPassword(repeatPassword)) {
            if (!password.equals(repeatPassword)) {
                error = setEditTextError(txtRepeatPassword, "Senhas não coincidem");
            }
        }

        if (!error) {
            message = "Cadastro realizado com sucesso";

            if (!message.equals("")) {
                Toast toast = Toast.makeText(context, message, duration);
                toast.show();
            }

        }

    }

    public final static boolean isValidName(String name) {
        try {
            return (!TextUtils.isEmpty(name));
        } catch (Exception e) {
            return false;
        }
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




































