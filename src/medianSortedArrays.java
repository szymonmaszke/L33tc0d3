import java.util.ArrayList;

//O(n+m) solution, space O(n+m)
public class Solution {
    public double findMedianSortedArrays(int[] first, int[] second){
        int[] mergedArray = mergeArrays(first, second);
        //System.out.println((int)mergedArray.length/2);
        //System.out.println(mergedArray[0] + " " + mergedArray[1] + " " + mergedArray[2]);
        if(mergedArray.length % 2 == 0)
            return ((double)mergedArray[mergedArray.length/2] + (double)mergedArray[mergedArray.length/2 - 1])/2.;
        return (double)mergedArray[mergedArray.length/2];
    }
    
    private int[] mergeArrays(int[] first, int[] second){
        int[] mergedArray = new int[first.length+second.length];
        int i=0, j=0, k=0;
        while(i<first.length && j<second.length){
            if(first[i] < second[j])
                mergedArray[k++] = first[i++];
            else
                mergedArray[k++] = second[j++];
        }
        System.arraycopy(first, i, mergedArray, k, (first.length -i));
        System.arraycopy(second, j, mergedArray, k, (second.length -j));
        return mergedArray;
    }
}
