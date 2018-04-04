package com.mobiquityinc.packer.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.mobiquityinc.packer.validation.ItemValidator;
import com.mobiquityinc.packer.validation.WeightValidator;

/**
 * A factory for creating Application objects.  this class is responsible for creating an object debend on name(like spring by name) my idea is make the code loosely coupled 
 */
public class ApplicationFactory {
	
	
  /** The map. */
  public static Map<String, Object> map=new LinkedHashMap<>();
	
	
	/**
	 * Inits the M ap.
	 */
	public static void initMAp(){
		map.put("packerReader", new FilePackerReader());		
		map.put("challengeAlgorithm", new PackerChallengeAlgorithm());
		map.put("weightValidator", new WeightValidator());
		map.put("itemValidator", new ItemValidator());
	

	}
	
}
