/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retirementcalculator;

/**
 *
 * @author derekbarrera
 */
public class Year {
    
    private final int year;
    private final double preTaxAmount;
    private final double postTaxAmount;
    
    public Year(int year, double preTaxAmount, double postTaxAmount){
    
        this.year = year;
        this.preTaxAmount = preTaxAmount;
        this.postTaxAmount = postTaxAmount;
        
    }
    
    @Override
    public String toString(){
    
        return year + " " + preTaxAmount + " " + postTaxAmount + "/n";
        
    }
    
}
