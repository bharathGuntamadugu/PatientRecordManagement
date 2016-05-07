import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PatientPrescriptionPage extends JFrame 
{
	private JPanel contentPane;
	JFrame frame=new JFrame("Patient Prescription");
	
	public void run(String patientId, int doctorId) 
	{	
		frame.setBounds(250, 100, 899, 472);
		frame.setVisible(true);
		frame.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 39, 857, 320);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JdbcConnectionCalls.addPatientPrescription(doctorId, Integer.parseInt(patientId), textArea.getText());
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(336, 372, 266, 40);
		contentPane.add(btnNewButton);
	}
}