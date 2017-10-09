package menu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DiskHandler {
	
	public DiskHandler (String name, String totalScore, String time)
	{
		BufferedWriter input = null;
		try 
		{
			File file = new File("HighScores.txt");
			if (!file.exists())
				file.createNewFile();
			BufferedReader output = new BufferedReader(new FileReader(file));
			ArrayList<String> players = new ArrayList<String>();
			String tmp = "";
			while (tmp != null)
			{
				tmp = output.readLine();
				if (tmp != null && !tmp.equals(""))
					players.add(tmp);
			}

			input = new BufferedWriter(new FileWriter(file));
			input.write(name + ":-:-:" + totalScore + ":-:-:" + time);
			if (players.size() == 5)
				players.remove(4);
			while (!players.isEmpty())
			{
				input.newLine();
				input.write(players.get(0));
				players.remove(0);
			}

			output.close();
			input.close();
		}
		catch (Exception e) {System.out.println(e.toString());}
	}
}
