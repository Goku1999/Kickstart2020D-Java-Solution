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

public class D2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 1; i <= t; ++i)
        {
            int n=sc.nextInt();
            int[] ar=new int[n];
            for(int x=0;x<n;x++)
            {
                ar[x]=sc.nextInt();
            }
            int dp[][]=new int[n+1][5];
            for(int x=0;x<=n;x++)
            {
                for(int y=0;y<5;y++)
                {
                    dp[x][y]=-1;
                }
            }
            int ans = kamehameha(dp,ar,0,0,-1);
            System.out.println("Case #" + i + ": " + ans);
        }
    }
    public static int kamehameha(int dp[][],int ar[],int i,int c,int p)
    {
        if(i==ar.length)
        {
            dp[i][c]=0;
            return 0;
        }
        else if(p==ar[i])
        {
            if(dp[i+1][c]==-1)
            {
                dp[i+1][c]=kamehameha(dp,ar,i+1,c,ar[i]);
            }
            return dp[i+1][c];
        }
        else
        {
            if(p<ar[i])
            {
                int min=Integer.MAX_VALUE;
                for(int x=1;x<=4;x++)
                {
                    if(dp[i+1][x]==-1)
                    {
                        dp[i+1][x]=kamehameha(dp,ar,i+1,x,ar[i]);
                    }
                    if(x>c)
                    {
                        min=Math.min(dp[i+1][x],min);
                    }
                    else
                    {
                        min=Math.min(1+dp[i+1][x],min);
                    }
                }
                dp[i][c]=min;
                return min;
            }
            else
            {

                int min=Integer.MAX_VALUE;
                for(int x=1;x<=4;x++)
                {
                    if(dp[i+1][x]==-1)
                    {
                        dp[i+1][x]=kamehameha(dp,ar,i+1,x,ar[i]);
                    }
                    if(x<c)
                    {
                        min=Math.min(dp[i+1][x],min);
                    }
                    else
                    {
                        min=Math.min(1+dp[i+1][x],min);
                    }
                }
                dp[i][c]=min;
                return min;
            }
        }
    }
}
