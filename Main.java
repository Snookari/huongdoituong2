import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize the scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Create a SanPham instance to fetch the product data
        SanPham sanPham = new SanPham();

        // Get the list of available products
        List<SanPham> sanPhamList = sanPham.getAllSanPham();

        // Display the available products
        System.out.println("Danh sách sản phẩm có sẵn:");
        for (SanPham product : sanPhamList) {
            System.out.println("ID: " + product.getId() + ", Tên sản phẩm: " + product.getTenSanPham() +
                    ", Giá: " + product.getGia() + ", Số lượng: " + product.getSoLuong());
        }

        List<HangBanChay> top3HangBanChay = SanPham.getTop3HangBanChay();

        // Display the information for the top 3 best-selling products
        System.out.println("Top 3 sản phẩm bán chạy:");
        for (HangBanChay product : top3HangBanChay) {
            System.out.println("ID: " + product.getId() + ", Tên sản phẩm: " + product.getTenSanPham() +
                    ", Giá: " + product.getGia() + ", Số lượng: " + product.getSoLuong());
        }


        // Ask the user to choose a product
        System.out.print("Nhập ID sản phẩm bạn muốn mua: ");
        int productId = scanner.nextInt();
        System.out.println("Nhập số lượng bạn muốn mua: ");
        int quantity = scanner.nextInt();

        SanPham selectedProduct = null;
        boolean productFound = false;

        for (SanPham product : sanPhamList) {
            if (product.getId() == productId) {
                selectedProduct = product;
                productFound = true;
                break;
            }
        }

        if (productFound) {
            // Kiểm tra tính hợp lệ của số lượng và thực hiện thêm sản phẩm vào giỏ hàng
            if (quantity > 0) {
                // Thực hiện thêm sản phẩm vào giỏ hàng
                // selectedProduct có thông tin sản phẩm bạn có thể sử dụng
            } else {
                System.out.println("Số lượng không hợp lệ. Vui lòng nhập số lượng lớn hơn 0.");
            }
        } else {
            System.out.println("Sản phẩm không tồn tại. Vui lòng kiểm tra lại ID sản phẩm.");
        }

        if (selectedProduct != null) {
            System.out.println("Hoa don cua ban la ");
            selectedProduct.printout();
            System.out.println("Tong gia thanh bang "+quantity*selectedProduct.getGia());

        } else {
            System.out.println("Sản phẩm không tồn tại.");
        }


        scanner.close();
    }
}

