package com.mobiquityinc;

import java.net.URISyntaxException;

import com.mobiquityinc.packer.exception.ApiException;
import com.mobiquityinc.packer.manager.PackerChallengeManager;
import com.mobiquityinc.packer.util.ApplicationFactory;
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
     * @throws URISyntaxException 
     */
    public static void main(final String[] args) throws URISyntaxException {
    	ApplicationFactory.initMAp();
    	
    	if(args.length==0){
    		throw new ApiException("no argument passed to command line");
    	}
    	pack(args[0]);


    }
    
    
    public static void pack(String fileName) throws URISyntaxException{
    	
    	 final PackerChallengeAlgorithm challengeAlgorithm = (PackerChallengeAlgorithm) ApplicationFactory.map.get("challengeAlgorithm");
         final PackerReader packerReader = (PackerReader) ApplicationFactory.map.get("packerReader");
         final PackerChallengeManager challengeManager = new PackerChallengeManager(packerReader, challengeAlgorithm);
         challengeManager.process(fileName);
    	
    	
    }

}
