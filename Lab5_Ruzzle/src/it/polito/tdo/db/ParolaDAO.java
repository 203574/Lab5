package it.polito.tdo.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParolaDAO 
{
	public String findParola(String s)
	{
		Connection conn = dbConnection.getConnection();
		String sql = "select min(nome) as nome from parola where nome like ?";
		PreparedStatement ps;
		try 
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, s+"%");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String ret = rs.getString("nome");
				return ret;
			}
			else
				return null;
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally 
		{
			try 
			{
				conn.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
		
	
}
