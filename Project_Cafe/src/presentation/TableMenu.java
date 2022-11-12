package presentation;

import bussiness.entity.Table;
import bussiness.imploy.TableImp;
import confic.Notify;
import confic.Validation;

import java.util.Scanner;

public class TableMenu {
    private static TableImp tableImp = new TableImp();


    public static void TableMenu() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(Notify.MENU_TABLE);
            System.out.println(Notify.NOTI_YOUR_CHOISE);
            String pick = sc.nextLine();
            boolean checkPick = Validation.checkInterger(pick);
            if (checkPick) {
                switch (Integer.parseInt(pick)) {
                    case 1:
                        TableMenu.listTable();
                        break;
                    case 2:
                        TableMenu.creatTable(sc);
                        break;
                    case 3:
                        TableMenu.updateTable(sc);
                        break;
                    case 4:
                        TableMenu.updateStatus(sc);
                        break;
                    case 5:
                        CafeManagement.CafeManagent();
                        break;
                    default:
                        System.out.println(Notify.NOTI_PICK_1_5);
                        break;
                }

            } else {
                System.out.println(Notify.NOTI_PICK_1_5);
            }
        } while (true);
    }

    public static void listTable() {
        tableImp.displayByStatus();
    }

    public static void creatTable(Scanner sc) {
        Table table = tableImp.inputData(sc);
        boolean result = tableImp.creat(table);
        if (result) {
            System.out.println(Notify.NOTI_CREAT_SUCCESSFUL);
        } else {
        }
    }

    public static void updateTable(Scanner sc) {
        tableImp.displayByStatus();
        System.out.println(Notify.NOTI_INPUT_ID_UPDATE);
        do {
            String ID = sc.nextLine();
            if (tableImp.findByID(ID) != null) {
                boolean result = tableImp.update(tableImp.updateDetail(tableImp.findByID(ID)));
                if (result) {
                    System.out.println(Notify.NOTI_UP_DATE_SUCCESSFUL);
                    break;
                } else {
                }
            } else {
                System.out.println(Notify.NOTI_INPUT_ID);
            }
        } while (true);
    }

    public static void updateStatus(Scanner sc) {
        tableImp.displayByStatus();
        System.out.println(Notify.NOTI_INPUT_ID_UPDATE);
        do {
            String ID = sc.nextLine();
            if (tableImp.findByID(ID) != null) {
                boolean check = Validation.checkEnter(ID);
                if (!check) {
                    boolean result = tableImp.update(tableImp.updateStatus(tableImp.findByID(ID)));
                    if (result) {
                        System.out.println(Notify.NOTI_UP_DATE_SUCCESSFUL);
                        break;
                    } else {
                        System.out.println(Notify.NOTI_UP_DATE_FAIL);
                        break;
                    }
                } else {
                    System.out.println(Notify.NOTI_INPUT_ID);
                }
            } else {
                System.out.println(Notify.NOTI_INPUT_ID);
            }
        } while (true);
    }


}
