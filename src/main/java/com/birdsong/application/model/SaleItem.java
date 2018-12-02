package com.birdsong.application.model;

public class SaleItem {

    private final int itemId;
    private final int categoryId;
    private final String item;
    private final String cost;
    private final String price;
    private final String discount;
    private final String imageUri;

    public SaleItem(int _itemId, int _categoryId, String _item, String _cost, String _price, String _discount, String _imageUri) {
        itemId = _itemId;
        categoryId = _categoryId;
        item = _item;
        cost = _cost;
        price = _price;
        discount = _discount;
        imageUri = _imageUri;
    }

    public int itemId() {
        return itemId;
    }

    public int categoryId() {
        return categoryId;
    }

    public String getItem() {
        return item;
    }

    public String getCost() {
        return cost;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getImageUri() {
        return imageUri;
    }
}