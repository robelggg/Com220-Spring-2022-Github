package com.alexanderbehrhof.myyearbook.activities.alex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alexanderbehrhof.myyearbook.AbstractActivity;
import com.alexanderbehrhof.myyearbook.MyYearbook;
import com.alexanderbehrhof.myyearbook.R;

public class MainActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alex_activity_main);
    }

    public void onClickBtn(View v) {
        Intent graduationPlanActivityIntent = new Intent(MainActivity.this, GraduationPlanActivity.class);
        MainActivity.this.startActivity(graduationPlanActivityIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        MyYearbook.resumeActivity();
    }

    @Override
    protected void onPause() {
        super.onPause();

        MyYearbook.pauseActivity();

        // Sends an activity that returns to Alex's Main Activity.
        MyYearbook.getInstance().pushNotificationAfterGivenTime(this, MainActivity.class, 30000, 1000);
    }
}
