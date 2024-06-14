package com.example.quadratic_equation_test.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
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

    EditText varA;
    EditText varB;
    EditText varC;
    TextView discriminant;
    TextView head_equation;
    Button btn_calculate;
    Button btn_detailed;
    CalculatorPresenter presenter;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        Log.d("!!!", "onCreateView");
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        setListeners();
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

    private void initViews() {
        if(getView() != null) {
            varA = getView().findViewById(R.id.variable_a);
            varB = getView().findViewById(R.id.variable_b);
            varC = getView().findViewById(R.id.variable_c);
            discriminant = getView().findViewById(R.id.discriminant);
            btn_calculate = getView().findViewById(R.id.btn_calculate);
            btn_detailed = getView().findViewById(R.id.btn_detailed);
            head_equation = getView().findViewById(R.id.head_equation);
        }
    }

    private void setListeners() {
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCalculateClicked(
                        varA.getText().toString(),
                        varB.getText().toString(),
                        varC.getText().toString()
                );
            }
        });

        btn_detailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDetailedClicked();
            }
        });
    }
}
