
package com.mobiquityinc.packer.validation;


public class ValidactionFactory {

    public static Validator getValidation(final String name) {
        if (name.equalsIgnoreCase("weight")) {
            return new WeightValidator();
        } else if (name.equalsIgnoreCase("item")) {
            return new ItemValidator();
        }

        return null;

    }

}
