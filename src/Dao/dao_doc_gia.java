package Dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.sql;
import Model.doc_gia;

public class dao_doc_gia implements dao_interface<doc_gia> {

	public static dao_doc_gia instance() {
		return new dao_doc_gia();
	}
	@Override
	public void insert(doc_gia t) {
		Connection conn =sql.ket_noi();
		try {
			java.sql.Statement st = conn.createStatement();
			String sql = "insert into doc_gia\r\n"
					+ "values ('"+t.getMa_doc_gia()+"',N'"+t.getTen_doc_gia()+"',N'"+t.getTen_sach_muon()+"',N'"
					+t.getThoi_gia()+"',N'"+t.getGioi_tinh()+"',"+t.getSo_luong_sach_muon()+")";
			int check=st.executeUpdate(sql);
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
			String sql ="delete from doc_gia where ma_doc_gia = '"+value+"'";
			int check =st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
		
	}

	@Override
	public void fix(doc_gia t,String value) {
			
	}
	@Override
	public ArrayList<doc_gia> get_data(String tuan) {
		Connection conn =sql.ket_noi();
		ArrayList<doc_gia> list =new ArrayList<>();
		try {
			java.sql.Statement st = conn.createStatement();
			String sql ="select * from doc_gia where thoi_gian = N'"+tuan+"' ORDER BY ma_doc_gia";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String ma_dg = rs.getString("ma_doc_gia");
				String ten = rs.getString("ten_doc_gia");
				String sach_muon = rs.getString("sach_muon");
				String thoi_gian = rs.getString("thoi_gian");
				String gioi_tinh = rs.getString("gioi_tinh");
				int so_luong = rs.getInt("so_luong_muon");
				list.add(new doc_gia(ma_dg, ten, sach_muon, thoi_gian, gioi_tinh, so_luong));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
		return list;
	}
	public void update_muon_tra(String ma_dg ,String sach ,String thoi_gian,int so_luong) {
		Connection conn = sql.ket_noi();
		try {
			java.sql.Statement st = conn.createStatement();
			String sql ="UPDATE doc_gia\r\n"
					+ "SET sach_muon=N'"+sach+"',so_luong_muon="+so_luong+"\r\n"
					+ "WHERE ma_doc_gia = '"+ma_dg+"' and thoi_gian =N'"+thoi_gian+"'";
			int check = st.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
	}
	public ArrayList<doc_gia> get_data_all() {
		Connection conn =sql.ket_noi();
		ArrayList<doc_gia> list =new ArrayList<>();
		try {
			java.sql.Statement st = conn.createStatement();
			String sql ="select * from doc_gia ";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String ma_dg = rs.getString("ma_doc_gia");
				String ten = rs.getString("ten_doc_gia");
				String sach_muon = rs.getString("sach_muon");
				String thoi_gian = rs.getString("thoi_gian");
				String gioi_tinh = rs.getString("gioi_tinh");
				int so_luong = rs.getInt("so_luong_muon");
				list.add(new doc_gia(ma_dg, ten, sach_muon, thoi_gian, gioi_tinh, so_luong));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
		return list;
	}

}
