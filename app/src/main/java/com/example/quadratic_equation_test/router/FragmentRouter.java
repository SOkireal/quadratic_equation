package com.example.quadratic_equation_test.router;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.quadratic_equation_test.fragments.CalculatorFrag;
import com.example.quadratic_equation_test.fragments.DetailsFrag;
import com.example.quadratic_equation_test.model.CalculationDetailsModel;
import com.example.quadratic_equation_test.presenters.CalculatorPresenter;
import com.example.quadratic_equation_test.presenters.DetailsPresenter;

public class FragmentRouter {

    private final FragmentManager manager;
    private final int containerId;
    CalculationDetailsModel cdm;

    public FragmentRouter(FragmentManager manager, int containerId) {
        this.manager = manager;
        this.containerId = containerId;
    }

    public void showFragmentCalculator() {
        CalculatorFrag calcFrag = new CalculatorFrag();
        CalculatorPresenter calcPresenter = new CalculatorPresenter();
        cdm = new CalculationDetailsModel();
        calcFrag.setPresenter(calcPresenter);
        calcPresenter.setView(calcFrag);
        calcPresenter.setRouter(this);
        calcPresenter.setModel(cdm);
        showFragment(calcFrag);
    }

    public void showFragmentDetails() {
        DetailsFrag detailsFrag = new DetailsFrag();
        DetailsPresenter detailsPresenter = new DetailsPresenter();
        detailsFrag.setPresenter(detailsPresenter);
        detailsPresenter.setView(detailsFrag);
        detailsPresenter.setRouter(this);
        detailsPresenter.setModel(cdm);
        showFragment(detailsFrag);
    }

    private void showFragment(Fragment fragment) {
        manager.beginTransaction().replace(containerId, fragment)
                .commit();
    }
}
