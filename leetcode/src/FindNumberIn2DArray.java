import org.junit.Test;

/**
 * @author JeffCar
 * @date 1/2/2021 - 8:14 PM
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target){
        if (matrix.length == 0) return false;
        int n =matrix.length;  //行数
        int m =matrix[0].length; //列数
        if (n==0 || m==0){
            return false;
        }else {

            if (target < matrix[0][0]) {
                return false;
            } else if (target > matrix[n - 1][m - 1]) {
                return false;
            } else {
                for (int i = 0; i < n; i++) {
                    if (target == matrix[i][0]) {
                        return true;
                    }
                }
                for (int i = 0; i < m; i++) {
                    if (target == matrix[0][i]) {
                        return true;
                    }
                }
                if (n-1==1||m-1==1){
                    return false;
                }else {

                    int[][] newMatrix = new int[n - 1][m - 1];
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < m - 1; j++) {
                            newMatrix[i][j] = matrix[i + 1][j + 1];
                        }
                    }
                    boolean numberIn2DArray = findNumberIn2DArray(newMatrix, target);
                    return numberIn2DArray;
                }
            }

        }

    }

    public boolean test2(int[][] matrix, int target){
//        if (matrix.length ==0) return false;
//        int n = matrix.length; //行数
//        int m = matrix[0].length; //列数
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }

    @Test
    public void  test(){
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean numberIn2DArray = findNumberIn2DArray(matrix, 20);
        System.out.println(numberIn2DArray);
    }

}
