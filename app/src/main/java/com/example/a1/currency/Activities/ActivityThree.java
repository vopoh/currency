package com.example.a1.currency.Activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.a1.currency.R;
import com.example.a1.currency.api.FixerApi;
import com.example.a1.currency.api.RetrofitClient;
import com.example.a1.currency.model.Response;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class ActivityThree extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TEXTVIEW_STATE_KEY = "HUFIOSADGIO";
    private SwipeRefreshLayout mSwipeRefreshLayout;

    String base;
    String to;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);



        if (savedInstanceState != null && savedInstanceState.containsKey(TEXTVIEW_STATE_KEY)) {
            textView.setText(savedInstanceState.getString(TEXTVIEW_STATE_KEY, "error"));
            return;
        } else {
            base = getIntent().getStringExtra("Base");
            to = getIntent().getStringExtra("To");
        }


        textView = (TextView) findViewById(R.id.textView);

        final FixerApi api = RetrofitClient.getApi();

        api.getRates(base, to)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response>() {
                    @Override
                    public void accept(Response response) throws Exception {
                        textView.setText("1 " + base + " = "
                                + response.getRates().get(to) + " "
                                + to);
                    }

                });
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        TextView myTextView = (TextView)findViewById(R.id.textView);
        saveInstanceState.putString(TEXTVIEW_STATE_KEY, myTextView.getText().toString());

        super.onSaveInstanceState(saveInstanceState);

    }

    @Override
    public void onRefresh() {

    }
}