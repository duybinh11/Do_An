package Model;

public class Sach {
	private String ma_sach,ten_sach,tac_gia,nha_xb,the_loai;
	private int nam_xb,so_luong_sach;
	public Sach() {}
	
	

	public Sach(String ma_sach, String ten_sach, String tac_gia, String nha_xb, String the_loai,
			int so_luong_sach , int nam_xb) {
		super();
		this.ma_sach = ma_sach;
		this.ten_sach = ten_sach;
		this.tac_gia = tac_gia;
		this.nha_xb = nha_xb;
		this.the_loai = the_loai;
		this.nam_xb = nam_xb;
		this.so_luong_sach = so_luong_sach;
	}
	public String getMa_sach() {
		return ma_sach;
	}
	public void setMa_sach(String ma_sach) {
		this.ma_sach = ma_sach;
	}
	public String getTen_sach() {
		return ten_sach;
	}
	public void setTen_sach(String ten_sach) {
		this.ten_sach = ten_sach;
	}
	public String getTac_gia() {
		return tac_gia;
	}
	public void setTac_gia(String tac_gia) {
		this.tac_gia = tac_gia;
	} 
	public String getNha_xb() {
		return nha_xb;
	}
	public void setNha_xb(String nha_xb) {
		this.nha_xb = nha_xb;
	}
	public String getThe_loai() {
		return the_loai;
	}
	public void setThe_loai(String the_loai) {
		this.the_loai = the_loai;
	}
	public int getNam_xb() {
		return nam_xb;
	}
	public void setNam_xb(int nam_xb) {
		this.nam_xb = nam_xb;
	}
	public int getSo_luong_sach() {
		return so_luong_sach;
	}
	public void setSo_luong_sach(int so_luong_sach) {
		this.so_luong_sach = so_luong_sach;
	}
	@Override
	public String toString() {
		return "Sach [ma_sach=" + ma_sach + ", ten_sach=" + ten_sach + ", tac_gia=" + tac_gia + ", nha_xb=" + nha_xb
				+ ", the_loai=" + the_loai + ", nam_xb=" + nam_xb + ", so_luong_sach=" + so_luong_sach + "]";
	}
	
}
