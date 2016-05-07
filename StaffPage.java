import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StaffPage extends JFrame 
{
	private JPanel contentPane;
	JFrame  frame=new JFrame("Staff");
	public String firstName;
	public int id;
	public StaffPage(String name, int staffId)
	{
		firstName=name;
		id=staffId;
	}
	public void run() 
	{
		frame.setBounds(50, 50, 1800, 900);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		frame.setVisible(true);
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
		
		JButton btnNewButton = new JButton("New Patient");
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				NewPatientPage newPatient=new NewPatientPage(firstName, id);
				newPatient.run();
			}
		});
		btnNewButton.setBounds(219, 300, 571, 391);
		contentPane.add(btnNewButton);
		
		JButton btnExistingPatientSearch = new JButton("Existing Patient Search");
		btnExistingPatientSearch.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		btnExistingPatientSearch.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				ExistingPatientSearchPage pSearch=new ExistingPatientSearchPage();
				pSearch.run();
			}
		});
		btnExistingPatientSearch.setBounds(987, 300, 571, 391);
		contentPane.add(btnExistingPatientSearch);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:/Users/Its'Me/Desktop/Image/staffLoginPage.jpg"));
		lblImage.setBounds(0, 0, 1800, 900);
		contentPane.add(lblImage);
	}
}