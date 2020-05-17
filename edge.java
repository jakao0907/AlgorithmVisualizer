package ntou.cs.java2020.project;

public class edge{
    private int u,v,len;
    public edge(int x,int y,int z){
        u=x;
        v=y;
        len=z;
    }
    public int getLen(){
        return this.len;
    }

    @Override
    public String toString(){
    	return u+" "+v+" "+len;
    }
}