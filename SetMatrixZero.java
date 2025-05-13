class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(matrix[i][j] == 0){
                
                    matrix[i][j] = -999;
                }
            }
        }

        for(int i = 0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == -999){
                    for(int m = 0;m<row;m++){
                        if( matrix[m][j] != -999)  matrix[m][j] = 0;
                    }

                    for(int m = 0;m<col;m++){
                        if( matrix[i][m] != -999) matrix[i][m] = 0;
                    }

                    matrix[i][j] = 0;
                }
            }
        }

    }
}
