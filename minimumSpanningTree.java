package ntou.cs.java2020.project;

import java.util.*;

public class minimumSpanningTree extends graph{

    public minimumSpanningTree(int _n,int _m,ArrayList<edge> _G){
        super(_n,_m,_G);
    }

    public ArrayList<edge> solve(){
        Collections.sort(super.G, new Comparator<edge>(){
            @Override
            public int compare(edge x,edge y) {
                if(x.len<y.len) return -1;
                else if(x.len>y.len)    return 1;
                return 0;
            }
        });
        for(edge x : super.G){
            System.out.println(x);
        }
        return super.G;
    }

}