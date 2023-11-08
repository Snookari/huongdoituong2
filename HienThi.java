import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HienThi {
    public static void showCustomerInformation() {
        // Thông tin kết nối đến cơ sở dữ liệu MySQL
        String jdbcURL = "jdbc:mysql://localhost:3306/cua_hang";
        String username = "root";
        String password = "choinhanh12";

        try {
            // Kết nối đến cơ sở dữ liệu MySQL
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Tạo câu truy vấn SQL
            String sqlQuery = "SELECT * FROM khachhang";

            // Tạo đối tượng Statement để thực hiện truy vấn
            Statement statement = connection.createStatement();

            // Thực hiện truy vấn SQL và lấy kết quả
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            // Tạo một JFrame (cửa sổ ứng dụng)
            JFrame frame = new JFrame("Thông Tin Khách Hàng");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Tạo một JPanel để chứa giao diện
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            // Tạo một JTextArea để hiển thị thông tin khách hàng
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);

            // In thông tin khách hàng lên màn hình
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String ten = resultSet.getString("ho_ten");
                String diaChi = resultSet.getString("dia_chi");


                System.out.println("ID: " + id);
                System.out.println("Tên cửa hàng: " + ten);
                System.out.println("Địa chỉ: " + diaChi);
                System.out.println("--------------");
                textArea.append("ID: " + id + "\n");
                textArea.append("Tên Khách Hàng: " + ten + "\n");
                textArea.append("Dia chi : " + diaChi + "\n");

            }


            // Thêm JTextArea vào JPanel
            panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

            // Thêm JPanel vào JFrame
            frame.add(panel);

            // Hiển thị cửa sổ ứng dụng
            frame.setVisible(true);

            // Đóng tài nguyên
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
