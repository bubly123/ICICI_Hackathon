package com.example.home.mcheque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmChequeActivity extends AppCompatActivity {
 TextView tvConfirmAccNo, tvConfirmName, tvConfirmAmt, tvConfirmDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_cheque);
        setTitle("Confirm Cheque");
        mapIds();
        setData();
    }

    private void mapIds() {
        tvConfirmAccNo = (TextView)findViewById(R.id.tvConfirmAccNo);
        tvConfirmName = (TextView)findViewById(R.id.tvConfirmName);
        tvConfirmAmt = (TextView)findViewById(R.id.tvConfirmAmount);
        tvConfirmDate = (TextView)findViewById(R.id.tvConfirmDate);
    }

    private void setData() {
        Intent intent = getIntent();
        int position = intent.getIntExtra("positionOfPayee",0);
        tvConfirmAccNo.setText(((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeAccountNo());
        tvConfirmName.setText(((MyApplication)getApplicationContext()).payeeList.get(position).getPayeeShortName());
        tvConfirmAmt.setText(getResources().getString(R.string.rupee) + " " + intent.getStringExtra("amount"));
        tvConfirmDate.setText(intent.getStringExtra("date"));
    }
}
