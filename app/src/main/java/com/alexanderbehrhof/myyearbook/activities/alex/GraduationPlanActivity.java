package com.alexanderbehrhof.myyearbook.activities.alex;

import android.os.Bundle;
import com.alexanderbehrhof.myyearbook.AbstractActivity;
import com.alexanderbehrhof.myyearbook.MyYearbook;
import com.alexanderbehrhof.myyearbook.R;

public class GraduationPlanActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alex_graduation_plan);
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
