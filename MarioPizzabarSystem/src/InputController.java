import java.util.Scanner;

public class InputController {

    private static final Scanner scanner = new Scanner(System.in);

    private static final int MINIMUM_MENU_CHOICE = 1;
    private static final int MAXIMUM_MENU_CHOICE = 7;
    private static final int MINIMUM_ORDER_ID = 1;

    public static int getMenuChoice() {
        return getMenuChoice(MINIMUM_MENU_CHOICE, MAXIMUM_MENU_CHOICE);
    }

    public static int getMenuChoice(int minChoice, int maxChoice) {

        while (true) {
            // Vi bruger "maybeMenuChoice", da ugyldige tal kan forekomme.
            int maybeMenuChoice = scanner.nextInt();
            if (maybeMenuChoice >= minChoice && maybeMenuChoice <= maxChoice) {
                // Gyldigt menu valg.
                return maybeMenuChoice;
            }
        }
    }

    public static int getOrderId() {

        while (true) {
            // Vi bruger "maybeOrderId", da ugyldige ordrer ID'er kan forekomme.
            int maybeOrderId = scanner.nextInt();
            if (maybeOrderId > MINIMUM_ORDER_ID &&
                maybeOrderId < OrderList.getTheOrderList().size()) {
                // Gyldigt ordre-id.
                return maybeOrderId;
            }
        }

    }
}
