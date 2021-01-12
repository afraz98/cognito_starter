package com.application.espble;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    private Button Submit;
    private EditText Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Email = findViewById(R.id.emailinput);
        Password = findViewById(R.id.passwordinput);
        Submit = findViewById(R.id.submit);
    }
}
