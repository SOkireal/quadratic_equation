package com.example.quadratic_equation_test.presenters;

import android.widget.EditText;
import android.widget.TextView;

import com.example.quadratic_equation_test.fragments.CalculatorFrag;

public class CalculatorPresenter {
    Double a, b, c;
    String d;

    public void setView(CalculatorFrag calcFrag) {

    }

    public void onCalculateClicked(EditText var_a, EditText var_b, EditText var_c,
                                   TextView discriminant, TextView discriminant_error) {
            a = Double.parseDouble(var_a.getText().toString());
            b = Double.parseDouble(var_b.getText().toString());
            c = Double.parseDouble(var_c.getText().toString());

            d = Double.toString(b * b - 4 * a * c);
            CalculatorFrag cf = new CalculatorFrag();
            cf.showDisc(discriminant, discriminant_error, d);
    }
}
