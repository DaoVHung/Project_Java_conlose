package presentation;

import bussiness.entity.User;
import bussiness.imploy.UserImp;
import confic.Notify;
import confic.Validation;
import data.DataURL;
import data.FileImp;

import java.util.List;
import java.util.Scanner;
public class Login {

    private static UserImp userImp = new UserImp();
    public static String usaname;
    public static void login(Scanner sc){
        do {
            System.out.print(" Tên đăng nhập \uD83D\uDE0D : ");
            String userName = sc.nextLine();
            usaname = userName;
            System.out.print(" Mật khẩu \uD83E\uDD14      : ");
            String password = sc.nextLine();
            User user = userImp.checkLogin(userName,password);
            if (user!=null){
                if (user.isUserStatus()){
                    int idLogin = user.getUserID();
                        CafeManagement.CafeManagent();

                        break;
                }else {
                    System.out.println(" Tài khoản đã bị blobk !");
                    break;
                }
            }else{
                System.out.print(Notify.NOTI_LOGIN_FAIL);
                do {
                    String choice =sc.nextLine();
                    boolean checkInt = Validation.checkInterger(choice);
                    if (checkInt){
                        switch (Integer.parseInt(choice)){
                            case 1:
                                login(sc);
                            return;
                            case 2:
                            return;
                            default:
                                System.out.println(Notify.NOTI_PICK_1_2);

                        }
                    }else {
                        System.out.println(Notify.NOTI_INPUT_INTERGER);
                    }
                }while (true);
            }
        }while (true);
    }
//    public static void register(Scanner sc) {
//        System.out.println("Dang ky tai khoan !");
//        User userNew = userImp.inputDataUser(sc);
//        boolean result = userImp.creat(userNew);
//        if (result) {
//            System.out.println("\n Dang ky Thanh cong !");
//        } else {
//            System.out.println("\n Dang ky that bai !");
//        }
//    }
}
