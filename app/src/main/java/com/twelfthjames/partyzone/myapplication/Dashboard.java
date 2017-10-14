package com.twelfthjames.partyzone.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Dashboard extends AppCompatActivity {

    private WebView webView;
    private static final String TAG = "Main";
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dashboard);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);

        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                Log.i(TAG, "Processing Url...");
                view.loadUrl(url);
                return true;
            }

            public void onPageFinished(WebView view, String url){
                Log.i(TAG, "Finished Loading: " + url);
                if(progressBar.isShowing()) {
                    progressBar.dismiss();
                }
            }

//            public void onRecievedError(WebView view, int errorCode, String description, String failingUrl) {
//                Log.e(TAG, "Error: " + description);
//                Toast.makeText(Activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
//                alertDialog.setTitle("Error");
//                alertDialog.setMessage(description);
//                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        return;
//                    }
//                });
//
//                alertDialog.show();
//            }
        });

        webView.loadUrl("http://ec2-34-231-122-149.compute-1.amazonaws.com/");
    }
}
