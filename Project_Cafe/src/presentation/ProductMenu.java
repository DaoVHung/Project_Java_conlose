package presentation;
import bussiness.entity.Product;
import bussiness.imploy.ProductImp;
import confic.Notify;
import confic.Validation;
import java.util.Scanner;
public class ProductMenu {
    private static ProductImp productImp = new ProductImp();
    public static void ProductMenu() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(Notify.MENU_PRODUCT);
            System.out.print(Notify.NOTI_YOUR_CHOISE);
            String pick = sc.nextLine();
            boolean checkPick = Validation.checkInterger(pick);
            if (checkPick) {
                switch (Integer.parseInt(pick)) {
                    case 1:
                        ProductMenu.listProduct();
                        break;
                    case 2:
                        ProductMenu.creatProduct(sc);
                        break;
                    case 3:
                        ProductMenu.updateProduct(sc);
                        break;
                    case 4:
                        ProductMenu.searchProduct(sc);
                        break;
                    case 5:
                        ProductMenu.delete(sc);
                        break;
                    case 6:
                        CafeManagement.CafeManagent();
                        break;
                    default:
                        System.out.println(Notify.NOTI_PICK_1_6);
                        break;
                }
            } else {
                System.out.println(Notify.NOTI_PICK_1_6);
            }
        } while (true);
    }
    public static void delete(Scanner sc) {
        do {
            System.out.print(Notify.DELETE);
            String pick = sc.nextLine();
            boolean checkPick = Validation.checkInterger(pick);
            if (checkPick) {
                switch (Integer.parseInt(pick)) {
                    case 1:
                        ProductMenu.deleteProduct(sc);
                        break;
                    case 2:
                        ProductMenu.listDelete(sc);
                        break;
                    case 3:
                        ProductMenu.returnProduct(sc);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println(Notify.NOTI_PICK_1_4);
                }
            } else {
                System.out.println(Notify.NOTI_INPUT_INTERGER);
            }
        } while (true);
    }
    public static void listProduct() {
        productImp.displayByName();
    }
    public static void creatProduct(Scanner sc) {
        Product productNew = productImp.inputData(sc);
        boolean result = productImp.creat(productNew);
        if (result) {
            System.out.println(Notify.NOTI_CREAT_SUCCESSFUL);
        } else {
        }
    }
    public static void updateProduct(Scanner sc) {
        productImp.displayByName();
        System.out.print(Notify.NOTI_INPUT_ID_UPDATE);
        do {
            String ID = sc.nextLine();
            if (productImp.findByID(ID) != null) {
                boolean result = productImp.update(productImp.updateDetail(productImp.findByID(ID)));
                if (result) {
                    System.out.println(Notify.NOTI_UP_DATE_SUCCESSFUL);
                    break;
                }
            } else {
                System.out.println(Notify.NOTI_INPUT_ID);
            }
        } while (true);
    }
    public static void listDelete(Scanner sc) {
        productImp.listDele();
    }
    public static void deleteProduct(Scanner sc) {
        productImp.displayByName();
        System.out.print(Notify.NOTI_ID_DELETE);
        do {
            String ID = sc.nextLine();
            if (productImp.findByID(ID) != null) {
                boolean check = Validation.checkEnter(ID);
                if (!check) {
                    boolean result = productImp.update(productImp.updateStatus(productImp.findByID(ID)));
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
    public static void returnProduct(Scanner sc) {
        productImp.listDele();
        System.out.print(" Nhập ID sản phẩm muốn khôi phục : ");
        do {
            String ID = sc.nextLine();
            if (productImp.findByID(ID) != null) {
                boolean check = Validation.checkEnter(ID);
                if (!check) {
                    boolean result = productImp.update(productImp.returnProduct(productImp.findByID(ID)));
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
    public static void searchProduct(Scanner sc) {
        do {
            System.out.println(Notify.NOTI_CHOISE_SEARCH);
            String pick = sc.nextLine();
            boolean checkPick = Validation.checkInterger(pick);
            if (checkPick) {
                switch (Integer.parseInt(pick)) {
                    case 1:
                        ProductMenu.searchByName(sc);
                        break;
                    case 2:
                        ProductMenu.searchByPrice(sc);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println(Notify.NOTI_PICK_1_3);
                        break;
                }
            } else {
                System.out.println(Notify.NOTI_INPUT_INTERGER);
            }
        } while (true);
    }
    public static void searchByName(Scanner sc) {
        System.out.print(" Nhập vào tên sản phẩm muốn tìm kiếm : ");
        do {
            String search = sc.nextLine();
            boolean checkSearch = Validation.checkEnter(search);
            if (!checkSearch) {
                if (!productImp.findByName(search).isEmpty()) {
                    System.out.println(Notify.NOTI_DISPLAY_Produc);
                    for (Product pro : productImp.findByName(search)) {
                        String status = " Khong hoat dong ";
                        if (pro.isProductStatus()) {
                            status = " Hoat dong ";
                        }
                        System.out.printf(Notify.FONT_PRODUCT,
                                pro.getProductID(), pro.getProductName(), pro.getCatalog().getCatalogName(), pro.getImportPrice(), status);
                        System.out.println(Notify.POINT_PRO);
                    }
                    System.out.println(Notify.POINT_PRODUCT_END);
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
    public static void searchByPrice(Scanner sc) {
        do {
            System.out.println(" Nhập vào khoảng giá bạn muốn tìm : ");
            System.out.print("  Từ  : ");
            String price1 = sc.nextLine();
            boolean checkPrice1 = Validation.checkFloat(price1);
            if (checkPrice1) {
                System.out.print("  Đến : ");
                String price2 = sc.nextLine();
                boolean checkPrice2 = Validation.checkFloat(price2);
                if (checkPrice2) {
                    if (!productImp.findByPrice(Float.parseFloat(price1), Float.parseFloat(price2)).isEmpty()) {
                        System.out.println(Notify.NOTI_DISPLAY_Produc);
                        for (Product pro : productImp.findByPrice(Float.parseFloat(price1), Float.parseFloat(price2))) {
                            String status = " Khong hoat dong ";
                            if (pro.isProductStatus()) {
                                status = " Hoat dong ";
                            }
                            System.out.printf(Notify.FONT_PRODUCT,
                                    pro.getProductID(), pro.getProductName(), pro.getCatalog().getCatalogName(), pro.getImportPrice(), status);
                            System.out.println(Notify.POINT_PRO);
                        }
                        System.out.println(Notify.POINT_PRODUCT_END);

                    } else {
                        System.out.println(Notify.NOTI_UNKNOW_DATA);
                    }
                    break;
                } else {
                }
            } else {
                System.out.println(Notify.NOTI_INPUT_INTERGER);
            }
        } while (true);
    }
}
