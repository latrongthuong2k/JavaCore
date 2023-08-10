package ra;
import java.util.Scanner;
public interface IStudent {
    int MARK_PASS = 5;

    void inputData(Scanner scanner);
    void displayData();
    float calAvgMark();
}
