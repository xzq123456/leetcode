package Graph;

import org.junit.Before;
import org.junit.Test;

public class client {
    Graph g=null;
    @Before
    public  void init(){
       g=new Graph();
       g.e=g.n=6;
       TNode adjvst[]=new TNode[g.n];
       for(int i=0;i<adjvst.length;i++){

           adjvst[i]=new TNode();
           adjvst[i].val=i;
           adjvst[i].firstarc=null;
       }
       g.adjvst=adjvst;
       ArcNode e4=new ArcNode();
       e4.index=4;
       e4.next=null;


       ArcNode e3=new ArcNode();
       e3.next=e4;
       e3.index=3;

       ArcNode e1=new ArcNode();
       e1.next=e3;
       e1.index=1;
       adjvst[0].firstarc=e1;

       ArcNode e6=new ArcNode();
       e6.index=5;
       e6.next=null;

//测试拓扑排序加的边使得成为环
//        ArcNode e7=new ArcNode();
//        e7.index=4;
//        e7.next=e6;
//        adjvst[4].firstarc=e7;

       ArcNode e2=new ArcNode();
       e2.next=e6;
       e2.index=2;
       adjvst[1].firstarc=e2;

       ArcNode e5=new ArcNode();
       e5.index=4;
       e5.next=null;
       adjvst[5].firstarc=e5;

       int visit[]=new  int[g.n];
       g.visit=visit;
       int u[]=new int[g.n];
       g.u=u;
    }
    @Test
    public  void testDFS(){
         init();
         g.DFS(g,0);
    }
    @Test
    public void testBFS(){
        init();
        g.BFS(g,0);
    }
    @Test
    public  void testtop(){
        init();
        System.out.println(g.top(g));
    }
    @Test
    public  void testFindNear(){
        init();
        g.findNearest(g,0);
        for(int i=0;i<g.u.length;i++){
            System.out.print(g.u[i]+" ");
        }
    }
}
