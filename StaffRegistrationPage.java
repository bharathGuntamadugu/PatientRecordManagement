import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class StaffRegistrationPage extends JFrame 
{
	private JPanel contentPane;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField emailtext;
	private JTextField password;
	JFrame frame=new JFrame("Staff Registration");
	public String firstName;
	public int id;
	public StaffRegistrationPage(String name, int staffId)
	{
		firstName=name;
		id=staffId;
	}
	@SuppressWarnings({ })
	public void run()
	{
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(50, 50, 1800, 900);
		frame.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
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
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblFirstName.setBounds(1124, 279, 116, 22);
		contentPane.add(lblFirstName);
		
		firstNameText = new JTextField();
		firstNameText.setFont(new Font("Calibri", Font.PLAIN, 20));
		firstNameText.setBounds(1241, 274, 290, 37);
		contentPane.add(firstNameText);
		firstNameText.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblLastName.setBounds(1124, 332, 108, 16);
		contentPane.add(lblLastName);
		
		lastNameText = new JTextField();
		lastNameText.setFont(new Font("Calibri", Font.PLAIN, 20));
		lastNameText.setBounds(1241, 324, 292, 37);
		contentPane.add(lastNameText);
		lastNameText.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblPhone.setBounds(1124, 382, 82, 16);
		contentPane.add(lblPhone);

	    MaskFormatter mf = null;
		try 
		{
			mf = new MaskFormatter("###-###-####");
			mf.setPlaceholderCharacter('_');
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
	   		
		JFormattedTextField phone = new JFormattedTextField(mf);
		phone.setFont(new Font("Calibri", Font.PLAIN, 20));
		phone.setBounds(1243, 374, 172, 37);
		contentPane.add(phone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblEmail.setBounds(1124, 431, 108, 16);
		contentPane.add(lblEmail);
		
		emailtext = new JTextField();
		emailtext.setFont(new Font("Calibri", Font.PLAIN, 20));
		emailtext.setBounds(1243, 423, 290, 37);
		contentPane.add(emailtext);
		emailtext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblNewLabel.setBounds(1124, 480, 134, 16);
		contentPane.add(lblNewLabel);
		
		password = new JTextField();
		password.setFont(new Font("Calibri", Font.PLAIN, 20));
		password.setBounds(1243, 470, 290, 37);
		contentPane.add(password);
		password.setColumns(10);
			
		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblRole.setBounds(1124, 535, 39, 16);
		contentPane.add(lblRole);
		
		JComboBox<String> roleBox = new JComboBox<String>();
		roleBox.setFont(new Font("Calibri", Font.PLAIN, 20));
		roleBox.addItem("Staff");
		roleBox.addItem("Doctor");
		roleBox.addItem("Admin");
		roleBox.setBounds(1243, 531, 231, 28);
		contentPane.add(roleBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnSubmit.setBounds(1263, 612, 210, 41);
		contentPane.add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() 
		{		
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String fName=firstNameText.getText();
				String lName=lastNameText.getText();
				String phoneField=phone.getText();
				String email=emailtext.getText();
				String role=roleBox.getSelectedItem().toString();
				int roleid=0;
				if(role.equalsIgnoreCase("Staff")) roleid=2;
				if(role.equalsIgnoreCase("Doctor")) roleid=1;
				if(role.equalsIgnoreCase("Admin")) roleid=3;	
				String passwordField=password.getText();	
				if(!(fName.isEmpty()||lName.isEmpty()||phoneField.isEmpty()||email.isEmpty()||passwordField.isEmpty()))
				{
					JdbcConnectionCalls.newStaffInfo(fName, lName, phoneField, email, passwordField,roleid);
					frame.setVisible(false);
				}	
				else
				{
					JOptionPane.showMessageDialog(null, "Please fill all fields");
				}
			}
		});
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:/Users/Its'Me/Desktop/Image/patientRecords.jpg"));
		lblImage.setBounds(0, 0, 1800, 900);
		contentPane.add(lblImage);
	}
}
