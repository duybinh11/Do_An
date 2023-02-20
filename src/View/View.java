package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Dao.dao_doc_gia;
import Dao.dao_sach;
import Model.Sach;
import Model.doc_gia;

public class View extends JFrame {
	public static JPanel contentPane;
	private final JTabbedPane thu_vien = new JTabbedPane(JTabbedPane.TOP);

	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1168, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(106, 181, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		thu_vien.setBounds(10, 150, 1134, 570);
		contentPane.add(thu_vien);
		
		View_sach view_sach =new View_sach();
		thu_vien.addTab("Quản Lý Đọc Giả", view_sach);
		
		View_doc_gia view_doc_gia =new View_doc_gia();
		thu_vien.addTab("Quản Lý Đọc Giả", view_doc_gia);
		
		View_thong_ke view_thong_ke =new View_thong_ke();
		thu_vien.addTab("Thống Kê", view_thong_ke);
		
		
		this.setLocationRelativeTo(null);
		JLabel lblNewLabel_3 = new JLabel("THƯ VIỆN VKU");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(302, 30, 481, 75);
		contentPane.add(lblNewLabel_3);
	}
}

