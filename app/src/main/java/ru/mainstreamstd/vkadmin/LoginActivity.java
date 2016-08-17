package ru.mainstreamstd.vkadmin;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Noobburner on 18.07.2016.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView version = (TextView) findViewById(R.id.version);
        String versionName = BuildConfig.VERSION_NAME;
        version.setText("Ver: " + versionName);

        Button login = (Button) findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNetworkAvailable()) {
                    Intent Start = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(Start);
                    overridePendingTransition(R.anim.slide_right1, R.anim.slide_right2);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.no_internet),
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    protected boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }


}

