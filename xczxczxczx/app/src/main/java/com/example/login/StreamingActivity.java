package com.example.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;


public class StreamingActivity extends AppCompatActivity {
    final private static String TAG = "asdf";
    ImageButton a;
    ImageButton b;
    ImageButton c;
    ImageButton d;
    ImageButton stop;
    ImageButton bloo;
    ImageButton came;
    ImageButton graph;
    ImageButton album;
    ImageButton flash;
    Button auto_x;
    Button rc_ctrl_val;
    BluetoothSPP bt;

    ImageView iv_photo;
    final static int TAKE_PICTURE = 1;
    String mCurrentPhotoPath;
    final static int REQUEST_TAKE_PHOTO = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_streaming);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,

                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bt = new BluetoothSPP(getApplicationContext());
        a = findViewById(R.id.w);
        b = findViewById(R.id.r);
        c = findViewById(R.id.l);
        d = findViewById(R.id.b);
        bloo = findViewById(R.id.bloo);
        graph = findViewById(R.id.graph);
        album = findViewById(R.id.album);
        stop = findViewById(R.id.stop);
        auto_x = findViewById(R.id.auto);
        came = findViewById(R.id.came);
        flash = findViewById(R.id.light);
        rc_ctrl_val = findViewById(R.id.rc_ctrl_val);

        if (!bt.isBluetoothAvailable()) {
            Toast.makeText(getApplicationContext(), "블루투스 사용불가!",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "블루투스 사용가능!",
                    Toast.LENGTH_SHORT).show();
        }
        if (!bt.isBluetoothEnabled()) {  // 블루투스 비활성화시
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, BluetoothState.REQUEST_ENABLE_BT);
        } else {
            bt.setupService();
            bt.startService(BluetoothState.DEVICE_OTHER);

        }
        bloo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bt.getServiceState() == BluetoothState.STATE_CONNECTED) {
                    bt.disconnect();
                } else {
                    Intent intent = new Intent(StreamingActivity.this, DeviceList.class);
                    startActivityForResult(intent, BluetoothState.REQUEST_CONNECT_DEVICE);
                }
            }
        });
        bt.setBluetoothConnectionListener(new BluetoothSPP.BluetoothConnectionListener() {
            @Override
            public void onDeviceConnected(String name, String address) {
                Toast.makeText(getApplicationContext(), name + " 연결성공!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeviceDisconnected() {
                Toast.makeText(getApplicationContext(), "연결끊김!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeviceConnectionFailed() {
                Toast.makeText(getApplicationContext(), "연결실패!", Toast.LENGTH_SHORT).show();
            }
        });
        a.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        bt.send("w", true);
                        break;

                    case MotionEvent.ACTION_UP:
                        bt.send("x", true);
                        break;


                    default:
                        break;

                }
                return false;
            }
        });
        b.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        bt.send("r", true);
                        break;

                    case MotionEvent.ACTION_UP:
                        bt.send("x", true);
                        break;


                    default:
                        break;

                }
                return false;
            }
        });
        c.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        bt.send("l", true);
                        break;

                    case MotionEvent.ACTION_UP:
                        bt.send("x", true);
                        break;


                    default:
                        break;

                }
                return false;
            }
        });
        d.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        bt.send("b", true);
                        break;

                    case MotionEvent.ACTION_UP:
                        bt.send("x", true);
                        break;


                    default:
                        break;

                }
                return false;
            }
        });

        flash.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        bt.send("f", true);
                        break;

                    case MotionEvent.ACTION_UP:
                        bt.send("x", true);
                        break;


                    default:
                        break;

                }
                return false;
            }
        });

        stop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        bt.send("j", true);
                        break;

                    case MotionEvent.ACTION_UP:
                        bt.send("x", true);
                        break;


                    default:
                        break;

                }
                return false;
            }
        });

//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bt.send("j", true);
//
//            }
//        });

        auto_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt.send("y",true);
            }
        });

        rc_ctrl_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bt.send("m", true);

            }
        });

        came.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StreamingActivity.this, CaptureActivity.class);
                startActivity(intent);
            }
        });

        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StreamingActivity.this, GraphActivity.class);
                startActivity(intent);
            }
        });

        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StreamingActivity.this, AlbumActivity.class);
                startActivity(intent);
            }
        });

        WebView webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.setBackgroundColor(255);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // 자신이 실행시킨 스트리밍의 주소를 넣어주세요.
        webView.loadUrl("http://192.168.137.141:8081/");
        // webView.loadUrl("https://www.naver.com/");


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BluetoothState.REQUEST_CONNECT_DEVICE) {
            if (resultCode == RESULT_OK) {
                bt.connect(data);
            }
        }

    }





}