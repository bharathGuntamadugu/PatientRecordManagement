import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AdminAccess extends JFrame 
{
	private JPanel contentPane;
	private JTextField adminField;
	private JPasswordField passwordField;
	JFrame frame=new JFrame("Admin LogIn");

	public void run() 
	{
		frame.setVisible(true);
		frame.setBounds(600, 400, 580, 300);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel lblAdminuser = new JLabel("AdminUser:");
		lblAdminuser.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblAdminuser.setBounds(45, 67,130, 26);
		contentPane.add(lblAdminuser);
		
		adminField = new JTextField();
		adminField.setFont(new Font("Calibri", Font.PLAIN, 24));
		adminField.setBounds(170, 64, 322, 36);
		contentPane.add(adminField);
		adminField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblPassword.setBounds(45, 109,  115, 26);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 24));
		passwordField.setBounds(170, 109, 322, 36);
		contentPane.add(passwordField);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnLogIn.setBounds(215, 170, 163, 36);
		contentPane.add(btnLogIn);
		btnLogIn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				String user=adminField.getText();
				@SuppressWarnings("deprecation")
				String pass=passwordField.getText();
				if(user.contains("admin"))
				{
					StaffDetails result=JdbcConnectionCalls.loginJdbcRun(user, pass);
					if(result.getRoleId()==3)
					{
						AdminPage b= new AdminPage(result.getFirstName(), result.getId());
						b.run();
						frame.setVisible(false);	
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid USername or Password");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid USername or Password");
				}					
			}			
		});
	}
}
