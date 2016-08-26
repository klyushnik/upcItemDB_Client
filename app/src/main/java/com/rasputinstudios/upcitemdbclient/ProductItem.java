package com.rasputinstudios.upcitemdbclient;

//Every item in the list
public class ProductItem {
    private String ProductName = "";
    private String ProductDescription = "";
    private String UPC = "";
    private String EAN = "";
    private String[] ProductImages;
    private String[][][] VendorUrlPrice;



    public ProductItem(String productName, String productDescription, String UPC, String EAN, String[] productImages, String[][][] vendorUrlPrice){
        setProductName(productName);
        setProductDescription(productDescription);
        setUPC(UPC);
        setEAN(EAN);

    }

    public String getProductName() {
        if (ProductName.equals("")) return "Empty";
        return ProductName;
    }
    public void setProductName(String s){ProductName = s;}

    public String getProductDescription() {
        if (ProductDescription.equals("")) return "Empty";
        return ProductDescription;
    }
    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public String getUPC() {
        if (UPC.equals("")) return "000000000000";
        return UPC;
    }
    public void setUPC(String UPC) {
        this.UPC = UPC;
    }

    public String getEAN() {
        if (EAN.equals("")) return "0000000000000";
        return EAN;
    }
    public void setEAN(String EAN) {
        this.EAN = EAN;
    }
}
