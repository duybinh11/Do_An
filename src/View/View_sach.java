package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.dao_doc_gia;
import Dao.dao_sach;
import Model.Sach;
import Model.Thong_ke;
import Model.doc_gia;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class View_sach extends JPanel {
	public static ArrayList<Sach> list_sach;
	private JTextField txt_ma_sach;
	private JTextField txt_ten_sach;
	private JTextField txt_nha_xb;
	private JTextField txt_tac_gia;
	private JTextField txt_namxb;
	private JTextField txt_so_luong_sach;
	private static JTable table_sach;
	private JComboBox txt_the_loai;
	private JPanel jp_sach;
	private JTextField txt_text;
	public View_sach() {
		setLayout(null);
		
		jp_sach = new JPanel();
		jp_sach.setLayout(null);
		jp_sach.setBorder(new EmptyBorder(0, 0, 0, 0));
		jp_sach.setBounds(0, 0, 1129, 543);
		add(jp_sach);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(138, 197, 255));
		panel.setBounds(10, 30, 307, 483);
		jp_sach.add(panel);
		
		JLabel lblNewLabel = new JLabel("Mã Sách ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 10, 137, 34);
		panel.add(lblNewLabel);
		
		txt_ma_sach = new JTextField();
		txt_ma_sach.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_ma_sach.setColumns(10);
		txt_ma_sach.setBounds(146, 10, 151, 34);
		panel.add(txt_ma_sach);
		
		txt_ten_sach = new JTextField();
		txt_ten_sach.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_ten_sach.setColumns(10);
		txt_ten_sach.setBounds(146, 50, 151, 34);
		panel.add(txt_ten_sach);
		
		JLabel te = new JLabel("Tên Sách ");
		te.setFont(new Font("Dialog", Font.BOLD, 16));
		te.setBounds(10, 50, 137, 34);
		panel.add(te);
		
		txt_nha_xb = new JTextField();
		txt_nha_xb.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_nha_xb.setColumns(10);
		txt_nha_xb.setBounds(146, 130, 151, 34);
		panel.add(txt_nha_xb);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhà Xuất Bản ");
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 130, 137, 34);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblTcGi = new JLabel("Tác Giả ");
		lblTcGi.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTcGi.setBounds(10, 90, 137, 34);
		panel.add(lblTcGi);
		
		txt_tac_gia = new JTextField();
		txt_tac_gia.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_tac_gia.setColumns(10);
		txt_tac_gia.setBounds(146, 90, 151, 34);
		panel.add(txt_tac_gia);
		
		JLabel lblNewLabel_2_1 = new JLabel("Thể Loại");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(10, 259, 137, 34);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("Thêm")) {
					insert_sach();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setBounds(10, 306, 90, 68);
		panel.add(btnNewButton);
		
		JButton btnXa = new JButton("Sữa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("Sữa")) {
					fix_sach();
				}
			}
		});
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXa.setBackground(new Color(0, 128, 255));
		btnXa.setBounds(212, 306, 85, 68);
		panel.add(btnXa);
		
		JComboBox txt_title_tra_cuu = new JComboBox();
		txt_title_tra_cuu.setModel(new DefaultComboBoxModel(new String[] {"Tất Cả", "Tên Sách", "Thể Loại", "Tác Giả", "Nhà Xuất Bản"}));
		txt_title_tra_cuu.setFont(new Font("Dialog", Font.BOLD, 15));
		txt_title_tra_cuu.setBounds(8, 409, 121, 26);
		panel.add(txt_title_tra_cuu);
		
		JLabel lblNewLabel_1 = new JLabel("TRA CỨU");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(110, 377, 90, 34);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = (String) txt_title_tra_cuu.getSelectedItem();
				String text = txt_text.getText();
				if(title.equals("Tất Cả")) {
					load_data_sach();
				}else {
					tra_cuu(title, text);
					txt_text.setText("");
				}
				
			}
		});
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.setBounds(110, 447, 85, 26);
		panel.add(btnNewButton_1);
		
		JLabel txt_nam_xb_1 = new JLabel("Năm Xuất Bản ");
		txt_nam_xb_1.setFont(new Font("Dialog", Font.BOLD, 16));
		txt_nam_xb_1.setBounds(10, 174, 137, 34);
		panel.add(txt_nam_xb_1);
		
		txt_namxb = new JTextField();
		txt_namxb.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_namxb.setColumns(10);
		txt_namxb.setBounds(146, 174, 151, 34);
		panel.add(txt_namxb);
		
		JLabel txt_nam_xb = new JLabel("Số Lượng Sách");
		txt_nam_xb.setFont(new Font("Dialog", Font.BOLD, 16));
		txt_nam_xb.setBounds(10, 215, 137, 34);
		panel.add(txt_nam_xb);
		
		txt_so_luong_sach = new JTextField();
		txt_so_luong_sach.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_so_luong_sach.setColumns(10);
		txt_so_luong_sach.setBounds(146, 215, 151, 34);
		panel.add(txt_so_luong_sach);
		
		JButton btnXa_1 = new JButton("Xóa");
		btnXa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("Xóa")) {
					delete_sach();
					reset();
				}
			}
		});
		btnXa_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXa_1.setBackground(new Color(0, 128, 255));
		btnXa_1.setBounds(110, 306, 90, 68);
		panel.add(btnXa_1);
		
		txt_text = new JTextField();
		txt_text.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_text.setColumns(10);
		txt_text.setBounds(146, 409, 151, 26);
		panel.add(txt_text);
		
		txt_the_loai = new JComboBox();
		txt_the_loai.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_the_loai.setModel(new DefaultComboBoxModel(new String[] {"Truyện Tranh", "Khoa Học", "Thể Thao", "Văn Học", "Lập Trình", "Báo Chí"}));
		txt_the_loai.setBounds(146, 262, 151, 34);
		panel.add(txt_the_loai);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(new Color(138, 197, 255));
		panel_1.setBounds(327, 30, 792, 483);
		jp_sach.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 772, 463);
		panel_1.add(scrollPane);
		
		table_sach = new JTable();
		table_sach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_sach.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "T\u00E1c Gi\u1EA3", "Nh\u00E0 Xu\u1EA5t B\u1EA3n", "Th\u1EC3 Lo\u1EA1i", "S\u1ED1 L\u01B0\u1EE3ng", "N\u0103m Xu\u1EA5t B\u1EA3n"
			}
		));
		scrollPane.setViewportView(table_sach);
		table_sach.setRowHeight(20);
		
		
		table_sach.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table =(JTable) mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 1 ) {
					Sach sach = list_sach.get(row);
					hien_thi_sach(sach);
				}
			}
		});
		
		load_data_sach();
	}
	public static void load_data_sach() {
		list_sach = dao_sach.instance().get_data("");
		DefaultTableModel dtb = (DefaultTableModel) table_sach.getModel();
		dtb.setRowCount(0);
		for(int i=0;i<list_sach.size();i++) {
			dtb.addRow(new Object[] {list_sach.get(i).getMa_sach(),list_sach.get(i).getTen_sach(),list_sach.get(i).getTac_gia(),
					list_sach.get(i).getNha_xb(),list_sach.get(i).getThe_loai(),list_sach.get(i).getSo_luong_sach(),list_sach.get(i).getNam_xb()});
		}
	}
	public Sach get_infor_sach() {
		String ma_sach = txt_ma_sach.getText();
		String ten = txt_ten_sach.getText();
		String tac_gia = txt_tac_gia.getText();
		String nha_xb = txt_nha_xb.getText();
		String the_loai = (String) txt_the_loai.getSelectedItem();
		int so_luong = Integer.valueOf(txt_so_luong_sach.getText());
		int nam_xb = Integer.valueOf(txt_namxb.getText());
		return new Sach(ma_sach, ten, tac_gia, nha_xb, the_loai, so_luong, nam_xb);
	} 
	public void hien_thi_sach(Sach sach) {
		txt_ma_sach.setText(sach.getMa_sach());
		txt_ten_sach.setText(sach.getTen_sach());
		txt_tac_gia.setText(sach.getTac_gia());
		txt_nha_xb.setText(sach.getNha_xb());
		txt_the_loai.setSelectedItem(sach.getThe_loai());
		txt_so_luong_sach.setText(String.valueOf(sach.getSo_luong_sach()));
		txt_namxb.setText(String.valueOf(sach.getNam_xb()));
	}
	public void reset() {
		txt_ma_sach.setText("");
		txt_ten_sach.setText("");
		txt_tac_gia.setText("");
		txt_nha_xb.setText("");
		txt_namxb.setText("");
		txt_so_luong_sach.setText("");
		txt_the_loai.setSelectedItem("Truyện Tranh");
	}
	//them sach
	public void insert_sach() {
		if(txt_ma_sach.getText().equals("") || txt_ten_sach.getText().equals("") || 
			txt_nha_xb.getText().equals("") || txt_namxb.getText().equals("") || txt_so_luong_sach.getText().equals("") ) {
			JOptionPane.showMessageDialog(View.contentPane,"NHẬP ĐẦY ĐỦ THÔNG TIN", "Thông Báo", JOptionPane.ERROR_MESSAGE);
		}else if(Integer.valueOf(txt_so_luong_sach.getText())<0) {
			JOptionPane.showMessageDialog(View.contentPane,"VUI LÒNG NHẬP SỐ LƯỢNG >= 0", "Thông Báo", JOptionPane.ERROR_MESSAGE);
		}
		else {
			dao_sach.instance().insert(get_infor_sach());
			load_data_sach();
			JOptionPane.showMessageDialog(View.contentPane,"THÊM SÁCH THÀNH CÔNG", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
			reset();
		}
	}
	public void delete_sach() {
		ArrayList<doc_gia> list_doc_gia_all = dao_doc_gia.instance().get_data_all(); //lay  tat ca doc gia
		int row=-1;
		row=table_sach.getSelectedRow();
		if(row>=0 && row <=list_sach.size()) {
			for(int i=0;i<list_doc_gia_all.size();i++) {
				// xoa sách mượn của đọc giả . duyệt từng đọc giả để xóa sách 
				View_doc_gia.tra_sach(list_doc_gia_all.get(i).getTen_doc_gia(),list_sach.get(row).getTen_sach(),list_doc_gia_all.get(i).getThoi_gia());
			}
			dao_sach.instance().delete(list_sach.get(row).getMa_sach());
			load_data_sach();
		}else { 
			JOptionPane.showMessageDialog(View.contentPane,"Chọn Đối Tượng Để Xóa", "Thông Báo", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public void fix_sach() {
		String ma_sach=null;
		int row=-1;
		row=table_sach.getSelectedRow();
		if(row>=0 && row <=list_sach.size()) {
			ma_sach = list_sach.get(row).getMa_sach();
			if(txt_ma_sach.getText().equals("") || txt_ten_sach.getText().equals("") || 
					txt_nha_xb.getText().equals("") || txt_namxb.getText().equals("") || txt_so_luong_sach.getText().equals("") ) {
					JOptionPane.showMessageDialog(View.contentPane,"NHẬP ĐẦY ĐỦ THÔNG TIN", "Thông Báo", JOptionPane.ERROR_MESSAGE);
			}else {
				Sach sach =get_infor_sach();
				dao_sach.instance().fix(sach, ma_sach);
				load_data_sach();
				JOptionPane.showMessageDialog(View.contentPane,"SỬA SÁCH THÀNH CÔNG", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
				reset();
			}
		}else {
			JOptionPane.showMessageDialog(View.contentPane,"CHỌN ĐỐI TƯỢNG ĐỂ SỬA", "Thông Báo", JOptionPane.ERROR_MESSAGE);
		}	
	}
	public void tra_cuu(String title ,String text) {
		ArrayList<Sach> list_tra_cuu = dao_sach.instance().tra_cuu_sach(title, text);
		DefaultTableModel dtb = (DefaultTableModel) table_sach.getModel();
		dtb.setRowCount(0);
		for(int i=0;i<list_tra_cuu.size();i++) {
			dtb.addRow(new Object[] {list_tra_cuu.get(i).getMa_sach(),list_tra_cuu.get(i).getTen_sach(),list_tra_cuu.get(i).getTac_gia(),
					list_tra_cuu.get(i).getNha_xb(),list_tra_cuu.get(i).getNam_xb(),list_tra_cuu.get(i).getThe_loai(),list_tra_cuu.get(i).getSo_luong_sach()});
		}
	}
}
