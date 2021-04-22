package deThiMau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class QuanLyMonHoc_UI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaMon;
	private JTextField txtTenMon;
	private JTextField txtSoTinChi;
	private JComboBox<String> hocKyComboBox;
	private String []header= {"Mã môn","Tên môn", "Học kỳ", "Số tín chỉ"};
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField txtTimKiem;
	private JButton btnLuu;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnThem;

	public QuanLyMonHoc_UI() {
		setTitle("Quan ly mon hoc");
		setSize(600, 500);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		/* Begin: input panel */
		JPanel inputJPanel = new JPanel();
		inputJPanel.setBackground(Color.cyan);

		Box inputBox = Box.createVerticalBox();

		// mã môn
		Box maMonBox = Box.createHorizontalBox();
		maMonBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		JLabel maMonJLabel = new JLabel("Mã môn:");
		maMonJLabel.setPreferredSize(new Dimension(100, 15));
		maMonBox.add(maMonJLabel);
		txtMaMon = new JTextField(30);
		maMonBox.add(txtMaMon);

		inputBox.add(maMonBox);

		// tên môn
		Box tenMonBox = Box.createHorizontalBox();
		tenMonBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		JLabel tenMonJLabel = new JLabel("Tên môn:");
		tenMonJLabel.setPreferredSize(new Dimension(100, 15));
		tenMonBox.add(tenMonJLabel);
		txtTenMon = new JTextField(30);
		tenMonBox.add(txtTenMon);

		inputBox.add(tenMonBox);
		
		//học kỳ
		Box hocKyBox = Box.createHorizontalBox();
		hocKyBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		JLabel hocKyJLabel = new JLabel("Số tín chỉ:");
		hocKyJLabel.setPreferredSize(new Dimension(100, 15));
		hocKyBox.add(hocKyJLabel);
		hocKyComboBox = new JComboBox<String>();
		hocKyComboBox.addItem("1");
		hocKyComboBox.addItem("2");
		hocKyComboBox.addItem("3");
		
		hocKyBox.add(hocKyComboBox);

		inputBox.add(hocKyBox);
	

		// số tín chỉ
		Box soTinChiBox = Box.createHorizontalBox();
		soTinChiBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		JLabel soTinChiJLabel = new JLabel("Số tín chỉ:");
		soTinChiJLabel.setPreferredSize(new Dimension(100, 15));
		soTinChiBox.add(soTinChiJLabel);
		txtSoTinChi = new JTextField(30);
		txtSoTinChi.addActionListener(this);
		soTinChiBox.add(txtSoTinChi);

		inputBox.add(soTinChiBox);

		inputJPanel.add(inputBox);
		this.add(inputJPanel, BorderLayout.NORTH);
		/* End: input panel */

		/* Begin: view panel */
		JPanel viewJPanel = new JPanel(new BorderLayout());
		viewJPanel.setBorder(BorderFactory.createEmptyBorder(0, 160, 0, 0));
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		table.setRowHeight(20);
		
		viewJPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		this.add(viewJPanel, BorderLayout.CENTER);
		/* End: view panel */

		/* Begin: button panel */
		JPanel buttonJPanel = new JPanel();
		buttonJPanel.setBorder(BorderFactory.createTitledBorder("Chọ tác vụ"));
		
		
		Box timKiemBox = Box.createHorizontalBox();
		timKiemBox.setPreferredSize(new Dimension(250, 20));
		JLabel timKiemJLabel = new JLabel("Nhập mã môn cần tìm:");
		timKiemJLabel.setPreferredSize(new Dimension(150, 15));
		timKiemBox.add(timKiemJLabel);
		txtTimKiem= new JTextField(30);
		timKiemBox.add(txtTimKiem);
		buttonJPanel.add(timKiemBox);
		
		btnThem = new JButton("Thêm");
		btnXoa = new JButton("Xóa");
		btnXoaTrang = new JButton("Xóa trắng");
		btnLuu = new JButton("Lưu");
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		
		buttonJPanel.add(btnThem);
		buttonJPanel.add(btnXoa);
		buttonJPanel.add(btnXoaTrang);
		buttonJPanel.add(btnLuu);
		
		
		this.add(buttonJPanel, BorderLayout.SOUTH);
		/* End: button panel */
	}

	public static void main(String[] args) {
		new QuanLyMonHoc_UI().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		
		if (object.equals(btnThem)|| object.equals(txtSoTinChi)) {
			tableModel.addRow(new Object[] {txtMaMon.getText().trim(), txtTenMon.getText().trim(), hocKyComboBox.getSelectedItem(),txtSoTinChi.getText().trim()});
		}else if(object.equals(btnXoa)) {
			tableModel.removeRow(table.getSelectedRow());
		}else if (object.equals(btnXoaTrang)) {
			txtMaMon.setText("");
			txtTenMon.setText("");
			hocKyComboBox.setSelectedIndex(0);
			txtSoTinChi.setText("");
			
			txtMaMon.requestFocus();
		}else if (object.equals(btnLuu)) {
			
		}
		
		
	}
}
