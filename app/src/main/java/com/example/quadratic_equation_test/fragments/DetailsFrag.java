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
import com.example.quadratic_equation_test.router.FragmentRouter;

public class DetailsFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.fragment_details, container, false);

        TextView discriminant_decision1 = v.findViewById(R.id.discriminant_decision1);
        TextView discriminant_decision2 = v.findViewById(R.id.discriminant_decision2);
        Button back_to_main = v.findViewById(R.id.back_to_main);


        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentRouter fr = new FragmentRouter(getFragmentManager(), R.id.frame_layout);
                fr.showFragmentCalculator();
            }
        });

        return v;
    }

    public void setPresenter(DetailsPresenter detailsPresenter) {

    }
}
