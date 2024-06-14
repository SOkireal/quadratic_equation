package com.example.quadratic_equation_test.presenters;

import com.example.quadratic_equation_test.fragments.DetailsFrag;
import com.example.quadratic_equation_test.model.CalculationDetailsModel;
import com.example.quadratic_equation_test.router.FragmentRouter;

public class DetailsPresenter {

    DetailsFrag view;
    FragmentRouter fragmentRouter;
    String varA;
    String varB;
    String varC;
    String discriminant;
    String equation;
    CalculationDetailsModel calculationDetailsModel;

    public DetailsPresenter(FragmentRouter fragmentRouter, DetailsFrag view) {
        this.fragmentRouter = fragmentRouter;
        this.view = view;
    }

    public void updateData(CalculationDetailsModel calculationDetailsModel) {
        this.calculationDetailsModel = calculationDetailsModel;
    }

    public void formEquation() {
        getVar();
        equation = "D = " + varB + "\u00B2 " + " - 4 \u00D7 " + varA + " \u00D7 " + varC;
        discriminant = "D = " + discriminant;
        view.showEquation(equation, discriminant);
    }

    public void onBackButtonClick() {
        fragmentRouter.showFragmentCalculator();
    }

    private void getVar() {
        varA = calculationDetailsModel.varA;
        varB = calculationDetailsModel.varB;
        varC = calculationDetailsModel.varC;
        discriminant = calculationDetailsModel.discriminant;
    }
}
