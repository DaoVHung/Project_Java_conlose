package bussiness.imploy;

import bussiness.design.IUser;
import bussiness.entity.Table;
import bussiness.entity.User;
import confic.Notify;
import confic.Validation;
import data.DataURL;
import data.FileImp;

import java.util.*;

public class UserImp implements IUser<User, Integer> {
    public static String  userName;
    @Override
    public boolean creat(User user) {
        List<User> usersList = readFromFile();

        if (usersList == null) {
            usersList = new ArrayList<>();
        }
        usersList.add(user);
        boolean result = writeFromFile(usersList);
        return result;
    }
    @Override
    public boolean update(User user) {
        List<User> userList = readFromFile();
        boolean returnData = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserID()==user.getUserID()) {
                userList.set(i, user);
                returnData = true;
                break;
            }
        }
        boolean result = writeFromFile(userList);
        if (result && returnData) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return readFromFile();
    }

    @Override
    public User findByID(Integer id) {
        List<User> userList = readFromFile();
        for (User pro : userList) {
            if (pro.getUserID() == id) {
                return pro;
            }
        }
        return null;
    }

    @Override
    public List<User> readFromFile() {
        FileImp<User> userImp = new FileImp<>();
        return userImp.readFromFile(DataURL.URL_USER);
    }

    @Override
    public boolean writeFromFile(List<User> list) {
        FileImp<User> fileImp = new FileImp<>();
        return fileImp.writeFromFile(list, DataURL.URL_USER);
    }

    @Override
    public User inputData(Scanner sc) {
        List<User> userList = readFromFile();
        if (userList == null) {
            userList = new ArrayList<>();
        }
        User user = new User();
        if (userList.size() == 0) {
            user.setUserID(1);
        } else {
            int max = 0;
            for (User userlist : userList) {
                if (max < userlist.getUserID()) {
                    max = userlist.getUserID();
                }
            }
            user.setUserID(max + 1);
        }
        System.out.print(" Nhập tên đăng nhập : ");
        do {
            String userName = sc.nextLine();
            String regex = Notify.RegexUserName;
            boolean checkRegex = Validation.checkRegex(userName, regex);
            if (checkRegex) {
                user.setUserName(userName);
                break;
            } else {
                System.out.println(Notify.NOTI_RETYPE_LENGHT);
            }
        } while (true);

        System.out.print(" Nhập mật khẩu      : ");

        do {
            String passWord ;
            do {
                passWord=sc.nextLine();
                if (Validation.checkLenght(passWord)){
                    user.setPassword(passWord);
                    break;
                }else {
                    System.out.println(" Nhập mật khẩu dài hơn 6 ký tự !");
                }
            }while (true);
        System.out.print(" Xác nhận mật khẩu  : ");
            String confirmPass = sc.nextLine();
            boolean checkPass = Validation.checkConfirmPassword(passWord, confirmPass);
            if (checkPass) {
                user.setConfirmPassword(confirmPass);
                break;
            } else {
                System.out.print(Notify.WRONG_PASSWORD);
            }
        } while (true);
        System.out.print(" Nhập tên người dùng : ");
        user.setFullName(sc.nextLine());

        user.setDateRegister(java.time.LocalDate.now());
        System.out.print(Notify.NOTI_USER_STATUS);
        do {
            String pick = sc.nextLine();
            boolean checkPick = Validation.checkStatusNumber(pick);
            if (Validation.checkChoice(pick, 1, 2)) {
                if (checkPick) {
                    user.setUserStatus(true);
                    break;
                } else {
                    user.setUserStatus(false);
                    break;
                }
            } else {
                System.out.println(Notify.NOTI_PICK_1_2);
            }
        } while (true);

        System.out.println(" Nhập Email người dùng : ");
        do {
            String email = sc.nextLine();
            String regex = Notify.RegexEmail;
            boolean checkRegex = Validation.checkRegex(email, regex);
            if (checkRegex) {
                user.setEmail(email);
                break;
            } else {
                System.out.println(" Chưa đúng định dạng email ( ....@gmail.com ).\n Vui lòng nhập lại !");
            }
        } while (true);
        System.out.println(" Nhập số điện thoại : ");
        do {
            String phoneNuber = sc.nextLine();
            String regex = Notify.RegexPhongNumber;
            boolean checkRegexPhone = Validation.checkRegex(phoneNuber, regex);
            if (checkRegexPhone) {
                user.setPhoneNumber(phoneNuber);
                break;
            } else {
                System.out.println(" Vui lòng nhập theo định dạng SĐT Việt Nam : ");
            }
        } while (true);
        return user;
    }

    @Override
    public User checkLogin(String userName, String password) {
        List<User> userList = readFromFile();
        for (User user : userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {

                return user;
            }
        }
        return null;
    }

    @Override
    public void displayByDate() {
        List<User> userList = readFromFile();
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getDateRegister().compareTo(o1.getDateRegister());
            }
        });
        System.out.println(Notify.NOTI_DISPLAY_USER);
        for (User us : userList) {
            String statusUser = " Block ";
            if (us.isUserStatus()) {
                statusUser = " Active ";
            }
            System.out.printf(Notify.FONT_USER,
                    us.getUserID(), us.getUserName(), us.getFullName(), us.getDateRegister(), statusUser, us.getEmail(), us.getPhoneNumber());
        }
        System.out.println(Notify.POINT_USer);
    }
    @Override
    public User findByUserName(User user) {
        List<User> userList = readFromFile();
        Scanner sc = new Scanner(System.in);
        do {
            String search = sc.nextLine();
            for (User us : userList) {
                if (us.getFullName().equals(search) || us.getUserName().equals(search)) {
                    return us;
                } else {
                    System.out.println(Notify.NOTI_UNKNOW_DATA);
                }
            }
        } while (true);
    }

    @Override
    public List<User> findByName(String name) {
        List<User> userListFull = readFromFile();
        List<User> userList = new ArrayList<>();
        for (User us : userListFull) {
            if (us.getUserName().contains(name) || us.getFullName().contains(name)) {
                userList.add(us);
            }
        }
        return userList;
    }

    @Override
    public User updateStatus(User user) {
        do {
            if ((user.getUserID()==0)){
                System.out.println(" Bạn không có quyền thay đổi trạng thái tài khoản này !");
                break;
            }
            if (user.isUserStatus()) {
                user.setUserStatus(false);
                break;
            } else {
                user.setUserStatus(true);
                break;
            }
        } while (true);
        return user;
    }
    public User findByNamePass(String name) {
        List<User> userList = readFromFile();
        User userNull = null;
        for (User user : userList) {
            if (user.getUserName().equals(name)) {
                userNull = user;
            }
        }
        return userNull;
    }

}