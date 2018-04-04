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

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.mobiquityinc.packer.bo.Item;
import com.mobiquityinc.packer.util.PackerChallengeAlgorithm;

import junit.framework.Assert;

@RunWith(JUnit4.class)
public class PackerChallengeAlgorithmTest {

    private PackerChallengeAlgorithm testee = new PackerChallengeAlgorithm();

    @Test
    public void test() {

        Assert.assertEquals(25.0, testee.knapSack(7.0, buildItems()));

        Assert.assertEquals(0.0, testee.knapSack(1.0, buildItems()));

        Assert.assertEquals(29.0, testee.knapSack(12.0, buildItems()));

    }

    private List<Item> buildItems() {
        final Item item = new Item();
        item.setCost(23.0);
        item.setWeight(2.0);
        item.setIndex(1);

        final Item item1 = new Item();
        item1.setCost(2.0);
        item1.setWeight(3.0);
        item1.setIndex(2);

        final Item item2 = new Item();
        item2.setCost(4.0);
        item2.setWeight(7.0);
        item2.setIndex(3);
        return Arrays.asList(item, item1, item2);

    }

}
