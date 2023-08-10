package entity3;

public class XeMay extends Car {
    private double congXuat;

    // Constructor
    public XeMay(String ID, String hangSanXuat, int namSanXuat, double giaBan, String mauXe, double congXuat) {
        super(ID, hangSanXuat, namSanXuat, giaBan, mauXe);
        this.congXuat = congXuat;
    }

    public double getCongXuat() {
        return congXuat;
    }

    public void setCongXuat(double congXuat) {
        this.congXuat = congXuat;
    }
}
