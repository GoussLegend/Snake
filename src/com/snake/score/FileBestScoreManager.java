package com.snake.score;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileBestScoreManager implements BestScoreManager{

	private int best;
	private File file;

	public FileBestScoreManager()
	{
		file = new File("Bscores.txt");
		FileReader fr =null;

		try {
			fr = new FileReader(file);
			String str = "";
			int i = 0;
			//Reading data

			while((i = fr.read()) != -1)
				str += (char)i;

			best =  Integer.parseInt(str);
			//System.out.println(best);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(int score)
	{
		if(score>best)
		{
			best = score;
			this.writeNewScore();
		}
	}
	public void writeNewScore()
	{
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			String str ="" + best;
			fw.write(str);
			fw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int getBestScore() {
		return best;
	}

	public void setBestScore(int best) {
		this.best = best;
	}

	public static void main(String[] args)
	{ FileBestScoreManager b = new FileBestScoreManager();
	System.out.println(b.best);
	}
}