import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import com.mysql.jdbc.Connection;
import java.sql.*;
import java.text.SimpleDateFormat;

public class JdbcConnectionCalls 
{
	public static StaffDetails loginJdbcRun(String userName, String password)
	{
		try
		{
			ResultSet rs;
			Connection mySql=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/patientrecordmanagement?useSSL=false","root", "root");
			CallableStatement st=mySql.prepareCall("{call patientrecordmanagement.loginCheck(?,?)}");
			st.setString(1,userName);
			st.setString(2, password);
			rs=st.executeQuery();
			if(rs.next())
			{
				StaffDetails staff= new StaffDetails();
				staff.setId((int) rs.getLong(1));
				staff.setRoleId((int)rs.getLong(3));
				staff.setFirstName(rs.getString(2));
				return staff;
			}				
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return null;	
	}
	
	public static void newPatientInfo(String fName, String lName, String gender, int age, String phone,String email,int createdBy, String disease)
	{
		ResultSet rs;
		Connection mySql;
		try 
		{
			mySql = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/patientrecordmanagement?useSSL=false","root", "root");
			CallableStatement st=mySql.prepareCall("{call patientrecordmanagement.newPatientInformation(?,?,?,?,?,?,?,?)}");
			st.setString(1,fName);
			st.setString(2,lName);
			st.setString(3, gender);
			st.setInt(4, age);
			st.setString(5, phone);
			st.setString(6, email);
			st.setInt(7, createdBy);
			st.setString(8, disease);
			rs=st.executeQuery();
			if(rs.next())
			{
				long patientId=rs.getLong(1);
				JOptionPane.showMessageDialog(null, "Succesfully Registered. Patient ID is: "+patientId);
			}
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void newStaffInfo(String fName, String lName, String phone,String email, String password, int roleId)
	{
		ResultSet rs;
		Connection mySql;
		try 
		{
			mySql = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/patientrecordmanagement?useSSL=false","root", "root");
			CallableStatement st=mySql.prepareCall("{call patientrecordmanagement.newStaffInformation(?,?,?,?,?,?)}");
			st.setString(1,fName);
			st.setString(2,lName);
			st.setString(3, phone);
			st.setString(4, email);
			st.setString(5, password);
			st.setInt(6, roleId);
			rs=st.executeQuery();
			if(rs.next())
			{
				long staffId=rs.getLong(1);
				JOptionPane.showMessageDialog(null, "Succesfully Registered. Staff ID is: "+staffId);
			}
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static JTable searchTable(String fName, int id, boolean patientSearch)
	{
		ResultSet rs;
		Connection mySql;
		CallableStatement st = null;
		try 
		{
			mySql = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/patientrecordmanagement?useSSL=false","root", "root");
			if(patientSearch)
			{
				if(fName==null && id==0)
					st=mySql.prepareCall("{call patientrecordmanagement.patientTable()}");
				else if(fName!=null && id==0)
				{
					st=mySql.prepareCall("{call patientrecordmanagement.patientSearchByFName(?)}");
					st.setString(1, fName);
				}
				else
				{
					st=mySql.prepareCall("{call patientrecordmanagement.patientSearchByPatientId(?)}");
					st.setLong(1, id);
				}
			}	
			else
			{
				if(fName==null && id==0)
					st=mySql.prepareCall("{call patientrecordmanagement.staffTable()}");
				else if(fName!=null && id==0)
				{
					st=mySql.prepareCall("{call patientrecordmanagement.staffSearchByName(?)}");
					st.setString(1, fName);
				}
				else
				{
					st=mySql.prepareCall("{call patientrecordmanagement.staffSearchById(?)}");
					st.setLong(1, id);
				}
			}
			rs=st.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			int columnCount=rsmd.getColumnCount();
			Vector<String> column=new Vector<String>(columnCount);
			for(int i=1; i<=columnCount; i++)
			{
                column.add(rsmd.getColumnName(i));
			}
            Vector<Vector<String>> data = new Vector<Vector<String>>();
            Vector<String> row;
            while(rs.next())
            {
                row = new Vector<String>(columnCount);
                for(int i=1; i<=columnCount; i++)
                {
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            
            return(new JTable(data, column));	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet doctotPatientTable(int patientID)
	{
		try
		{
			Connection mySql=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/patientrecordmanagement?useSSL=false","root", "root");
			CallableStatement st=mySql.prepareCall("{call patientrecordmanagement.patientDoctorRecord(?)}");
			st.setLong(1,patientID);
			return (st.executeQuery());		
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void addPatientPrescription(int doctorId, int patientID, String prescription)
	{
		Connection mySql;
		try 
		{
			mySql = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/patientrecordmanagement?useSSL=false","root", "root");
			CallableStatement st=mySql.prepareCall("{call patientrecordmanagement.addPatientPrescription(?,?)}");
			String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new java.util.Date());
			prescription=timeStamp+"   DoctorID:"+ doctorId+"  "+prescription;
			System.out.println(prescription);
			st.setString(2, prescription);
			st.setInt(1, patientID);
			st.executeQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
}
