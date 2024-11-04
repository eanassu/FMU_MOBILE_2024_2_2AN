package br.fmu.exemplo2an;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class HttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        Thread thread = new Thread( new ThreadHttp(this));
        thread.run();
    }
}

class ThreadHttp extends Thread {

    private Context context;

    public ThreadHttp(Context context) {
        this.context = context;
    }

    public void run() {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://google.com";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("Resposta: " + response.substring(0, 500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Erro");
            }
        });
        queue.add(stringRequest);
    }

}