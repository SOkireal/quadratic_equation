package com.example.quadratic_equation_test.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.quadratic_equation_test.R;
import com.example.quadratic_equation_test.presenters.CalculatorPresenter;


public class CalculatorFrag extends Fragment {

    EditText var_a, var_b, var_c;
    TextView discriminant, head_equation;
    Button btn_calculate, btn_detailed;
    CalculatorPresenter presenter;
    View v;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        v = inflater.inflate(R.layout.fragment_calculator, container, false);

        initViews();

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    presenter.onCalculateClicked(var_a, var_b, var_c, discriminant);
            }
        });

        btn_detailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDetailedClicked();
            }
        });;
        return v;
    }

    public void setPresenter(CalculatorPresenter presenter) {
        this.presenter = presenter;
    }

    public void showDiscError(TextView viewDisc) {
        viewDisc.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                this.getResources().getDimension(R.dimen.disc_error_text)
        );
        viewDisc.setTextColor(this.getResources().getColor(R.color.discriminant_error));
        viewDisc.setText(R.string.discriminant_error);
        viewDisc.setVisibility(View.VISIBLE);
        btn_detailed.setVisibility(View.GONE);
        head_equation.setText(getResources().getString(R.string.equation_head));
    }

    public void showDisc(TextView viewDisc, String discriminant) {
        viewDisc.setText(discriminant);
        viewDisc.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                this.getResources().getDimension(R.dimen.disc_answer_text)
        );
        viewDisc.setTextColor(this.getResources().getColor(R.color.text_black));
        viewDisc.setVisibility(View.VISIBLE);
        btn_detailed.setVisibility(View.VISIBLE);
    }

    public void showHeadEquation(String head_equation) {
        this.head_equation.setText(head_equation);
    }

    public void initViews() {
        var_a = v.findViewById(R.id.variable_a);
        var_b = v.findViewById(R.id.variable_b);
        var_c = v.findViewById(R.id.variable_c);
        discriminant = v.findViewById(R.id.discriminant);
        btn_calculate = v.findViewById(R.id.btn_calculate);
        btn_detailed = v.findViewById(R.id.btn_detailed);
        head_equation = v.findViewById(R.id.head_equation);
    }
}
