
package com.mobiquityinc.packer.validation;

import com.mobiquityinc.packer.bo.Package;
import com.mobiquityinc.packer.exception.ApiException;

public class WeightValidator implements Validator<Package> {


    @Override
    public boolean validate(final Package object) {
        return validateWeight(object);
    }

    private boolean validateWeight(final Package pkg) {
        if (pkg.getWeight() < 0) {
            throw new ApiException("the package weight should be greater than 0");
        } else if (pkg.getWeight() > 100) {
            throw new ApiException("the package weight should be smaller than 100");
        }
        return true;
    }

}
