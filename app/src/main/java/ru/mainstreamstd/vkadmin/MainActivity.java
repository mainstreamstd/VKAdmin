package ru.mainstreamstd.vkadmin;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mainToolbar;
    private TextView noGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainToolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mainToolbar);
        mainToolbar.setTitle(getResources().getString(R.string.main_label));

        noGroup = (TextView)findViewById(R.id.no_group);
        noGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.vk.com/groups?act=new"));
                startActivity(browserIntent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.logout_message),
                    Toast.LENGTH_LONG).show();
            Intent Start = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(Start);
            overridePendingTransition(R.anim.slide_left1, R.anim.slide_left2);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}

