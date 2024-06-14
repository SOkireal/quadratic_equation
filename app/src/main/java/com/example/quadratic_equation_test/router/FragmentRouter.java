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

    public FragmentRouter(FragmentManager manager, int containerId) {
        this.manager = manager;
        this.containerId = containerId;
    }

    public void showFragmentCalculator() {
        CalculatorFrag calcFrag = new CalculatorFrag();
        CalculatorPresenter calcPresenter = new CalculatorPresenter(this, calcFrag);
        calcFrag.setPresenter(calcPresenter);
        showFragment(calcFrag);
    }

    public void showFragmentDetails(CalculationDetailsModel calculationDetailsModel) {
        DetailsFrag detailsFrag = new DetailsFrag();
        DetailsPresenter detailsPresenter = new DetailsPresenter(this, detailsFrag);
        detailsFrag.setPresenter(detailsPresenter);
        detailsPresenter.updateData(calculationDetailsModel);
        showFragment(detailsFrag);
    }

    private void showFragment(Fragment fragment) {
        manager.beginTransaction().replace(containerId, fragment)
                .commit();
    }
}
