import java.util.*;

public class Order {
    private static int nextId = 1;
    private int id;
    private List<MenuItem> items;
    private String status;
    private boolean isVIP;
    private String specialRequest;

    public Order(List<MenuItem> items, boolean isVIP) {
        this.id = nextId++;
        this.items = items;
        this.isVIP = isVIP;
        this.status = "Received";
        this.specialRequest = "";
    }

    public void denyIfContains(String itemName) {
        for (MenuItem item : items) {
            if (item.getName().equals(itemName)) {
                this.status = "Denied";
                break;
            }
        }
    }

    public String getStatus(){return this.status;}
    public Integer getId(){return this.id;}
    public List<MenuItem> getItems(){return this.items;}
    public boolean getisVIP(){return this.isVIP;}

    public void setStatus(String status1) {
        this.status = status1;
    }
    public void setSpecialRequest(String request){
        this.specialRequest = request;
    }

    @Override
    public String toString() {
        return "Order " + id + ": " + status + (isVIP ? " (VIP)" : "");
    }

    public Double costOfOrder(){
        Double cost = (double) 0;
        for (MenuItem item : items){
            cost += item.getPrice();
        }
        return cost;
    }

    public void orderDetails(){
        for (MenuItem items : items){
            System.out.print(items.getName() + ", ");
        }
        System.out.println();
    }
}
