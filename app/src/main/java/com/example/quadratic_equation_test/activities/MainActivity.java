package com.example.quadratic_equation_test.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.quadratic_equation_test.R;
import com.example.quadratic_equation_test.router.FragmentRouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentRouter fragmentRouter = new FragmentRouter(getSupportFragmentManager(),
                R.id.frame_layout);
        fragmentRouter.showFragmentCalculator();
    }
}
