package com.example.quadratic_equation_test.presenters;

import android.widget.EditText;
import android.widget.TextView;

import com.example.quadratic_equation_test.fragments.CalculatorFrag;
import com.example.quadratic_equation_test.model.CalculationDetailsModel;
import com.example.quadratic_equation_test.router.FragmentRouter;

import java.text.DecimalFormat;

public class CalculatorPresenter {

    Double a, b, c;
    String discriminant;
    String head_equation;
    CalculatorFrag view;
    FragmentRouter fragmentRouter;
    CalculationDetailsModel calculationDetailsModel;
    DecimalFormat decimalFormat = new DecimalFormat("0.#");

    public CalculatorPresenter(FragmentRouter fragmentRouter, CalculatorFrag view) {
        this.fragmentRouter = fragmentRouter;
        this.view = view;
    }

    public void updateData(CalculationDetailsModel cdm) {
        this.calculationDetailsModel = cdm;
    }

    public void onCalculateClicked(
            String var_a,
            String var_b,
            String var_c
    ) {
        if (!var_a.equals("") && !var_b.equals("") && !var_c.equals("")) {
            a = Double.parseDouble(var_a);
            b = Double.parseDouble(var_b);
            c = Double.parseDouble(var_c);
            discriminant = decimalFormat.format(b * b - 4 * a * c);
            saveVar();
            view.showDisc(discriminant);
            head_equation = String.format(
                    "%sx\u00B2 + %sx + %s = 0",
                    decimalFormat.format(a), decimalFormat.format(b), decimalFormat.format(c)
            );
            view.showHeadEquation(head_equation);
        } else view.showDiscError();
    }

    public void onDetailedClicked() {
        fragmentRouter.showFragmentDetails();
    }

    public void saveVar() {
        calculationDetailsModel.saveValues(
                decimalFormat.format(a),
                decimalFormat.format(b),
                decimalFormat.format(c),
                discriminant);
    }
}
