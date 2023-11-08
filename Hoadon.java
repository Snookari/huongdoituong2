
public class Hoadon extends SanPham implements MyInterface {

    private SanPham sanPham;
    private int soLuong;

    public Hoadon(SanPham sanPham, int soLuong) {

        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }


    @Override
    public int getId(){
        return sanPham.getId();
    }


    @Override
    public String getTenSanPham() {
        return sanPham.getTenSanPham();
    }

    @Override
    public double getGia() {
        return sanPham.getGia();
    }

    public double tinhTongTien() {
        return sanPham.getGia() * soLuong;
    }

    public void printout() {
        System.out.println("Tên sản phẩm: " + sanPham.getTenSanPham());
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Tổng tiền: " + tinhTongTien());
    }
}