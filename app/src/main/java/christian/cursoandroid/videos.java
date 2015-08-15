package christian.cursoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class videos extends AppCompatActivity {;

    // INI AGREGADO
    private WebView mWebView;
// FIN AGREGADO


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_videos, menu);
        // INI AGREGADO
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
// Activamos Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
// Url que carga la app (webview)
        mWebView.loadUrl("https://www.youtube.com/playlist?list=PLC7Ec2r5tkJCAwd-Ig7x69pytjjkHsfA9");
// Forzamos el webview para que abra los enlaces internos dentro de la la APP
        mWebView.setWebViewClient(new WebViewClient());
// Forzamos el webview para que abra los enlaces externos en el navegador
        mWebView.setWebViewClient(new MyAppWebViewClient());
// FIN AGREGADO
        return false;
    }
        // INI AGREGADO
        // Detectar cuando se presiona el botón de retroceso
        public void onBackPressed() {
            if(mWebView.canGoBack()) {
                mWebView.goBack();
            } else {
                super.onBackPressed();
            }
        }
// FIN AGREGADO
        ;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }


    class MyAppWebViewClient extends WebViewClient {
    }
}
