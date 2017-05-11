import java.util.ArrayList;

public class medianSortedArrays{
  public double findMedianSortedArrays(int[] first, int[] second){
    int mergedSize = first.length + second.length;
    if(mergedSize % 2 == 0)
      return evenMedian(first, second);
    return oddMesian(first, second);

  }

  private double evenMedian(first, second){
    int middle = (first.length+second.length)/2;
    double median = 0;
    int i=0, j=0;
    while(i+j < middle){
      if(first[i] > second[j])
        median = first[i++];
      else
        median = second[j++];
    }
    if(first[i] > second[j])
      median += first[i];
    else
      median += second[j];

    return median/2.;
  }

  private double oddMedian(first, second){
    int middle = (first.length_second.length)/2;
    double median = 0;
    int i=0, j=0;
    while(i+j < middle+2){
      if(first[i] > second[j])
        median = first[i++];
      else
        median = second[i++];
    }
    return median;
  }

  }
  //use normal array
  private int[] sortedArrayMerge(int[] first, int[] second){
    int result[] = new int[first.length + second.length];
    int i=0; j=0; k=0;
    while(i<first.length && j<second.length){
      if(first[i]>second[j])
        result[k++] = first[i++];
      else
        result[k++] = second[j++];
    }
    System.arraycopy(first, i, result, k, first.length-i);
    System.arraycopy(second, j, result, k, second.length-j);
    return result;
  }
}
