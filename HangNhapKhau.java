public class HangNhapKhau extends SanPham {
    private String xuatXu;

    public HangNhapKhau(int id, String tenSanPham, double gia, int soLuong, String xuatXu) {
        super(id, tenSanPham, gia, soLuong);
        this.xuatXu = xuatXu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    @Override
    public void printout() {
        super.printout();  // Gọi phương thức in thông tin của lớp cha
        System.out.println("Xuất xứ: " + xuatXu);
    }
}
