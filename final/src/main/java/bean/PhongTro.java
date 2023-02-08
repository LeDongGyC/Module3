package bean;

public class PhongTro {
    private int id;
    private String name;
    private String phone;
    private String ngayThue;
    private HinhThuc hinhThuc;
    private String ghiChu;

    public PhongTro() {
    }

    public PhongTro(int id, String name, String phone, String ngayThue, HinhThuc hinhThuc, String ghiChu) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.ngayThue = ngayThue;
        this.hinhThuc = hinhThuc;
        this.ghiChu = ghiChu;
    }

    public PhongTro(String name, String phone, String ngayThue, HinhThuc hinhThuc) {
        this.name = name;
        this.phone = phone;
        this.ngayThue = ngayThue;
        this.hinhThuc = hinhThuc;
    }

    public PhongTro(String name, String phone, String ngayThue, HinhThuc hinhThuc, String ghiChu) {
        this.name = name;
        this.phone = phone;
        this.ngayThue = ngayThue;
        this.hinhThuc = hinhThuc;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(String ngayThue) {
        this.ngayThue = ngayThue;
    }

    public HinhThuc getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(HinhThuc hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
