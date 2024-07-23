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
public class SurahList 
{
    SurahNode head;
    
    SurahList()
    {
        head = null;
    }
    
    public void insert(int surahNo, String surahName, boolean b, int numberOfayahs, AyahsList aL)
    {
        SurahNode newNode = new SurahNode(surahNo, surahName, b, numberOfayahs, aL);
        
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            head.next = newNode;
        }
    }
       public String toString()
    {
        String str = "";
        for(SurahNode temp = head; temp != null; temp = temp.next)
        {
            str += "Surah No.: " + temp.surahNo + " Surah Name: " + temp.surahName + " No. of ayahs: " + temp.numberOfAyahs;
            if(temp.b == true)
            {
                str += " Makki Surah ";
            }
            else
            {
                str += " Madani Surah ";
            }
            str += "\nTranslation:\n" + temp.aL.toString();
        }
        return str;
    }
}
