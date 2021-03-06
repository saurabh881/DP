import java.util.Arrays;

public class LongestCommonSubsequence {

    public String lcsDynamic(char str1[],char str2[]){
    	
    	int str1Len = str1.length;
    	int str2Len = str2.length;
    	StringBuffer sb = new StringBuffer();
    	int[][] lcsMatrix = new int[str1Len+1][str2Len+1];
    	Arrays.stream(lcsMatrix).forEach(a -> Arrays.fill(a, 0));
    	int max = 0;
    	int iMax = 0;
    	int jMax = 0;
    	for(int i = 1; i <= str1Len; i++) {
    		for(int j = 1; j <= str2Len; j++) {
    				if(str1[i-1].equals(str2[j-1])) {
    					lcsMatrix[i][j] = lcsMatrix[i-1][j-1]+1;
    				}else {
    					lcsMatrix[i][j] = Math.max(lcsMatrix[i-1][j], lcsMatrix[i][j-1]) ;
    				}
    			if(lcsMatrix[i][j] > max) {
    				max = lcsMatrix[i][j];
    				iMax = i;
    				jMax = j;
    				System.out.println("imax "+ iMax + " jmax "+ jMax + " max "+ max);
    			}
    		}
    	}
    	for (int[] row : lcsMatrix)
          System.out.println(Arrays.toString(row));
    	System.out.println("iMax = "+ iMax + " jMax= "+jMax );
    	while(iMax > 0 && jMax >0) {
    		if(lcsMatrix[iMax][jMax] > lcsMatrix[iMax-1][jMax] && 
    				lcsMatrix[iMax][jMax] > lcsMatrix[iMax][jMax-1] ) {
    			sb.append(str1[iMax-1]);
    			iMax = iMax-1;
    			jMax = jMax-1;
    		}else if(lcsMatrix[iMax][jMax] == lcsMatrix[iMax-1][jMax]) {
    			iMax = iMax-1;
    		}else {
    			jMax = jMax-1;
    		}
    	}
    	
    	sb.reverse();
    	return sb.toString();
    	
    	
    }
    public static void main(String args[]){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        
        String result = 
        		lcs.lcsDynamic(str1.toCharArray(), str2.toCharArray());
        System.out.print(result);
    }
    
}
