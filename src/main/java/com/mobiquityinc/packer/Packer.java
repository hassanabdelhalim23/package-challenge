package com.mobiquityinc.packer;

import com.mobiquityinc.packer.manager.PackerChallengeManager;
import com.mobiquityinc.packer.util.ApplicationFactory;
import com.mobiquityinc.packer.util.FilePackerReader;
import com.mobiquityinc.packer.util.PackerChallengeAlgorithm;
import com.mobiquityinc.packer.util.PackerReader;

/**
 * The Class Packer.
 */
public class Packer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {

    	ApplicationFactory.initMAp();
    
    	
    	pack(args[0]);


    }
    
    
    
    
    public static void pack(String fileName){
    	
    	 final PackerChallengeAlgorithm challengeAlgorithm = (PackerChallengeAlgorithm) ApplicationFactory.map.get("challengeAlgorithm");
         final PackerReader packerReader = (PackerReader) ApplicationFactory.map.get("packerReader");

         final PackerChallengeManager challengeManager = new PackerChallengeManager(packerReader, challengeAlgorithm);
         challengeManager.getItems("D:\\data.txt");
    	
    	
    }

}
