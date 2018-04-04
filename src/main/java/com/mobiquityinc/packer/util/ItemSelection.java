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

public class ItemSelection {

    public static void main(final String []args){
        
        final double[] we = { 85.31, 14.55, 3.98, 26.24, 63.69, 76.25, 60.02, 93.18, 89.95 };
        final double[] v = { 29, 74, 16, 55, 52, 75, 74, 35, 78 };
        final Solution sol=new Solution();
        final double w = 75;
        double previousWeight = 0, previousMax = 0;
        String info = "";
        for(int i=0;i<we.length;i++){
            previousWeight=0;
            previousMax=0;
            info = "";
            for (int j = i; j < we.length; j++) {
               if(we[j]+previousWeight > w){
                   continue;
               }
               
               else{
                    info += j + ",";
                   previousMax=previousMax+v[j];
                    previousWeight = we[j];
                   if(sol.maxx<previousMax){
                       sol.maxx=previousMax;
                        sol.weight = info;
                       
                   }
                   
               }
               
               
               
           }
           
        }
        
        System.out.println(sol.maxx + "  " + sol.weight);
       
        
        
    }
    
  
    

}
