package Dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.sql;
import Model.Sach;

public class dao_sach implements dao_interface<Sach>{
	public static dao_sach instance() {
		return new dao_sach();
	}
	@Override
	public void insert(Sach t) {
		Connection conn =sql.ket_noi();
		try {
			java.sql.Statement st = conn.createStatement();
	
			String sql = "insert into sach\r\n"
					+ "values ('"+t.getMa_sach()+"',N'"+t.getTen_sach()+"',N'"+t.getTac_gia()+"',N'"
					+t.getNha_xb()+"',N'"+t.getThe_loai()+"',"+t.getSo_luong_sach()+","+t.getNam_xb()+")";
			int check =st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
	}

	@Override
	public void delete(String value) {
		Connection conn = sql.ket_noi();
		try {
			java.sql.Statement st = conn.createStatement();
			String sql ="delete from sach where ma_sach ='"+value+"'";
			int check= st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
	}

	@Override
	public void fix(Sach t, String value) {
		Connection conn = sql.ket_noi();
		try {
			java.sql.Statement st = conn.createStatement();
			String sql = "UPDATE sach\r\n"
					+ "SET ma_sach ='"+t.getMa_sach()+"' ,ten_sach =N'"+t.getTen_sach()+"',tac_gia =N'"+t.getTac_gia()+"',nha_xb = N'"+t.getNha_xb()+"',the_loai =N'"+t.getThe_loai()+"',\r\n"
					+ "so_luong_sach="+t.getSo_luong_sach()+",nam_xb="+t.getNam_xb()+"\r\n"
					+ "WHERE ma_sach ='"+value+"'";
			int check =st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
	}

	@Override
	public ArrayList<Sach> get_data(String value) {
		ArrayList<Sach> list =new ArrayList<>();
		Connection conn =sql.ket_noi();
		try {
			java.sql.Statement st =conn.createStatement();
			String sql ="select * from sach ORDER BY ma_sach";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String ma_sach = rs.getString("ma_sach");
				String ten = rs.getString("ten_sach");
				String tac_gia = rs.getString("tac_gia");
				String nha_xb = rs.getString("nha_xb");
				String the_loai = rs.getString("the_loai");
				int nam_xb = rs.getInt("nam_xb");
				int so_luong = rs.getInt("so_luong_sach");
				list.add(new Sach(ma_sach, ten, tac_gia, nha_xb, the_loai, so_luong, nam_xb));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
		return list;
	}
	public ArrayList<Sach> tra_cuu_sach(String title,String text) {
		ArrayList<Sach> list =new ArrayList<>();
		if(title.equals("Tên Sách")) {
			title = "ten_sach";
		}else if(title.equals("Tác Giả")) {
			title ="tac_gia";
		}else if(title.equals("Nhà Xuất Bản")) {
			title ="nha_xb";
		}else {
			title ="the_loai";
		}
		Connection conn = sql.ket_noi();
		try {
			java.sql.Statement st = conn.createStatement();
			String sql = "select * from sach where "+title+" = N'"+text+"'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String ma_sach = rs.getString("ma_sach");
				String ten = rs.getString("ten_sach");
				String tac_gia = rs.getString("tac_gia");
				String nha_xb = rs.getString("nha_xb");
				String the_loai = rs.getString("the_loai");
				int nam_xb = rs.getInt("nam_xb");
				int so_luong = rs.getInt("so_luong_sach");
				list.add(new Sach(ma_sach, ten, tac_gia, nha_xb, the_loai, so_luong, nam_xb));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
		return list;
	}
	public void muon_sach(String ten_sach) {
		Connection conn = sql.ket_noi();
		try {
			java.sql.Statement st = conn.createStatement();
			String sql ="UPDATE sach\r\n"
					+ "SET so_luong_sach = so_luong_sach-1\r\n"
					+ "WHERE ten_sach =N'"+ten_sach+"'";
			int check = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
	}
	public void tra_sach(String ten_sach) {
		Connection conn = sql.ket_noi();
		try {
			java.sql.Statement st = conn.createStatement();
			String sql ="UPDATE sach\r\n"
					+ "SET so_luong_sach = so_luong_sach+1\r\n"
					+ "WHERE ten_sach =N'"+ten_sach+"'";
			int check = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.close(conn);
	}

	
}
