public class ShoppingCartController {
    public List<PurchaseOrderLine__c> productsInCart {get;set;}
    public Set<ID> productIdsInCart {get;set;} 
    public String selectedProductId {get;set;}
    public PurchaseOrder__c order {get;set;}
    public Date deliveryDate {get;set;}
    public boolean productsPopUp {get;set;}
    public boolean purchaseOrderLineItemsdisplayPopUp {get; set;}  
    public boolean cartDisplayPopUp {get; set;}  
    public boolean purchaseOrderdisplayPopUp {get; set;} 
    public boolean productsDisplayPopUp {get; set;} 
    public Boolean categoryDisplayPopUp {get;set;}
    public boolean noRecordMessagePopUp{get; set;} 
    public boolean personalInfoDisplayPopUp {get; set;}  
    public String selectedCategory {get;set;}
    public ApexPages.StandardSetController productSetController {get; set;}
    public String query;
    public Integer totalPages {get;set;}
    Decimal dtotalPages;
    Integer recordsPerPage = 5;   
    //list of products
    public List<Product1__c> Products {
        get{
            return (List<Product1__c>) productSetController.getRecords();
        }set;
    }   
    //Controller
    public ShoppingCartController(){
        productsPopUp = true;
        cartDisplayPopUp = true;
        purchaseOrderLineItemsdisplayPopUp = false;
        personalInfoDisplayPopUp = false;
        purchaseOrderdisplayPopUp = false;
        categoryDisplayPopUp = true;
        order = new PurchaseOrder__c();
        productsInCart = new List<PurchaseOrderLine__c>();
        productIdsInCart = new Set<ID>();
        selectedCategory = 'All';
        retrieveProducts(); 
    }
    //To get list all available categories
    public List<SelectOption> getCategories() {
        List<SelectOption> options = new List<SelectOption>();
        options.add(new SelectOption('All','All'));
        options.add(new SelectOption('Electronics','Electronics'));
        options.add(new SelectOption('Clothing','Clothing'));
        options.add(new SelectOption('Home Appliances','Home Appliances'));
        options.add(new SelectOption('Others','Others'));
        return options;
    }
    //To search products by on the basis of selected category
    public void searchByCategory() {
        retrieveProducts();
    }
    //To retrive products (all or on the basis of category)
    public void retrieveProducts(){
        query = 'SELECT id,Name,Category__c,UnitPrice__c FROM Product1__c ';
        if(selectedCategory!=null && selectedCategory != '' && selectedCategory != 'All'){
            query += 'where Category__c=\''+selectedCategory+'\'';
        }
        productSetController = new ApexPages.StandardSetController(Database.getQueryLocator(query));
        productSetController.setPageSize(recordsPerPage);
        dtotalPages = (productSetController.getResultSize() / productSetController.getPageSize());
        dtotalPages = dtotalPages + ((Math.mod(productSetController.getResultSize(), recordsPerPage)>0) ? 1 : 0);
        totalPages = Integer.valueOf(dtotalPages);
    }
    //To add selected product in cart
    public void addToCart(){
        purchaseOrderLineItemsdisplayPopUp = true;
        if(productIdsInCart.contains(selectedProductId)){
            for(PurchaseOrderLine__c product : productsInCart){
                if(product.Product__c == selectedProductId){
                    product.Quantity__c = ++product.Quantity__c;
                }
            }   
        }
       else{
            System.debug(selectedProductId);
            Product1__c productToPurchase = [Select id,Name,UnitPrice__c from Product1__c where id=:selectedProductId];
            PurchaseOrderLine__c lineItem = new PurchaseOrderLine__c();
            lineItem.Name = productToPurchase.Name;
            lineItem.Product__c = productToPurchase.id;
            lineItem.Quantity__c = 1;
            lineItem.UnitPrice__c = productToPurchase.UnitPrice__C;
            insert lineItem;
            ID lineItemId = lineItem.id;
            PurchaseOrderLine__c newProduct = [Select Name,Product__c,Quantity__c,UnitPrice__c,TotalPrice__c from PurchaseOrderLine__c where id=:lineItemId];
            productsInCart.add(newProduct);
            productIdsInCart.add(newProduct.Product__c);
        }
    }    
    //To remove product from cart
    public Void removeFromCart(){
        PurchaseOrderLine__c productToRemove = [Select Name__c,Quantity__c,UnitPrice__c,TotalPrice__c from PurchaseOrderLine__c where id=:selectedProductId];
        Integer index = 0;
        for(PurchaseOrderLine__c product : productsInCart){
            if(product.Id == productToRemove.Id){
                break;
            }
            index++;
        }
        productsInCart.remove(index);
        if(productsInCart.size() > 0){
            purchaseOrderLineItemsdisplayPopUp = true;
        }
        else{
            purchaseOrderLineItemsdisplayPopUp = false;
        }
        Delete productToRemove;
    }
    //To proceed for payment
    public void proceedToPay(){  
        Decimal totalPrice = 0;
        for(PurchaseOrderLine__c purchaseOrder : productsInCart){
            totalPrice += (purchaseOrder.UnitPrice__c * purchaseOrder.Quantity__c);
        }
        order.TotalPrice__c = totalPrice;
        productsPopUp = false;
        cartDisplayPopUp = false;
        personalInfoDisplayPopUp = true;
        purchaseOrderLineItemsdisplayPopUp = false;
        categoryDisplayPopUp = false;
        totalPages = 0;
    }
    //To create order and provide info of delievery of product to user
    public void pay(){
        insert order;
        Id orderId = order.Id;
        for(PurchaseOrderLine__c purchaseOrder : productsInCart){
            purchaseOrder.PurchaseOrder__c = orderId;
        }
        Update productsInCart;
        deliveryDate = (Date.today()).addDays(9);
        personalInfoDisplayPopUp  = false;
        purchaseOrderdisplayPopUp = true;
    }
}