package presentation;

import bussiness.entity.Catalog;
import bussiness.imploy.CatalogImp;
import confic.Notify;
import confic.Validation;

import java.util.Scanner;

public class CatalogMenu {
    private static CatalogImp catImp = new CatalogImp();
    public static void CatalogMenu() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(Notify.MENU_CATALOG);
            System.out.print(Notify.NOTI_YOUR_CHOISE);
            String pick = sc.nextLine();
            boolean checkPick = Validation.checkInterger(pick);
            if (checkPick) {
                switch (Integer.parseInt(pick)) {
                    case 1:
                        CatalogMenu.listCatalog();
                        break;
                    case 2:
                        CatalogMenu.creatCatalog(sc);

                        break;
                    case 3:
                        CatalogMenu.updateCatalog(sc);

                        break;
                    case 4:
                        CatalogMenu.searchCatalog(sc);
                        break;
                    case 5:
                        CafeManagement.CafeManagent();
                    default:
                        System.out.println(Notify.NOTI_PICK_1_5);
                        break;
                }
            } else {
                System.out.println(Notify.NOTI_PICK_1_5);
            }
        } while (true);
    }
    public static void listCatalog() {
        catImp.displayByPriority();
    }
    public static void creatCatalog(Scanner sc) {
        System.out.println("    Tạo danh mục ");
        Catalog catalogNew = catImp.inputData(sc);
        boolean result = catImp.creat(catalogNew);
    }
    public static void updateCatalog(Scanner sc) {
        catImp.displayByPriority();
        System.out.print(" Nhập ID danh mục muốn cập nhật : ");
        do {
            String Cata = sc.nextLine();
            boolean checkInt = Validation.checkInterger(Cata);
            if (checkInt) {
                if (catImp.findByID(Integer.parseInt(Cata)) != null) {
                    int ID = Integer.parseInt(Cata);
                    boolean result = catImp.update(catImp.updateDetail(catImp.findByID(ID)));
                    if (result) {
                        System.out.println(Notify.NOTI_UP_DATE_SUCCESSFUL);
                    }
                    break;
                } else {
                    System.out.println(Notify.NOTI_INPUT_ID);
                }
            } else {
                System.out.println(Notify.NOTI_INPUT_INTERGER);
            }
        } while (true);
    }
    public static void searchCatalog(Scanner sc) {
        System.out.print(" Nhập tên danh mục muốn tìm kiếm : ");
        do {
            String search = sc.nextLine();
            boolean checakSearch = Validation.checkEnter(search);
            if (!checakSearch) {
                if (!catImp.findByCatalogName(search).isEmpty()) {
                    System.out.println(Notify.NOTI_DISPLAY_CATALOG);
                    for (Catalog cat : catImp.findByCatalogName(search)) {
                        String status = " Khong hoat dong ";
                        if (cat.isCatalogStatus()){
                            status = " Hoat dong ";
                        }
                        System.out.printf(Notify.FONT_CATALOG,
                                cat.getCatalogID(), cat.getCatalogName(), cat.getPriority(), status);
                        System.out.println(Notify.POINT_CATALOG);
                    }
                    System.out.println(Notify.POINT_CATALOG_END);
                } else {
                    System.out.println(Notify.NOTI_UNKNOW_DATA);
                }
                break;
            } else {
                System.out.println(Notify.NOTI_UNKNOW_DATA);
                break;
            }
        } while (true);
    }
}
