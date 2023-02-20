package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.ls.LSInput;

import Dao.dao_thong_ke;
import Model.Sach;
import Model.Thong_ke;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Label;

public class View_thong_ke extends JPanel {
	private ArrayList<Thong_ke> list_thong_ke;
	private JTable table_thong_ke;
	private JComboBox txt_tk_theo_tuan;
	private JLabel jl_so_luong;
	private JLabel jl_phan_tram;
	private Label jl_ten_sach;
	public View_thong_ke() { 
		setLayout(null); 
		JPanel jp_thong_ke = new JPanel();
		jp_thong_ke.setBounds(0, 0, 1129, 543);
		add(jp_thong_ke);
		jp_thong_ke.setLayout(null);
		
		txt_tk_theo_tuan = new JComboBox();
		txt_tk_theo_tuan.setFont(new Font("Tahoma", Font.BOLD, 25));
		txt_tk_theo_tuan.setModel(new DefaultComboBoxModel(new String[] {"Tuần 1", "Tuần 2", "Tuần 3"}));
		txt_tk_theo_tuan.setBounds(20, 10, 162, 48);
		jp_thong_ke.add(txt_tk_theo_tuan);
		
		JButton btnNewButton = new JButton("Thống Kê");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("Thống Kê")) {
					String tuan =(String) txt_tk_theo_tuan.getSelectedItem();
					if(tuan.equals("Tuần 1")) {
						load_data("Tuần 1");
						load_table(tuan);
					}else if(tuan.equals("Tuần 2")) {
						load_data("Tuần 2");
						load_table(tuan);
					}else {
						load_data("Tuần 3");
						load_table(tuan);
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(202, 10, 191, 53);
		jp_thong_ke.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(138, 197, 255));
		panel.setBounds(20, 98, 1099, 435);
		jp_thong_ke.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 452, 415);
		panel.add(scrollPane); 
		
		table_thong_ke = new JTable();
		table_thong_ke.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_thong_ke.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"T\u00EAn S\u00E1ch", "S\u1ED1 L\u01B0\u1EE3ng M\u01B0\u1EE3n", "% s\u00E1ch M\u01B0\u1EE3n"
			}
		));
		table_thong_ke.getColumnModel().getColumn(0).setPreferredWidth(128);
		table_thong_ke.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table_thong_ke);
		
				table_thong_ke.setRowHeight(20);
				
				JLabel lblNewLabel = new JLabel("Sách Được Quan Tâm Nhất Trong Tuần ");
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
				lblNewLabel.setBounds(472, 10, 617, 49);
				panel.add(lblNewLabel);
				
				JLabel lblNewLabel_1_1 = new JLabel("Số Lượng Mượn ");
				lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
				lblNewLabel_1_1.setBounds(472, 129, 230, 49);
				panel.add(lblNewLabel_1_1);
				
				jl_so_luong = new JLabel("");
				jl_so_luong.setForeground(new Color(255, 0, 0));
				jl_so_luong.setHorizontalAlignment(SwingConstants.LEFT);
				jl_so_luong.setFont(new Font("Tahoma", Font.BOLD, 22));
				jl_so_luong.setBounds(668, 129, 421, 49);
				panel.add(jl_so_luong);
				
				JLabel lblNewLabel_1_1_1 = new JLabel("Số % Mỗi Cuốn Sách Trong Tuần  ");
				lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
				lblNewLabel_1_1_1.setBounds(472, 272, 388, 49);
				panel.add(lblNewLabel_1_1_1);
				
				jl_phan_tram = new JLabel("");
				jl_phan_tram.setForeground(new Color(255, 0, 0));
				jl_phan_tram.setHorizontalAlignment(SwingConstants.LEFT);
				jl_phan_tram.setFont(new Font("Tahoma", Font.BOLD, 22));
				jl_phan_tram.setBounds(847, 272, 242, 49);
				panel.add(jl_phan_tram);
				
				JSeparator separator = new JSeparator();
				separator.setBounds(472, 272, 617, 25);
				panel.add(separator);
				
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(472, 129, 617, 25);
				panel.add(separator_1);
				
				JSeparator separator_1_1 = new JSeparator();
				separator_1_1.setBounds(472, 10, 617, 25);
				panel.add(separator_1_1);
				
				jl_ten_sach = new Label("");
				jl_ten_sach.setForeground(new Color(255, 0, 0));
				jl_ten_sach.setFont(new Font("Dialog", Font.PLAIN, 22));
				jl_ten_sach.setBounds(468, 49, 621, 49);
				panel.add(jl_ten_sach);
	}
	public void load_data(String tuan) {
		list_thong_ke=new ArrayList<>();
		String c = dao_thong_ke.instance().get_data_thong_ke(tuan); //lấy tất cả sách mà đọc giả mượn trong tuần qua
		int so_luong_muon =dao_thong_ke.instance().get_so_luong(tuan); //lấy số lượng tất cả sách mượn trong tuần qua
		if(so_luong_muon==0) {
			JOptionPane.showMessageDialog(View.contentPane,"KHÔNG CÓ AI MƯỢN SÁCH TRONG TUẦN "+tuan.toUpperCase(), "Thông Báo", JOptionPane.ERROR_MESSAGE);
		}else {
			String strNew = c.substring(0, c.length()-1); //xóa đi phần tử cuối cùng trong chuổi
			String mang_sach_muon [] = strNew.split(","); //tách chuổi vào mảng
			
			for(int i=0;i<View_sach.list_sach.size();i++) {
				int dem=0;
				for(int j=0;j<mang_sach_muon.length;j++) {
					if(View_sach.list_sach.get(i).getTen_sach().equals(mang_sach_muon[j])) {
						//cho 2 for chạy nếu mà list_sach = mang_sach_muon thì dem++
						dem++; 
					}
				}
				list_thong_ke.add(new Thong_ke(View_sach.list_sach.get(i).getTen_sach(),tuan, dem)); 
			}
		}
	}
	public void load_table(String tuan) {
		
		int so_luong_muon =dao_thong_ke.instance().get_so_luong(tuan);
		if(so_luong_muon>0) {
			DefaultTableModel dtb = (DefaultTableModel) table_thong_ke.getModel();
			dtb.setRowCount(0);
			int max =list_thong_ke.get(0).getSo_luong_muon();
			//đổ dữ liệu lên bảng
			for(int i=0;i<list_thong_ke.size();i++) {
				if(list_thong_ke.get(i).getThoi_gian().equals(tuan)) {
					float phantram = (float)list_thong_ke.get(i).getSo_luong_muon()*100/so_luong_muon;
					dtb.addRow(new Object[] {list_thong_ke.get(i).getTen_sach(),list_thong_ke.get(i).getSo_luong_muon(),phantram+"%"});
				}
				if(max<list_thong_ke.get(i).getSo_luong_muon()) {
					max=list_thong_ke.get(i).getSo_luong_muon(); // tìm giá trị max
				}
			}
			String ten_sach="";
			for(int i=0;i<list_thong_ke.size();i++) {
				if(max==list_thong_ke.get(i).getSo_luong_muon() && tuan.equals(list_thong_ke.get(i).getThoi_gian())) {
					ten_sach+=list_thong_ke.get(i).getTen_sach()+',';
				}
			}
			String str =ten_sach.substring(0,ten_sach.length()-1);
			jl_ten_sach.setText(str);
			float phantram = (float)max*100/so_luong_muon;
			jl_phan_tram.setText(String.valueOf(phantram));
			jl_so_luong.setText(String.valueOf(max));
		}
		
		
		
	}

}
