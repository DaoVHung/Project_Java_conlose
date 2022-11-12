package presentation;

import bussiness.entity.User;
import bussiness.imploy.UserImp;
import confic.Notify;
import confic.Validation;

import java.time.LocalDate;
import java.util.Scanner;

public class CafeRun {
    private static UserImp userImp = new UserImp();



    public static void main(String[] args) {
//        User admin = new User("123", "123123", "123123", "Dao Van Hung", LocalDate.now(),
//                true,true, "daohung@gmail.com", "8412345678");
//        boolean user = userImp.creat(admin);



        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(Notify.RUN);
            System.out.print(Notify.NOTI_YOUR_CHOISE);
            String pick = sc.nextLine();
            boolean checkPick = Validation.checkInterger(pick);
            if (checkPick) {
                switch (Integer.parseInt(pick)) {
                    case 1:
                        Login.login(sc);
                        break;
                    case 3:
//                        Login.register(sc);
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println(Notify.NOTI_PICK_1_2);
                }
            } else {
                System.out.println(Notify.NOTI_PICK_1_2);
            }
        } while (true);
    }
}
