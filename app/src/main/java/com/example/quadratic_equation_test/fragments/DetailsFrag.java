package com.example.quadratic_equation_test.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.quadratic_equation_test.R;
import com.example.quadratic_equation_test.presenters.DetailsPresenter;

public class DetailsFrag extends Fragment {

    DetailsPresenter presenter;
    TextView discDecision;
    TextView discriminantAnswer;
    Button backToMain;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        presenter.formEquation();
        setListeners();
    }

    public void setPresenter(DetailsPresenter presenter) {
        this.presenter = presenter;
    }

    public void showEquation(String equation, String discriminant) {
        discDecision.setText(equation);
        discriminantAnswer.setText(discriminant);
    }

    private void initViews() {
        if (getView() != null) {
            discDecision = getView().findViewById(R.id.discriminant_decision);
            discriminantAnswer = getView().findViewById(R.id.disc);
            backToMain = getView().findViewById(R.id.back_to_main);
        }
    }

    private void setListeners() {
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackButtonClick();
            }
        });
    }
}
