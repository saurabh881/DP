import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public ArrayList<Integer> findLis(int[] arr){
		
		int[] lengths = new int[arr.length];
		int[] references = new int[arr.length];
		ArrayList<Integer> result = new ArrayList<>();

		Arrays.fill(lengths, 1);
		Arrays.fill(references, -1);
		int max = 0;
		int maxIndex = 0;
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					lengths[i] = lengths[j]+1 > lengths[i] ? lengths[j]+1 : lengths[i];
					references[i] = j;
					if(lengths[i] > max)
						max = lengths[i];
						maxIndex = i;
				}
			}
		}
		while(maxIndex >= 0) {
			result.add(arr[maxIndex]);
			maxIndex = references[maxIndex];
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] arrx = {0,4,12,2,10,6,9,13,3,11,7,15};
		System.out.println(lis.findLis(arrx));
	}

}
