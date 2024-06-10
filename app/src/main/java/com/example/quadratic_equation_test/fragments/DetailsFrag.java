package com.example.quadratic_equation_test.fragments;

import android.os.Bundle;
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
    TextView disc_decision, disc;
    Button back_to_main;
    View v;

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        v = inflater.inflate(R.layout.fragment_details, container, false);

        initViews();
        presenter.formEquation();

        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackButtonClick();
            }
        });
        return v;
    }

    public void setPresenter(DetailsPresenter presenter) {
        this.presenter = presenter;
    }

    public void showEquation(String equation, String discriminant) {
        disc_decision.setText(equation);
        disc.setText(discriminant);
    }

    public void initViews() {
        disc_decision = v.findViewById(R.id.discriminant_decision);
        disc = v.findViewById(R.id.disc);
        back_to_main = v.findViewById(R.id.back_to_main);
    }
}
