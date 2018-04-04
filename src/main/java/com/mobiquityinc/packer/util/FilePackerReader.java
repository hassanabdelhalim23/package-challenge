
package com.mobiquityinc.packer.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mobiquityinc.packer.bo.Item;
import com.mobiquityinc.packer.bo.Package;
import com.mobiquityinc.packer.exception.ApiException;
import com.mobiquityinc.packer.validation.Validator;

/**
 * The Class FilePackerReader. an implmention of {@link PackerReader}
 */
public class FilePackerReader implements PackerReader {

  
	
	/* (non-Javadoc)
     * @see com.mobiquityinc.packer.util.PackerReader#collectPackagesFromFile(java.lang.String)
     */
    @Override
    public List<Package> collectPackagesFromFile(final String fileName) {

        final Validator<Item> itemValidator = (Validator<Item>) ApplicationFactory.map.get("itemValidator");
        final Validator<Package> weightValidator = (Validator<Package>) ApplicationFactory.map.get("weightValidator");

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

    /**
     * Validate item.
     *
     * @param weight the weight
     * @param items the items
     * @param item the item
     */
    public void validateItem(final Double weight, final List<Item> items, final Item item) {

        if (item.getWeight() <= weight) {

            items.add(item);
        }

    }

}
