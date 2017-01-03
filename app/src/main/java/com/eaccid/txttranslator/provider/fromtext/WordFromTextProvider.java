package com.eaccid.txttranslator.provider.fromtext;

import android.view.MotionEvent;
import android.widget.TextView;

public interface WordFromTextProvider {
    WordFromText getWordByMotionEvent(TextView tv, MotionEvent event);
}
