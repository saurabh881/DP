import java.util.Arrays;

class Solution {
    public int editDistance(String s, String t) {
        int i =0; 
        int j =0;
        int[][] arr = new int[s.length()][t.length()];
        for(int[] arr1 :arr) {
        	Arrays.fill(arr1, -1);
        }
        return editDistanceX(s,t,i,j, arr);
    }
    
    public int editDistanceX(String s, String t, int i, int j, int[][] arr){
  //  	System.out.println("i = "+i +" j= "+j);
    	if(i == s.length()){
            return t.length() -j;//This time I did wrong here. I returned 0
        }
        
        if(j == t.length()){
            return s.length() -i;//We should count remaining characters
        }
    
        if(s.charAt(i) == t.charAt(j)){
        	if(arr[i][j] != -1) {
   //     		System.out.println("Found");
        		return arr[i][j];
        		
        	}
        		
        	else {
        		arr[i][j]  = editDistanceX(s, t, i+1, j+1, arr);
     //   		System.out.println("Stored");
        		return arr[i][j];
        	}
        }
        if(arr[i][j] == -1) {
        	arr[i][j] = 1+Math.min(Math.min(editDistanceX(s, t, i, j+1, arr), editDistanceX(s, t, i+1, j, arr)),
                    Math.min(editDistanceX(s, t, i+1, j, arr), editDistanceX(s, t, i+1, j+1, arr)));
        }         
        return arr[i][j];
    }
}

public class EditDistance {
	public static void main(String[] args) {
		Solution soln = new Solution();
		String str1 = "ecfbefdcfca";
        String str2 = "badfcbebbf";
		System.out.println(soln.editDistance(str1, str2));
		
	}
}
