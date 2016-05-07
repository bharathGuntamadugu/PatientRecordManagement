import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class DoctorPage extends JFrame 
{
	private JPanel contentPane, defaultPanel;
	private JTextField patientIdField;
	JFrame frame=new JFrame("Doctor");
	public String firstName;
	public int id;
	public String[] patientData;
	
	public DoctorPage(String name, int staffId)
	{
		firstName=name;
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
		lblHello.setBounds(272, 53, 77, 32);
		contentPane.add(lblHello);
		
		JLabel lblName = new JLabel(firstName);
		lblName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 30));
		lblName.setBounds(336, 54, 324, 28);
		contentPane.add(lblName);
		
		JLabel lblLoggedInId = new JLabel("Logged In ID:");
		lblLoggedInId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblLoggedInId.setBounds(272, 88, 134, 32);
		contentPane.add(lblLoggedInId);
		
		JLabel lblId = new JLabel(Integer.toString(id));
		lblId.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblId.setBounds(390, 96, 77, 16);
		contentPane.add(lblId);
		
		JButton btnStaffDirectory = new JButton("Staff Directory");
		btnStaffDirectory.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnStaffDirectory.setBounds(1485, 50, 216, 45);
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
		
		JLabel lblNewLabel = new JLabel("Patient ID: ");
		lblNewLabel.setBounds(663, 60, 216, 32);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.BOLD, 35));
		contentPane.add(lblNewLabel);
		
		patientIdField = new JTextField();
		patientIdField.setFont(new Font("Calibri", Font.PLAIN, 20));
		patientIdField.setBounds(857, 51, 216, 45);
		contentPane.add(patientIdField);
		patientIdField.setColumns(10);

		defaultPanel = new JPanel();
		defaultPanel.setBounds(144, 143, 1557, 628);
		defaultPanel.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblFirstName.setBounds(38, 32, 107, 16);
		defaultPanel.add(lblFirstName);
		
		JLabel fName = new JLabel();
		fName.setFont(new Font("Calibri", Font.BOLD, 30));
		fName.setBounds(143, 17, 293, 41);
		defaultPanel.add(fName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblLastName.setBounds(668, 32, 102, 16);
		defaultPanel.add(lblLastName);
		
		JLabel lName = new JLabel();
		lName.setFont(new Font("Calibri", Font.BOLD, 30));
		lName.setBounds(770, 17, 435, 41);
		defaultPanel.add(lName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblAge.setBounds(1260, 27, 56, 26);
		defaultPanel.add(lblAge);
		
		JLabel age = new JLabel();
		age.setFont(new Font("Calibri", Font.BOLD, 30));
		age.setBounds(1311, 17, 92, 41);
		defaultPanel.add(age);
		
		JLabel lblDisease = new JLabel("Disease:");
		lblDisease.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblDisease.setBounds(38, 102, 92, 16);
		defaultPanel.add(lblDisease);
		
		JLabel disease = new JLabel();
		disease.setFont(new Font("Calibri", Font.BOLD, 30));
		disease.setBounds(111, 94, 343, 36);
		defaultPanel.add(disease);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblGender.setBounds(466, 102, 80, 16);
		defaultPanel.add(lblGender);
		
		JLabel gender = new JLabel();
		gender.setFont(new Font("Calibri", Font.BOLD, 30));
		gender.setBounds(541, 94, 102, 36);
		defaultPanel.add(gender);
		
		JLabel lblPhone = new JLabel("phone:");
		lblPhone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblPhone.setBounds(861, 97, 66, 26);
		defaultPanel.add(lblPhone);
		
		JLabel phone = new JLabel();
		phone.setFont(new Font("Calibri", Font.BOLD, 30));
		phone.setBounds(942, 94, 218, 36);
		defaultPanel.add(phone);
		
		JLabel lblCreatedBy = new JLabel("Created by: ");
		lblCreatedBy.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblCreatedBy.setBounds(1184, 97, 114, 26);
		defaultPanel.add(lblCreatedBy);
		
		JLabel createdBy = new JLabel();
		createdBy.setFont(new Font("Calibri", Font.BOLD, 30));
		createdBy.setBounds(1298, 94, 80, 34);
		defaultPanel.add(createdBy);
		
		JLabel lblPrescription = new JLabel("Prescription:");
		lblPrescription.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblPrescription.setBounds(39, 184, 106, 16);
		defaultPanel.add(lblPrescription);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 223, 1478, 405);
		defaultPanel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 15));
		scrollPane.setViewportView(textArea);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Calibri", Font.PLAIN, 25));
		btnSearch.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String pID=patientIdField.getText();
				if(pID.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "Patient ID cannot be empty");
				}
				else
				{
					int patientID=-1;
					try {
						patientID=Integer.parseInt(pID);
					} catch (Exception e2) 
					{	
						JOptionPane.showMessageDialog(null, "Please check Patient ID");
						return;
					}
					patientData=Search.doctorPatientSearch(patientID);
					fName.setText(patientData[0]);
					lName.setText(patientData[1]);
					createdBy.setText(patientData[5]);
					disease.setText(patientData[6]);
					age.setText(patientData[3]);
					gender.setText(patientData[2]);
					phone.setText(patientData[4]);
					textArea.setText(patientData[7]);
				}
			}
		});
		
		btnSearch.setBounds(1085, 52, 121, 45);
		contentPane.add(btnSearch);
		contentPane.add(defaultPanel);
		
		JButton btnAddPrescription = new JButton("Add Prescription");
		btnAddPrescription.setFont(new Font("Calibri", Font.PLAIN, 24));
		btnAddPrescription.setBounds(789, 784, 351, 56);
		contentPane.add(btnAddPrescription);
		btnAddPrescription.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(!patientIdField.getText().isEmpty())
					new PatientPrescriptionPage().run(patientIdField.getText(), id);
				else
				{
					JOptionPane.showMessageDialog(null, "Please Enter Patient ID");
				}			
			}
		});
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:/Users/Its'Me/Desktop/Image/doctorLoginPage.jpg"));
		lblImage.setBounds(0, 0, 1800, 900);
		contentPane.add(lblImage);
	}
}
