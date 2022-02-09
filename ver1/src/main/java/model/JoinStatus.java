package model;

public class JoinStatus {
    private String status;
    private int quantity;

    public JoinStatus(String status, int quantity) {
        this.status = status;
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
