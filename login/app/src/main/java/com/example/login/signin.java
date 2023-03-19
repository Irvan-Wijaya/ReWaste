package com.example.login;

import static android.text.Html.fromHtml;

import androidx.appcompat.app.AppCompatActivity;

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

public class signin extends AppCompatActivity {

    EditText Password, Email;
    Button btnSignUp;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Email = (EditText)findViewById(R.id.Email);
        Password = (EditText)findViewById(R.id.password);
        btnSignUp = (Button) findViewById(R.id.btnSignup);

        dbHelper = new DBHelper(this);

        TextView tvCreateAccount = (TextView) findViewById(R.id.tvCreateAccount);

        tvCreateAccount.setText(fromHtml("I don't have ReWaste Account yet " +
                "</font><font color='#3b5998'>create one</font>"));

        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signin.this, register.class));
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                Boolean res = dbHelper.checkUser(username, password);
                if(res == true){
                    Toast.makeText(signin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(signin.this, home.class));
                }else{
                    Toast.makeText(signin.this, "Login Failed", Toast.LENGTH_SHORT).show();
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