package com.alexanderbehrhof.myyearbook;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
    }

    public void onClickAlexBtn(View v) {
        Intent alexMainActivity = new Intent(Dashboard.this, com.alexanderbehrhof.myyearbook.activities.alex.MainActivity.class);
        Dashboard.this.startActivity(alexMainActivity);
    }

    public void onClickDaviaBtn(View v) {
        Intent daviaMainActivity = new Intent(Dashboard.this, com.alexanderbehrhof.myyearbook.activities.davia.MainActivity.class);
        Dashboard.this.startActivity(daviaMainActivity);
    }

    public void onClickRobelBtn(View v) {
        Intent robelMainActivity = new Intent(Dashboard.this, com.alexanderbehrhof.myyearbook.activities.robel.MainActivity.class);
        Dashboard.this.startActivity(robelMainActivity);
    }
}
