package Week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class priorityQueue {
    public static void swim(List<Integer> a, int i){
        while(i>1&& a.get((int) (i/2)-1) < a.get(i-1)){
            Collections.swap(a,i-1,(int)(i/2)-1);
            i/=2;
        }
    }
    public static void sink(List<Integer>a,int i){
        int n=a.size();
        while(2*i<=n){
            int j=2*i;
            if(j<n&&a.get(j)>a.get(j-1))j++;
            if(a.get(j-1)<a.get(i-1)) break;
            Collections.swap(a,i-1,j-1);
            i=j;
        }
    }
    public static void insert(List<Integer> a,int n){
        a.add(n);
        swim(a,a.size());
    }
    public static int delete(List<Integer>a){
        int r=a.get(0);
        Collections.swap(a,0,a.size()-1);
        a.remove(a.size()-1);
        sink(a,1);
        return r;
    }
    public static void qs(List<Integer>a){
        int n=a.size();
        List<Integer> tmp=new ArrayList<>();
        for(int i=1;i<=n;i++)insert(tmp,a.get(i-1));
        for(int i=0;i<n;i++)a.set(i,delete(tmp));
    }
    public static void main(String[] args){
        List<Integer>a=new ArrayList<>();
        a.add(17);a.add(9);a.add(8);a.add(5);a.add(2);a.add(7);
        qs(a);
        System.out.println(a);
    }

}
