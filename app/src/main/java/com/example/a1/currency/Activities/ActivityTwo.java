package com.example.a1.currency.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.a1.currency.R;
import com.example.a1.currency.api.FixerApi;
import com.example.a1.currency.api.RetrofitClient;

public class ActivityTwo extends AppCompatActivity {

    private FloatingActionButton fab;
    private Spinner spinnerFrom;
    private Spinner spinnerTo;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        spinnerFrom = (Spinner) findViewById(R.id.spinnerFrom);
        spinnerTo = (Spinner) findViewById(R.id.spinnerTo);
        textView = (TextView) findViewById(R.id.textView);

        final FixerApi api = RetrofitClient.getApi();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String currencyBase = spinnerFrom.getSelectedItem().toString();
                final String currencyTo = spinnerTo.getSelectedItem().toString();

                Intent intent = new Intent(getApplicationContext(), ActivityThree.class);
                intent.putExtra("Base", currencyBase);
                intent.putExtra("To", currencyTo);
                //intent.putStringExtra("Base", currencyBase);
                //intent.putStringExtra("To", currencyTo);
                startActivity(intent);
//                api.getRates(currencyBase, currencyTo)
//                        .subscribeOn(Schedulers.newThread())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Consumer<Response>() {
//                            @Override
//                            public void accept(Response response) throws Exception {
//                                textView.setText("1 " + currencyBase + " = "
//                                        + response.getRates().get(currencyTo) + " "
//                                        + currencyTo);
//                            }
//                        });
//            }
            }
        });

    }
}

