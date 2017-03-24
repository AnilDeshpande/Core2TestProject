package shell.com.core2testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends EnhancedAppCompatActivity<MainPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
