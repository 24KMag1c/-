package item;

public class Customer {
    private String custName;
    private String custID;

    public Customer(String custName, String custID) {
        this.custName = custName;
        this.custID = custID;
    }
    public Customer() {
        this.custName = null;
        this.custID = null;
    }
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }
}

