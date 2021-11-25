/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OtherClasses;

import java.util.Random;

/**
 *
 * @author A 04 Nishant Badlani
 */
public class RandomGen 
{
    public static String  randomGen(int len)
    {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(chars[rnd.nextInt(chars.length)]);

        return sb.toString();
    }
    
    public static void main(String [] args)
    {
        System.out.println(randomGen(5));
    }
}
