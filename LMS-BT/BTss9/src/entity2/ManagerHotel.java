package entity2;

import java.util.*;

public class ManagerHotel {
    private final List<Customer> customerList;
    private final List<Room> rooms;

    public ManagerHotel() {
        customerList = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    //  thêm phòng
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void removeCustomer(String idNumber) {
        for (Customer item : customerList) {
            if (item.getIdNumber().equals(idNumber)) {
                customerList.remove(item);
                break;
            }
        }
    }

    // tính số tiền thuê nhà
    public double calculateRent(Customer idNumber, int numDays) {
        for (Customer item : customerList) {
            if (item.getIdNumber().equals(idNumber)) {
                double price = 0;
                for (Room room : rooms) {
                    if (room.getType().equals("A")) {
                        price += room.getPrice() * numDays;
                    }
                    if (room.getType().equals("B")) {
                        price += room.getPrice() * numDays;
                    }
                    if (room.getType().equals("C")) {
                        price += room.getPrice() * numDays;
                    }
                }
                return price;
            }
        }
        return 0;
    }

    public Customer getCustomerById(String idNumber) {
        for (Customer item : customerList) {
            if (item.getIdNumber().equals(idNumber))
                return item;
        }
        return null;
    }
}

