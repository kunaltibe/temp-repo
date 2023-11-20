

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.Main;

import MarketingManagement.MarketingPersonDirectory;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
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
class PopulateModel_UI {
    
    
    
    public static Business populate(Business business) {
        Business b = business;
        String filePath = "/Users/sangram/Desktop/AED/Assignment_4/populateModel.json";
        
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try{
             JsonNode jsonNode = objectMapper.readTree(new File(filePath));
            
            if (jsonNode.isArray()) {
                int i = 0;
                for (JsonNode customerNode : jsonNode){
                    
                    
                    String customer = customerNode.get("Customer").asText();
                    String salesPerson = customerNode.get("SalesPerson").asText();
                    String supplier = customerNode.get("Supplier").asText();
                    String market = customerNode.get("Market").asText();
                    String channel = customerNode.get("Channel").asText();
                    int priceVariation = customerNode.get("PriceVariation").asInt();
                    
                    if(b.getCustomerDirectory().findCustomer(customer) == null){
                        Person p = b.getPersonDirectory().newPerson(customer);
                        CustomerProfile c = business.getCustomerDirectory().newCustomerProfile(p);
                        System.out.println(c.getCustomerId());
                    }
                    else{
                        i += 1;
                        System.out.println("Customer: "+customer+" already exists "+i);
                        
                    }
                   
                    if(b.getSalesPersonDirectory().findSalesPerson(salesPerson) == null){
                        Person p = b.getPersonDirectory().newPerson(salesPerson);
                        SalesPersonProfile s = b.getSalesPersonDirectory().newSalesPersonProfile(p);
                        }
                    
                    else{
                        i += 1;
                        System.out.println("Sales Person: "+salesPerson+" already exists "+i); 
                    }
                    
                    if(b.getSupplierDirectory().findSupplier(supplier) == null){
                        SupplierDirectory suplierdirectory = business.getSupplierDirectory();
                        Supplier s = suplierdirectory.newSupplier(supplier); 
                            
                        }
                    
                    JsonNode productsNode = customerNode.path("Solution").path("Products");
                            if (productsNode.isArray()) {
                            for (JsonNode productNode : productsNode) {
                                ProductCatalog productcatalog = s.getProductCatalog();
                                
                                String productName = productNode.get("name").asText();
                                int floorPrice = productNode.get("floorPrice").asInt();
                                int ceilingPrice = productNode.get("ceilingPrice").asInt();
                                int targetPrice = productNode.get("targetPrice").asInt();
                                
                                if(productcatalog.findProduct(productName) == null){
                                Product prod = productcatalog.newProduct(
                                        productName, floorPrice, 
                                        ceilingPrice, targetPrice);

                                System.out.println("  Product: " + productName);
                                System.out.println("  Floor Price: " + floorPrice);
                                System.out.println("  Ceiling Price: " + ceilingPrice);
                                System.out.println("  Target Price: " + targetPrice);
                                System.out.println();
                                }
                    else{
                        i += 1;
                        System.out.println("Supplier: "+supplier+" already exists "+i); 
                    }
                    
                    }
                }
            }
            for()
                
            
//        catch (IOException ex) {
//            Logger.getLogger(PopulateModel_UI.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(ex);
//        }
        
        
//        return b;
    
    
}
}       catch (IOException ex) {
            Logger.getLogger(PopulateModel_UI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
}