package com.example.login;

import static android.text.Html.fromHtml;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText Name, Email, Password, ConfirmPassword;
    Button btnRegister;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBHelper(this);

        Name = (EditText) findViewById(R.id.Name);
        Email = (EditText)findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.password);
        ConfirmPassword = (EditText) findViewById(R.id.confirmPassword);
        btnRegister = (Button) findViewById(R.id.btnSignup);

        TextView tvRegister = (TextView) findViewById(R.id.tvRegister);

        tvRegister.setText(fromHtml("Back to " + "</font><font color='#3b5998'>Login</font>"));

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this, signin.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = Name.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String conPass = ConfirmPassword.getText().toString().trim();

                ContentValues values = new ContentValues();

                if (!password.equals(conPass)){
                    Toast.makeText(register.this, "Password not macth", Toast.LENGTH_SHORT).show();
                }else if (password.equals("") || username.equals("")){
                    Toast.makeText(register.this, "Email or Password cannot be empty", Toast.LENGTH_SHORT).show();
                }else{
                    values.put(DBHelper.row_username, username);
                    values.put(DBHelper.row_password, password);
                    dbHelper.insertData(values);

                    Toast.makeText(register.this, "Register successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    public static Spanned fromHtml (String html){
        Spanned result;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        }else{
            result = Html.fromHtml(html);
        }
        return result;
    }

}