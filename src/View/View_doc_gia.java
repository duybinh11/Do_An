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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.dao_doc_gia;
import Dao.dao_sach;
import Model.doc_gia;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class View_doc_gia extends JPanel {
	private JTextField txt_ma_dg;
	private JTextField txt_ten_dg;
	private JTextField txt_ten_sach_muon;
	private JTextField txt_mt_ten_sach;
	private JTextField txt_mt_ma_dg;
	private static JTable table_tuan_1;
	private static JTable table_tuan_2;
	private static JTable table_tuan_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox txt_thoi_gian_muon;
	private static ArrayList<doc_gia> list_doc_gia1;
	private static ArrayList<doc_gia> list_doc_gia2;
	private static ArrayList<doc_gia> list_doc_gia3;
	private JRadioButton dg_nam;
	private JRadioButton dg_nu;
	private static JComboBox txt_mt_thoi_gia_muon_tra;
	/**
	 * Create the panel.
	 */
	public View_doc_gia() {
		setLayout(null);
		
		JPanel jp_doc_gia = new JPanel();
		jp_doc_gia.setLayout(null);
		jp_doc_gia.setBounds(0, 0, 1129, 543);
		add(jp_doc_gia);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(new Color(138, 197, 255));
		panel_2.setBounds(10, 30, 307, 483);
		jp_doc_gia.add(panel_2);
		panel_2.setLayout(null);
		
		JTabbedPane doc_gia = new JTabbedPane(JTabbedPane.TOP);
		doc_gia.setBounds(10, 10, 287, 463);
		panel_2.add(doc_gia);
		
		JPanel jp_thong_tin_doc_gia = new JPanel();
		jp_thong_tin_doc_gia.setLayout(null);
		doc_gia.addTab("Th??ng Tin ?????c Gi???", null, jp_thong_tin_doc_gia, null);
		
		JLabel lblNewLabel_2 = new JLabel("M?? ?????c Gi??? ");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_2.setBounds(10, 10, 126, 34);
		jp_thong_tin_doc_gia.add(lblNewLabel_2);
		
		txt_ma_dg = new JTextField();
		txt_ma_dg.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_ma_dg.setColumns(10);
		txt_ma_dg.setBounds(135, 10, 137, 34);
		jp_thong_tin_doc_gia.add(txt_ma_dg);
		
		JButton btnXa_1_1 = new JButton("X??a");
		btnXa_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("X??a")) {
					delete_doc_gia(get_infor_doc_gia().getMa_doc_gia());
					load_theo_tuan(get_infor_doc_gia().getThoi_gia());
				}
			}
		});
		btnXa_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXa_1_1.setBackground(new Color(0, 128, 255));
		btnXa_1_1.setBounds(10, 271, 197, 43);
		jp_thong_tin_doc_gia.add(btnXa_1_1);
		
		JButton btnNewButton_2 = new JButton("Th??m");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("Th??m")) {
					insert_doc_gia(get_infor_doc_gia());
				}
			}
		});
	
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBackground(new Color(0, 128, 255));
		btnNewButton_2.setBounds(10, 218, 197, 43);
		jp_thong_tin_doc_gia.add(btnNewButton_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("T??n ?????c Gi???");
		lblNewLabel_2_2.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_2_2.setBounds(10, 52, 126, 34);
		jp_thong_tin_doc_gia.add(lblNewLabel_2_2);
		
		txt_ten_dg = new JTextField(); 
		txt_ten_dg.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_ten_dg.setColumns(10);
		txt_ten_dg.setBounds(135, 52, 137, 34);
		jp_thong_tin_doc_gia.add(txt_ten_dg);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("S??ch M?????n");
		lblNewLabel_2_2_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_2_2_1.setBounds(10, 94, 126, 34);
		jp_thong_tin_doc_gia.add(lblNewLabel_2_2_1);
		
		txt_ten_sach_muon = new JTextField();
		txt_ten_sach_muon.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_ten_sach_muon.setColumns(10);
		txt_ten_sach_muon.setBounds(135, 94, 137, 34);
		jp_thong_tin_doc_gia.add(txt_ten_sach_muon);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Th???i Gian ");
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(10, 135, 137, 34);
		jp_thong_tin_doc_gia.add(lblNewLabel_1_1_1);
		
		txt_thoi_gian_muon = new JComboBox();
		txt_thoi_gian_muon.setModel(new DefaultComboBoxModel(new String[] {"Tu???n 1", "Tu???n 2", "Tu???n 3"}));
		txt_thoi_gian_muon.setFont(new Font("Dialog", Font.BOLD, 15));
		txt_thoi_gian_muon.setBounds(135, 135, 137, 34);
		jp_thong_tin_doc_gia.add(txt_thoi_gian_muon);
		
		dg_nam = new JRadioButton("Nam");
		buttonGroup.add(dg_nam);
		dg_nam.setFont(new Font("Tahoma", Font.BOLD, 15));
		dg_nam.setBounds(135, 179, 72, 34);
		jp_thong_tin_doc_gia.add(dg_nam);
		
		dg_nu = new JRadioButton("N???");
		buttonGroup.add(dg_nu);
		dg_nu.setFont(new Font("Tahoma", Font.BOLD, 15));
		dg_nu.setBounds(209, 179, 63, 34);
		jp_thong_tin_doc_gia.add(dg_nu);
		
		JLabel lblTcGi_1_1 = new JLabel("Gi???i T??nh :");
		lblTcGi_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTcGi_1_1.setBounds(10, 179, 137, 34);
		jp_thong_tin_doc_gia.add(lblTcGi_1_1);
		
		JPanel jp_muon_tra_sach = new JPanel();
		jp_muon_tra_sach.setLayout(null);
		doc_gia.addTab("M?????n Tr??? S??ch", null, jp_muon_tra_sach, null);
		
		txt_mt_ten_sach = new JTextField();
		txt_mt_ten_sach.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_mt_ten_sach.setColumns(10);
		txt_mt_ten_sach.setBounds(135, 52, 137, 34);
		jp_muon_tra_sach.add(txt_mt_ten_sach);
		
		JLabel lblNewLabel_2_3 = new JLabel("M?? ?????c Gi???");
		lblNewLabel_2_3.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_2_3.setBounds(10, 10, 126, 34);
		jp_muon_tra_sach.add(lblNewLabel_2_3);
		
		txt_mt_ma_dg = new JTextField();
		txt_mt_ma_dg.setFont(new Font("Dialog", Font.PLAIN, 15));
		txt_mt_ma_dg.setColumns(10);
		txt_mt_ma_dg.setBounds(135, 10, 137, 34);
		jp_muon_tra_sach.add(txt_mt_ma_dg);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("T??n S??ch");
		lblNewLabel_2_2_1_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel_2_2_1_1.setBounds(10, 52, 126, 34);
		jp_muon_tra_sach.add(lblNewLabel_2_2_1_1);
		
		txt_mt_thoi_gia_muon_tra = new JComboBox();
		txt_mt_thoi_gia_muon_tra.setModel(new DefaultComboBoxModel(new String[] {"Tu???n 1", "Tu???n 2", "Tu???n 3"}));
		txt_mt_thoi_gia_muon_tra.setFont(new Font("Dialog", Font.BOLD, 15));
		txt_mt_thoi_gia_muon_tra.setBounds(135, 93, 137, 34);
		jp_muon_tra_sach.add(txt_mt_thoi_gia_muon_tra);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Th???i Gian");
		lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 93, 137, 34);
		jp_muon_tra_sach.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton_3 = new JButton("M?????n S??ch");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("M?????n S??ch")) {
					String ma_dg=txt_mt_ma_dg.getText();
					String mt_ten_sach =txt_mt_ten_sach.getText();
					String thoi_gian = (String) txt_mt_thoi_gia_muon_tra.getSelectedItem();
					muon_sach(ma_dg,mt_ten_sach,thoi_gian);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBackground(new Color(0, 128, 255));
		btnNewButton_3.setBounds(10, 174, 126, 34);
		jp_muon_tra_sach.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Tr??? S??ch");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(cmd.equals("Tr??? S??ch")) {
					String ma_dg = txt_mt_ma_dg.getText();
					String sach_tra_1 = txt_mt_ten_sach.getText();
					String thoi_gian = (String) txt_mt_thoi_gia_muon_tra.getSelectedItem();
					tra_sach(ma_dg,sach_tra_1,thoi_gian);
				}
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3_1.setBackground(new Color(0, 128, 255));
		btnNewButton_3_1.setBounds(146, 174, 126, 34);
		jp_muon_tra_sach.add(btnNewButton_3_1);
		
		JPanel jp_tuan = new JPanel();
		jp_tuan.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jp_tuan.setBackground(new Color(138, 197, 255));
		jp_tuan.setBounds(327, 30, 792, 483);
		jp_doc_gia.add(jp_tuan);
		jp_tuan.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 772, 463);
		jp_tuan.add(tabbedPane);
		
		JPanel jp_tuan1 = new JPanel();
		jp_tuan1.setLayout(null);
		tabbedPane.addTab("Tu???n 1", null, jp_tuan1, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 747, 416);
		jp_tuan1.add(scrollPane_1);
		
		table_tuan_1 = new JTable();
		table_tuan_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_tuan_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 \u0110\u1ECDc Gi\u1EA3", "T\u00EAn \u0110\u1ECDc Gi\u1EA3", "S\u00E1ch M\u01B0\u1EE3n", "Th\u1EDDi Gian M\u01B0\u1EE3n", "Gi\u1EDBi T\u00EDnh", "S\u1ED1 L\u01B0\u1EE3ng"
			}
		));
		table_tuan_1.getColumnModel().getColumn(0).setPreferredWidth(62);
		table_tuan_1.getColumnModel().getColumn(1).setPreferredWidth(120);
		table_tuan_1.getColumnModel().getColumn(2).setPreferredWidth(140);
		table_tuan_1.getColumnModel().getColumn(3).setPreferredWidth(85);
		table_tuan_1.getColumnModel().getColumn(4).setPreferredWidth(55);
		table_tuan_1.getColumnModel().getColumn(5).setPreferredWidth(54);
		scrollPane_1.setViewportView(table_tuan_1);
		
		JPanel jp_tuan2 = new JPanel();
		jp_tuan2.setLayout(null);
		tabbedPane.addTab("Tu???n 2", null, jp_tuan2, null);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 10, 747, 416);
		jp_tuan2.add(scrollPane_1_1);
		
		table_tuan_2 = new JTable();
		table_tuan_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_tuan_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 \u0110\u1ECDc Gi\u1EA3", "T\u00EAn \u0110\u1ECDc Gi\u1EA3", "S\u00E1ch M\u01B0\u1EE3n", "Th\u1EDDi Gian", "Gi\u1EDBi T\u00EDnh", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		table_tuan_2.getColumnModel().getColumn(0).setPreferredWidth(62);
		table_tuan_2.getColumnModel().getColumn(1).setPreferredWidth(120);
		table_tuan_2.getColumnModel().getColumn(2).setPreferredWidth(140);
		table_tuan_2.getColumnModel().getColumn(3).setPreferredWidth(56);
		table_tuan_2.getColumnModel().getColumn(4).setPreferredWidth(54);
		table_tuan_2.getColumnModel().getColumn(5).setPreferredWidth(51);
		scrollPane_1_1.setViewportView(table_tuan_2);
		
		JPanel jp_tuan3 = new JPanel();
		jp_tuan3.setLayout(null);
		tabbedPane.addTab("Tu???n 3", null, jp_tuan3, null);
		
		JScrollPane scrollPane_1_2 = new JScrollPane();
		scrollPane_1_2.setBounds(10, 10, 747, 416);
		jp_tuan3.add(scrollPane_1_2);
		
		table_tuan_3 = new JTable();
		table_tuan_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_tuan_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 \u0110\u1ECDc Gi\u1EA3", "T\u00EAn \u0110\u1ECDc Gi\u1EA3", "S\u00E1ch M\u01B0\u1EE3n", "Th\u1EDDi Gian", "Gi\u1EDBi T\u00EDnh", "S\u1ED1 L\u01B0\u1EE3ng"
			}
		));
		table_tuan_3.getColumnModel().getColumn(0).setPreferredWidth(64);
		table_tuan_3.getColumnModel().getColumn(1).setPreferredWidth(120);
		table_tuan_3.getColumnModel().getColumn(2).setPreferredWidth(140);
		table_tuan_3.getColumnModel().getColumn(3).setPreferredWidth(53);
		table_tuan_3.getColumnModel().getColumn(4).setPreferredWidth(50);
		table_tuan_3.getColumnModel().getColumn(5).setPreferredWidth(54);
		scrollPane_1_2.setViewportView(table_tuan_3);
		table_tuan_1.setRowHeight(20);
		table_tuan_2.setRowHeight(20);
		table_tuan_3.setRowHeight(20);
		
		table_tuan_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table =(JTable) mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 1 ) {
					hien_thi_doc_gia(list_doc_gia1.get(row));
				}
			}
		});
		table_tuan_2.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table =(JTable) mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 1 ) {
					hien_thi_doc_gia(list_doc_gia2.get(row));
				}
			}
		});
		table_tuan_3.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table =(JTable) mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 1 ) {
					hien_thi_doc_gia(list_doc_gia3.get(row));
				}
			}
		});
		
		load_data_doc_gia1();
		load_data_doc_gia2();
		load_data_doc_gia3();

	}
	public static void load_data_doc_gia1() {
		list_doc_gia1 =dao_doc_gia.instance().get_data("Tu???n 1");
		DefaultTableModel dtb1 = (DefaultTableModel) table_tuan_1.getModel();
		dtb1.setRowCount(0);
		for(int i=0;i<list_doc_gia1.size();i++) {
			dtb1.addRow(new Object[] {list_doc_gia1.get(i).getMa_doc_gia(),list_doc_gia1.get(i).getTen_doc_gia(),list_doc_gia1.get(i).getTen_sach_muon(),
					list_doc_gia1.get(i).getThoi_gia(),list_doc_gia1.get(i).getGioi_tinh(),list_doc_gia1.get(i).getSo_luong_sach_muon()});
			}	
	}
	//load du lieu len bang doc gia 2
	public static void load_data_doc_gia2() {
		list_doc_gia2 =dao_doc_gia.instance().get_data("Tu???n 2");
		DefaultTableModel dtb2 = (DefaultTableModel) table_tuan_2.getModel();
		dtb2.setRowCount(0);
		for(int i=0;i<list_doc_gia2.size();i++) {
			dtb2.addRow(new Object[] {list_doc_gia2.get(i).getMa_doc_gia(),list_doc_gia2.get(i).getTen_doc_gia(),list_doc_gia2.get(i).getTen_sach_muon(),
					list_doc_gia2.get(i).getThoi_gia(),list_doc_gia2.get(i).getGioi_tinh(),list_doc_gia2.get(i).getSo_luong_sach_muon()});
			}
	}
	//load du lieu len bang doc gia 
	public static void load_data_doc_gia3() {
		list_doc_gia3 =dao_doc_gia.instance().get_data("Tu???n 3");
		DefaultTableModel dtb3 = (DefaultTableModel) table_tuan_3.getModel();
		dtb3.setRowCount(0);
		for(int i=0;i<list_doc_gia3.size();i++) {
			dtb3.addRow(new Object[] {list_doc_gia3.get(i).getMa_doc_gia(),list_doc_gia3.get(i).getTen_doc_gia(),list_doc_gia3.get(i).getTen_sach_muon(),
					list_doc_gia3.get(i).getThoi_gia(),list_doc_gia3.get(i).getGioi_tinh(),list_doc_gia3.get(i).getSo_luong_sach_muon()});
			}
	}
	//kiem tra nen load du lieu cua bang n??o
		public static void load_theo_tuan(String tuan) {
			if(tuan.equals("Tu???n 1")) {
				load_data_doc_gia1();
			}else if(tuan.equals("Tu???n 2")) {
				load_data_doc_gia2();
			}else {
				load_data_doc_gia3();
			}
		}
		//hien thi 
		public void hien_thi_doc_gia(doc_gia dg) {
			txt_ma_dg.setText(dg.getMa_doc_gia());
			txt_ten_dg.setText(dg.getTen_doc_gia());
			txt_ten_sach_muon.setText(dg.getTen_sach_muon());
			txt_thoi_gian_muon.setSelectedItem(dg.getThoi_gia());
			if(dg.getGioi_tinh().equals("Nam")) {
				dg_nam.setSelected(true);
			}else {
				dg_nu.setSelected(true);
			}
		}
		//lay thong tin doc gia 
		public doc_gia get_infor_doc_gia() {
			String ma_dg = txt_ma_dg.getText();
			String ten = txt_ten_dg.getText();
			String sach_muon = txt_ten_sach_muon.getText();
			String thoi_gian = (String) txt_thoi_gian_muon.getSelectedItem();
			String gioi_tinh;
			if(dg_nam.isSelected()) {
				gioi_tinh = dg_nam.getText();
			}else {
				gioi_tinh = dg_nu.getText();
			}
			String mang_sach_muon[] =sach_muon.split(",");
			int so_luong = mang_sach_muon.length;
			return new doc_gia(ma_dg, ten, sach_muon, thoi_gian, gioi_tinh, so_luong);
		}
		//them doc gia
		public void insert_doc_gia(doc_gia dg) {
			String mang_sach_muon [] = dg.getTen_sach_muon().split(","); //t??ch chu???i v??o m???ng
			if(mang_sach_muon.length>3) {
				JOptionPane.showMessageDialog(View.contentPane,"Qu?? S??? L?????ng S??ch M?????n Trong 1 Tu???n", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
			}else {
				
				if(check_ma_dg(dg.getThoi_gia(), dg.getMa_doc_gia())==false) {
					boolean check =true;
					String sach_ktt="";
					String sach_het="";
					for(int i=0;i<mang_sach_muon.length;i++) {
						for(int j=0;j<View_sach.list_sach.size();j++) {
							if(mang_sach_muon[i].equals(View_sach.list_sach.get(j).getTen_sach())) {
								if(View_sach.list_sach.get(j).getSo_luong_sach()==0 ) { //ki???m tra s??ch c?? h???t s??ch hay kh??ng
									sach_het+=View_sach.list_sach.get(j).getTen_sach()+" ";	//c???ng v??o chu???i
									check =false; 
								}
							}
						}
					}
					for(int i=0;i<mang_sach_muon.length;i++) {
						if(check_sach(mang_sach_muon[i])) {
							check=false;
							sach_ktt+=mang_sach_muon[i]+" ";
						}
					}
					if(check) {
						for(int i=0;i<mang_sach_muon.length;i++) {
							dao_sach.instance().muon_sach(mang_sach_muon[i]); // gi???m s??? l?????ng s??ch m?????n
						}
						View_sach.load_data_sach(); //load l???i s??ch
						dao_doc_gia.instance().insert(dg); //them doc gia
						JOptionPane.showMessageDialog(View.contentPane,"???? Th??m ?????c Gi??? ", "Th??ng B??o", JOptionPane.INFORMATION_MESSAGE);
					}else {
						if(sach_het.equals("")==false && sach_ktt.equals("")== false) {
							JOptionPane.showMessageDialog(View.contentPane,sach_het.toUpperCase()+" H???t S??ch ,"+sach_ktt.toUpperCase()+" Kh??ng T???n T???i S??ch", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
						}else if(sach_het.equals("")==false) {
							JOptionPane.showMessageDialog(View.contentPane,sach_het.toUpperCase()+" H???t S??ch", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(View.contentPane,sach_ktt.toUpperCase()+" Kh??ng T???n T???i S??ch", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
						}
					}
					load_theo_tuan(get_infor_doc_gia().getThoi_gia());
					View_sach.load_data_sach();
				}
				else {
					JOptionPane.showMessageDialog(View.contentPane,"M?? ?????C GI??? ???? T???N T???I", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
				}
			}
				
			
		}

		public static void delete_doc_gia(String ma_dg) {
			dao_doc_gia.instance().delete(ma_dg);
		}
		public void muon_sach(String ma_dg,String mt_ten_sach,String thoi_gian ) {
			if(ma_dg.equals("") || mt_ten_sach.equals("")) {
				JOptionPane.showMessageDialog(View.contentPane,"NH???P ?????Y ????? TH??NG TIN", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
			}else {
				String ten_sach_muon=sach_dg(ma_dg, thoi_gian); //l???y s??ch c???a ?????c gi??? g??n v??o ten_sach_muon
				ten_sach_muon+=","+txt_mt_ten_sach.getText();  // c???ng 2 chu???i ????? t???o th??nh chu???i s??ch m?????n
				String mang_sac_muon[] = ten_sach_muon.split(",");	//t??ch c??c s??ch v??o m???ng mang_sac_muon
				String sach_muon[] =txt_mt_ten_sach.getText().split(",");//t??ch c??c s??ch m?????n v??o m???ng sach_muon
				if(mang_sac_muon.length>3) {
					JOptionPane.showMessageDialog(View.contentPane,"Qu?? S??? L?????ng S??ch M?????n Trong 1 Tu???n", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
				}else {
					boolean check =true;
					String d="";
					String c="";
					for(int i=0;i<sach_muon.length;i++) {
						for(int j=0;j<View_sach.list_sach.size();j++) {
							if(sach_muon[i].equals(View_sach.list_sach.get(j).getTen_sach())) {
								if(View_sach.list_sach.get(j).getSo_luong_sach()==0) { //ki???m tra s??ch c?? h???t s??ch hay kh??ng
									c+=View_sach.list_sach.get(j).getTen_sach()+" ";
									check =false; 
								}
							}
						}
					}
					for(int i=0;i<sach_muon.length;i++) {
						if(check_sach(sach_muon[i])) {
							check=false;
							d+=sach_muon[i]+" ";
						}
					}
					if(check) {
						for(int i=0;i<mang_sac_muon.length;i++) {
							dao_sach.instance().muon_sach(mang_sac_muon[i]);//gi???m s??? l?????ng s??ch c?? trong m???ng 	
						}
						dao_doc_gia.instance().update_muon_tra(ma_dg, ten_sach_muon, thoi_gian, mang_sac_muon.length);
						load_theo_tuan(thoi_gian);
						View_sach.load_data_sach();
						
					}else {
						if(c.equals("")==false && d.equals("")== false) {
							JOptionPane.showMessageDialog(View.contentPane,c.toUpperCase()+" H???t S??ch ,"+d.toUpperCase()+" Kh??ng T???n T???i S??ch", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
						}else if(c.equals("")==false) {
							JOptionPane.showMessageDialog(View.contentPane,c.toUpperCase()+" H???t S??ch", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(View.contentPane,d.toUpperCase()+" S??ch Kh??ng T???n T???i", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
						}
						
					}
				}
			}
		}
		
		public static void tra_sach(String ma_dg,String sach_tra,String thoi_gian) {
			if(ma_dg.equals("") || sach_tra.equals("")) {
				JOptionPane.showMessageDialog(View.contentPane,"NH???P ?????Y ????? TH??NG TIN", "Th??ng B??o", JOptionPane.ERROR_MESSAGE);
			}else {
				String sach_dg_muon=sach_dg(ma_dg,thoi_gian); //l???y c??c s??ch m?????n c???a ?????c gi??? g??n v??o sach_doc_gia_muon v?? m?? ?????c gi???
				String sach_muon[] =sach_dg_muon.split(",");//t??ch s??ch ?????c gia m?????n v??o m???ng
				String sach_tra_mag[] =sach_tra.split(",");//t??ch s??ch ?????c gia tr??? v??o m???ng
				int so_luong =sach_muon.length-sach_tra_mag.length;
				String sach_cua_dg="";
				for(int i=0;i<sach_muon.length;i++) {
					boolean check =true;
					for(int j=0;j<sach_tra_mag.length;j++) {
						if(sach_muon[i].equals(sach_tra_mag[j])) { //cho 2 for ch???y n???u s??ch m?????n equal s??ch tr??? th?? check = false
							check=false;
						}
					}
					if(check==true) {
						sach_cua_dg+=sach_muon[i]+","; //c???ng chu???i
					}
				}
				
				if(sach_cua_dg.equals("")) {//n???u m?? s??ch c???a ?????c gi??? m?? h???t. 
					delete_doc_gia(ma_dg); // x??a ??i ?????c gi??? ????
				}else {
					String strNew = sach_cua_dg.substring(0, sach_cua_dg.length()-1); //x??a ??i ph???n t??? cu???i c??ng c???a chu???i sach_ktt
					dao_doc_gia.instance().update_muon_tra(ma_dg, strNew, thoi_gian, so_luong); //c???p nh???t l???i ?????c gi???
				}
				for(int i=0;i<sach_tra_mag.length;i++) {
					dao_sach.instance().tra_sach(sach_tra_mag[i]);  //t??ng s??? l?????ng s??ch l??n
				}
				View_sach.load_data_sach();
				load_theo_tuan(thoi_gian);
			}
		}
		public boolean check_sach(String sach) {
			boolean check = true;
			for(int i=0;i<View_sach.list_sach.size();i++) {
				if(View_sach.list_sach.get(i).getTen_sach().equals(sach)) {
					check=false; //n???u s??ch c?? trong list_sach th?? check = false
				}
			}
			return check;
		}
		public boolean check_ma_dg(String thoi_gian,String ma_dg) {
			if(thoi_gian.equals("Tu???n 1")) {
				for(int i=0;i<list_doc_gia1.size();i++) {
					if(ma_dg.equals(list_doc_gia1.get(i).getMa_doc_gia())) {
						return true;
					}
				}
			}else if(thoi_gian.equals("Tu???n 2")) {
				for(int i=0;i<list_doc_gia2.size();i++) {
					if(ma_dg.equals(list_doc_gia2.get(i).getMa_doc_gia())) {
						return true;
					}
				}
			}else {
				for(int i=0;i<list_doc_gia3.size();i++) {
					if(ma_dg.equals(list_doc_gia3.get(i).getMa_doc_gia())) {
						return true;
					}
				}
			}
			return false;
		}
		public static String sach_dg(String ma_dg,String thoi_gian) {
			String ten_sach_muon="";
			if(thoi_gian.equals("Tu???n 1")) {
				for(int i=0;i<list_doc_gia1.size();i++) {
					if(list_doc_gia1.get(i).getMa_doc_gia().equals(ma_dg)) {
						ten_sach_muon=list_doc_gia1.get(i).getTen_sach_muon();
					}
				}
			}else if(thoi_gian.equals("Tu???n 2")) {
				for(int i=0;i<list_doc_gia2.size();i++) {
					if(list_doc_gia1.get(i).getMa_doc_gia().equals(ma_dg)) {
						ten_sach_muon=list_doc_gia2.get(i).getTen_sach_muon();
					}
				}
			}else {
				for(int i=0;i<list_doc_gia3.size();i++) {
					if(list_doc_gia1.get(i).getMa_doc_gia().equals(ma_dg)) {
						ten_sach_muon=list_doc_gia3.get(i).getTen_sach_muon();
					}
				}
			}
			return ten_sach_muon;
		}
		
}
