package entity3;

public class XeTai extends Car {
    private double trongTai;

    // Constructor
    public XeTai(String ID, String hangSanXuat, int namSanXuat, double giaBan, String mauXe, double trongTai) {
        super(ID, hangSanXuat, namSanXuat, giaBan, mauXe);
        this.trongTai = trongTai;
    }

    public double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(double trongTai) {
        this.trongTai = trongTai;
    }
}
