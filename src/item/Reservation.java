package item;

public class Reservation {
    private String custName;
    private int resvType; // 1 for flight, 2 for hotel, 3 for bus
    private String resvKey;

    public Reservation(String custName, int resvType, String resvKey) {
        this.custName = custName;
        this.resvType = resvType;
        this.resvKey = resvKey;
    }
    public Reservation() {
        this.custName = null;
        this.resvType = 0;
        this.resvKey = null;
    }
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getResvType() {
        return resvType;
    }

    public void setResvType(int resvType) {
        this.resvType = resvType;
    }

    public String getResvKey() {
        return resvKey;
    }

    public void setResvKey(String resvKey) {
        this.resvKey = resvKey;
    }
}
