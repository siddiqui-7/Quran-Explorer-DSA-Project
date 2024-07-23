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
public class SearchThroughSurahNumber 
{
    SurahNode[] surahs;
    SurahNode searchResult;
    String ayahTranslation = null;
    
    SearchThroughSurahNumber(SurahList[] sL, int i)
    {
        surahs = new SurahNode[47];
        for(SurahNode temp = sL[0].head; temp != null; temp = temp.next)
        {
            insert(temp);
        }
        for(SurahNode temp = sL[1].head; temp != null; temp = temp.next)
        {
            insert(temp);
        }
        searchResult = Search(i);
    }
    
    SearchThroughSurahNumber(SurahList[] sL, int i, int ayahNo)
    {
        surahs = new SurahNode[47];
        for(SurahNode temp = sL[0].head; temp != null; temp = temp.next)
        {
            insert(temp);
        }
        for(SurahNode temp = sL[1].head; temp != null; temp = temp.next)
        {
            insert(temp);
        }
        searchResult = Search(i);
        AyahsNode[] arr = searchResult.aL.returnArr();
        if(ayahNo <= arr.length)
        {
            ayahTranslation = arr[ayahNo-1].ayah;
        }
    }
    
    public int Hash(int n)
    {
        return n % surahs.length;
    }
    
    public int reHash(int hash)
    {
        while(true)
        {
            for(int j = 0; j < surahs.length; j++)
            {
                int k = (hash + (j*j) ) % surahs.length;
                if(surahs[k] == null)
                {
                    return k;
                }
            }
        }
    }
    
    public SurahNode reHashSearch(int hash, int n)
    {
        while(true)
        {
            for(int j = 0; j < surahs.length; j++)
            {
                int k = (hash + (j*j) ) % surahs.length;
                if(surahs[k] == null)
                {
                    return null;
                }
                if(surahs[k].surahNo == n)
                {
                    return surahs[k];
                }
            }
        }
    }
    
    public void insert(SurahNode n)
    {
        int i = Hash(n.surahNo);
        if(surahs[i] == null)
        {
            surahs[i] = n;
        }
        else
        {
            int j = reHash(i);
            surahs[j] = n;
        }
    }
    
    public SurahNode Search(int n)
    {
        int i = 0;
        int k = Hash(n);
        if(surahs[k].surahNo == n)
        {
            return surahs[k];
        }
        else
        {
            SurahNode r = reHashSearch(k, n);
            if(r != null)
            {
                return r;
            }
            else
            {
                return null;
            }
        }
    }
    
    public String toString()
    {
        if(ayahTranslation != null)
        {
            return "Surah Number: " + searchResult.surahNo + " " + searchResult.surahName + " " + ayahTranslation;
        }
        if(searchResult != null)
        {
            String str = "";
            str += "Surah No.: " + searchResult.surahNo + " Surah Name: " + searchResult.surahName + " No. of ayahs: " + searchResult.numberOfAyahs;
            if(searchResult.b == true)
            {
                str += " Makki Surah ";
            }
            else
            {
                str += " Madani Surah ";
            }
            str += "\nTranslation:\n" + searchResult.aL.toString();
            return str;
        }
        else
        {
            return "Sorry could not find this Surah";
        }
    }
    
    public void playAyah(String filename)
    {
        Player p=new Player();
        p.playMusic(filename);
    }
}
