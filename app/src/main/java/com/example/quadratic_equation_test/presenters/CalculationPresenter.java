package com.example.quadratic_equation_test.presenters;



import com.example.quadratic_equation_test.fragments.CalculationFragment;
import com.example.quadratic_equation_test.model.CalculationDetailsModel;
import com.example.quadratic_equation_test.router.FragmentRouter;
import java.text.DecimalFormat;

public class CalculationPresenter {
    Double varA;
    Double varB;
    Double varC;
    String discriminant;
    String headEquation;
    CalculationFragment view;
    FragmentRouter fragmentRouter;
    CalculationDetailsModel calculationDetailsModel;
    DecimalFormat decimalFormat = new DecimalFormat("0.#");

    public CalculationPresenter(FragmentRouter fragmentRouter, CalculationFragment view) {
        this.fragmentRouter = fragmentRouter;
        this.view = view;
    }

    public void onCalculateClicked(
            String varA,
            String varB,
            String varC
    ) {
        if (varA.equals("") || varB.equals("") || varC.equals("")) {
            view.showEmptyFieldError();
        } else if (!varA.equals(".") && !varB.equals(".") && !varC.equals(".")) {
            this.varA = Double.parseDouble(varA);
            this.varB = Double.parseDouble(varB);
            this.varC = Double.parseDouble(varC);
            discriminant = decimalFormat.format(
                    this.varB * this.varB - 4 * this.varA * this.varC
            );
            saveVar();
            view.showDisc(discriminant);
            headEquation = String.format(
                    "%sx\u00B2 + %sx + %s = 0",
                    decimalFormat.format(this.varA),
                    decimalFormat.format(this.varB),
                    decimalFormat.format(this.varC)
            );
            view.showHeadEquation(headEquation);
        } else view.showIncorrectInputNum();
    }

    public void onDetailedClicked() {
        fragmentRouter.showFragmentDetails(calculationDetailsModel);
    }

    private void saveVar() {
        calculationDetailsModel = new CalculationDetailsModel(
                decimalFormat.format(varA),
                decimalFormat.format(varB),
                decimalFormat.format(varC),
                discriminant
        );
    }
}
