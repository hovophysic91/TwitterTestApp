package johnnysc.github.twittertestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.crashlytics.android.Crashlytics;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig =  new TwitterAuthConfig("R50NtCvEvmH8LDEnemLaev8vm", "9bnypUqoH4SO0M4Vwavl7JSOOG2hRrjv5eCeronW4LZxV06NS5");
        Fabric.with(this, new TwitterCore(authConfig));
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);


    }
}
