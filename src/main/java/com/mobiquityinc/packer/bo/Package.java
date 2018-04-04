
package com.mobiquityinc.packer.bo;

import java.util.List;

/**
 * The Class Package.
 * 
 * 
 */
public class Package {

    /** The weight. */
    private Double weight;

    /** The items. */
    private List<Item> items;

    /**
     * Gets the weight.
     *
     * @return the weight
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Sets the weight.
     *
     * @param weight the new weight
     */
    public void setWeight(final Double weight) {
        this.weight = weight;
    }

    /**
     * Gets the items.
     *
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets the items.
     *
     * @param items the new items
     */
    public void setItems(final List<Item> items) {
        this.items = items;
    }

}
