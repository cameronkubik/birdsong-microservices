package microservice;

import com.fasterxml.jackson.annotation.JsonGetter;

public class ConcessionItem {

    private final int itemId;
    private final int categoryId;
    private final String item;
    private final String cost;
    private final String price;
    private final String discount;
    private final String imageUri;                      


    public ConcessionItem(int _itemId, int _categoryId, String _item, String _cost, String _price, String _discount, String _imageUri) {
        itemId = _itemId;
        categoryId = _categoryId;
        item = _item;
        cost = _cost;
        price = _price;
        discount = _discount;
        imageUri = _imageUri;
    }

    @JsonGetter("itemId")
    public int itemId() {
        return itemId;
    }
    @JsonGetter("categoryId")
    public int categoryId() {
        return categoryId;
    }
    @JsonGetter("item")
    public String getItem() {
        return item;
    }
    @JsonGetter("cost")
    public String getCost() {
        return cost;
    }
    @JsonGetter("price")
    public String getPrice() {
        return price;
    }
    @JsonGetter("discount")
    public String getDiscount() {
        return discount;
    }
    @JsonGetter("imageUri")
    public String getImageUri() {
        return imageUri;
    }
}