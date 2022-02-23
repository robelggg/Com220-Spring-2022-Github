package com.alexanderbehrhof.myyearbook.activities.robel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alexanderbehrhof.myyearbook.AbstractActivity;
import com.alexanderbehrhof.myyearbook.R;

public class GraduationPlanActivity extends AbstractActivity {
private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.robel_graduation_plan);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com");
    }
}
