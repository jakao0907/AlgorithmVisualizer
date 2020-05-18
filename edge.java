package ntou.cs.java2020.project;

public class edge{
    int u,v,len;
    public edge(int x,int y,int z){
        u=x;
        v=y;
        len=z;
    }

    @Override
    public String toString(){
    	return u+" "+v+" "+len;
    }
}