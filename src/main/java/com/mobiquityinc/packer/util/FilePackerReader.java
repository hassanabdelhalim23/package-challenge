/*
 * Copyright 2018 Mondia Media Group GmbH. All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Mondia Media Group GmbH ("Confidential Information").
 * You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement
 * you entered into with Mondia Media Group GmbH.
 */
package com.mobiquityinc.packer.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mobiquityinc.packer.bo.Item;
import com.mobiquityinc.packer.bo.Package;
import com.mobiquityinc.packer.exception.ApiException;
import com.mobiquityinc.packer.validation.ValidactionFactory;
import com.mobiquityinc.packer.validation.Validator;

public class FilePackerReader implements PackerReader {

    @Override
    public List<Package> collectPackagesFromFile(final String fileName) {

        final Validator<Item> itemValidator = ValidactionFactory.getValidation("item");
        final Validator<Package> weightValidator = ValidactionFactory.getValidation("weight");

        final List<Package> packages = new ArrayList<>();
         try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String currentLine = bufferedReader.readLine();
            String[] itemsText = null;
            String[] textLine = null;
            Item item = null;
            Package pkg = null;
            while (currentLine != null) {
                pkg = new Package();
                textLine = currentLine.split(":");
                pkg.setWeight(Double.parseDouble(textLine[0].trim()));
                itemsText = textLine[1].trim().split(" ");
                weightValidator.validate(pkg);
                final List<Item> x = new ArrayList<>();
                for (final String s : itemsText) {
                    item = new Item();
                    final String[] subItem = s.split(",");
                    item.setIndex(Integer.parseInt(subItem[0].substring(1)));
                    item.setWeight(Double.parseDouble(subItem[1]));
                    item.setCost(Double.parseDouble(subItem[2].substring(1, subItem[2].length() - 1)));

                    itemValidator.validate(item);
                    x.add(item);
                    item = null;
                }
                pkg.setItems(x);
                packages.add(pkg);
                pkg = null;
                currentLine = bufferedReader.readLine();

            }

        } catch (final IOException e) {
            throw new ApiException(e.getMessage());
        }

        return packages;

    }

    public void validateItem(final Double weight, final List<Item> items, final Item item) {

        if (item.getWeight() <= weight) {

            items.add(item);
        }

    }

}
