package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {
    EditText main_login_id;
    EditText main_login_pw;
    Button main_login_btn;
    Button main_join_btn;
    RequestQueue rq;
    StringRequest sr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,

                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        main_login_id = findViewById(R.id.main_login_id); // findViewById를 클릭할때마다 사용하여 안드로이드는 부담을 느낀다. 때문에 위치를 옮겨준다.
        main_login_pw = findViewById(R.id.main_login_pw);
        main_join_btn = findViewById(R.id.main_join_btn);
        main_login_btn = findViewById(R.id.main_login_btn);

        // 1. requestQueue 생성 : 데이터 통로
        rq = Volley.newRequestQueue(getApplicationContext());

        // 2. 접속할 url 세팅!
        String url = "http://172.30.1.10:8081/3rd_project/AppLogin";
        // 3. StringRequest 생성 : 저장객체
        sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //응답이 돌아왔을 때 처리하는 메소드
                Log.d("asdf","11");
                if (response.equals("false")) {
                    Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "로그인 완료!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    Log.d("asdf",response);
                    intent.putExtra("readData", response); // id값 넘겨줌
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 응답 에러났을 때 처리하는 메소드
                Log.d("asdf","응답 에러");
            }
        }) {  // StringRequest 내부 메소드 오버라이딩하는부분 ↓


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>(); // 데이터 담음
                params.put("id", main_login_id.getText().toString()); // 키값에 밸류 넣음
                params.put("pw", main_login_pw.getText().toString()); // 키값에 밸류 넣음
                return params;
            }
        };

        sr.setTag("MAIN"); //태그 닮

        main_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // login 누르면 실행됨
                rq.add(sr); // 서버에 전송함
            }
        });

        main_join_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // join 누르면 실행됨
                Intent intent = new Intent(LoginActivity.this, JoinActivity.class); // 화면 전환함
                startActivity(intent); // intent(화면전환) 를 start함

            }
        });

    }
}