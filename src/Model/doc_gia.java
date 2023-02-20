package Model;

public class doc_gia {
	private String ma_doc_gia;
	private String ten_doc_gia;
	private String ten_sach_muon;
	private String thoi_gia;
	private String gioi_tinh;
	private int so_luong_sach_muon;
	public doc_gia() {}
	public doc_gia(String ma_doc_gia, String ten_doc_gia, String sach_muon_doc_gia, String thoi_gia, String gioi_tinh,
			int so_luong_sach_muon) {
		super();
		this.ma_doc_gia = ma_doc_gia;
		this.ten_doc_gia = ten_doc_gia;
		this.ten_sach_muon = sach_muon_doc_gia;
		this.thoi_gia = thoi_gia;
		this.gioi_tinh = gioi_tinh;
		this.so_luong_sach_muon = so_luong_sach_muon;
	}
	public String getMa_doc_gia() {
		return ma_doc_gia;
	}
	public void setMa_doc_gia(String ma_doc_gia) {
		this.ma_doc_gia = ma_doc_gia;
	}
	public String getTen_doc_gia() {
		return ten_doc_gia;
	}
	public void setTen_doc_gia(String ten_doc_gia) {
		this.ten_doc_gia = ten_doc_gia;
	}
	public String getThoi_gia() {
		return thoi_gia;
	}
	public void setThoi_gia(String thoi_gia) {
		this.thoi_gia = thoi_gia;
	}
	public String getGioi_tinh() {
		return gioi_tinh;
	}
	public String getTen_sach_muon() {
		return ten_sach_muon;
	}
	public void setTen_sach_muon(String ten_sach_muon) {
		this.ten_sach_muon = ten_sach_muon;
	}
	public void setGioi_tinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}
	public int getSo_luong_sach_muon() {
		return so_luong_sach_muon;
	}
	public void setSo_luong_sach_muon(int so_luong_sach_muon) {
		this.so_luong_sach_muon = so_luong_sach_muon;
	}
	@Override
	public String toString() {
		return "doc_gia [ma_doc_gia=" + ma_doc_gia + ", ten_doc_gia=" + ten_doc_gia + ", ten_sach_muon="
				+ ten_sach_muon + ", thoi_gia=" + thoi_gia + ", gioi_tinh=" + gioi_tinh + ", so_luong_sach_muon="
				+ so_luong_sach_muon + "]";
	}
	
	
}
