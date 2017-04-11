package com.example.home.mcheque;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CreateChequeActivity extends AppCompatActivity {
    EditText editTextDate,editTextAmt;
    Calendar myCalendar;
    TextView tvName,tvAccountNo;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cheque);
        setTitle("Create Cheque");
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);

        mapIds();

        tvName.setText(((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeShortName());
        tvAccountNo.setText(((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeAccountNo());

        createDatePickerDialog();

        Button buttonContinue = (Button)findViewById(R.id.buttonContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate() == true) {
                    Intent intent = new Intent(CreateChequeActivity.this,ConfirmChequeActivity.class);
                    intent.putExtra("positionOfPayee",position);
                    intent.putExtra("amount",editTextAmt.getText().toString().trim());
                    intent.putExtra("date",editTextDate.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validate() {
        if(editTextAmt.getText().toString().trim().equals("")) {
            Toast.makeText(this,"Please enter amount!",Toast.LENGTH_LONG).show();
            return false;
        } else if(editTextDate.getText().toString().trim().equals("")) {
            Toast.makeText(this,"Please enter the date!",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
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
                DatePickerDialog dialog = new DatePickerDialog(CreateChequeActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                long now = System.currentTimeMillis() - 1000;
                dialog.getDatePicker().setMinDate(now);
                dialog.getDatePicker().setMaxDate(now+(1000*60*60*24*15));
                dialog.show();
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
