import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        
    }

    public static List<Integer> mergeSort(List<Integer> vector){
        if(vector.size() == 1){
            return vector;
        } else {
            List<Integer> a = vector.subList(0, vector.size()/2);
            List<Integer> b = vector.subList(vector.size()/2, vector.size()-1);
            a = mergeSort(a);
            b = mergeSort(b);

            List<Integer> l = merge(a, b);
            return l;
        }
    }

    public static List<Integer> merge(List<Integer> a, List<Integer> b){
        List<Integer> result = new ArrayList<>();
        if(a.get(0) < b.get(0)){
            result.add(a.get(0));
             return result.addAll(a);
        }
       
    }
}