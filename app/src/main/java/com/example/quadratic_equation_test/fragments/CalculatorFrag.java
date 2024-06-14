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

    EditText var_a;
    EditText var_b;
    EditText var_c;
    TextView discriminant;
    TextView head_equation;
    Button btn_calculate;
    Button btn_detailed;
    CalculatorPresenter presenter;
    View view;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        view = inflater.inflate(R.layout.fragment_calculator, container, false);

        initViews();

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    presenter.onCalculateClicked(
                            var_a.getText().toString(),
                            var_b.getText().toString(),
                            var_c.getText().toString()
                            );
            }
        });

        btn_detailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDetailedClicked();
            }
        });;
        return view;
    }

    public void setPresenter(CalculatorPresenter presenter) {
        this.presenter = presenter;
    }

    public void showDiscError() {
        discriminant.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                this.getResources().getDimension(R.dimen.disc_error_text)
        );
        discriminant.setTextColor(this.getResources().getColor(R.color.discriminant_error));
        discriminant.setText(R.string.discriminant_error);
        discriminant.setVisibility(View.VISIBLE);
        btn_detailed.setVisibility(View.GONE);
        head_equation.setText(getResources().getString(R.string.equation_head));
    }

    public void showDisc(String discriminant) {
        this.discriminant.setText(discriminant);
        this.discriminant.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                this.getResources().getDimension(R.dimen.disc_answer_text)
        );
        this.discriminant.setTextColor(this.getResources().getColor(R.color.text_black));
        this.discriminant.setVisibility(View.VISIBLE);
        btn_detailed.setVisibility(View.VISIBLE);
    }

    public void showHeadEquation(String head_equation) {
        this.head_equation.setText(head_equation);
    }

    public void initViews() {
        if(view != null) {
            var_a = view.findViewById(R.id.variable_a);
            var_b = view.findViewById(R.id.variable_b);
            var_c = view.findViewById(R.id.variable_c);
            discriminant = view.findViewById(R.id.discriminant);
            btn_calculate = view.findViewById(R.id.btn_calculate);
            btn_detailed = view.findViewById(R.id.btn_detailed);
            head_equation = view.findViewById(R.id.head_equation);
        }
    }
}
