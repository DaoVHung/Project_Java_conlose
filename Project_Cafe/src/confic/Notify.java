package confic;
public class Notify {
    public static final String WRONG_PASSWORD = "  Mật khẩu chưa khớp.\n Vui lòng nhập lại : ";
    public static final String NOTI_USER_STATUS = " Nhập trạng thái tài khoản : \n      1 ➣ Hoạt động. \n      2 ➣ Khóa. \n     Lựa chọn của bạn : ";
    public static final String NOTI_RETYPE_LENGHT = " Hãy nhập tên có từ 6 - 30 ký tự !\n Vui lòng nhập lại : ";
    public static final String NOTI_UP_DATE_SUCCESSFUL = " Cập nhật thành công !";
    public static final String NOTI_UP_DATE_FAIL = " Cập nhật thất bại \uD83D\uDE22 !";
    public static final String NOTI_INPUT_ID = " Vui lòng nhập ID trong danh sách !\n     Hãy nhập lại : ";
    public static final String NOTI_YOUR_CHOISE = " Nhập lựa chọn của bạn : ";
    public static final String NOTI_PICK_1_5 = "      Vui lòng nhập từ 1 ➣ 5 ! ";
    public static final String NOTI_PICK_1_6 = "      Vui lòng nhập từ 1 ➣ 6 ! ";
    public static final String NOTI_PICK_1_4 = "      Vui lòng nhập từ 1 ➣ 4 ! ";
    public static final String NOTI_PICK_1_3 = "      Vui lòng nhập từ 1 ➣ 3 ! ";
    public static final String NOTI_PICK_1_2 = "      Vui lòng 1 hoặc 2 !";
    public static final String NOTI_CREAT_SUCCESSFUL = " Tạo mới thành công \uD83D\uDE0D ! \n ";
    public static final String NOTI_INPUT_ID_UPDATE = " Nhập ID bạn muốn cập nhật : ";
    public static final String NOTI_ID_DELETE = " Nhập ID sản phẩm muốn xóa ";
    public static final String NOTI_INPUT_INTERGER = " Vui lòng nhập lại 1 số : ";
    public static final String NOTI_UNKNOW_DATA = " Không có thông tin \uD83D\uDE41! ";
    public static final String NOTI_INPUT_STATUS_CATALOG = " Chọn trạng thái danh mục. \n      1 ➢ Hoạt động. \n      2 ➢ Không hoạt động. \n Lựa chọn của bạn là : ";
    public static final String NOTI_EXIST_NAME = " Tên danh mục đã tồn tại !\n      Vui lòng nhập tên khác : ";
    public static final String NOTI_FONT_IDPRODUCT = " Nhập mã sản phẩm ( Gồm 5 ký tự, bắt đầu là P ) : ";
    public static final String NOTI_ID_EXIST = " ID đã tồn tại !\n      Vui lòng nhập ID khác :  ";
    public static final String INPUT_RIGHT = " Vui lòng nhập đúng định dạng.\n Hãy nhập lại : ";
    public static final String NAME_EXIST = " Tên đã tồn tại.\n Hãy nhập tên khác : ";
    public static final String NAME_NUMBER_TABLE = " Số ghê phải lớn hơn 0 !. \n Hãy nhập lại : ";
    public static final String NAME_PRICE_NUMBER = " Giá phải lớn hơn 0 !. \n Hãy nhập lại : ";
    public static final String NOTI_INPUT_STATUS_PRODUCT = " Chọn trạng thái sản phẩm. \n      1 ➢ Hoạt động. \n      2 ➢ Không hoạt động. \n Lựa chọn của bạn là : ";
    public static final String RegexEmail = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static final String RegexPhongNumber = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
    public static final String RegexTableID = "^[A][Z]\\d{3}$";
    public static final String REGEX_PRODUCTNAME = "^[P]\\d{4}$";
    public static final String RegexUserName = "^[a-zA-Z0-9]{6,}$";
    public static final String NOTI_CHOISE_SEARCH = " Tìm kiếm : \n" +
            "     1 ➢ Theo tên sản phẩm. \n" +
            "     2 ➢ Theo khoảng giá. \n" +
            "     3 ➢ Thoát ! ";
    public static final String NOTI_LOGIN_FAIL = "  \n" +
            "  Đăng nhập thất bai !\n" +
            "   1. Đăng nhập lại .\n" +
            "   2. Thoát.\n" +
            " Sự lựa chọn của bạn :";
    public static final String TABLE_STATUS = " Nhập vào trạng thái của bàn .\n" +
            "          1 ➮ Trống.\n" +
            "          2 ➮ Đang sử dụng.\n" +
            "          3 ➮ Đang ghép bàn.\n" +
            "          4 ➮ Hỏng\n" +
            "          Lựa chọn của bạn là : ";
    public static final String DELETE = " Vui lòng trọn mục :\n" +
            "          1 ➮ Xóa sản phẩm .\n" +
            "          2 ➮ Sản phẩm đã xóa.\n" +
            "          3 ➮ Khôi phục sản phẩm đã xóa.\n" +
            "          4 ➮ Thoát.\n" +
            "          Lựa chọn của bạn là : ";
    public static final String MENU_CATALOG = " \n" +
            "                   ꧁ \n"+
            "                     ╔════════════════════════════╗\n" +
            "                     ║           CATALOG          ║\n" +
            "                     ╟════════════════════════════╢\n" +
            "                     ║   1. Danh sách danh mục.   ║\n" +
            "                     ║   2. Tạo mới danh mục.     ║\n" +
            "                     ║   3. Cập nhật danh mục.    ║\n" +
            "                     ║   4. Tìm kiếm danh mục.    ║\n" +
            "                     ║   5. Thoat.                ║\n" +
            "                     ╚════════════════════════════╝꧂\n";
    public static final String MENU_PRODUCT = " \n" +
            "                   ꧁ \n"+
            "                     ╔════════════════════════════╗\n" +
            "                     ║           PRODUCT          ║\n" +
            "                     ╟════════════════════════════╢\n" +
            "                     ║  1.  Danh sách sản phẩm.   ║\n" +
            "                     ║  2.  Tạo mới sản phẩm.     ║\n" +
            "                     ║  3.  Cập nhật sản phẩm.    ║\n" +
            "                     ║  4.  Tìm kiếm sản phẩm.    ║\n" +
            "                     ║  5.  Xóa sản phẩm.         ║\n" +
            "                     ║  6.  Thoát.                ║\n" +
            "                     ╚════════════════════════════╝꧂\n";
    public static final String MENU_TABLE = " \n" +
            "                   ꧁ \n"+
            "                     ╔════════════════════════════╗\n" +
            "                     ║           TABLE            ║\n" +
            "                     ╟════════════════════════════╢\n" +
            "                     ║ 1. Danh sách bàn.          ║\n" +
            "                     ║ 2. Thêm mới bàn.           ║\n" +
            "                     ║ 3. Cập nhật thông tin bàn. ║\n" +
            "                     ║ 4. Cập nhật trạng thái bàn.║\n" +
            "                     ║ 5. Thoát.                  ║\n" +
            "                     ╚════════════════════════════╝꧂\n";
    public static final String MENU_USER = " \n" +
            "                   ꧁                   \n"+
            "                     ╔════════════════════════════╗\n" +
            "                     ║            USER            ║\n" +
            "                     ╟════════════════════════════╢\n" +
            "                     ║  1. Danh sách tài khoản.   ║\n" +
            "                     ║  2. Thêm tài khoản.        ║\n" +
            "                     ║  3. Cập nhật hoạt động.    ║\n" +
            "                     ║  4. Tìm kiếm tài khoản.    ║\n" +
            "                     ║  5. Dổi mật khẩu.          ║\n" +
            "                     ║  6. Thoát.                 ║\n" +
            "                     ╚════════════════════════════╝꧂\n";
    public static final String MENU_CAFEMANAGE = " \n" +
            "                   ꧁         \n"+
            "                     ╔════════════════════════════╗\n" +
            "                     ║        MENU  MAGANE        ║\n" +
            "                     ╟════════════════════════════╢\n" +
            "                     ║   1. Quản lý danh mục.     ║\n" +
            "                     ║   2. Quản lý sản phẩm.     ║\n" +
            "                     ║   3. Quản lý bàn.          ║\n" +
            "                     ║   4. Quản lý tài khoản.    ║\n" +
            "                     ║   5. Thoat.                ║\n" +
            "                     ╚════════════════════════════╝꧂\n";
    public static final String RUN = " \n" +
            "                   ꧁                                   \n"+
            "                     ╔════════════════════════════╗\n" +
            "                     ║           LOGIN  ❤        ║\n" +
            "                     ╟════════════════════════════╢\n" +
            "                     ║       1. Đăng nhập.        ║\n" +
            "                     ║       2. Thoát.            ║\n" +
            "                     ╚════════════════════════════╝꧂\n";
    public static final String NOTI_DISPLAY_TABLE = " \n" +
            "    Danh sách bàn :\n" +
            "  ꧁ \n"+
            "    ╔════════╤═════════════╤══════════╤═════════════════════╗\n" +
            "    ║   ID   │   Tên bàn   │  Số ghế  │     Trạng thái      ║\n" +
            "    ╟════════┼═════════════┼══════════┼═════════════════════╢";
    public static final String FONT_TABLE = "    ║ %-3s  │     %-8s│    %-5d │  %-19s║ \n";
    public static final String POINT_TABLE = "" +
            "    ╟────────┼─────────────┼──────────┼─────────────────────╢ ";
    public static final String POINT_TABLE_END = "" +
            "    ╚════════╧═════════════╧══════════╧═════════════════════╝꧂";
    public static final String NOTI_DISPLAY_CATALOG = " \n" +
            "    Danh sách danh mục :\n" +
            "  ꧁ \n"+
            "    ╔════╤══════════════════════╤════════════╤═══════════════════════╗\n" +
            "    ║ ID │       Tên bàn        │   Số ghế   │      Trạng thái       ║\n" +
            "    ╟════┼══════════════════════┼════════════┼═══════════════════════╢";
    public static final String FONT_CATALOG = "    ║ %-3d│  %-20s│     %-5d  │  %-20s ║ \n";
    public static final String POINT_CATALOG = "" +
            "    ╟────┼──────────────────────┼────────────┼───────────────────────╢ ";
    public static final String POINT_CATALOG_END = "" +
            "    ╚════╧══════════════════════╧════════════╧═══════════════════════╝꧂";
    public static final String NOTI_DISPLAY_Produc = " \n" +
            "    Danh sách sản phẩm :\n" +
            "  ꧁ \n"+
            "    ╔════════╤══════════════════════╤══════════════════════╤══════════════╤═══════════════════════╗\n" +
            "    ║   ID   │     Tên sản phẩm     │   Tên danh mục       │ Giá sản phẩm │       Trạng thái      ║\n" +
            "    ╟════════┼══════════════════════┼══════════════════════┼══════════════┼═══════════════════════╢";
    public static final String FONT_PRODUCT = "    ║ %-7s│ %-21s│  %-20s│  %-12d│  %-21s║\n";
    public static final String POINT_PRO = " " +
            "   ╟────────┼──────────────────────┼──────────────────────┼──────────────┼───────────────────────╢";
    public static final String POINT_PRODUCT_END = "" +
            "    ╚════════╧══════════════════════╧══════════════════════╧══════════════╧═══════════════════════╝꧂";
    public static final String NOTI_DISPLAY_USER = " \n" +
            "    Danh sách tài khoản :\n" +
            "    ┌────────┬───────────────────┬────────────────────┬────────────────────┬────────────┬────────────────────────────┬───────────────────┐\n" +
            "    │   ID   │   Tên tài khoản   │   Tên người dùng   │ Ngày tạo tài khaỏn │ Trạng thái │            Email           │   Số điện thoại   │\n" +
            "    ├────────┼───────────────────┼────────────────────┼────────────────────┼────────────┼────────────────────────────┼───────────────────┤";
    public static final String FONT_USER ="    │%5d   │ %-16s  │ %-19s│  %-18s│%-12s│ %-27s│ %-18s│\n";
    public static final String POINT_USer =
            "    └────────┴───────────────────┴────────────────────┴────────────────────┴────────────┴────────────────────────────┴───────────────────┘꧂";
}
