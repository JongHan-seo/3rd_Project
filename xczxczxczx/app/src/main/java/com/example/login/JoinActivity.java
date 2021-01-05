package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class JoinActivity extends AppCompatActivity {

    EditText join_login_name;
    EditText join_login_id;
    EditText join_login_pw;
    EditText join_login_phon;
    EditText join_login_address;
    EditText join_login_pin;
    Button join_login_btn;

    RequestQueue rq; // 요청한 데이터를 전송하는 통로이다.
    StringRequest sr; // 내가 전송하고 싶은 데이터를 저장하는 객체이다.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,

                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        join_login_name = findViewById(R.id.join_login_name);
        join_login_id = findViewById(R.id.join_login_id);
        join_login_pw = findViewById(R.id.join_login_pw);
        join_login_phon = findViewById(R.id.join_login_phon);
        join_login_address = findViewById(R.id.join_login_address);
        join_login_pin = findViewById(R.id.join_login_pin);
        join_login_btn = findViewById(R.id.join_login_btn);

        // 1. requestQueue 생성 : 데이터 통로
        rq = Volley.newRequestQueue(getApplicationContext());

        // 2. 접속할 URL
        String url = "http://172.30.1.10:8081/3rd_project/UserAppInsert";

        // 3.StringRequest 생성: 저장객체
        sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // 응답이 돌아왔을 때 처리하는 메소드
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 응답 에러났을 때 처리하는 메소드
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name",join_login_name.getText().toString());
                params.put("id",join_login_id.getText().toString());
                params.put("pw",join_login_pw.getText().toString());
                params.put("phon",join_login_phon.getText().toString());
                params.put("address",join_login_address.getText().toString());
                params.put("pin",join_login_pin.getText().toString());

                return params;
            }
        };




        sr.setTag("MAIN");

        join_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rq.add(sr); //버튼을 눌렀을 경우 데이터가 넘어가게함 (통로에 데이터 담기)

                Intent intent = new Intent(JoinActivity.this, LoginActivity.class); // 화면 전환함
                startActivity(intent);
            }
        });


    }


}