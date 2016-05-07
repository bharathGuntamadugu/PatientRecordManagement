import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class ExistingPatientSearchPage extends JFrame 
{
	private JPanel contentPane;
	private JPanel tablePanel;
	private JTextField fNameField;
	private JTextField patientIdField;
	JFrame frame=new JFrame("Patient Search");
	
	public void run() 
	{
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(50, 50, 1800, 900);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		tablePanel=Search.searchTableView(null, 0, true);
		tablePanel.setBounds(95, 120, 1600, 700);
		contentPane.add(tablePanel);
		
		JLabel lblSearchByFirst = new JLabel("Search by First Name");
		lblSearchByFirst.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblSearchByFirst.setBounds(95, 76, 223, 23);
		contentPane.add(lblSearchByFirst);
		
		fNameField = new JTextField();
		fNameField.setFont(new Font("Calibri", Font.PLAIN, 24));
		fNameField.setBounds(330, 71, 401, 32);
		contentPane.add(fNameField);
		fNameField.setColumns(10);
		fNameField.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String fName=fNameField.getText();
				tablePanel=Search.searchTableView(fName, 0, true);
				contentPane.add(tablePanel);
			}
		});
	
		JLabel lblSearchByPatient = new JLabel("Search By Patient ID");
		lblSearchByPatient.setFont(new Font("Berlin Sans FB", Font.PLAIN, 24));
		lblSearchByPatient.setBounds(852, 71, 232, 27);
		contentPane.add(lblSearchByPatient);
		
		patientIdField = new JTextField();
		patientIdField.setFont(new Font("Calibri", Font.PLAIN, 24));
		patientIdField.setBounds(1067, 72, 349, 32);
		contentPane.add(patientIdField);
		patientIdField.setColumns(10);
		patientIdField.addActionListener(new ActionListener()
		{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					if(patientIdField.getText().isEmpty())
					{
						tablePanel=Search.searchTableView(null, 0, true);
						contentPane.add(tablePanel);
					}
					else
					{
						int pID=-1;
						try{
							pID=Integer.parseInt(patientIdField.getText());
							tablePanel=Search.searchTableView(null, pID, true);
							contentPane.add(tablePanel);
						}
						catch(Exception w)
						{
							JOptionPane.showMessageDialog(null, "Invalid Patient ID");
						}
					}
				
				}
		
		});
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:/Users/Its'Me/Desktop/Image/search.jpg"));
		lblImage.setBounds(0, 0, 1800, 900);
		contentPane.add(lblImage);	
	}
}
