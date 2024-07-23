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
public class MakkiMadani 
{
    SurahList sL;
    
    MakkiMadani(SurahList[] s, String t)
    {
        if(t.equalsIgnoreCase("Makki"))
        {
            sL = s[0];
        }
        else
        {
            sL = s[1];
        }
    }
    
    public String toString()
    {
        return sL.toString();
    }
}
