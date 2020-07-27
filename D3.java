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

public class D3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 1; i <= t; ++i)
        {
            int n=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            LinkedList<Integer> graph[]=new LinkedList[n];
            for(int x=0;x<n;x++)
            {
                graph[x]=new LinkedList<>();
            }
            graph[0].add(-1);
            for(int x=1;x<n;x++)
            {
                graph[x].add(sc.nextInt()-1);
            }
            HashMap<Integer,Integer> count=new HashMap<>();
            for(int x=0;x<n;x++)
            {
                for(int y=0;y<n;y++)
                {
                    int d=count(graph,x,y,n,a,b);
                    if(count.containsKey(d))
                    {
                        int e=count.get(d);
                        count.put(d,e+1);
                    }
                    else
                    {
                        count.put(d,1);
                    }
                }
            }
            float ans=0.0f;
            float sum=0.0f;
            for(Integer d:count.keySet())
            {
                sum+=count.get(d);
            }
            
            for(Integer d:count.keySet())
            {
                ans=ans+d*(count.get(d)/sum);
                //System.out.println(d+" "+count.get(d));
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static int count(LinkedList<Integer>[] graph, int x, int y, int n,int a,int b)
    {
        int color[]=new int[n];
        color[x]=1;
        color[y]=1;
        int d=x;
        outer:
        while(true)
        {
            for(int i=0;i<a;i++)
            {
                d=graph[d].get(0);
                if(d==-1)
                {
                    break outer;
                }
            }
            color[d]=1;
        }
        d=y;
        outer:
        while(true)
        {
            for(int i=0;i<b;i++)
            {
                d=graph[d].get(0);
                if(d==-1)
                {
                    break outer;
                }
            }
            color[d]=1;
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
            c+=color[i];
        }
        return c;
    }
}
