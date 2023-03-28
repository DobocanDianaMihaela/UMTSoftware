import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDivider {
    public static boolean splitA(int[] A, List<Integer> B, List<Integer> C) {
        int n = A.length;
        //If the length of the input array is 1, it can't be divided into two non-empty arrays.
        if (n == 1) {
            return false;
        }
        //sort the input array, A in ascending order
        Arrays.sort(A);

        int sumListB = 0, sumListC = 0;
        //iterate over the sorted array in reverse order
        for (int i = n - 1; i >= 0; i--) {
           //add each element to List B or C, whichever has a smaller sum
            if (sumListB <= sumListC) {
                B.add(A[i]);
                sumListB += A[i];
            } else {
                C.add(A[i]);
                sumListC += A[i];
            }
        }
        //This line checks if both lists have at least one element, and if one of them is empty, it returns false, which means that the array A could not be split:
        if (B.isEmpty() || C.isEmpty()) {
            return false;
        }
        // check if the average of the elements in B is equal to the average of the elements in C.
        //n - B.size() represents the length of list C, while n - C.size() represents the length of list B.
        //The relation: sumListB * (n - B.size()) == sumListC * (n - C.size()) is a result of multiplying the means with the extremes in the equation: sumListB/(n - C.size())=sumListC/(n - B.size()).
        return sumListB * (n - B.size()) == sumListC * (n - C.size());
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,};//initializing the array A
        List<Integer> B = new ArrayList<>();// create an empty array lists named B
        List<Integer> C = new ArrayList<>();//create an empty array lists named C
        boolean verify = splitA(A, B, C);// calls the method splitA with the arguments A, B, and C and stores the return value in a boolean variable named verify.
        System.out.println(verify);//prints the value of verify to the console.(If the value is true, it means that the array A can be divided into two non-empty lists B and C with equal average).
        //  System.out.println("List B: " + B);
       // System.out.println("List C: " + C);
    }
}



