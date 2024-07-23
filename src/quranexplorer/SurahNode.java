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
public class SurahNode 
{
    int surahNo;
    String surahName;
    boolean b;
    //b is true if the Surah is Makki and false is the Surah is Madani
    int numberOfAyahs;
    AyahsList aL;
    SurahNode next;
    
    SurahNode(int n, String s, boolean b, int a, AyahsList l)
    {
        this.surahNo = n;
        this.surahName = s;
        this.b = b;
        this.numberOfAyahs = a;
        this.aL = l;
    }
}
