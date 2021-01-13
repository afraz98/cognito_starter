package com.application.espble;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class RegisterActivity extends Activity {
    private Button Submit;
    private EditText Email, Password, Name, ConfirmPassword;

    private void confirmRegistration(){
        final Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("USER", Name.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Name = findViewById(R.id.name_input);
        Email = findViewById(R.id.email_input);
        ConfirmPassword = findViewById(R.id.passwordconfirm_input);
        Password = findViewById(R.id.password_input);
        Submit = findViewById(R.id.submit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Handle user registration
                Amplify.Auth.signUp(
                        Email.getText().toString(),
                        Password.getText().toString(),
                        AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.name(), Name.getText().toString()).build(),
                        result -> confirmRegistration(),
                        error -> Log.e("AuthQuickStart", "Sign up failed", error)
                );
            }
        });
    }
}
