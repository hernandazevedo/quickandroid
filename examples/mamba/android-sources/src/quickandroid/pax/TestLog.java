package quickandroid.pax;

import android.util.Log;

public class TestLog {

    public static final String LOG_TAG = "paxexample";

    private String childName = "";

    public TestLog() {
        childName = getClass().getSimpleName() + ".";
    }

    public void logTrue(String method) {
        Log.i(LOG_TAG, childName + method);
    }

    public void logErr(String method, String errString) {
        Log.e(LOG_TAG, childName + method + "   Error：" + errString);
    }
}
