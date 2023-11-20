package TheBusiness;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import MarketingManagement.MarketingPersonDirectory;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.MarketModel.ChannelCatalog;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductSummary;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sangram
 */
public class PopulateModel {
    
    
    
    static Business populateModel(Business business) {
        Business b = business;
        String filePath = "/Users/sangram/Desktop/AED/Assignment_4/populateModel.json";
        String customer;
        String salesPerson;
        
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try{
             JsonNode jsonArrayNode = objectMapper.readTree(new File(filePath));
            
            if (jsonArrayNode.isArray()) {
                Iterator<JsonNode> elements = jsonArrayNode.elements();
                while (elements.hasNext()) {
                    JsonNode jsonNode = elements.next();
                    
                    customer = jsonNode.get("Customer").asText();
                    if(b.getCustomerDirectory().findCustomer(customer) == null){
                        Person p = b.getPersonDirectory().newPerson(customer);
                        CustomerProfile c = b.getCustomerDirectory().newCustomerProfile(p);
                        System.out.println(c.getCustomerId());
                    }
                   
                    salesPerson = jsonNode.get("SalesPerson").asText();
                    if(b.getSalesPersonDirectory().findSalesPerson(salesPerson) == null){
                        Person p = b.getPersonDirectory().newPerson(salesPerson);
                        SalesPersonProfile s = b.getSalesPersonDirectory().newSalesPersonProfile(p);
                        
                    }
                  
                }
            }
             }
        catch (IOException ex) {
            Logger.getLogger(PopulateModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return b;
    
    
}
}
