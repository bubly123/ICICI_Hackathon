package com.example.home.mcheque;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        setTitle("Cheque Invoice");
        Button btnGoToSentCheque = (Button)findViewById(R.id.btnGoToSentCheque);
        btnGoToSentCheque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InvoiceActivity.this, ChequeHistoryActivity.class);
                startActivity(intent);
            }
        });
    }
}
