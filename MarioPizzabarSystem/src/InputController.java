import java.util.Scanner;

public class InputController {

    private static final Scanner scanner = new Scanner(System.in);

    private static final int MINIMUM_MENU_CHOICE = 1;
    private static final int MAXIMUM_MENU_CHOICE = 8;
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
            if (maybeOrderId >= MINIMUM_ORDER_ID &&
                maybeOrderId <= Order.getOrderCounter()) {
                // Gyldigt ordre-id.
                return maybeOrderId;
            }
        }
    }

    public static String getFileName(){
        Scanner sc = new Scanner(System.in);
        String fileName;
        while (true) {
            fileName = sc.nextLine();
            if (isNotIllegal(fileName)){
                return "MarioPizzabarSystem/OrderListSaves/" + fileName + ".csv";
            }
            System.out.println("Filnavnet indeholder et ugyldigt symbol:  \\/<>:\"|?*\nprøv igen:");
        }
    }
    private static boolean isNotIllegal(String input){
        String illegalChars ="<>:\"/\\|?*";
        for (int i = 0; i<input.length(); i++){
            for (int j = 0; j<illegalChars.length(); j++){
                if (input.charAt(i) == illegalChars.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
