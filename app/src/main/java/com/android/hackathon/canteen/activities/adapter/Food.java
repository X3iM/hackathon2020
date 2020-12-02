package com.android.hackathon.canteen.activities.adapter;

public class Food {
    private String Name;
    private String Category;
    private String Description;
    private double Price;
    private int Thumbnail;



    public Food(String name, String category, String description,double price,int thumbnail) {
        Name = name;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
        Price = price;
    }

    public Food(){

    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return "€"+Double.toString(Price);
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
