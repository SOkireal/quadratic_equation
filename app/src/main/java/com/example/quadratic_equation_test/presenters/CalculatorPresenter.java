package com.example.quadratic_equation_test.presenters;

import android.widget.EditText;
import android.widget.TextView;

import com.example.quadratic_equation_test.fragments.CalculatorFrag;
import com.example.quadratic_equation_test.model.CalculationDetailsModel;
import com.example.quadratic_equation_test.router.FragmentRouter;

import java.text.DecimalFormat;

public class CalculatorPresenter {

    Double a, b, c;
    String d, head_equation;
    CalculatorFrag view;
    FragmentRouter fr;
    CalculationDetailsModel cdm;
    DecimalFormat df = new DecimalFormat("0.#");

    public void setRouter(FragmentRouter fr) {
        this.fr = fr;
    }

    public void setView(CalculatorFrag view) {
        this.view = view;
    }

    public void setModel(CalculationDetailsModel cdm) {
        this.cdm = cdm;
    }

    public void onCalculateClicked(
            EditText var_a,
            EditText var_b,
            EditText var_c,
            TextView discriminant
    ) {
        if (!var_a.getText().toString().equals("") && !var_b.getText().toString().equals("")
                && !var_c.getText().toString().equals("")) {
            a = Double.parseDouble(var_a.getText().toString());
            b = Double.parseDouble(var_b.getText().toString());
            c = Double.parseDouble(var_c.getText().toString());
            d = df.format(b * b - 4 * a * c);
            saveVar();
            view.showDisc(discriminant, d);
            head_equation = df.format(a) + "x^2 + " + df.format(b) + "x + " + df.format(c) + " = 0";
            view.showHeadEquation(head_equation);
        } else view.showDiscError(discriminant);
    }

    public void onDetailedClicked() {
        fr.showFragmentDetails();
    }

    public void saveVar() {
        cdm.setVar_a(df.format(a));
        cdm.setVar_b(df.format(b));
        cdm.setVar_c(df.format(c));
        cdm.setDiscriminant(d);
    }
}
