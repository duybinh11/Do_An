		package Model;

public class Thong_ke {
	private String ten_sach;
	private String thoi_gian;
	private int so_luong_muon;

	
	public Thong_ke() {}
	
	public Thong_ke(String ten_sach, String thoi_gian, int so_luong_muon) {
		super(); 
		this.ten_sach = ten_sach; 
		this.thoi_gian = thoi_gian;
		this.so_luong_muon = so_luong_muon;
	}

	public String getTen_sach() {
		return ten_sach;
	}

	public void setTen_sach(String ten_sach) {
		this.ten_sach = ten_sach;
	}

	public String getThoi_gian() {
		return thoi_gian;
	}

	public void setThoi_gian(String thoi_gian) {
		this.thoi_gian = thoi_gian;
	}

	public int getSo_luong_muon() {
		return so_luong_muon;
	}

	public void setSo_luong_muon(int so_luong_muon) {
		this.so_luong_muon = so_luong_muon;
	}


	@Override
	public String toString() {
		return "Thong_ke [ten_sach=" + ten_sach + ", thoi_gian=" + thoi_gian + ", so_luong_muon=" + so_luong_muon+ "]";
	}
	
	
}
