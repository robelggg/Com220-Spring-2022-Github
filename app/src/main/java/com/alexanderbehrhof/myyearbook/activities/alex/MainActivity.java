package com.alexanderbehrhof.myyearbook.activities.alex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alexanderbehrhof.myyearbook.AbstractActivity;
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
}
