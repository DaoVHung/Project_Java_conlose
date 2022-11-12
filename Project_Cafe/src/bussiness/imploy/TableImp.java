package bussiness.imploy;

import bussiness.design.ITable;
import bussiness.entity.Table;
import confic.Notify;
import confic.Validation;
import data.DataURL;
import data.FileImp;

import java.util.*;

public class TableImp implements ITable<Table, String> {
    @Override
    public Table inputData(Scanner sc) {
        List<Table> tableList = readFromFile();
        if (tableList == null) {
            tableList = new ArrayList<>();
        }
        Table table = new Table();
        System.out.print(" Nhap ma san pham: \n( gom 5 ky tu bat dau = A-Z ) : ");
        do {
            String ID = sc.nextLine();
            String regex = Notify.RegexTableID;
            boolean checkID = Validation.checkRegex(ID,regex);
            if (checkID) {
                boolean checkExist = Validation.checkExistTableID(tableList, ID);
                if(!checkExist){
                    table.setTableID(ID);
                    break;
                }else {
                    System.err.print(Notify.NOTI_ID_EXIST);
                }
            } else {
                System.err.print(Notify.INPUT_RIGHT);
            }
        } while (true);

        System.out.print(" Nhập tên bàn : ");
        do {
            String tableName = sc.nextLine();
            boolean checkExist = Validation.checkExistTableName(tableList, tableName);
            if (!checkExist) {
                table.setTableName(tableName);
                break;
            } else {
                System.err.print(Notify.NAME_EXIST);
            }
        } while (true);


        System.out.print(" Nhập số chỗ ngồi : ");
        do {
            String inputSeat = sc.nextLine();
            boolean checkSeat = Validation.checkInterger(inputSeat);
            if (checkSeat) {
                boolean cheakSeatValue = Validation.checkSeat(Integer.parseInt(inputSeat));
                if (cheakSeatValue) {
                    table.setSeat(Integer.parseInt(inputSeat));
                    break;
                } else {
                    System.err.print(Notify.NAME_NUMBER_TABLE);
                }
            } else {
                System.out.print(Notify.NOTI_INPUT_INTERGER);
            }
        } while (true);

        do {
            System.out.print(Notify.TABLE_STATUS);
            String number = sc.nextLine();
            boolean check = Validation.checkInterger(number);
            if (check) {
                if(Validation.checkChoice(number,1,4)){
                    table.setTableStatus(Integer.parseInt(number));
                    break;
                }else {
                    System.out.println(Notify.NOTI_PICK_1_4);
                }
            } else {
                System.out.println(Notify.NOTI_PICK_1_4);
            }
        } while (true);
        return table;
    }
//    Integer.parseInt(number)>=1&&Integer.parseInt(number)<=4
    @Override
    public Table updateStatus(Table table) {
        Scanner sc = new Scanner(System.in);

        List<Table> tableList = readFromFile();
        do {
            System.out.print(Notify.TABLE_STATUS);
            String number = sc.nextLine();
            boolean check = Validation.checkInterger(number);
            if (check) {
                if(Validation.checkChoice(number,1,4)){
                    table.setTableStatus(Integer.parseInt(number));
                    break;
                }else {
                    System.out.println(Notify.NOTI_PICK_1_4);
                }
            } else {
                System.out.println(Notify.NOTI_PICK_1_4);
            }
        } while (true);
        return table;
    }
    @Override
    public Table updateDetail(Table table) {
        List<Table> tableList = readFromFile();

        Scanner sc = new Scanner(System.in);

        System.out.print(" Nhập tên bàn mới : ");
        do {
            String tableName = sc.nextLine();
            boolean checkEnter = Validation.checkEnter(tableName);
            if (!checkEnter){
                boolean checkExist = Validation.checkExistTableName(tableList, tableName);
                if (!checkExist) {
                    table.setTableName(tableName);
                    break;
                } else {
                    System.out.print(Notify.NAME_EXIST);
                }
            }else {
                break;
            }
        } while (true);
        System.out.print(" Nhập số chỗ ngồi mới : ");
        do {
            String inputSeat = sc.nextLine();
            boolean checkEnter = Validation.checkEnter(inputSeat);
            if (!checkEnter){
                boolean checkSeat = Validation.checkInterger(inputSeat);
                if (checkSeat) {
                    boolean cheakSeatValue = Validation.checkSeat(Integer.parseInt(inputSeat));
                    if (cheakSeatValue) {
                        table.setSeat(Integer.parseInt(inputSeat));
                        break;
                    } else {
                        System.out.println(Notify.NAME_NUMBER_TABLE);
                    }
                } else {
                    System.out.print(Notify.NOTI_INPUT_INTERGER);
                }
            }else {
                break;
            }
        } while (true);

        return table;

    }

    @Override
    public List<Table> readFromFile() {
        FileImp<Table> fileImp = new FileImp<>();
        return fileImp.readFromFile(DataURL.URL_TABLE);
    }

    @Override
    public boolean writeFromFile(List<Table> list) {
        FileImp<Table> fileImp = new FileImp<>();
        return fileImp.writeFromFile(list, DataURL.URL_TABLE);
    }

    @Override
    public boolean creat(Table table) {
        List<Table> tableList = readFromFile();
        if (tableList == null) {
            tableList = new ArrayList<>();
        }
        tableList.add(table);
        boolean result = writeFromFile(tableList);
        return result;
    }

    @Override
    public boolean update(Table table) {
        List<Table> tableList = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < tableList.size(); i++) {
            if (tableList.get(i).getTableID().equals(table.getTableID())) {
                tableList.set(i, table);
                returnData = true;
                break;
            }
        }
        boolean result = writeFromFile(tableList);
        if (result && returnData) {
            return true;
        }
        return false;
    }

    @Override
    public List<Table> findAll() {
        return readFromFile();
    }

    @Override
    public Table findByID(String id) {
        List<Table> tableList = readFromFile();
        for (Table cat : tableList) {
            if (cat.getTableID().equals(id)) {
                return cat;
            }
        }
        return null;
    }
    @Override
    public void displayByStatus() {
        if (readFromFile()==null){
            System.out.println(" Chưa có bàn ! ");
        }else {
            List<Table> tableList = readFromFile();
            Collections.sort(tableList, new Comparator<Table>() {
                @Override
                public int compare(Table o1, Table o2) {
                    return o1.getTableStatus()-o2.getTableStatus();
                }
            });
            System.out.println(Notify.NOTI_DISPLAY_TABLE);
            for (Table ta : tableList) {
                String status = "";
                switch (ta.getTableStatus()){
                    case 1:
                        status ="Trong";
                        break;
                    case 2:
                        status ="Dang su dung";
                        break;
                    case 3:
                        status ="Dang ghep";
                        break;
                    case 4:
                        status ="Hong";
                        break;
                    default:
                        System.out.println(Notify.NOTI_PICK_1_4);
                        break;

                }
                System.out.printf(Notify.FONT_TABLE,
                        ta.getTableID(),ta.getTableName(),ta.getSeat(),status);
                System.out.println(Notify.POINT_TABLE);
            }
            System.out.println(Notify.POINT_TABLE_END);

        }

    }

}
