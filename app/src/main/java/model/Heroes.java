package model;

public class Heroes {
    private String _id, name, desc, imageName;
    private double price;

    public Heroes(String name, String desc, String imageName, double price) {
        this.name = name;
        this.desc = desc;
        this.imageName = imageName;
        this.price = price;
    }

    public String get_id() {
        return _id;
    }

    public String getImage() {
        return imageName;
    }

    public void setImage(String imageName) {
        this.imageName = imageName;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
