/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quranexplorer;

import java.util.Scanner;

/**
 *
 * @author Windows 10 Pro
 */
public class QuranExplorer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       // TODO code application logic here
        SurahList[] sL;
        FileReading fR = new FileReading();
        sL = fR.ReadFile("quran.txt");
        SearchThroughName sN;
        MakkiMadani mm;
        SearchThroughSurahNumber sNo;
        //System.out.println(sL[0].toString());
        //System.out.println(sL[1].toString());
        sN = new SearchThroughName(sL, "Al-Kauther", 3);
        System.out.println(sN.toString());
        // SearchThroughSurahNumber sNo = new SearchThroughSurahNumber(sL, 114, 3);
        //System.out.println(sNo.toString());
        //mm = new MakkiMadani(sL, "Madani");
        //System.out.println(mm.toString());
        //MainFrame MF = new MainFrame();
        //MF.show();
             
        Scanner n=new Scanner(System.in);
        Scanner s=new Scanner(System.in);
        int num=0;
        String st="";
        int ch=-1;
        while(ch!=4)
        {
            System.out.println("Enter 1 to search through Surah name");
            System.out.println("Enter 2 to search through Surah number");
            System.out.println("Enter 3 to search for type of Surah");
            System.out.println("Enter 4 to exit");
            ch=n.nextInt();
            if(ch==1)
            {
                System.out.println("Enter Surah name:");
                st=s.nextLine();
                System.out.println("Enter ayah number:");
                num=n.nextInt();
                sN=new SearchThroughName(sL,st,num);
                System.out.println(sN);
                sN.playAyah(st+".wav");
            }
            else if(ch==2)
            {
                System.out.println("Enter Surah number:");
                int sn=n.nextInt();
                System.out.println("Enter ayah number:");
                num=n.nextInt();
                sNo=new SearchThroughSurahNumber(sL,sn,num);
                System.out.println(sNo);  
                sNo.playAyah(sn+".wav");
            }
            else if(ch==3)
            {
                System.out.println("Enter type of Surah:");
                st=s.nextLine();
                mm=new MakkiMadani(sL, st);
                System.out.println(mm);
            }            
        }
        System.out.println("Thank You!!");
          
        
    }
}
