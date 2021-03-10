import java.util.Arrays;
import java.util.Scanner;

public class MoveEvenElements{
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i =0;i<n; i++){
			
			arr[i] = sc.nextInt();	
		}
		
		int i = 0;
		int j = n-1;
		
		System.out.println(Arrays.toString(arr));		
		while((i<j) && (i<n && j>=0)){
			if( (arr[i]%2 != 0) && (arr[j]%2!= 0))
				j -= 1;
			else if( (arr[i]%2 == 0) && (arr[j]%2==0))
				i += 1;
			else if ((arr[i] %2 != 0) && (arr[j] %2 == 0)){
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				j -= 1;
					
			}
			else
				i += 1;

				
		}
		System.out.println(Arrays.toString(arr));

			
	

	}




}
