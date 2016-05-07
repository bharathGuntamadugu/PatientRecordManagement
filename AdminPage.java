import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

	public class AdminPage 
	{
	public JPanel contentPane;
	public JTextField textField;
	public String firstName;
	public ImageIcon pic;
	public Image picture;
	public int id;
	JFrame frame=new JFrame("Admin");
	public AdminPage(String fName, int staffId)
	{
		firstName=fName;
		id=staffId;
	}
	
	public void run()
	{
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(50, 50, 1800, 900);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel lblHello = new JLabel("Hello");
		lblHello.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblHello.setBounds(143, 53, 77, 32);
		contentPane.add(lblHello);
		
		JLabel lblName = new JLabel(firstName);
		lblName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblName.setBounds(207, 54, 324, 28);
		contentPane.add(lblName);
		
		JLabel lblLoggedInId = new JLabel("Logged In ID:");
		lblLoggedInId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblLoggedInId.setBounds(143, 88, 134, 32);
		contentPane.add(lblLoggedInId);
		
		JLabel lblId = new JLabel(Integer.toString(id));
		lblId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblId.setBounds(261, 96, 77, 16);
		contentPane.add(lblId);
		
		JButton btnStaffDirectory = new JButton("Staff Directory");
		btnStaffDirectory.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnStaffDirectory.setBounds(1406, 53, 216, 55);
		contentPane.add(btnStaffDirectory);	
		btnStaffDirectory.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				StaffSearchPage search=new StaffSearchPage();
				search.run();		
			}
		});
		
		JButton btnRegisterDoctorstaff = new JButton("Register Doctor/Staff");
		btnRegisterDoctorstaff.setFont(new Font("Calibri", Font.PLAIN, 28));
		btnRegisterDoctorstaff.setBounds(606, 246, 514, 376);
		contentPane.add(btnRegisterDoctorstaff);
		btnRegisterDoctorstaff.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				StaffRegistrationPage staff=new StaffRegistrationPage(firstName, id);
				staff.run();
			}
		});
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:/Users/Its'Me/Desktop/Image/staffRegistrationPage.jpg"));
		lblImage.setBounds(0, 0, 1800, 900);
		contentPane.add(lblImage);

	}
}
