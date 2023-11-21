/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.Business;

import MarketingManagement.MarketingPersonDirectory;
import TheBusiness.MarketModel.ChannelCatalog;
import java.util.ArrayList;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.ProductSummary;
import TheBusiness.ProductManagement.ProductsReport;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {
    
    String name;
    PersonDirectory persondirectory; //all people profiles regardless of the role
    MasterOrderList masterorderlist;
    CustomerDirectory customers;
    SupplierDirectory suppliers;
    MarketCatalog marketcatalog;
    ChannelCatalog channelcatalog;
    MarketChannelComboCatalog marketChannelComboCatalog;
    SolutionOfferCatalog solutionoffercatalog;
    CustomerDirectory customerdirectory;
    // EmployeeDirectory employeedirectory;
    SalesPersonDirectory salespersondirectory;
    UserAccountDirectory useraccountdirectory;
    MarketingPersonDirectory marketingpersondirectory;
    MasterSolutionOrderList mastersolutionorderlist;
    
    public Business(String n) {
        name = n;
        masterorderlist = new MasterOrderList();
        suppliers = new SupplierDirectory();
        persondirectory = new PersonDirectory();
        customerdirectory = new CustomerDirectory(this);
        salespersondirectory = new SalesPersonDirectory(this);
        useraccountdirectory = new UserAccountDirectory();
        marketingpersondirectory = new MarketingPersonDirectory(this);
        marketcatalog = new MarketCatalog();
        channelcatalog = new ChannelCatalog();
        
        // Channel c = channelcatalog.newChannel("tv");
        // market.addValidChannel(c);
        // c = channelcatalog.newChannel("");
        
        marketChannelComboCatalog = new MarketChannelComboCatalog();
        
        // MarketChannelAssignment mca2 = marketChannelComboCatalog.newMarketChannelCombo(market, c);
        solutionoffercatalog = new SolutionOfferCatalog();
        mastersolutionorderlist  = new MasterSolutionOrderList();
    }
    
    
    public void setMasterSolutionOrderlist(MasterSolutionOrderList mastersolutionorderlist) {    
        this.mastersolutionorderlist = mastersolutionorderlist;
    }
    
    public void setPersonDirectory(PersonDirectory persondirectory) {
        this.persondirectory = persondirectory;
    }
    
    public void setMasterOrderlist(MasterOrderList masterorderlist) {
        this.masterorderlist = masterorderlist;
    }
    
    public void setMarketCatalog(MarketCatalog marketcatalog) {
        this.marketcatalog = marketcatalog;
    }
    
    public void setSolutionOfferCatalog(SolutionOfferCatalog solutionoffercatalog) {
        this.solutionoffercatalog = solutionoffercatalog;
    }
    
    public void setCustomerDirectory(CustomerDirectory customerdirectory) {
        this.customerdirectory = customerdirectory;
    }
    
    public void setSalesPersonDirectory(SalesPersonDirectory salespersondirectory) {
        this.salespersondirectory = salespersondirectory;
    }
    
    
    public int getSalesVolume() {
        return masterorderlist.getSalesVolume();
    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }

    public MarketingPersonDirectory getMarketingPersonDirectory() {
        return marketingpersondirectory;
    }

    public SupplierDirectory getSupplierDirectory() {
        return suppliers;
    }

    public ProductsReport getSupplierPerformanceReport(String n) {
        Supplier supplier = suppliers.findSupplier(n);
        if (supplier == null) {
            return null;
        }
        return supplier.prepareProductsReport();
    }

    public ArrayList<ProductSummary> getSupplierProductsAlwaysAboveTarget(String n) {

        ProductsReport productsreport = getSupplierPerformanceReport(n);
        return productsreport.getProductsAlwaysAboveTarget();
    }

    public int getHowManySupplierProductsAlwaysAboveTarget(String n) {
        ProductsReport productsreport = getSupplierPerformanceReport(n); // see above
        int i = productsreport.getProductsAlwaysAboveTarget().size(); //return size of the arraylist
        return i;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerdirectory;
    }

    public SalesPersonDirectory getSalesPersonDirectory() {
        return salespersondirectory;
    }

    public MasterOrderList getMasterOrderList() {
        return masterorderlist;
    }

    public MarketCatalog getMarketCatalog() {
        return marketcatalog;
    }

    public ChannelCatalog getChannelCatalog() {
        return channelcatalog;
    }
    public SolutionOfferCatalog getSolutionOfferCatalog(){
        return solutionoffercatalog;
    }
    public MarketChannelComboCatalog getMarketChannelComboCatalog() {

        return marketChannelComboCatalog;
    }
    public MasterSolutionOrderList getMasterSolutionOrderList(){
        return mastersolutionorderlist;
    }
    
    
    @Override
    public String toString() {
        return "Business{" + "name=" + name + ", persondirectory=" + persondirectory + ", masterorderlist=" + masterorderlist + ", customers=" + customers + ", suppliers=" + suppliers + ", marketcatalog=" + marketcatalog + ", channelcatalog=" + channelcatalog + ", marketChannelComboCatalog=" + marketChannelComboCatalog + ", solutionoffercatalog=" + solutionoffercatalog + ", customerdirectory=" + customerdirectory + ", salespersondirectory=" + salespersondirectory + ", useraccountdirectory=" + useraccountdirectory + ", marketingpersondirectory=" + marketingpersondirectory + ", mastersolutionorderlist=" + mastersolutionorderlist + '}';
    }
    /* */
    
    //     public EmployeeDirectory getEmployeeDirectory() {
    //     return employeedirectory;
    //  }
    
}
