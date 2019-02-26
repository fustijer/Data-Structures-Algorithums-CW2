/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsacw2;

import java.util.Arrays;
import static java.util.Arrays.sort;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author ashmit.khadka
 */
public class DSACW2 {

    
    public static int ex1t1(int[] a){
        int n = a.length;
        for(int i = 0; i < n; i++)
        {
            int cnt = 0;
            for(int j = 0; j < n; j++)
            {
                if(a[i]==a[j])
                {
                    cnt++;
                }
            }
            if (cnt > n/2){
                return a[i];
            }
        }
        return -1;
    }
    
    public static int ex1t2(int[] a)
    {
        int n = a.length; 
        sort(a);        //O(nlong(n))
        int cnt = 0;
        int median = a[n/2];        
       
        for (int i = 0; i < n; i++) //O(n)
        {
            if (a[i] == median && ++cnt>n/2)
            {                
                return median;         
            }
        }        
        return -1;
    }
    
    public static int ex1t3(int[] a)
    {
        int n = a.length;
        HashMap<Integer, Integer> freq_tally = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < n; i++)
        {
            if (!freq_tally.containsKey(a[i]))
            {
                freq_tally.put(a[i], 1);
            }
            else
            {
                int tally = freq_tally.get(a[i])+1; 
                if (tally > n/2)
                {
                    return a[i];
                }  
                freq_tally.put(a[i], tally);
            }
        }
        return -1;
        
    }   
    
    public static void show_result(int r)
    {
        if (r < 0) 
        {
            System.out.println("SVD not found!");
        }
        else
        {
            System.out.printf("SVD is %d\n", r);
        }
    }
    
    
    public static void test(int task, int smaples ,int repeats){
        Random rnd = new Random();  
        int[] a = new int[smaples];    
        long startTime = 0;
        long endTime = 0;        
        long total = 0;
        
        //generate array of sample data
        for (int i = 0; i<a.length; i++){
            if(i%2==0){
                a[i]=4;
            }else{
                a[i] = rnd.nextInt(10);
            }
            //System.out.println(a[i]);
        }
        
        //repeat the test function, print the average time
        for(int j =0; j<repeats; j++){
            startTime = System.nanoTime();
            if (task == 1){
                //show_result(ex1t1(a));
                ex1t1(a);
            } else if (task == 2){
                ex1t2(a);
            }else{
                ex1t3(a);
            }
            endTime = System.nanoTime();
            total += (endTime - startTime);

        }
        System.out.println(total);
        System.out.println("Time: " + total/repeats);
    }
    
    public static void main(String[] args) {
        int[] a = {1,1,1,3,3,3};
        //show_result(ex1t1(a));
        //show_result(ex1t2(a));
        //show_result(ex1t3(a));
        
        
        test(2, 100000, 10000);
    }
    
}
