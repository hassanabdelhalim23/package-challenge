
package com.mobiquityinc.packer.validation;

import com.mobiquityinc.packer.bo.Item;
import com.mobiquityinc.packer.exception.ApiException;
import com.mobiquityinc.packer.util.PackerChallengeConstants;

public class ItemValidator implements Validator<Item> {

    @Override
    public boolean validate(final Item object) {
        return validateIndex(object) && validateWeight(object);

    }

    private boolean validateIndex(final Item item) {
        if (item.getIndex() < 0) {
            throw new ApiException(PackerChallengeConstants.ITEM_VALIDATION_LEAST_VALUE_MESSAGE);
        } else if (item.getIndex() > 15) {
            throw new ApiException(PackerChallengeConstants.ITEM_VALIDATION_LIMIT_MESSAGE);
        }
        return true;
    }

    private boolean validateWeight(final Item item) {
        if (item.getWeight() < 0) {
            throw new ApiException("the item weight should be greater than 0");
        } else if (item.getWeight() > 100) {
            throw new ApiException("the item weight should be smaller than 100");
        }
        return true;
    }

}
