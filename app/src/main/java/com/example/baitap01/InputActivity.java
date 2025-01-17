package com.example.baitap01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    private EditText editTextInput;
    private TextView textViewOutput;
    private Button btnProcess;
    private TextView textViewReverse;
    private Button btnNavigate;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        editTextInput = findViewById(R.id.editText);
        textViewOutput = findViewById(R.id.textViewOutput);
        btnProcess = findViewById(R.id.btnProcess);
        textViewReverse = findViewById(R.id.textViewReverse);
        btnNavigate =findViewById(R.id.buttonNavigate);
        btnNavigate.setOnClickListener(v -> {
            Intent intent = new Intent(InputActivity.this, MainActivity.class);
            startActivity(intent);
        });
        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy chuỗi nhập vào
                String input = editTextInput.getText().toString().trim();

                // Kiểm tra chuỗi rỗng
                if (input.isEmpty()) {
                    Toast.makeText(InputActivity.this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Đảo ngược chuỗi và chuyển thành in hoa
                String reversed = reverseAndUpperCase(input);

                // Hiển thị chuỗi ban đầu và chuỗi đảo ngược
                textViewOutput.setText("Chuỗi ban đầu: " + input);
                textViewReverse.setText("Chuỗi đảo ngược: " + reversed);
                // Hiển thị Toast chuỗi đảo ngược
                Toast.makeText(InputActivity.this,  reversed, Toast.LENGTH_LONG).show();
            }
        });
    }
    // Hàm đảo ngược chuỗi và chuyển in hoa
    private String reverseAndUpperCase(String input) {
        String[] words = input.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim().toUpperCase();
    }
}
