import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class KhachHang extends MyAbstractClass{
    private String id;
    private String name;
    private String email;
    private String phone;
    private static int balance;
    public String getId() {
        return id;
    }
    public String getName() {return name;}
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public Integer getBalance(){return balance;}
    private void changeBalance(int change) {
        balance += change;
    }
    private void baomat(){

    }

    public static void BankAccount(){

        try {
            // Establish a database connection
            Connection connection = null;
            connection = DatabaseConnection.getConnection();

            // Prepare and execute SQL query
            String query = "SELECT * FROM khachhang";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("ho_ten");
                int balance = resultSet.getInt("so_du");

            }

            resultSet.close();
            statement.close();
            connection.close();



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    /* public static boolean LuuKhachHang(int CustomerId , String CustomerName, int CustomerBalance) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập id khach hang : ");
            int CustomerId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nhập ten khach hang: ");
            String CustomerName = scanner.nextLine();

            System.out.print("Nhập so du khach hang : ");
            int CustomerBalance = scanner.nextInt();

        try {
            Connection connection = null;
            connection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO khachhang (id, ho_ten, so_du) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, CustomerId);
            preparedStatement.setString(2, CustomerName);
            preparedStatement.setInt(3, CustomerBalance);

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

            return rowsAffected > 0; // Trả về true nếu có dòng bị ảnh hưởng (dữ liệu đã được thêm)

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } */
}
