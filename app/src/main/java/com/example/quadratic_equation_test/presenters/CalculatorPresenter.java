package com.example.quadratic_equation_test.presenters;



import com.example.quadratic_equation_test.fragments.CalculatorFrag;
import com.example.quadratic_equation_test.model.CalculationDetailsModel;
import com.example.quadratic_equation_test.router.FragmentRouter;
import java.text.DecimalFormat;

public class CalculatorPresenter {
    Double varA;
    Double varB;
    Double varC;
    String discriminant;
    String headEquation;
    CalculatorFrag view;
    FragmentRouter fragmentRouter;
    CalculationDetailsModel calculationDetailsModel;
    DecimalFormat decimalFormat = new DecimalFormat("0.#");

    public CalculatorPresenter(FragmentRouter fragmentRouter, CalculatorFrag view) {
        this.fragmentRouter = fragmentRouter;
        this.view = view;
    }

    public void onCalculateClicked(
            String varA,
            String varB,
            String varC
    ) {
        try {
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
        } catch(Exception e) {
            view.showUnknownError();
        }

        if (varA.equals("") && varB.equals("") && varC.equals("")) {
            view.showEmptyFieldError();
        }
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
