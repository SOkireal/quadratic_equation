package com.example.quadratic_equation_test.presenters;

import com.example.quadratic_equation_test.fragments.DetailsFrag;
import com.example.quadratic_equation_test.model.CalculationDetailsModel;
import com.example.quadratic_equation_test.router.FragmentRouter;

public class DetailsPresenter {

    DetailsFrag view;
    FragmentRouter fr;
    String a, b, c, d;
    String equation;
    CalculationDetailsModel cdm;

    public void setView(DetailsFrag view) {
        this.view = view;
    }

    public void setRouter(FragmentRouter fr) {
        this.fr = fr;
    }

    public void setModel(CalculationDetailsModel cdm) {
        this.cdm = cdm;
    }

    public void formEquation() {
        getVar();
        equation = "D = " + b + "\u00B2 " + " - 4 \u00D7 " + a + " \u00D7 " + c;
        d = "D = " + d;
        view.showEquation(equation, d);
    }

    public void onBackButtonClick() {
        fr.showFragmentCalculator();
    }

    public void getVar() {
        a = cdm.getVar_a();
        b = cdm.getVar_b();
        c = cdm.getVar_c();
        d = cdm.getDiscriminant();
    }
}
