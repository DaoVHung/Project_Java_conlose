package data;
import java.io.*;
import java.util.List;

public class FileImp<T> {

    public List<T> readFromFile(String filePath) {
        List<T> list = null;
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            file = new File(filePath);
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                list = (List<T>) ois.readObject();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return list;
    }
    public boolean writeFromFile(List<T> list, String filePath) {
        File file = null;
        FileOutputStream fos= null;
        ObjectOutputStream oos = null;
        boolean returnData = true;
        try {
            file = new File(filePath);
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            returnData = true;
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            try {
                if (oos!=null){
                    oos.close();
                }
                if (fos!=null){
                    fos.close();
                }
            }catch (Exception e){
                e.getStackTrace();
            }
        }
        return returnData;
    }
}
