package ntou.cs.java2020.project;

import java.util.*;

public class minimumSpanningTree{
    private int n,m;
    private ArrayList<edge> path;

    public void minimumSpanningTree(int _n,int _m,ArrayList<edge> _path){
        n = _n;
        m = _m;
        path = new ArrayList<edge>(_path);
    }

    public ArrayList<edge> solve(){
        Collections.sort(path, new Comparator<edge>(){
            @Override
            public int compare(edge x,edge y) {
                if(x.getLen()<y.getLen()) return -1;
                else if(x.getLen()>y.getLen())    return 1;
                return 0;
            }
        });
        for(edge x : path){
            System.out.println(x);
        }
        return path;
    }

}