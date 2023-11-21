/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SolutionOrders.SolutionOrder;

/**
 *
 * @author kal bugrara
 */

public class SolutionOffer {
    
    ArrayList<Product> products;
    /* Added for Dashboard */
    int actualPrice; //floor, ceiling, and target ideas
    int floorPrice;
    int ceilingPrice;
    int targetPrice;
    
    String ad;
    MarketChannelAssignment marketchannelcomb;
    ArrayList<SolutionOrder> solutionorders;
    
    
    public SolutionOffer(String marketName, int actualPrice, int floorPrice, int ceilingPrice, int targetPrice) {
        products = new ArrayList();
        solutionorders = new ArrayList();
        MarketChannelAssignment mca = new MarketChannelAssignment(marketName);
        marketchannelcomb = mca;
        this.actualPrice = actualPrice;
        this.floorPrice = floorPrice;
        this.ceilingPrice = ceilingPrice;
        this.targetPrice = targetPrice;
    }

    public MarketChannelAssignment getMarketchannelcomb() {
        return marketchannelcomb;
    }
    
    
    public SolutionOffer(MarketChannelAssignment m){
        marketchannelcomb = m;
        products = new ArrayList();
        solutionorders = new ArrayList();
        m.addSolutionOffer(this); 
    } 
    
    
    public boolean isGreaterThanTargerPriceOfProducts() {
        int sumProductTargetPrice = 0;
        for(Product p : this.products) {
            sumProductTargetPrice = sumProductTargetPrice + p.getTargetPrice();
        }
        if((this.actualPrice - sumProductTargetPrice) > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public void addProduct(Product p){
        products.add(p);
    }
    
    public void setTotalPrice(int p){
        actualPrice = p;    
    }
    
    public int getSolutionPrice(){
        return actualPrice;
    }
    
    public int getRevenues(){
        int sum = 0;
        for(SolutionOrder so: solutionorders){
            sum = sum + so.getSolutionPrice();
        }
        return sum;
    }
    
    public void addSolutionOrder(SolutionOrder so){
        solutionorders.add(so);
    }
    
    // this will allow one to retrieve all offers meant for this market/channel combo
    public boolean isSolutionOfferMatchMarketChannel(MarketChannelAssignment mca){    
        if (marketchannelcomb==mca) return true;
        else return false;
    }
    
    public String getAd(){
        return ad;
    }
    
    public void setAd(String a){ //this an amazing solution for people like
        ad = a;
    }
    
    
    @Override
    public String toString() {
        return "SolutionOffer{" + "products=" + products + ", actualPrice=" + actualPrice + ", floorPrice=" + floorPrice + ", ceilingPrice=" + ceilingPrice + ", targetPrice=" + targetPrice + ", ad=" + ad + ", marketchannelcomb=" + marketchannelcomb + '}';
    }
    
    
}
