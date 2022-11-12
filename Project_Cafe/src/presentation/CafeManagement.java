package presentation;

import confic.Notify;
import confic.Validation;

import java.util.Scanner;

public class CafeManagement {
    public static void CafeManagent() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(Notify.MENU_CAFEMANAGE);
            System.out.print(Notify.NOTI_YOUR_CHOISE);
            String pick = sc.nextLine();
            boolean checkPick = Validation.checkInterger(pick);
            if (checkPick) {
                switch (Integer.parseInt(pick)) {
                    case 1:
                        CatalogMenu.CatalogMenu();
                        break;
                    case 2:
                        ProductMenu.ProductMenu();
                        break;
                    case 3:
                        TableMenu.TableMenu();
                        break;
                    case 4:
                        AdminMenu.UserMenu();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println(Notify.NOTI_PICK_1_5);
                }
            } else {
                System.out.println(Notify.NOTI_PICK_1_5);
            }
        } while (true);
    }
}
