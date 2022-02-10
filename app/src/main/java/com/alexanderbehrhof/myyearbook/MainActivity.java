package com.alexanderbehrhof.myyearbook;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View v) {
        final TextView mTextView = (TextView) findViewById(R.id.screen_text);
        mTextView.setText(R.string.button_click_text);
    }
}
