import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	public List<User> loadUsers() throws IOException
	{
		List<User> users = new ArrayList<User>();
		File f = new File("users2.txt");
		
		if(f.exists())
		{
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			String st;
			while ((st = br.readLine()) != null)
			{
				String[] splitNames = st.split(" ");
				User u = new User();
				u.setFirst_name(splitNames[0]);
				
				if(splitNames.length>2)
				{
					u.setMiddle_name(splitNames[1]);
					u.setLast_name(splitNames[2]);
				}
				else
				{
					u.setLast_name(splitNames[1]);
				}
				users.add(u);
			}
		}
		return users;
	}
	
	public static void main(String[] args)
	{
		UserService us = new UserService();
		try
		{
			us.loadUsers();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}


}
