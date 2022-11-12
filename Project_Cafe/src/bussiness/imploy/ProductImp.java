package bussiness.imploy;

import bussiness.design.IProduct;
import bussiness.entity.Catalog;
import bussiness.entity.Product;
import confic.Notify;
import confic.Validation;
import data.DataURL;
import data.FileImp;

import java.util.*;

public class ProductImp implements IProduct<Product, String> {

    @Override
    public Product inputData(Scanner sc) {
        List<Product> productList = readFromFile();
        if (productList == null) {
            productList = new ArrayList<>();
        }
        Product productNew = new Product();


        System.out.print(Notify.NOTI_FONT_IDPRODUCT);
        do {
            String idProduct = sc.nextLine();
            String regex = Notify.REGEX_PRODUCTNAME;
            boolean checkRegex = Validation.checkRegex(idProduct, regex);
            if (checkRegex) {
                boolean checkExist = Validation.checkExistProductId(productList, idProduct);
                if (!checkExist) {
                    productNew.setProductID(idProduct);
                    break;
                } else {
                    System.out.print(Notify.NOTI_ID_EXIST);
                }
            } else {
                System.out.println(Notify.INPUT_RIGHT);
            }

        } while (true);

        System.out.print("    Nhập tên sản phẩm : ");
        do {
            String productName = sc.nextLine();
            boolean checkLenght = Validation.checkLenght(productName);
            if (checkLenght) {
                boolean checkExistName = Validation.checkExistProductName(productList, productName);
                if (!checkExistName) {
                    productNew.setProductName(productName);
                    break;
                } else {
                    System.out.print(Notify.NAME_EXIST);
                }
            } else {
                System.out.print(Notify.NOTI_RETYPE_LENGHT);
            }
        } while (true);

        System.out.print("    Nhập giá sản phẩm : ");
        do {
            String priceInput = sc.nextLine();
            boolean checkFloat = Validation.checkFloat(priceInput);
            if (checkFloat) {
                int price = Integer.parseInt(priceInput);
                boolean checkPrice = Validation.checkPrice(price);
                if (checkPrice) {
                    productNew.setImportPrice(price);
                    break;
                } else {
                    System.out.print(Notify.NAME_PRICE_NUMBER);
                }
            } else {
                System.out.print(Notify.NOTI_INPUT_INTERGER);
            }
        } while (true);

        System.out.println("    Chọn danh mục của sản phẩm ");
        CatalogImp catImp = new CatalogImp();
        List<Catalog> listCat = catImp.findAll();
        for (Catalog catalog : listCat) {
            System.out.println("           ID : " + catalog.getCatalogID() +
                    "   ➢  " + catalog.getCatalogName());
        }

        do {
            System.out.print(Notify.NOTI_YOUR_CHOISE);
            String pick = sc.nextLine();
            boolean checkPick = Validation.checkInterger(pick);
            if (checkPick) {
                int choiceCata = Integer.parseInt(pick);
                boolean checkChoice = Validation.checkChoiceCatalog(listCat, choiceCata);
                if (checkChoice) {
                    for (Catalog catalog : listCat) {
                        if (choiceCata == catalog.getCatalogID()) {
                            productNew.setCatalog(catalog);
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.print(Notify.NOTI_INPUT_ID);
                }

            } else {
                System.out.print(Notify.NOTI_INPUT_INTERGER);
            }
        }
        while (true);
        do {
            System.out.print(Notify.NOTI_INPUT_STATUS_PRODUCT);
            String pick = sc.nextLine();
            boolean checkPick = Validation.checkInterger(pick);
            if (checkPick) {
                if(Validation.checkChoice(pick,1,2)){
                    boolean checkStatus = Validation.checkStatus(Integer.parseInt(pick));
                    productNew.setProductStatus(checkStatus);
                    break;
                }else {
                    System.out.println(Notify.NOTI_PICK_1_2);
                }
            }
        } while (true);
        return productNew;
    }

    @Override
    public Product updateDetail(Product product) {
        Scanner sc = new Scanner(System.in);
        List<Product> productList = readFromFile();
        if (productList == null) {
            productList = new ArrayList<>();
        }
        System.out.print("    Nhập tên mới của sản phẩm : ");
        do {
            String productName = sc.nextLine();
            boolean checkEnter = Validation.checkEnter(productName);
            if (!checkEnter){
                boolean checkLenght = Validation.checkLenght(productName);
                if (checkLenght) {
                    boolean checkExistName = Validation.checkExistProductName(productList, productName);
                    if (!checkExistName) {
                        product.setProductName(productName);
                        break;
                    } else {
                        System.out.print(Notify.NAME_EXIST);
                    }
                } else {
                    System.out.println(Notify.NOTI_RETYPE_LENGHT);
                }
            }else {
                break;
            }
        } while (true);

        System.out.print("    Nhập giá mới của sản phẩm : ");
        do {
            String priceInput = sc.nextLine();
            boolean checkEnter = Validation.checkEnter(priceInput);
            if(!checkEnter){
                boolean checkFloat = Validation.checkFloat(priceInput);
                if (checkFloat) {
                    int price = Integer.parseInt(priceInput);
                    boolean checkPrice = Validation.checkPrice(price);
                    if (checkPrice) {
                        product.setImportPrice(price);
                        break;
                    } else {
                        System.out.print(Notify.NAME_PRICE_NUMBER);
                    }
                } else {
                    System.out.print(Notify.NOTI_INPUT_INTERGER);
                }
            }else {
                break;
            }
        } while (true);

        System.out.println("    Chọn danh mục mới cho sản phẩm .");
        CatalogImp catImp = new CatalogImp();
        List<Catalog> listCat = catImp.findAll();
        for (Catalog catalog : listCat) {
            System.out.println("           ID : " + catalog.getCatalogID() +
                    "   ➢  " + catalog.getCatalogName());
        }

        do {
            System.out.print("    Chọn danh mục mới : ");
            String pick = sc.nextLine();
            boolean checkEnter = Validation.checkEnter(pick);
            if(!checkEnter){
                boolean checkPick = Validation.checkInterger(pick);
                if (checkPick) {
                    int choiceCata = Integer.parseInt(pick);
                    boolean checkChoice = Validation.checkChoiceCatalog(listCat, choiceCata);
                    if (checkChoice) {
                        for (Catalog catalog : listCat) {
                            if (choiceCata == catalog.getCatalogID()) {
                                product.setCatalog(catalog);
                                break;
                            }
                        }
                        break;
                    } else {
                        System.err.print(Notify.NOTI_INPUT_ID);
                    }

                } else {
                    System.err.print(Notify.NOTI_INPUT_INTERGER);
                }
            }else {
                break;
            }
        }
        while (true);
        do {
            System.out.print(Notify.NOTI_INPUT_STATUS_PRODUCT);
            String pick = sc.nextLine();
            boolean checkEnter = Validation.checkEnter(pick);
            if(!checkEnter){
                boolean checkPick = Validation.checkInterger(pick);
                if (checkPick) {
                    if(Validation.checkChoice(pick,1,2)){
                        boolean checkStatus = Validation.checkStatus(Integer.parseInt(pick));
                        product.setProductStatus(checkStatus);
                        break;
                    }else {
                        System.out.println(Notify.NOTI_PICK_1_2);
                    }
                }
            }else {
                break;
            }
        } while (true);
        return product;
    }

    @Override
    public Product updateStatus(Product product) {
        do {
            product.setProductStatus(false);
            break;
        } while (true);
        return product;
    }
    @Override
    public Product returnProduct(Product product) {
        do {
            product.setProductStatus(true);
            break;
        } while (true);
        return product;
    }


    @Override
    public boolean creat(Product product) {
        List<Product> productList = readFromFile();
        if (productList == null) {
            productList = new ArrayList<>();
        }
        productList.add(product);
        boolean result = writeFromFile(productList);
        return result;

    }

    @Override
    public boolean update(Product product) {
        List<Product> productList = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID().equals(product.getProductID())) {
                productList.set(i, product);
                returnData = true;
                break;
            }
        }
        boolean result = writeFromFile(productList);
        if (result && returnData) {
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        return readFromFile();
    }

    @Override
    public Product findByID(String id) {
        List<Product> productList = readFromFile();
        for (Product pro : productList) {
            if (pro.getProductID().equals(id)) {
                return pro;
            }
        }
        return null;
    }

    @Override
    public List<Product> readFromFile() {
        FileImp<Product> fileImp = new FileImp<>();
        return fileImp.readFromFile(DataURL.URL_PRODUCT);
    }

    @Override
    public boolean writeFromFile(List<Product> list) {
        FileImp<Product> fileImp = new FileImp<>();
        return fileImp.writeFromFile(list, DataURL.URL_PRODUCT);
    }


    @Override
    public void displayByName() {
        if (readFromFile() == null) {
            System.err.println("    Chưa có sản phẩm nào ! ");
        } else {
            List<Product> productList = readFromFile();
            Collections.sort(productList, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getCatalog().getPriority() - o2.getCatalog().getPriority();
                }
            });
            System.out.println(Notify.NOTI_DISPLAY_Produc);
            for (Product pro : productList) {
                if (pro.isProductStatus()==false){
                    continue;
                }
                String status = " Khong hoat dong ";
                if (pro.isProductStatus()) {
                    status = " Hoat dong ";
                }
                System.out.printf(Notify.FONT_PRODUCT,
                        pro.getProductID(), pro.getProductName(), pro.getCatalog().getCatalogName(), pro.getImportPrice(), status);
                System.out.println(Notify.POINT_PRO);
            }
            System.out.println(Notify.POINT_PRODUCT_END);
        }
    }
    @Override
    public void listDele() {
            List<Product> productList = readFromFile();
            Collections.sort(productList, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getCatalog().getPriority() - o2.getCatalog().getPriority();
                }
            });
            System.out.println(Notify.NOTI_DISPLAY_Produc);
            for (Product pro : productList) {
                if (pro.isProductStatus()==true){
                    continue;
                }
                String status = " Khong hoat dong ";
                if (pro.isProductStatus()) {
                    status = " Hoat dong ";
                }
                System.out.printf(Notify.FONT_PRODUCT,
                        pro.getProductID(), pro.getProductName(), pro.getCatalog().getCatalogName(), pro.getImportPrice(), status);
                System.out.println(Notify.POINT_PRO);
            }
            System.out.println(Notify.POINT_PRODUCT_END);
        }



    @Override
    public List<Product> findByName(String name) {
        List<Product> productListFull = readFromFile();
        List<Product> productList = new ArrayList<>();
        for (Product pro : productListFull) {
            if (pro.getProductName().contains(name)) {
                productList.add(pro);
            }
        }
        return productList;
    }

    @Override
    public List<Product> findByPrice(Float price1, Float price2) {
        List<Product> productListFull = readFromFile();
        List<Product> productList = new ArrayList<>();
        for (Product pro : productListFull) {
            if (pro.getImportPrice() > price1 && pro.getImportPrice() < price2) {
                productList.add(pro);
            }
        }
        return productList;
    }
}