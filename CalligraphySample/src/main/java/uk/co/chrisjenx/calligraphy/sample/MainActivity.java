package uk.co.chrisjenx.calligraphy.sample;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.InjectView;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import uk.co.chrisjenx.calligraphy.CalligraphyTypefaceSpan;
import uk.co.chrisjenx.calligraphy.CalligraphyUtils;
import uk.co.chrisjenx.calligraphy.TypefaceUtils;

public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        // Inject pragmatically
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, PlaceholderFragment.getInstance())
                .commit();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                setTitle("Calligraphy changed");
                getSupportActionBar().setSubtitle("Added subtitle");

                mToolbar.setTitle("CALLIGRAPHY YAY");

//                mToolbar.setTitle(CalligraphyUtils.applyTypefaceSpan("CALLIGRAPHY YAY", TypefaceUtils.load(getAssets(), "fonts/Oswald-Stencbab.ttf")));

                Log.d("vmi", "title: " + mToolbar.getTitle());
            }
        }, 1000);


    }

    /*
        Uncomment if you disable PrivateFactory injection. See CalligraphyConfig#disablePrivateFactoryInjection()
     */
//    @Override
//    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//    public View onCreateView(View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs) {
//        return CalligraphyContextWrapper.onActivityCreateView(this, parent, super.onCreateView(parent, name, context, attrs), name, context, attrs);
//    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
