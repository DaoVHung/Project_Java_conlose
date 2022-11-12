package bussiness.imploy;

import bussiness.design.ICatalog;
import bussiness.entity.Catalog;
import confic.Notify;
import confic.Validation;
import data.DataURL;
import data.FileImp;
import java.util.*;
public class CatalogImp implements ICatalog<Catalog, Integer> {
    @Override
    public Catalog inputData(Scanner sc) {
        List<Catalog> catalogList = readFromFile();
        if (catalogList == null) {
            catalogList = new ArrayList<>();
        }
        Catalog catalog = new Catalog();
        if (catalogList.size() == 0) {
            catalog.setCatalogID(1);
        } else {
            int max = 0;
            for (Catalog cataList : catalogList) {
                if (max < cataList.getCatalogID()) {
                    max = cataList.getCatalogID();
                }
            }
            catalog.setCatalogID(max + 1);
        }
        System.out.print("    Nhập tên danh mục            : ");
        do {
            String catalogName = sc.nextLine();
            boolean checkLenght = Validation.checkLenght(catalogName);
            if (checkLenght) {
                boolean checkExistName = Validation.checkExistCatalogName(catalogList, catalogName);
                if (!checkExistName) {
                    catalog.setCatalogName(catalogName);
                    break;
                } else {
                    System.out.println(Notify.NOTI_EXIST_NAME);
                }
            } else {
                System.out.println(Notify.NOTI_RETYPE_LENGHT);

            }
        } while (true);
        System.out.print("    Nhập độ ưu tiên của danh mục : ");
        do {
            String number = sc.nextLine();
            boolean checkInterger = Validation.checkInterger(number);
            if (checkInterger) {
                catalog.setPriority(Integer.parseInt(number));
                break;
            } else {
                System.err.print(Notify.NOTI_INPUT_INTERGER);
            }
        } while (true);
        System.out.print(Notify.NOTI_INPUT_STATUS_CATALOG);
        do {
            String number = sc.nextLine();
            boolean checkInterger = Validation.checkInterger(number);
            if (checkInterger) {
                if(Validation.checkChoice(number,1,2)){
                    if (Integer.parseInt(number) == 1) {
                        catalog.setCatalogStatus(true);
                    } else {
                        catalog.setCatalogStatus(false);
                    }
                    break;
                }else {
                    System.out.println(Notify.NOTI_PICK_1_2);
                }

            }else {
                System.out.print(Notify.NOTI_INPUT_INTERGER);
            }
        } while (true);
        return catalog;
    }
    @Override
    public boolean creat(Catalog catalog) {
        List<Catalog> catalogList = readFromFile();
        if (catalogList == null) {
            catalogList = new ArrayList<>();
        }
        catalogList.add(catalog);
        boolean result = writeFromFile(catalogList);
        return result;
    }
    @Override
    public boolean update(Catalog catalog) {
        List<Catalog> catalogList = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < catalogList.size(); i++) {
            if (catalogList.get(i).getCatalogID() == catalog.getCatalogID()) {
                catalogList.set(i, catalog);
                returnData = true;
                break;
            }
        }
        boolean result = writeFromFile(catalogList);
        if (result && returnData) {
            return true;
        }
        return false;
    }
    @Override
    public Catalog updateDetail(Catalog catalog) {
        List<Catalog> catalogList = readFromFile();
        Scanner sc = new Scanner(System.in);
        System.out.print("    Nhập tên danh mục mới : ");
        do {
            String catalogName = sc.nextLine();
            boolean checkEnter = Validation.checkEnter(catalogName);
            if(!checkEnter){
                boolean checkLenght = Validation.checkLenght(catalogName);
                if (checkLenght) {
                    boolean checkExistName = Validation.checkExistCatalogName(catalogList, catalogName);
                    if (!checkExistName) {
                        catalog.setCatalogName(catalogName);
                        break;
                    } else {
                        System.out.print(Notify.NOTI_EXIST_NAME);
                    }
                } else {
                    System.out.print(Notify.NOTI_RETYPE_LENGHT);
                }
            }else {
                break;
            }
        } while (true);
        System.out.print("    Nhập vào độ ưu tiên mới : ");
        do {
            String number = sc.nextLine();
            boolean checkEnter = Validation.checkEnter(number);
            if(!checkEnter){
                boolean check = Validation.checkInterger(number);
                if (check) {
                    catalog.setPriority(Integer.parseInt(number));
                    break;
                } else {
                    System.out.println(Notify.NOTI_INPUT_INTERGER);
                }
            }else {
                break;
            }
        } while (true);
        System.out.print(Notify.NOTI_INPUT_STATUS_CATALOG);
        do {
            String number = sc.nextLine();
            boolean checkEnter = Validation.checkEnter(number);
            if (!checkEnter){
                boolean checkInterger = Validation.checkInterger(number);
                if (checkInterger) {
                    if(Validation.checkChoice(number,1,2)){
                        if (Integer.parseInt(number) == 1) {
                            catalog.setCatalogStatus(true);
                        } else {
                            catalog.setCatalogStatus(false);
                        }
                        break;
                    }else {
                        System.out.println(Notify.NOTI_PICK_1_2);
                    }
                }else {
                    System.out.println(Notify.NOTI_INPUT_INTERGER);
                }
            }else {
                break;
            }
        } while (true);
        return catalog;
    }
    @Override
    public List<Catalog> findAll() {
        return readFromFile();
    }
    @Override
    public Catalog findByID(Integer id) {
        List<Catalog> catalogList = readFromFile();
        for (Catalog cat : catalogList) {
            if (cat.getCatalogID() == id) {
                return cat;
            }
        }
        return null;
    }
    @Override
    public List<Catalog> findByCatalogName(String name) {
        List<Catalog> catalogList = readFromFile();
        List<Catalog> catalogsList2 = new ArrayList<>();
        for (Catalog cata : catalogList) {
            if (cata.getCatalogName().contains(name)) {
                catalogsList2.add(cata);
            }
        }
        return catalogsList2;
    }
    @Override
    public List<Catalog> readFromFile() {
        FileImp<Catalog> fileImp = new FileImp<>();
        return fileImp.readFromFile(DataURL.URL_CATALOG);
    }
    @Override
    public boolean writeFromFile(List<Catalog> list) {
        FileImp<Catalog> fileImp = new FileImp<>();
        return fileImp.writeFromFile(list, DataURL.URL_CATALOG);
    }
    @Override
    public void displayByPriority() {
        if (readFromFile() == null) {
            System.err.println("    Chưa có sản phẩm nào ! ");
        }else {
            List<Catalog> catalogList = readFromFile();
            Collections.sort(catalogList, new Comparator<Catalog>() {
                @Override
                public int compare(Catalog o1, Catalog o2) {
                    return o1.getPriority() - o2.getPriority();
                }
            });
            System.out.println(Notify.NOTI_DISPLAY_CATALOG);
            for (Catalog cat : catalogList) {
                String status = " Khong hoat dong ";
                if (cat.isCatalogStatus()){
                    status = "    Hoat dong ";
                }
                System.out.printf(Notify.FONT_CATALOG,
                        cat.getCatalogID(), cat.getCatalogName(), cat.getPriority(), status);
                System.out.println(Notify.POINT_CATALOG);
            }
            System.out.println(Notify.POINT_CATALOG_END);
        }
        }

}
