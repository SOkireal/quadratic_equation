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
    TextView disc_decision;
    TextView discriminant;
    Button back_to_main;

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
        disc_decision.setText(equation);
        this.discriminant.setText(discriminant);
    }

    private void initViews() {
        if (getView() != null) {
            disc_decision = getView().findViewById(R.id.discriminant_decision);
            discriminant = getView().findViewById(R.id.disc);
            back_to_main = getView().findViewById(R.id.back_to_main);
        }
    }

    private void setListeners() {
        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackButtonClick();
            }
        });
    }
}
