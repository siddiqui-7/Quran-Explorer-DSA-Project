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
public class AyahsList 
{
    AyahsNode[] arr;
    int index;
    
    AyahsList(int n)
    {
        arr = new AyahsNode[n];
        index = -1;
    }
    
    public void insert(String ayah)
    {
        index ++;
        AyahsNode newNode = new AyahsNode(ayah);
        arr[index] = newNode;
    }
    
    public AyahsNode[] returnArr()
    {
        return arr;
    }
    
    public String toString() //O(n)
    {
        String str = "";
        for(int i = 0; i <= index; i++)
        {
            str += arr[i].ayah;
        }
        return str;
    }
    
}
