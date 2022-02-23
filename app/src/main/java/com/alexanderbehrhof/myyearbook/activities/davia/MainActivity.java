package com.alexanderbehrhof.myyearbook.activities.davia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.alexanderbehrhof.myyearbook.AbstractActivity;
import com.alexanderbehrhof.myyearbook.R;

public class MainActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.davia_activity_main);
    }

    public void onClickBtn(View v) {
        Intent graduationPlanActivityIntent = new Intent(MainActivity.this, GraduationPlanActivity.class);
        MainActivity.this.startActivity(graduationPlanActivityIntent);
    }

    public void onClickShareBtn(View v) {
        Uri uri = Uri.parse("android.resource://"+ getPackageName()+"/"
            +R.drawable.davia_image);
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType("image/jpeg");
        startActivity(Intent.createChooser(shareIntent, null));

    }
}
