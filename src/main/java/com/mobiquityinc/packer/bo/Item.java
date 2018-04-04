
package com.mobiquityinc.packer.bo;

/**
 * The Class Item. represent the properties related to item  will be read from the file
 */
public class Item  implements  Comparable<Item> {

    /** The index. */
    private Integer index;

    /** The weight. */
    private Double weight;

    /** The cost. */
    private Double cost;

    /**
     * Gets the index.
     *
     * @return the index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * Sets the index.
     *
     * @param index the new index
     */
    public void setIndex(final Integer index) {
        this.index = index;
    }

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
     * Gets the cost.
     *
     * @return the cost
     */
    public Double getCost() {
        return cost;
    }

    /**
     * Sets the cost.
     *
     * @param cost the new cost
     */
    public void setCost(final Double cost) {
        this.cost = cost;
    }

	@Override
	public int compareTo(Item o) {
		return (int) (this.getWeight() - o.getWeight());
	
	}

}
