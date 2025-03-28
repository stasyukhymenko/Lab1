package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView txtResult;
    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtResult = findViewById(R.id.txtResult);
        btnReturn = findViewById(R.id.btnReturn);

        String selectedBook = getIntent().getStringExtra("selectedBook");
        String selectedYear = getIntent().getStringExtra("selectedYear");

        String result = "Вибраний варіант:\n" +
                "Книга: " + selectedBook + "\n" +
                "Рік видання: " + selectedYear;
        txtResult.setText(result);

        btnReturn.setOnClickListener(v -> finish());
    }
}
