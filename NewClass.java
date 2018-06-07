/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egpseleniumgoods;

/**
 *
 * @author Nitish
 */
public class NewClass 
{
    public static void main(String[] args) 
    {
        String  url = "http://192.168.3.8:8080/officer/APPDashboard.jsp?appID=191&msg=File%20processed%20successfully";
        //int firstIndex = url.indexOf('');
        int firstIndex = url.indexOf("ID=");
        int lastIndex = url.indexOf("&msg");
        String tenderId = "";
        System.out.println(firstIndex);
        System.out.println(lastIndex);
        for(int i=firstIndex+3;i<lastIndex;i++)
        {
            //System.out.println(i);
            tenderId = tenderId + url.charAt(i);
        }
        System.out.println(tenderId);
        //return tenderId;
    }
}
