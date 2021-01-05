package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

public class AlbumActivity extends AppCompatActivity {

    ImageButton album;
    ImageButton graph;
    ImageButton streaming;
    RequestQueue rq;
    StringRequest sr;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference spaceRef = storage.getReference("images");
    ImageView[] imgs = new ImageView[20];
    int cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,

                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        album = findViewById(R.id.album);
        graph = findViewById(R.id.graph);
        streaming = findViewById(R.id.streaming);

        String readData = getIntent().getStringExtra("readData");


        for (int i = 0; i < 20; i++) {
            int id = getResources().getIdentifier("img" + (i + 1), "id", getPackageName());
            imgs[i] = findViewById(id);
        }


        cnt = 0;
        spaceRef.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
            @Override
            public void onSuccess(ListResult listResult) {
                Log.d("asdf","123");
                for (StorageReference prefix : listResult.getItems()) {
                    Log.v("asdf", prefix.getPath().substring(8));

                    spaceRef.child(prefix.getPath().substring(8)).getDownloadUrl()
                            .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {

                                    Glide.with(getApplicationContext())
                                            .load(uri.toString()).override(650,300)
                                            .into(imgs[cnt]);
                                    cnt++;

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            Log.v("asdf", exception.getMessage());
                        }
                    });
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });


        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlbumActivity.this, AlbumActivity.class);
                intent.putExtra("readData", readData);
                startActivity(intent);
            }
        });

        graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlbumActivity.this, GraphActivity.class);
                intent.putExtra("readData",readData);
                startActivity(intent);
            }
        });
        streaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlbumActivity.this, StreamingActivity.class);
                startActivity(intent);
            }
        });
    }
}



