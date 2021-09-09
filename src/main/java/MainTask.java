import static com.epam.company.maintask.HelloUser.setUserConsole;
import static com.epam.company.maintask.NumberMonthValue.setNumberMonthValue;
import static com.epam.company.maintask.RandomNumbers.setRandomNumber;
import static com.epam.company.maintask.ReverseDate.setReverseDateConsole;
import static com.epam.company.maintask.SumProductOfNumbers.setNumbersOfSumProduct;

public class MainTask {
    public static void main(String[] args) throws IllegalAccessException {
        setUserConsole();
        setReverseDateConsole();
        setNumbersOfSumProduct();
        setNumberMonthValue();
        setRandomNumber();
    }
}
