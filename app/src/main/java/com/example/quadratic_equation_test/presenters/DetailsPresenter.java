package com.example.quadratic_equation_test.presenters;

import com.example.quadratic_equation_test.fragments.DetailsFragment;
import com.example.quadratic_equation_test.model.CalculationDetailsModel;
import com.example.quadratic_equation_test.router.FragmentRouter;

public class DetailsPresenter {

    DetailsFragment view;
    FragmentRouter fragmentRouter;
    String varA;
    String varB;
    String varC;
    String discriminant;
    String equation;
    CalculationDetailsModel calculationDetailsModel;

    public DetailsPresenter(FragmentRouter fragmentRouter, DetailsFragment view) {
        this.fragmentRouter = fragmentRouter;
        this.view = view;
    }

    public void updateData(CalculationDetailsModel model) {
        calculationDetailsModel = model;
    }

    public void formEquation() {
        getVar();
        equation = String.format("D = %s\u00B2 - 4 \u00D7 %s \u00D7 %s", varB, varA, varC);
        discriminant = String.format("D = %s", discriminant);
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
