
package com.mobiquityinc.packer.manager;

import java.util.List;

import com.mobiquityinc.packer.bo.Package;
import com.mobiquityinc.packer.util.PackerChallengeAlgorithm;
import com.mobiquityinc.packer.util.PackerReader;

/**
 * The Class PackerChallengeManager. manages the procces from (getting the information from file according to it's type currently we support read from text file) and process this using algorthime
 */
public class PackerChallengeManager {

    /** The packer reader. */
    private PackerReader packerReader;

    /** The packer challenge algorithm. */
    private PackerChallengeAlgorithm packerChallengeAlgorithm;

    /**
     * Instantiates a new packer challenge manager.
     *
     * @param packerReader the packer reader
     * @param challengeAlgorithm the challenge algorithm
     */
    public PackerChallengeManager(final PackerReader packerReader, final PackerChallengeAlgorithm challengeAlgorithm) {
        this.packerReader = packerReader;
        this.packerChallengeAlgorithm = challengeAlgorithm;

    }

    /**
     * Gets the items.
     *
     * @return the items
     */
    public void getItems(String fileName){
        final List<Package> packages = this.packerReader.collectPackagesFromFile(fileName);
        packages.stream().forEach(pkg -> this.packerChallengeAlgorithm.knapSack(pkg.getWeight(), pkg.getItems()));
        
    }

    /**
     * Gets the packer reader.
     *
     * @return the packer reader
     */
    public PackerReader getPackerReader() {
        return packerReader;
    }

    /**
     * Sets the packer reader.
     *
     * @param packerReader the new packer reader
     */
    public void setPackerReader(final PackerReader packerReader) {
        this.packerReader = packerReader;
    }

    /**
     * Gets the packer challenge algorithm.
     *
     * @return the packer challenge algorithm
     */
    public PackerChallengeAlgorithm getPackerChallengeAlgorithm() {
        return packerChallengeAlgorithm;
    }

    /**
     * Sets the packer challenge algorithm.
     *
     * @param packerChallengeAlgorithm the new packer challenge algorithm
     */
    public void setPackerChallengeAlgorithm(final PackerChallengeAlgorithm packerChallengeAlgorithm) {
        this.packerChallengeAlgorithm = packerChallengeAlgorithm;

    }
}
