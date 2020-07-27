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

public class D4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 1; i <= t; ++i)
        {
            int n=sc.nextInt();
            int q=sc.nextInt();
            int ar[]=new int[n-1];
            for(int x=0;x<n-1;x++)
            {
                ar[x]=sc.nextInt();
            }
            int dis[][]=new int[n][2];
            dis[0][0]=Integer.MAX_VALUE;
            dis[0][1]=ar[0];
            dis[n-1][0]=ar[n-2];
            dis[n-1][1]=Integer.MAX_VALUE;
            for(int x=1;x<n-1;x++)
            {
                dis[x][0]=ar[x-1];
                dis[x][1]=ar[x];
            }
            int dp[][]=new int[n][n];
            for(int x=0;x<n;x++)
            {
                int s=x;
                int c=s;
                int l=s;
                int r=s;
                dp[x][0]=x;
                for(int y=1;y<n;y++)
                {
                    int a=Integer.MAX_VALUE;
                    int b=Integer.MAX_VALUE;
                    if(l>=0)
                    {
                        a=dis[l][0];
                    }
                    if(r<n)
                    {
                        b=dis[r][1];
                    }
                    //System.out.println(a+" "+b);
                    if(a>b)
                    {
                        r++;
                        c=r;
                    }
                    else
                    {
                        l--;
                        c=l;
                    }
                    dp[x][y]=c;
                }
            }
            String ans="";
            while(q-->0)
            {
                int s=sc.nextInt()-1;
                int k=sc.nextInt()-1;
                ans=ans+(dp[s][k]+1)+" ";
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}
