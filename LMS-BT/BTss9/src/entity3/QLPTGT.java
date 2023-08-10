package entity3;

import java.util.ArrayList;
import java.util.List;

public class QLPTGT {
    private final List<Car> dsPhuongTien;

    public QLPTGT() {
        dsPhuongTien = new ArrayList<>();
    }

    public void themPhuongTien(Car ptgt) {
        dsPhuongTien.add(ptgt);
    }

    public void hienThiThongTin() {

        for (Car ptgt : dsPhuongTien) {
            System.out.println("ID: " + ptgt.getID());
            System.out.println("Hãng sản xuất: " + ptgt.getHangSanXuat());
            System.out.println("Năm sản xuất: " + ptgt.getHangSanXuat());
            System.out.println("Giá bán: " + ptgt.getGiaBan());
            System.out.println("Màu xe: " + ptgt.getMauXe());

            if (ptgt instanceof Oto oto) {
                System.out.println("Số chỗ ngồi: " + oto.getSoChoNgoi());
                System.out.println("Kiểu động cơ: " + oto.getKieuDongCo());
            } else if (ptgt instanceof XeMay xeMay) {
                System.out.println("Công xuất: " + xeMay.getCongXuat());
            } else if (ptgt instanceof XeTai xeTai) {
                System.out.println("Trọng tải: " + xeTai.getTrongTai());
            }

            System.out.println("----------");
        }
    }

    // (thêm, sửa, xóa, tìm kiếm, v.v...)

}

class Main {
    public static void main(String[] args) {
        
    }
}

