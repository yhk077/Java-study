import java.util.Scanner;
public class homework3161{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); 
        int n = reader.nextInt();
        int[] arr = new int[n];
        int target = reader.nextInt();
        System.out.println();
        for(int i=0;i<n;i++)
        {
            arr[i] = reader.nextInt();
        }
        System.out.println(binarySearch(arr, target));   
        reader.close();
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0,right = arr.length - 1;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(arr[mid]==target)
            {
                return mid+1;
            }
            else if(arr[mid]<target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return -1;
    }
}
