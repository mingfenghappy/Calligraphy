package uk.co.chrisjenx.calligraphy.sample;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

import uk.co.chrisjenx.calligraphy.CalligraphyUtils;
import uk.co.chrisjenx.calligraphy.TypefaceUtils;

public class CalligraphyToolbar extends Toolbar {

    public CalligraphyToolbar(Context context) {
        super(context);
    }

    public CalligraphyToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CalligraphyToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(CalligraphyUtils.applyTypefaceSpan(title, TypefaceUtils.load(getContext()
                .getAssets(), "fonts/Oswald-Stencbab.ttf")));
    }
}
