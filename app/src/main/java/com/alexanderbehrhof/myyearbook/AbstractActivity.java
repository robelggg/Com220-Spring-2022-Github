package com.alexanderbehrhof.myyearbook;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public abstract class AbstractActivity extends AppCompatActivity {

    public void onClickHomeBtn(View v) {
        Intent MainActivityIntent = new Intent(AbstractActivity.this, Dashboard.class);
        AbstractActivity.this.startActivity(MainActivityIntent);
    }
}
