package quickandroid.example;
import org.qtproject.qt5.android.QtNative;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.pax.dal.IDAL;
import com.pax.neptunelite.api.DALProxyClient;

import quickandroid.QuickAndroidActivity;
import quickandroid.SystemDispatcher;
import quickandroid.pax.TestLog;

/** An alternative Activity class for Qt applicaiton.

 Remarks: It is recommended but not a must to use this class as the main activity.
 */

public class MyMainActivity extends QuickAndroidActivity {

    public static IDAL idal = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            idal = DALProxyClient.getInstance().getDal(getApplicationContext());
        } catch (Exception e) {
            Log.e(TestLog.LOG_TAG,e.getMessage());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SystemDispatcher.onActivityResult(requestCode,resultCode,data);
    }

    protected void onResume() {
        super.onResume();
        SystemDispatcher.onActivityResume();
    }

}

