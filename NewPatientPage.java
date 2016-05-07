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
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class NewPatientPage extends JFrame
{
	private JPanel contentPane;
	private JTextField firstNameText;
	private JTextField lastNameText;
	private JTextField emailtext;
	JFrame frame=new JFrame("New Patient");
	public String firstName;
	public int id;

	public NewPatientPage(String name, int staffId)
	{
		firstName=name;
		id=staffId;
	}

	public void run()
	{
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(50,50,1800,900);
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

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblFirstName.setBounds(1063, 279, 116, 22);
		contentPane.add(lblFirstName);

		firstNameText = new JTextField();
		firstNameText.setFont(new Font("Calibri", Font.PLAIN, 20));
		firstNameText.setBounds(1205, 274, 290, 37);
		contentPane.add(firstNameText);
		firstNameText.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblLastName.setBounds(1063, 332, 108, 16);
		contentPane.add(lblLastName);

		lastNameText = new JTextField();
		lastNameText.setFont(new Font("Calibri", Font.PLAIN, 20));
		lastNameText.setBounds(1205, 324, 292, 37);
		contentPane.add(lastNameText);
		lastNameText.setColumns(10);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblPhone.setBounds(1063, 382, 82, 16);
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

		JFormattedTextField phoneText = new JFormattedTextField(mf);
		phoneText.setFont(new Font("Calibri", Font.PLAIN, 20));
		phoneText.setBounds(1205, 374, 172, 37);
		contentPane.add(phoneText);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblEmail.setBounds(1063, 432, 108, 16);
		contentPane.add(lblEmail);

		emailtext = new JTextField();
		emailtext.setFont(new Font("Calibri", Font.PLAIN, 20));
		emailtext.setBounds(1205, 424, 290, 37);
		contentPane.add(emailtext);
		emailtext.setColumns(10);

		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblAge.setBounds(1063, 486, 68, 19);
		contentPane.add(lblAge);

		SpinnerModel sm=new SpinnerNumberModel(0, 0, 120, 1);
		JSpinner spinner = new JSpinner(sm);
		spinner.setFont(new Font("Calibri", Font.PLAIN, 20));
		spinner.setBounds(1205, 481, 77, 32);
		contentPane.add(spinner);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblGender.setBounds(1063, 545, 82, 16);
		contentPane.add(lblGender);

		JComboBox<String> genderBox = new JComboBox<String>();
		genderBox.setFont(new Font("Calibri", Font.PLAIN, 20));
		genderBox.addItem("Male");
		genderBox.addItem("Female");
		genderBox.setBounds(1205, 538, 126, 32);
		contentPane.add(genderBox);

		JLabel lblDiesases = new JLabel("Diesases: ");
		lblDiesases.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		lblDiesases.setBounds(1063, 601, 92, 16);
		contentPane.add(lblDiesases);

		JComboBox<String> diseaseBox = new JComboBox<String>();
		diseaseBox.setFont(new Font("Calibri", Font.PLAIN, 20));
		diseaseBox.addItem("Abdomen");
		diseaseBox.addItem("Eye");
        diseaseBox.addItem("Heart");
        diseaseBox.addItem("Joint Pains");
        diseaseBox.addItem("Kidney");
		diseaseBox.setBounds(1205, 590, 181, 32);
		contentPane.add(diseaseBox);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Calibri", Font.PLAIN, 30));
		btnSubmit.setBounds(1121, 693, 325, 73);
		contentPane.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String fName=firstNameText.getText();
				String lName=lastNameText.getText();
				String phone=phoneText.getText();
				String email=emailtext.getText();
				int age=(int) spinner.getValue();
				String disease=diseaseBox.getSelectedItem().toString();
				String gender=genderBox.getSelectedItem().toString();
				if(!(fName.isEmpty()||lName.isEmpty()||phone.isEmpty()||email.isEmpty()||age<0))
				{
					JdbcConnectionCalls.newPatientInfo(fName, lName, gender, age, phone, email, id, disease);
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
