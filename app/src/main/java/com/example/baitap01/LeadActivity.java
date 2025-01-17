package com.example.baitap01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LeadActivity extends AppCompatActivity {
    private Button btnNavigate;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);
        Button btnGenerate = (Button) findViewById(R.id.buttonGenerate);
        btnGenerate.setOnClickListener(view -> {
            processRandomArray();
        });
        btnNavigate =findViewById(R.id.buttonNavigate);
        btnNavigate.setOnClickListener(v -> {
            Intent intent = new Intent(LeadActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
    private void processRandomArray() {
        Random random = new Random();
        List<Integer> numbers = random.ints(50, 1, 1001) // 10 số ngẫu nhiên từ 1 đến 100
                .boxed()
                .collect(Collectors.toList());

        List<Integer> evenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> oddNumbers = numbers.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());

        Log.d("ArrayList", "Mảng ban đầu: " + numbers);
        Log.d("ArrayList", "Số chẵn: " + evenNumbers);
        Log.d("ArrayList", "Số lẻ: " + oddNumbers);
    }
}
