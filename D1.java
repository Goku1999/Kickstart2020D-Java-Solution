/*
    Author: @__goku__
    ssrivastava990@gmail.com

                   `\-.   `
                      \ `.  `
                       \  \ |
              __.._    |   \.       S O N - G O K U
       ..---~~     ~ . |    Y
         ~-.          `|    |
            `.               `~~--.
              \                    ~.
               \                     \__. . -- -  .
         .-~~~~~      ,    ,            ~~~~~~---...._
      .-~___        ,'/  ,'/ ,'\          __...---~~~
            ~-.    /._\_( ,(/_. 7,-.    ~~---...__
           _...>-  P""6=`_/"6"~   6)    ___...--~~~
            ~~--._ \`--') `---'   9'  _..--~~~
                  ~\ ~~/_  ~~~   /`-.--~~
                    `.  ---    .'   \_
                      `. " _.-'     | ~-.,-------._
                  ..._../~~   ./       .-'    .-~~~-.
            ,--~~~ ,'...\` _./.----~~.'/    /'       `-
        _.-(      |\    `/~ _____..-' /    /      _.-~~`.
       /   |     /. ^---~~~~       ' /    /     ,'  ~.   \
      (    /    (  .           _ ' /'    /    ,/      \   )
      (`. |     `\   - - - - ~   /'      (   /         .  |
       \.\|       \            /'        \  |`.           /
       /.'\\      `\         /'           ~-\         .  /\
      /,   (        `\     /'                `.___..-      \
     | |    \         `\_/'                  //      \.     |
     | |     |                 _Seal_      /' |       |     |
 */

import java.io.*;
import java.util.*;

public class D1
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 1; i <= t; ++i)
        {
            int ans = 0;
            int n=sc.nextInt();
            int[] ar=new int[n];
            for(int x=0;x<n;x++)
            {
                ar[x]=sc.nextInt();
            }
            PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
            pq.add(-1);
            for(int x=0;x<n;x++)
            {
                if(x==n-1)
                {
                    if(ar[x]>pq.peek())
                    {
                        ans++;
                    }
                }
                else
                {
                    if(ar[x]>pq.peek()&&ar[x]>ar[x+1])
                    {
                        ans++;
                    }
                }
                pq.add(ar[x]);
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}
