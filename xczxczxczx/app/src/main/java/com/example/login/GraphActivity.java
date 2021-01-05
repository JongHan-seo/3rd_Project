package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {
    ImageButton album;
    ImageButton graph;
    ImageButton streaming;
    private LineChart chart;
    Button btn1;
    Button btn2;
    Button btn3;
    ArrayList<String> timeData = new ArrayList<>();
    ArrayList<Integer> gasData = new ArrayList<>();
    ArrayList<Integer> tempData = new ArrayList<>();
    ArrayList<Integer> waterData = new ArrayList<>();
    ArrayList<Entry> values;
    LineDataSet set1;
    ArrayList<ILineDataSet> dataSets;
    LineData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,

                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        album = findViewById(R.id.album);
        graph = findViewById(R.id.graph);
        streaming = findViewById(R.id.streaming);
        chart = findViewById(R.id.linechart1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);


        String a = getIntent().getStringExtra("readData");

        chart.setNoDataText("보고싶은 항목을 선택하세요.");

        for(int i = 0; i < 10; i++){
            timeData.add(a.split(":")[4*i]);
            gasData.add(Integer.parseInt(a.split(":")[4*i+1]));
            tempData.add(Integer.parseInt(a.split(":")[4*i+2]));
            waterData.add(Integer.parseInt(a.split(":")[4*i+3]));
        }


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values = new ArrayList<>();

                for(int i = 0; i < 10; i++){
                    values.add(new Entry(i, gasData.get(i)));
                }

                set1 = new LineDataSet(values, "유해가스 농도 (ppm)");

                dataSets = new ArrayList<>();
                dataSets.add(set1); // add the data sets

                // create a data object with the data sets
                data = new LineData(dataSets);

                // black lines and points
                set1.setColor(Color.GRAY);
                set1.setCircleColor(Color.GRAY);
                set1.setDrawFilled(true);
                set1.setFillColor(Color.GRAY);

                XAxis xAxis = chart.getXAxis();
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                YAxis yAxisRight = chart.getAxisRight(); //Y축의 오른쪽
                yAxisRight.setDrawLabels(false);
                yAxisRight.setDrawAxisLine(false);
                yAxisRight.setDrawGridLines(false);

                YAxis yAxis = chart.getAxisLeft();
                yAxis.setAxisMinimum(0);
                yAxis.setAxisMaximum(650);

                // set data
                chart.setData(data);
                chart.invalidate();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values = new ArrayList<>();

                for(int i = 0; i < 10; i++){
                    values.add(new Entry(i, tempData.get(i)));
                }
                Log.d("asdf",Integer.toString(tempData.get(2)));
                set1 = new LineDataSet(values, "실내온도 (℃");

                dataSets = new ArrayList<>();
                dataSets.add(set1); // add the data sets

                // create a data object with the data sets
                data = new LineData(dataSets);

                // black lines and points
                set1.setColor(Color.RED);
                set1.setCircleColor(Color.RED);
                set1.setDrawFilled(true);
                set1.setFillColor(Color.RED);
                XAxis xAxis = chart.getXAxis();
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                YAxis yAxisRight = chart.getAxisRight(); //Y축의 오른쪽
                yAxisRight.setDrawLabels(false);
                yAxisRight.setDrawAxisLine(false);
                yAxisRight.setDrawGridLines(false);

                YAxis yAxis = chart.getAxisLeft();
                yAxis.setAxisMinimum(0);
                yAxis.setAxisMaximum(40);


                // set data
                chart.setData(data);
                chart.invalidate();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                values = new ArrayList<>();

                for(int i = 0; i < 10; i++){
                    values.add(new Entry(i, waterData.get(i)));
                }


                set1 = new LineDataSet(values, "실내습도 (％)");

                dataSets = new ArrayList<>();
                dataSets.add(set1); // add the data sets

                // create a data object with the data sets
                data = new LineData(dataSets);

                // black lines and points
                set1.setColor(Color.BLUE);
                set1.setCircleColor(Color.BLUE);
                set1.setDrawFilled(true);
                XAxis xAxis = chart.getXAxis();
                xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                YAxis yAxisRight = chart.getAxisRight(); //Y축의 오른쪽
                yAxisRight.setDrawLabels(false);
                yAxisRight.setDrawAxisLine(false);
                yAxisRight.setDrawGridLines(false);

                YAxis yAxis = chart.getAxisLeft();
                yAxis.setAxisMinimum(0);

                // set data
                chart.setData(data);
                chart.invalidate();
            }
        });





        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GraphActivity.this, AlbumActivity.class);
                startActivity(intent);

            }
        });

//        graph.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GasActivity.this, GasActivity.class);
//                startActivity(intent);
//            }
//        });
        streaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GraphActivity.this, StreamingActivity.class);
                intent.putExtra("readData", a);
                startActivity(intent);
            }
        });

    }

}