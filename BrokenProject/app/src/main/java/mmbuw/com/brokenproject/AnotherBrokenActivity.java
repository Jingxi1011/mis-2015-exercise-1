package mmbuw.com.brokenproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mmbuw.com.brokenproject.R;

public class AnotherBrokenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_broken);

        Intent intent = getIntent();
        String message = intent.getStringExtra(BrokenActivity.EXTRA_MESSAGE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.another_broken, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class MainActivity extends Activity {

        private EditText edtURL;
        private EditText edtHTTP;
        private Button btnRequest;

        private String strURL;

        private MyTask myTask;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_another_broken);

            edtURL = (EditText) findViewById(R.id.edturl);
            edtHTTP = (EditText) findViewById(R.id.edthttp);
            btnRequest = (Button) findViewById(R.id.requesthtml);

            btnRequest.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (!(strURL = edtURL.getText().toString()).equals("")) {

                        myTask = new MyTask(edtHTTP);
                        myTask.execute(strURL);
                    }

                }
            });
        }
    }
}