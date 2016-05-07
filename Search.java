import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class Search 
{
	public static JTable table;
	public static JPanel searchPanel;
	public static JPanel docorPatientPanel;
	public static ResultSet rs;
	
	public static JPanel searchTableView(String fName, int ID, boolean patient)
	{
		searchPanel = new JPanel();
		searchPanel.setBounds(95, 120, 1600, 700);
		if(patient)
			table = JdbcConnectionCalls.searchTable(fName, ID, true);
		else
		{
			table=JdbcConnectionCalls.searchTable(fName, ID, false);
		}
		table.setSize(1600, 700);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(15);
		columnModel.getColumn(1).setPreferredWidth(120);
		columnModel.getColumn(2).setPreferredWidth(125);
		columnModel.getColumn(3).setPreferredWidth(30);
		columnModel.getColumn(4).setPreferredWidth(10);
		if(patient)
		{
			columnModel.getColumn(5).setPreferredWidth(50);
			columnModel.getColumn(6).setPreferredWidth(150);
			columnModel.getColumn(7).setPreferredWidth(15);
			columnModel.getColumn(8).setPreferredWidth(200);
		}
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(00,00, 1600, 700);
		searchPanel.setLayout(null);
		searchPanel.add(sp);;
		return searchPanel;
	}
	
	public static String[] doctorPatientSearch(int patientID)
	{
		String[] data=new String[8];
		rs=JdbcConnectionCalls.doctotPatientTable(patientID);
		try 
		{
			if(!rs.next())
			{
				JOptionPane.showMessageDialog(null, "No records with that patient ID");
			}
			else
			{
				data[0]=rs.getString(1);
				data[1]=rs.getString(2);
				data[2]=rs.getString(6);
				data[3]=rs.getString(5);
				data[4]=rs.getString(7);
				data[5]=Integer.toString((int) rs.getLong(3));
				data[6]=rs.getString(4);
				data[7]=rs.getString(8);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return data;
	}
}
