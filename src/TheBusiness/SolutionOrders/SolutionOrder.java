/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SolutionOrders;

import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.SolutionOffer;

/**
 *
 * @author kal bugrara
 */

public class SolutionOrder {
    
    private String solutionOrderName;
    SolutionOffer selectedsolutionoffer;
    // CustomerProfile customerprofile;
    MarketChannelAssignment marketChannelAssignment;
    
   
    public SolutionOrder(String solutionOrderName, SolutionOffer selectedsolutionoffer, MarketChannelAssignment marketChannelAssignment) {
        this.solutionOrderName = solutionOrderName;
        this.selectedsolutionoffer = selectedsolutionoffer;
        this.marketChannelAssignment = marketChannelAssignment;
    }
    
    public SolutionOrder(String solutionOrderName, SolutionOffer selectedsolutionoffer) {
        this.solutionOrderName = solutionOrderName;
        this.selectedsolutionoffer = selectedsolutionoffer;
    }
    
    public String getSolutionOrderName() {
        return solutionOrderName;
    }
    /* */
    
    public SolutionOrder(SolutionOffer so,  MarketChannelAssignment mca){
        selectedsolutionoffer = so;
        marketChannelAssignment = mca;
    }
    
    
    public boolean isSolutionOfferPriceGreaterThanProductsTargetPrice() {
        return this.selectedsolutionoffer.isGreaterThanTargerPriceOfProducts();
    }
    
    public String getMarketName() {
        return this.selectedsolutionoffer.getMarketchannelcomb().getMarket().getName();
    }
    
    
    public int getSolutionPrice(){
        return selectedsolutionoffer.getSolutionPrice();
    }
    
    public MarketChannelAssignment getMarketChannelCombo(){   
        return marketChannelAssignment;
    }
    
    
    @Override
    public String toString() {
        return "SolutionOrder{" + "solutionOrderName=" + solutionOrderName + ", selectedsolutionoffer=" + selectedsolutionoffer + ", marketChannelAssignment=" + marketChannelAssignment + '}';
    }
    
    
}
