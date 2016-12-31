package com.eaccid.txttranslator;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.eaccid.txttranslator.fromtext.WordFromText;
import com.eaccid.txttranslator.fromtext.WordFromTextProviderImpl;

public class OnWordFromTextViewTouchListener implements View.OnTouchListener{

    public interface OnWordFromTextClickListener {
        void OnWordClicked(WordFromText WordFromText);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.AXIS_Y:
                TextView tv = (TextView) view;
                WordFromText WordFromText = new WordFromTextProviderImpl().getWordByMotionEvent(tv, motionEvent);
                if (!WordFromText.getText().isEmpty()) {
                    try {
                        ((OnWordFromTextClickListener) view.getContext()).OnWordClicked(WordFromText);
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new NotImplementedException("'interface " +
                                "OnWordFromTextViewTouchListener.OnWordFromTextClickListener: ' " +
                                "method is not implemented in " + "'" +
                                view.getContext().getPackageName() + "." +
                                view.getContext().getClass().getName() + "'");
                    }
                }
        }
        return true;
    }

}
