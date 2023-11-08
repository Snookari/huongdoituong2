import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


public class SanPham extends MyAbstractClass implements MyInterface  {
    private int id;
    private String tenSanPham;
    private double gia;

    private int soLuong;

    public SanPham(int id, String tenSanPham, double gia, int soLuong) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public SanPham() {

    }

    // Getter methods for fields
    public int getId() {
        return id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public double getGia() {
        return gia;
    }

    public int getSoLuong() {
        return soLuong;
    }


    public static  List<SanPham> getAllSanPham()  {
        List<SanPham> sanPhamList = new ArrayList<>();


        try {
            // Establish a database connection
            Connection connection = null;
            connection = DatabaseConnection.getConnection();
            // Prepare and execute SQL query
            String query = "SELECT * FROM sanpham";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Process the query result and print product details
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenSanPham = resultSet.getString("ten_sanpham");
                double gia = resultSet.getDouble("gia");
                int soLuong = resultSet.getInt("so_luong");


                SanPham sanPham = new SanPham(id, tenSanPham, gia, soLuong);
                sanPhamList.add(sanPham);

            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return sanPhamList;
    }

    public static List<HangBanChay> getTop3HangBanChay() {
        List<SanPham> sanPhamList = getAllSanPham();

        // Sắp xếp danh sách sản phẩm theo số lượng giảm dần bằng SanPhamComparator
        sanPhamList.sort(new SanPhamComparator());

        // Tạo một danh sách mới để lưu trữ 3 sản phẩm bán chạy nhất dưới dạng các đối tượng HangBanChay
        List<HangBanChay> top3HangBanChay = new ArrayList<>();

        // Lặp qua danh sách đã sắp xếp và thêm 3 sản phẩm hàng đầu vào danh sách mới
        for (int i = 0; i < 3 && i < sanPhamList.size(); i++) {
            SanPham sanPham = sanPhamList.get(i);
            HangBanChay hangBanChay = new HangBanChay(sanPham.getId(), sanPham.getTenSanPham(), sanPham.getGia(), sanPham.getSoLuong());
            top3HangBanChay.add(hangBanChay);
        }

        return top3HangBanChay;
    }

    public static class SanPhamComparator implements Comparator<SanPham> {
        @Override
        public int compare(SanPham sp1, SanPham sp2) {
            return sp2.getSoLuong() - sp1.getSoLuong();
        }
    }

    @Override
    public void printout(){
        System.out.println("ID: " + id);
        System.out.println("Tên Sản Phẩm: " + tenSanPham);
        System.out.println("Giá: " + gia);
    }
}

