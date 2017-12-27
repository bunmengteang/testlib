package testlib.mengteang.mylib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by User on 12/27/2017.
 */

public class MyLibCutomizeToast extends Toast {
    private static MyLibCutomizeToast myLibCutomizeToast;

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public MyLibCutomizeToast(Context context) {
        super(context);
    }

    public static synchronized MyLibCutomizeToast getInstance(Context context) {
        if (null == myLibCutomizeToast) {
            myLibCutomizeToast = new MyLibCutomizeToast(context);
        }
        return myLibCutomizeToast;
    }

    public void showToastLong(final Context context, final String smg) {
        if (null != myLibCutomizeToast) {
            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    myLibCutomizeToast.cancel();
                    myLibCutomizeToast.makeText(context, smg + " Method 1", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void showToastShort(final Context context, final String smg) {
        if (null != myLibCutomizeToast) {
            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    myLibCutomizeToast.cancel();
                    myLibCutomizeToast.makeText(context, smg + " Method 2", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
