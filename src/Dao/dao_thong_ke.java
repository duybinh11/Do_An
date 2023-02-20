package Dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.sql;

public class dao_thong_ke {
	public static dao_thong_ke instance() {
		return new dao_thong_ke();
	}
	public String get_data_thong_ke(String tuan){
		String c="";
		Connection conn = sql.ket_noi();
		try {
			java.sql.Statement st = conn.createStatement();
			String sql ="select sach_muon from doc_gia where thoi_gian =N'"+tuan+"'";
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()) {
				c+=rs.getString("sach_muon")+",";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
		return c;
	}
	public int get_so_luong(String tuan) {
		Connection conn = sql.ket_noi();
		int so=0;
		try {
			java.sql.Statement st = conn.createStatement();
			String sql = "select sum(so_luong_muon) as 'tong_so_luong_muon' from doc_gia where thoi_gian =N'"+tuan+"'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				so=rs.getInt("tong_so_luong_muon");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sql.close(conn);
		return so;
	}
}
