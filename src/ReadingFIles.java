import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFIles {
	private void fileDetails() throws IOException
	{
		File f = new File("users2.txt");
		System.out.println("Does the file exist? " + f.exists());
		
		if(f.exists())
		{
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			String st;
			while ((st = br.readLine()) != null)
			{
				String[] splitNames = st.split(" ");
				User u = new User();
				u.setFirst_name(splitNames[0]);
				
				if(splitNames.length > 2)
				{
					u.setMiddle_name(splitNames[1]);
					u.setLast_name(splitNames[2]);
				}
				else
				{
					u.setLast_name(splitNames[1]);
				}
				System.out.println(st);
			}
			
		}
	}
	
	public static void main(String[] args)
	{
		ReadingFIles rf = new ReadingFIles();
		try
		{
			rf.fileDetails();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
