package com.example.lab1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerBooks;
    private RadioGroup radioGroupYears;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerBooks = findViewById(R.id.spinnerBooks);
        radioGroupYears = findViewById(R.id.radioGroupYears);
        btnOk = findViewById(R.id.btnOk);

        String[] books = {
                "Дж.К. Роулінг - Гаррі Поттер",
                "Джордж Орвелл - 1984",
                "Всеволод Нестайко - Тореадори з Васюківки",
                "Герберт Шілдт - Java. Повне керівництво"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, books);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBooks.setAdapter(adapter);

        btnOk.setOnClickListener(v -> {

            int selectedRadioId = radioGroupYears.getCheckedRadioButtonId();
            if (selectedRadioId == -1) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Незавершені дані")
                        .setMessage("Будь ласка, оберіть рік видання.")
                        .setPositiveButton("OK", null)
                        .show();
                return;
            }

            String selectedBook = spinnerBooks.getSelectedItem().toString();
            RadioButton selectedRadioButton = findViewById(selectedRadioId);
            String selectedYear = selectedRadioButton.getText().toString();

            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("selectedBook", selectedBook);
            intent.putExtra("selectedYear", selectedYear);
            startActivity(intent);
        });
    }
}
