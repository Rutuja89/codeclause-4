package exam;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
public class exam {
 
	private JFrame frmCurdOperationSwing;
	private JTextField txtROLLNO;
	private JTextField txtName;
	private JTextField txtSUBJECT;
	
	private JTable table;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exam window = new exam();
					window.frmCurdOperationSwing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the application.
	 */
	public exam() {
		initialize();
		 Connect();
		 loadData();
	}
 
 
	//Database Connection
	Connection con = null;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtYEAR;
	private JTextField txtBRANCH;
	private JTextField txtSEMESTER;
	private JTextField txtblockno;
 
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/com";
			String username = "root";
			String password = "1234";
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
 
	// Clear All
		public void clear() {
			txtROLLNO.setText("");
			txtName.setText("");
			txtSUBJECT.setText("");
			txtYEAR.setText("");
			txtBRANCH.setText("");
			txtSEMESTER.setText("");
			
			//txtstudentName.requestFocus();
		}
 
		// Load Table
		public void loadData() {
			try {
				pst = con.prepareStatement("Select * from admi");
				rs = pst.executeQuery();
				table.setModel(DbUtil.resultSetToTableModel(rs));
 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
 
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCurdOperationSwing = new JFrame();
		frmCurdOperationSwing.getContentPane().setBackground(Color.CYAN);
		frmCurdOperationSwing.setBackground(Color.CYAN);
		frmCurdOperationSwing.setTitle("              "+"CURD Operation Swing MySQL");
		frmCurdOperationSwing.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmCurdOperationSwing.getContentPane().setLayout(null);
 
		JLabel lblNewLabel = new JLabel("EXAM SEATING ARRANGEMENT");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10,11,300,60);//10, 11, 259, 60
		frmCurdOperationSwing.getContentPane().add(lblNewLabel);
 
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(20, 81, 387, 284);
		frmCurdOperationSwing.getContentPane().add(panel);
		panel.setLayout(null);
 
		JLabel lblNewLabel_1 = new JLabel("ROLLNO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 46, 46, 24);
		panel.add(lblNewLabel_1);
 
		JLabel lblNewLabel_1_2 = new JLabel("Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(21, 81, 46, 24);
		panel.add(lblNewLabel_1_2);
 
		
 
		txtROLLNO = new JTextField();
		//txtID.setEditable(false);
		txtROLLNO.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtROLLNO.setBounds(78, 46, 287, 24);
		panel.add(txtROLLNO);
		txtROLLNO.setColumns(10);
 
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(78, 81, 287, 24);
		panel.add(txtName);
 
		txtSUBJECT = new JTextField();
		txtSUBJECT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSUBJECT.setColumns(10);
		txtSUBJECT.setBounds(78, 120, 287, 24);
		panel.add(txtSUBJECT);
		
		txtYEAR = new JTextField();
		txtYEAR.setBounds(78, 154, 287, 19);
		panel.add(txtYEAR);
		txtYEAR.setColumns(10);
		
		txtBRANCH = new JTextField();
		txtBRANCH.setBounds(78, 176, 287, 19);
		panel.add(txtBRANCH);
		txtBRANCH.setColumns(10);
		
		txtSEMESTER = new JTextField();
		txtSEMESTER.setBounds(78, 205, 287, 19);
		panel.add(txtSEMESTER);
		txtSEMESTER.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("SUBJECT");
		lblNewLabel_2.setBounds(22, 127, 45, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("YEAR");
		lblNewLabel_3.setBounds(21, 155, 57, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BRANCH");
		lblNewLabel_4.setBounds(22, 179, 45, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SEMESTER");
		lblNewLabel_5.setBounds(0, 208, 67, 13);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("blockno");
		lblNewLabel_6.setBounds(10, 240, 45, 13);
		panel.add(lblNewLabel_6);
		
		txtblockno = new JTextField();
		txtblockno.setBounds(88, 234, 260, 19);
		panel.add(txtblockno);
		//txtblockno.setColumns(10);
 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 71, 467, 284);
		frmCurdOperationSwing.getContentPane().add(scrollPane);
 
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
 
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				// ID NAME AGE CITY
				txtROLLNO.setText(model.getValueAt(index, 0).toString());
				txtName.setText(model.getValueAt(index, 1).toString());
				txtSUBJECT.setText(model.getValueAt(index, 2).toString());
				txtYEAR.setText(model.getValueAt(index, 3).toString());
				txtBRANCH.setText(model.getValueAt(index, 4).toString());
				txtSEMESTER.setText(model.getValueAt(index, 5).toString());
				txtblockno.setText(model.getValueAt(index, 6).toString());
				
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		
 
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(104, 414, 125, 23);
		frmCurdOperationSwing.getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ROLLNO = txtROLLNO.getText();
				String Name = txtName.getText();
				String SUBJECT= txtSUBJECT.getText();
				String YEAR = txtYEAR.getText();
				String BRANCH = txtBRANCH.getText();
				String SEMESTER= txtSEMESTER.getText();
				String blockno= txtblockno.getText();
				
			
				if (ROLLNO == null || ROLLNO.isEmpty() || ROLLNO.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter ROLLNO");
					txtROLLNO.requestFocus();
					return;
				}
				if (Name == null || Name.isEmpty() || Name.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter studentName");
					txtName.requestFocus();
					return;
				}
				if (SUBJECT == null ||SUBJECT.isEmpty() || SUBJECT.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter bookname");
					txtSUBJECT.requestFocus();
					return;
				}
			
				if (YEAR == null || YEAR.isEmpty() || YEAR.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter ROLLNO");
					txtYEAR.requestFocus();
					return;
				}
				if (BRANCH == null || BRANCH.isEmpty() || BRANCH.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter studentName");
					txtBRANCH.requestFocus();
					return;
				}
				if (SEMESTER == null ||SUBJECT.isEmpty() || SUBJECT.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter SEMESTER");
					txtSEMESTER.requestFocus();
					return;
				}
				if (blockno == null ||blockno.isEmpty() || blockno.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter SEMESTER");
					txtblockno.requestFocus();
					return;
				}
			
 
				
					try {
						String sql = "insert into admi (ROLLNO,Name,SUBJECT,YEAR,BRANCH,SEMESTER,blockno) values (?,?,?,?,?,?,?)";
						pst = con.prepareStatement(sql);
						pst.setString(1,  ROLLNO);
						pst.setString(2, Name);
						pst.setString(3, SUBJECT);
						pst.setString(4,  YEAR);
						pst.setString(5, BRANCH);
						pst.setString(6, SEMESTER);
						pst.setString(7, blockno);
					
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data insert Success");
						clear();
						loadData();
 
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
 
 
			}
		);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(280, 414, 88, 23);
		frmCurdOperationSwing.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Update Details
				String ROLLNO = txtROLLNO.getText();
				String Name = txtName.getText();
				String SUBJECT = txtSUBJECT.getText();
				String YEAR = txtYEAR.getText();
				String BRANCH = txtBRANCH.getText();
				String SEMESTER = txtSEMESTER.getText();
				String blockno = txtblockno.getText();
				
 
				if (Name == null || Name.isEmpty() || Name.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter name");
					txtName.requestFocus();
					return;
				}
				if (SUBJECT == null || SUBJECT.isEmpty() || SUBJECT.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter subject");
					txtSUBJECT.requestFocus();
					return;
				}
				if (YEAR == null || YEAR.isEmpty() || YEAR.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter yr");
					txtYEAR.requestFocus();
					return;
				}
				if (BRANCH == null || BRANCH.isEmpty() || BRANCH.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter branch");
					txtBRANCH.requestFocus();
					return;
				}
				if (SEMESTER == null || SEMESTER.isEmpty() || SEMESTER.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter sem");
					txtSEMESTER.requestFocus();
					return;
				}
				if (blockno == null || blockno.isEmpty() || blockno.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter blockno");
					txtblockno.requestFocus();
					return;
				}
				
				
 
				if (!txtROLLNO.getText().isEmpty()) {
					try {
						String sql = "update admi set Name=?,SUBJECT=?,YEAR=?,BRANCH=?,SEMESTER=?,blockno=? where ROLLNO=?";
						pst = con.prepareStatement(sql);
						pst.setString(1, Name);
						pst.setString(2, SUBJECT);
						pst.setString(3, YEAR);
						pst.setString(4, BRANCH);
						pst.setString(5, SEMESTER);
						pst.setString(6, blockno);
						
						
						pst.setString(7, ROLLNO);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Update Success");
						clear();
						loadData();
 
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(436, 414, 125, 23);
		frmCurdOperationSwing.getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
 
				// Delete Details
				String ROLLNO = txtROLLNO.getText();
				if (!txtROLLNO.getText().isEmpty()) {
 
					int result = JOptionPane.showConfirmDialog(null, "Sure? You want to Delete?", "Delete",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
 
					if (result == JOptionPane.YES_OPTION) {
						try {
							String sql = "delete from admi where ROLLNO=?";
							pst = con.prepareStatement(sql);
							pst.setString(1, ROLLNO);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Data Deleted Success");
							clear();
							loadData();
 
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
 
			}
		}
		);
		
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmCurdOperationSwing.setBounds(100, 100, 910, 522);
		frmCurdOperationSwing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}
