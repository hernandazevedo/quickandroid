package quickandroid.pax;

import android.util.Log;

import com.pax.dal.IDAL;

import quickandroid.QuickAndroidActivity;

public class GetObj {

    private static IDAL dal;

    public static IDAL getDal() {
        dal = quickandroid.example.MyMainActivity.idal;
        if (dal == null) {
            Log.e(TestLog.LOG_TAG, "dal is null");
        }
        return dal;
    }

}
