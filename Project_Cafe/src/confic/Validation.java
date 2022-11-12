package confic;

import bussiness.entity.Catalog;
import bussiness.entity.Product;
import bussiness.entity.Table;
import bussiness.entity.User;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean checkLenght(String str) {
        if (str.length() >= 6 && str.length() < 30) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean checkEnter(String str){
        if(str.trim().length()==0){
            return true;
        }else {
            return false;
        }
    }
    public static boolean checkPrice(Integer fl) {
        try {
            if (fl > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkSeat(Integer number) {
        try {
            if (number > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkStatus(Integer number) {
        try {
            if (number == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean checkStatusNumber(String str) {
        try {
            int number = Integer.parseInt(str);
            if (number == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean checkRegex(String str , String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static boolean checkChoice(String str1, Integer choice1, Integer choice2) {
        try {
            int number1 = Integer.parseInt(str1);
            if (number1>=choice1&&number1<=choice2){
                return true;
            }else{
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean checkInterger(String str) {
        try {
            int number = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean checkFloat(String str) {
        try {
            Float number = Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean checkExistProductName(List<Product> listPro, String productName) {
        for (Product pro : listPro) {
            if (pro.getProductName().equals(productName)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkExistProductId(List<Product> listPro, String productId) {
        for (Product pro : listPro) {
            if (pro.getProductID().equals(productId)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkExistNameUser(List<User> listUser, String userName) {
        for (User us : listUser) {
            if (us.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkExistCatalogName(List<Catalog> listCata, String catalogName) {
        for (Catalog cata : listCata) {
            if (cata.getCatalogName().equals(catalogName)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkExistTableName(List<Table> listTable, String tableName) {
        for (Table ta : listTable) {
            if (ta.getTableName().equals(tableName)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkExistTableID(List<Table> listTable, String tableName) {
        for (Table ta : listTable) {
            if (ta.getTableID().equals(tableName)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkConfirmPassword(String passWord , String passwordConfirm){

            if(passWord.equals(passwordConfirm)){
                return true;
            }
        return false;
    }
    public static boolean checkChoiceCatalog(List<Catalog> list, Integer integer){
        if(integer >=1 && integer<= list.size()){
            return true;
        }
        else {
            return false;
        }
    }














}
