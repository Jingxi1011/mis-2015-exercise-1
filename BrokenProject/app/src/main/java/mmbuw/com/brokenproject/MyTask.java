package mmbuw.com.brokenproject;

import android.os.AsyncTask;
import android.widget.EditText;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MyTask extends AsyncTask<String, Integer, StringBuffer> {

    private EditText edtHTTP;
    private StringBuffer sbHTML;

    public MyTask(EditText edtHTTP) {

        this.edtHTTP = edtHTTP;
        sbHTML = new StringBuffer();
    }

    @Override
    protected StringBuffer doInBackground(String... params) {

        HttpClient hc = new DefaultHttpClient();

        HttpGet hg = new HttpGet(params[0]);

        try {

            HttpResponse hr = hc.execute(hg);

            BufferedReader br = new BufferedReader(new InputStreamReader(hr
                    .getEntity().getContent()));


            String line = "";
            sbHTML = new StringBuffer();
            while ((line = br.readLine()) != null) {
                sbHTML.append(line);
            }

            return sbHTML;
        } catch (IOException e) {

            edtHTTP.setText("Error！！！");
        }
        return null;
    }


    @Override
    protected void onPostExecute(StringBuffer result) {

        if (result != null) {
            edtHTTP.setText(result);
        }
        super.onPostExecute(result);
    }
}
