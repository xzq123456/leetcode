package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ArcNode{
    public  int index;
    public ArcNode next;
}
class TNode{
    public  int val;
    public ArcNode firstarc;
    public int rudu;
}
public class Graph {
    public TNode adjvst[];
    public int n,e;//e:边数 g：顶点数
    public  int[] visit;

    public void visit(Graph g,int v){
        System.out.println(g.adjvst[v].val);
    }
    public void DFS(Graph g,int v){
        visit[v]=1;
        visit(g,v);
        ArcNode p=g.adjvst[v].firstarc;
        while(p!=null){
            if(visit[p.index]==0){
                DFS(g,p.index);
            }
            p=p.next;
        }
    }
    public void BFS(Graph g,int v){
        Queue<Integer> queue=new LinkedList<>();
        visit[v]=1;
        visit(g,v);
        queue.add(v);
        while(!queue.isEmpty()){
            int p = queue.poll();
            ArcNode q=g.adjvst[p].firstarc;
            while(q!=null){
                if(visit[q.index]==0){
                    visit[q.index]=1;
                    visit(g,q.index);
                    queue.add(q.index);
                }
                q=q.next;
            }
        }
    }
    //判断一个有向图有没有环（拓扑排序）
    public boolean top(Graph g){
     //1.首先计算每个顶点的入度
        for(int i=0;i<g.n;i++){
            ArcNode p=g.adjvst[i].firstarc;
            while (p!=null){
                g.adjvst[p.index].rudu++;
                p=p.next;
            }
        }


        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<g.n;i++){
            if(g.adjvst[i].rudu==0)
                stack.push(i);
        }
        int count=0;
        while(!stack.isEmpty()) {
            int pop = stack.pop();
            count++;
            ArcNode q=g.adjvst[pop].firstarc;
            while (q != null) {
                int w = --g.adjvst[q.index].rudu;
                if (w == 0)
                    stack.push(q.index);
                q=q.next;
            }
        }
        if(count==g.n)
            return true;
        else
            return false;
    }

    //找到从顶点v开始到其他顶点的最短路径长度
    //思路：使用BFS思路，用一个数组记录
    public int[] u;
    public void findNearest(Graph g,int v){
        visit[v]=1;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()){
            int pop=queue.poll();
            ArcNode q=g.adjvst[pop].firstarc;
            while (q!=null){
                int w=q.index;
                if(visit[w]==0){
                    u[w]=u[pop]+1;
                    queue.add(w);
                }
                q=q.next;
            }

        }
    }
}
