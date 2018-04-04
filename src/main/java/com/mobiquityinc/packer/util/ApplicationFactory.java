package com.mobiquityinc.packer.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApplicationFactory {
	
	
  public static Map<String, Object> map=new LinkedHashMap<>();
	
	
	public static void initMAp(){
		map.put("packerReader", new FilePackerReader());		
		map.put("challengeAlgorithm", new PackerChallengeAlgorithm());

	
	}
	
}
