import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class LoginPage extends JFrame 
{
	private JPasswordField passwordField;
	private JTextField userField;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public LoginPage() 
	{
		setResizable(false);
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1800, 900);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patients Record Management");
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 50));
		lblNewLabel.setBounds(945, 156, 682, 69);
		getContentPane().add(lblNewLabel);
		
		JLabel Username = new JLabel("Username:");
		Username.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		Username.setBounds(1049, 272, 115, 26);
		getContentPane().add(Username);
		
		userField = new JTextField();
		userField.setFont(new Font("Calibri", Font.PLAIN, 24));
		userField.setBounds(1176, 270, 322, 36);
		getContentPane().add(userField);
		userField.setColumns(10);
		
		JLabel Password = new JLabel("Password:");
		Password.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		Password.setBounds(1049, 327, 115, 26);
		getContentPane().add(Password);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 24));
		passwordField.setBounds(1176, 325, 322, 36);
		getContentPane().add(passwordField);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnLogIn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String user=userField.getText();
				@SuppressWarnings("deprecation")
				String pass=passwordField.getText();
				StaffDetails result=JdbcConnectionCalls.loginJdbcRun(user, pass);
				if(result==null)
				{
					JOptionPane.showMessageDialog(null, "Invalid USername or Password");
				}
				else if(result.getRoleId()==3)
				{
					AdminPage admin= new AdminPage(result.getFirstName(), result.getId());
					admin.run();
					setVisible(false);
				}
				else if(result.getRoleId()==1)
				{
					DoctorPage doctor=new DoctorPage(result.getFirstName(), result.getId());
					doctor.run();
					setVisible(false);
				}
				else if(result.getRoleId()==2)
				{
					StaffPage staff=new StaffPage(result.getFirstName(), result.getId());
					staff.run();
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid USername or Password");
				}	
				
			}
		});
		btnLogIn.setBounds(1244, 396, 163, 36);
		getContentPane().add(btnLogIn);
		
		JLabel lblNewUser = new JLabel("New User? ");
		lblNewUser.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblNewUser.setBounds(1063, 501, 124, 26);
		getContentPane().add(lblNewUser);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnRegister.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				AdminAccess admin=new AdminAccess();
				admin.run();					
			}		
		});
		btnRegister.setBounds(1232, 491, 188, 36);
		getContentPane().add(btnRegister);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:/Users/Its'Me/Desktop/Image/loginPage.jpeg"));
		lblImage.setBounds(0, 0, 1800, 900);
		getContentPane().add(lblImage);
	}
}
