package quickandroid.example;
import br.com.buy4.mamba.R;
import quickandroid.SystemDispatcher;
import quickandroid.pax.PrinterTester;

import android.app.Notification;
import android.app.NotificationManager;
import android.util.Log;
import android.os.Handler;
import android.app.Activity;
import android.view.View;
import android.content.Context;
import android.widget.Toast;

import com.pax.dal.entity.EFontTypeAscii;
import com.pax.dal.entity.EFontTypeExtCode;

import java.util.Map;
import org.qtproject.qt5.android.QtNative;

public class ExampleService {

    static void start() {

        SystemDispatcher.addListener(new SystemDispatcher.Listener() {

            NotificationManager m_notificationManager;
            Notification.Builder m_builder;

            private void notificationManagerNotify(Map data) {

                final Activity activity = QtNative.activity();
                final Map messageData = data;

                Runnable runnable = new Runnable () {
                    public void run() {
                        try {
                            String title = (String) messageData.get("title");

                            String message = (String) messageData.get("message");

                            if (m_notificationManager == null) {
                                m_notificationManager = (NotificationManager) activity.getSystemService(Context.NOTIFICATION_SERVICE);
                                m_builder = new Notification.Builder(activity);

                                // Small Icon is a must to make notification works.
                                // And that is why you need to inherit QtActivity
                                m_builder.setSmallIcon(R.drawable.icon);
                            }

                            m_builder.setContentTitle(title);
                            m_builder.setContentText(message);
                            m_notificationManager.notify(1, m_builder.build());

                            // Test function. Remove it later.
                            SystemDispatcher.dispatch("Notifier.notifyFinished");
                        } catch (Exception e) {
                            Log.d("",e.getMessage());
                        }

                    };
                };
                activity.runOnUiThread(runnable);
            }


            private void paxPrint(Map data) {

                final Activity activity = QtNative.activity();
                final Map messageData = data;

                Runnable runnable = new Runnable () {
                    public void run() {
                        try {
                            String title = (String) messageData.get("title");

                            String message = (String) messageData.get("message");

                            Log.d("quickandroid.example",title);
                            Log.d("quickandroid.example",message);

                            final String messageToPrint = String.format("Title: %s, Message: %s",title,message);

                            //TODO replace with the code to call neptune and print on the POS A920
//                            Toast.makeText(activity, title +" " + message, Toast.LENGTH_LONG).show();

                            new Thread(new Runnable() {
                                public void run() {
                                    PrinterTester.getInstance().init();
                                    PrinterTester.getInstance().fontSet((EFontTypeAscii) EFontTypeAscii.FONT_8_16,
                                            (EFontTypeExtCode) EFontTypeExtCode.FONT_16_16);
                                    PrinterTester.getInstance().spaceSet(Byte.parseByte("0"),
                                            Byte.parseByte("0"));
                                    PrinterTester.getInstance().leftIndents(Short.parseShort("0"));
                                    PrinterTester.getInstance().setGray(1);
                                    PrinterTester.getInstance().setInvert(false);
                                    PrinterTester.getInstance().printStr(messageToPrint, null);
                                    PrinterTester.getInstance().step(150);

                                    final String status = PrinterTester.getInstance().start();

                                }
                            }).start();

                            // Test function. Remove it later.
                            SystemDispatcher.dispatch("Notifier.notifyFinished");
                        } catch (Exception e) {
                            Log.d("",e.getMessage());
                        }

                    };
                };
                activity.runOnUiThread(runnable);
            }

            private void hapticFeedbackPerform(Map data) {

                final Activity activity = QtNative.activity();
                final Map messageData = data;
                Runnable runnable = new Runnable () {
                    public void run() {
                        int feedbackConstant = (Integer) messageData.get("feedbackConstant");
                        int flags = (Integer) messageData.get("flags");

                        Log.d("",String.format("hapticFeedbackPerform(%d,%d)",feedbackConstant,flags));

                        View rootView = activity.getWindow().getDecorView().getRootView();
                        rootView.performHapticFeedback(feedbackConstant, flags);

                        // Test function. Remove it later.
                        SystemDispatcher.dispatch("hapticFeedbackPerformFinished");
                    };
                };
                activity.runOnUiThread(runnable);
            }

            public void onDispatched(String name , Map data) {

                Log.d("quickandroid.example", "onDispatched: " + name);

                if (name.equals("Notifier.notify")) {
                    notificationManagerNotify(data);
                    return;
                } else if (name.equals("hapticFeedbackPerform")) {
                    hapticFeedbackPerform(data);
                    return;
                } else if (name.equals("Notifier.paxPrint")){
                    paxPrint(data);
                }

                return;
            }
        });

    }

}

