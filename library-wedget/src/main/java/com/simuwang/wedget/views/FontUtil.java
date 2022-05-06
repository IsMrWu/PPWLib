package com.simuwang.wedget.views;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;

public class FontUtil {
    private static final String TAG = "FontUtil";


    public static void mediumFont(TextView textView) {
        fontStrokeWidth(textView,1.0f);
    }

    public static void fontStrokeWidth(TextView textView, float strokeWidth) {
        if(textView == null) return;
        try {
            //textView .setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            //textView.invalidate();
            Typeface typeface = textView.getTypeface();
            if(typeface == null) typeface = Typeface.create("sans-serif", Typeface.NORMAL);
            textView.setTypeface(typeface);
            textView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
            textView.getPaint().setStrokeWidth(strokeWidth);
            textView.invalidate();
        } catch(Exception e) {

        }
    }

    public static void defaultFont(TextView textView) {
        if(textView == null) return;
        try {
            textView .setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            textView.getPaint().setStrokeWidth(0);
            textView.invalidate();
        } catch(Exception e) {

        }
    }
}
