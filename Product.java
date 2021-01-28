import java.util.Comparator;

class Product{

    String pid;
    String product_name;
    String brand;
    String product_url;
    int retail_price;
    int discounted_price;
    float product_rating;

    
    public Product() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduct_url() {
        return product_url;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    public int getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(int retail_price) {
        this.retail_price = retail_price;
    }

    public int getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(int discounted_price) {
        this.discounted_price = discounted_price;
    }

    public float getProduct_rating() {
        return product_rating;
    }

    public void setProduct_rating(float product_rating) {
        this.product_rating = product_rating;
    }

    @Override
    public String toString() {
        return "pid=" + this.getPid() + ", product_name=" + this.getProduct_name() + "Product brand=" + this.getBrand() + ",  product_url=" + this.getProduct_url()+"discounted_price=" + this.getDiscounted_price() + " retail_price=" + this.getRetail_price()+" product_rating=" + this.getProduct_rating() ;
                 
    }
    
    public static Comparator<Product> priceComp = new Comparator<Product>() {

        public int compare(Product s1, Product s2) {

        int price1 = s1.getRetail_price();
        int price2 = s2.getRetail_price();

        /*For ascending order*/
        return price1-price2;

        /*For descending order*/
        //price2-price1;
    
        }
    };

    public static Comparator<Product> ratingComp = new Comparator<Product>() {

        public int compare(Product s1, Product s2) {
    
           float rating1 = s1.getProduct_rating();
           float rating2 = s2.getProduct_rating();
    
           /*For ascending order*/
           //return rating1-rating2;
    
           /*For descending order*/
           return (int) (rating2 - rating1);
       
        }
    };
}