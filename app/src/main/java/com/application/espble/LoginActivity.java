package com.application.espble;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.core.Amplify;

public class LoginActivity extends Activity {
    private Button Submit;
    private EditText Email, Password;

    public void switchContext(){
        final Intent intent = new Intent(this, BodyActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Email = findViewById(R.id.email_input);
        Password = findViewById(R.id.password_input);
        Submit = findViewById(R.id.submit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Handle user login
                Amplify.Auth.signIn(
                        Email.getText().toString(),
                        Password.getText().toString(),
                        result -> switchContext(),
                        error -> Log.e("AuthQuickstart", error.toString())
                );
            }
        });
    }
}
