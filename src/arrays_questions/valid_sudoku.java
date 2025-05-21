package arrays_questions;

import java.util.HashMap;

public class valid_sudoku {
    public static void main(String[] args) {
        char[][] input = {
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','1','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(input));
    }

    public static boolean isValidSudoku(char[][] board) {
        // traverses whole matrix one by one
        for(int i = 0; i< board.length; i++){
            var rowDuplicateMap = new HashMap<Character, Integer>();
            var columnDuplicateMap = new HashMap<Character, Integer>();

            // traverses whole row and return false for duplicates
            for(int j = 0; j< board[i].length; j++){
                var currentRowElement = board[i][j];
                if(board[i][j] != '.'){
                    var currentMapElement = rowDuplicateMap.get(currentRowElement);

                    if(currentMapElement==null){
                        rowDuplicateMap.put(currentRowElement, 1);
                    } else {
                        return false;
                    }
                }
            }

            // traverses whole column and return false for duplicates
            for(int k = 0; k< board[i].length; k++){
                var currentColumnElement = board[k][i];
                if(board[k][i] != '.'){
                    var currentMapElement = columnDuplicateMap.get(currentColumnElement);
                    if(currentMapElement==null){
                        columnDuplicateMap.put(currentColumnElement, 1);
                    } else {
                        return false;
                    }
                }
            }
        }

        // traverse whole matrix in 3x3 chunks (wrapper)
        for(int row = 0; row < board.length; row+=3){

            for(int col = 0; col < board[row].length; col+=3){
                var matrixCustomChunks = new HashMap<Character, Integer>();

                //traverse 3x3 chunks element by element
                for(int i = row; i < row +3; i++){

                    for(int j = col; j < col +3; j++){
                        var currentRowElement = board[i][j];
                        if(board[i][j] != '.'){
                            var currentMapElement = matrixCustomChunks.get(currentRowElement);

                            if(currentMapElement==null){
                                matrixCustomChunks.put(currentRowElement, 1);
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

}