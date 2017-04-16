package com.example.home.mcheque;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateChequeActivity extends AppCompatActivity {
    EditText editTextDate,editTextAmt;
    Calendar myCalendar;
    TextView tvName,tvAccountNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cheque);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        mapIds();

        tvName.setText(((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeShortName());
        tvAccountNo.setText(((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeAccountNo());

        createDatePickerDialog();

    }

    private void createDatePickerDialog() {
        myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        editTextDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(CreateChequeActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
    private void mapIds() {
        tvName = (TextView)findViewById(R.id.tvPayeeName);
        tvAccountNo = (TextView)findViewById(R.id.tvPayeeAccountNo);

        editTextDate = (EditText)findViewById(R.id.editTextDate);
        editTextAmt = (EditText)findViewById(R.id.editTextAmount);
    }

    private void updateLabel() {

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editTextDate.setText(sdf.format(myCalendar.getTime()));
    }
}
