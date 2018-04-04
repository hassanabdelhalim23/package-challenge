/*
 * Copyright 2018 Mondia Media Group GmbH. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Mondia Media Group GmbH ("Confidential Information").
 * You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement
 * you entered into with Mondia Media Group GmbH.
 */
package com.mobiquityinc.packer;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.mobiquityinc.packer.bo.Item;
import com.mobiquityinc.packer.util.PackerChallengeConstants;
import com.mobiquityinc.packer.validation.ItemValidator;

@RunWith(JUnit4.class)
public class ValidationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ItemValidator itemValidator = new ItemValidator();

    @Test
    public void testIndexLimit() {
        expectedException.expectMessage(PackerChallengeConstants.ITEM_VALIDATION_LIMIT_MESSAGE);
        final Item item = new Item();
        item.setWeight(10.0);
        item.setIndex(16);
        item.setCost(2.5);
        itemValidator.validate(item);
    }

    @Test
    public void testIndexExceedWeight() {
        expectedException.expectMessage(PackerChallengeConstants.ITEM_VALIDATION_LEAST_VALUE_MESSAGE);
        final Item item = new Item();
        item.setWeight(10.0);
        item.setIndex(-1);
        item.setCost(2.5);
        itemValidator.validate(item);
    }

}
