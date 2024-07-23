/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quranexplorer;

/**
 *
 * @author Windows 10 Pro
 */
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;   // Import the FileWriter class

public class FileReading 
{
    public SurahList[] ReadFile(String filename)
    {
        
        SurahList[] sL = new SurahList[2];
        sL[0] = new SurahList();
        sL[1] = new SurahList();
        
        try
        {
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
        
            int surahNo;
            String surahName;
            boolean b;
            int numberOfAyahs;
            AyahsList aL;
            String data = myReader.nextLine();
            int count = 0;
            
            do
            {
                if(data.charAt(0) == '#')
                {
                    data = myReader.nextLine();
                    String[] parts = data.split(" ", 4);
                    surahNo = Integer.parseInt(parts[0]);
                    surahName = parts[1];
                    
                    if(parts[2].equalsIgnoreCase("Makki"))
                    {
                        b = true;
                    }
                    else
                    {
                        b = false;
                    }
                    
                    numberOfAyahs = Integer.parseInt(parts[3]);
                    aL = new AyahsList(numberOfAyahs);
                    data = myReader.nextLine();
                    
                    while(myReader.hasNextLine() && data.charAt(0) != '#')
                    {
                        aL.insert(data + "\n");
                        data = myReader.nextLine();
                    }
                    if(b == true)
                    {
                        sL[0].insert(surahNo, surahName, b, numberOfAyahs, aL);
                    }
                    else
                    {
                        sL[1].insert(surahNo, surahName, b, numberOfAyahs, aL);
                    }
                }
            }
            while(myReader.hasNextLine());
        }
        catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return sL;
    }
}
