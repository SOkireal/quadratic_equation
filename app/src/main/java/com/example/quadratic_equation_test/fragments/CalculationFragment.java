package com.example.quadratic_equation_test.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.quadratic_equation_test.R;
import com.example.quadratic_equation_test.presenters.CalculationPresenter;


public class CalculationFragment extends Fragment {

    EditText varA;
    EditText varB;
    EditText varC;
    TextView discriminantAnswer;
    TextView headEquation;
    Button btnCalculate;
    Button btnDetailed;
    CalculationPresenter presenter;
    public static final String TAG = "CalculatorFrag";

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        setListeners();
    }

    public void setPresenter(CalculationPresenter presenter) {
        this.presenter = presenter;
    }

    public void showEmptyFieldError() {
        discriminantAnswer.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                this.getResources().getDimension(R.dimen.disc_error_text)
        );
        discriminantAnswer.setTextColor(this.getResources().getColor(R.color.discriminant_error));
        discriminantAnswer.setText(R.string.discriminant_error);
        discriminantAnswer.setVisibility(View.VISIBLE);
        btnDetailed.setVisibility(View.GONE);
        headEquation.setText(getResources().getString(R.string.equation_head));
    }

    public void showIncorrectInputNum() {
        discriminantAnswer.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                this.getResources().getDimension(R.dimen.disc_error_text)
        );
        discriminantAnswer.setTextColor(this.getResources().getColor(R.color.discriminant_error));
        discriminantAnswer.setText(R.string.unknown_error);
        discriminantAnswer.setVisibility(View.VISIBLE);
        btnDetailed.setVisibility(View.GONE);
        headEquation.setText(getResources().getString(R.string.equation_head));
    }

    public void showDisc(String discriminant) {
        discriminantAnswer.setText(discriminant);
        discriminantAnswer.setTextSize(
                TypedValue.COMPLEX_UNIT_PX,
                this.getResources().getDimension(R.dimen.disc_answer_text)
        );
        discriminantAnswer.setTextColor(this.getResources().getColor(R.color.text_black));
        discriminantAnswer.setVisibility(View.VISIBLE);
        btnDetailed.setVisibility(View.VISIBLE);
    }

    public void showHeadEquation(String headEquation) {
        this.headEquation.setText(headEquation);
    }

    private void initViews() {
        if(getView() != null) {
            varA = getView().findViewById(R.id.variable_a);
            varB = getView().findViewById(R.id.variable_b);
            varC = getView().findViewById(R.id.variable_c);
            discriminantAnswer = getView().findViewById(R.id.discriminant);
            btnCalculate = getView().findViewById(R.id.btn_calculate);
            btnDetailed = getView().findViewById(R.id.btn_detailed);
            headEquation = getView().findViewById(R.id.head_equation);
        }
    }

    private void setListeners() {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCalculateClicked(
                        varA.getText().toString().trim(),
                        varB.getText().toString().trim(),
                        varC.getText().toString().trim()
                );
            }
        });

        btnDetailed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDetailedClicked();
            }
        });
    }
}
