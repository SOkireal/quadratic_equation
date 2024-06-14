package com.example.quadratic_equation_test.model;

public class CalculationDetailsModel {
    String var_a;
    String var_b;
    String var_c;
    String discriminant;

    public void saveValues(String var_a, String var_b, String var_c, String discriminant) {
        this.var_a = var_a;
        this.var_b = var_b;
        this.var_c = var_c;
        this.discriminant = discriminant;
    }

    public String getVar_a() {
        return var_a;
    }

    public String getVar_b() {
        return var_b;
    }

    public String getVar_c() {
        return var_c;
    }

    public String getDiscriminant() {
        return discriminant;
    }
}
