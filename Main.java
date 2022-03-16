import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        List<Integer> test= genRand(4488, 0, 100);
        long start = System.nanoTime();
        mergeSort(test);
        long end =  System.nanoTime();
        System.out.println("MilliSec => " + (end - start)/1000000.0);

        /*List<Integer> test2= genRand(2048, 0, 100);
        long start2 = System.nanoTime();
        mergeSort(test2);
        long end2 =  System.nanoTime();
        System.out.println("MilliSec => " + (end2 - start2)/1000000.0);

        List<Integer> test3= genRand(4048, 0, 100);
        long start3 = System.nanoTime();
        mergeSort(test3);
        long end3 =  System.nanoTime();
        System.out.println("MilliSec => " + (end3 - start3)/1000000.0);*/
    }

    public static List<Integer> mergeSort(List<Integer> vector){
        if(vector.size() == 1){
            return vector;
        } else {
            List<Integer> a = vector.subList(0, vector.size()/2);
            List<Integer> b = vector.subList(vector.size()/2, vector.size());
            a = mergeSort(a);
            b = mergeSort(b);
            
            List<Integer> l = merge(a, b);
            return l;
        }
    }

    public static List<Integer> merge(List<Integer> a, List<Integer> b){
        List<Integer> result = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>(a);
        List<Integer> b2 = new ArrayList<>(b);
        if(a2.isEmpty() && b2.isEmpty())
        {
            result.addAll(a2);
            return result;
        }
        
        if(a2.isEmpty()) 
        {
            result.addAll(b2);
            return result;
        }

        if(b2.isEmpty()) 
        {
            result.addAll(a2);
            return result;
        }
        
        if(a2.get(0) <= b2.get(0)){
            result.add(a2.get(0));
            a2.remove(0);
            result.addAll(merge(a2,b2));
            return result;
        }
        else {
            result.add(b2.get(0));
            b2.remove(0);
            result.addAll(merge(a2,b2));
            return result;
        }
       
    }

    public static List<Integer> genRand(int n, int max, int min){
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            result.add(getRandomNumber(min,max));
        }
        return result;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}