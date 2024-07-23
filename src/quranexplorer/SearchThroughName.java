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
public class SearchThroughName 
{
    SurahNode[] surahs;
    SurahNode searchResult;
    String ayahTranslation = null;

    
    SearchThroughName(SurahList[] sL, String name){
        surahs = new SurahNode[47];
        for(SurahNode temp = sL[0].head; temp != null; temp = temp.next)
        {
            insert(temp);
        }
        for(SurahNode temp = sL[1].head; temp != null; temp = temp.next)
        {
            insert(temp);
        }
        searchResult = Search(name);
    }
    
    SearchThroughName(SurahList[] sL, String name, int ayahNo)
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
        searchResult = Search(name);
        AyahsNode[] arr = searchResult.aL.returnArr();
        if(ayahNo <= arr.length)
        {
            ayahTranslation = arr[ayahNo-1].ayah;
        }
        else{
            System.out.println("ayah is not present");
            }
    
   }
        
       public void insert(SurahNode n)
    {
        int i = Hash(n.surahName);
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
    
    public int Hash(String key)
    {
        if(key != null)
        return ((int)key.charAt(0) + (int)key.charAt(key.length()-2) + (int)key.charAt(key.length()-1)) % surahs.length;
        return 0;
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
    
    public SurahNode reHashSearch(int hash, String name)//rehash untill find the same surah
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
                if(surahs[k].surahName.equalsIgnoreCase(name))
                {
                    return surahs[k];
                }
            }
        }
    }
    
 
    
    public SurahNode Search(String name)//hashsearch
    {
        int k = Hash(name); // 
        if(surahs[k].surahName == name)
        {
            return surahs[k];
        }
        else
        {
            SurahNode r = reHashSearch(k, name);
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
            return searchResult.surahName + " " + ayahTranslation;
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
