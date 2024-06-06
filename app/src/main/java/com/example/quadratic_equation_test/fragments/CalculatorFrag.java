package com.example.quadratic_equation_test.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.quadratic_equation_test.R;
import com.example.quadratic_equation_test.presenters.CalculatorPresenter;
import com.example.quadratic_equation_test.router.FragmentRouter;


public class CalculatorFrag extends Fragment {

    EditText var_a, var_b, var_c;
    TextView discriminant, discriminant_error;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        var_a = view.findViewById(R.id.variable_a);
        var_b = view.findViewById(R.id.variable_b);
        var_c = view.findViewById(R.id.variable_c);

        discriminant = view.findViewById(R.id.discriminant);
        discriminant_error = view.findViewById(R.id.discriminant_error);
        Button btn_calculate = view.findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!var_a.getText().toString().equals("") && !var_b.getText().toString().equals("")
                        && !var_c.getText().toString().equals("")) {
                    CalculatorPresenter calculatorPresenter = new CalculatorPresenter();
                    calculatorPresenter.onCalculateClicked(var_a, var_b, var_c, discriminant, discriminant_error);
                } else showDiscError(discriminant_error);
            }
        });

        Button btn_detailed = view.findViewById(R.id.btn_detailed);
        btn_detailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentRouter fr = new FragmentRouter(getFragmentManager(), R.id.frame_layout);
                fr.showFragmentDetails();
            }
        });

        return view;
    }

    public void setPresenter(CalculatorPresenter calcPresenter) {

    }

    public void showDiscError(TextView textView) {
        textView.setText(R.string.discriminant_error);
        discriminant.setText("");
    }

    public void showDisc(TextView textDisc, TextView textDiscError, String discriminant) {
        textDisc.setText(discriminant);
        textDiscError.setText("");
    }
}
