package com.example.sudokuapp;

import java.util.ArrayList;
import java.util.Random;

public class SudokuAnitilazer {
        private final int[][] board;
        ArrayList<ArrayList<Integer>> emptyBoxIndex;
        private int selected_row;
        private  int selected_column;
        SudokuAnitilazer(){
            selected_row = -1;
            selected_column = -1;

            board = new int[9][9];
            emptyBoxIndex = new ArrayList<>();
        }
        public void getEmptyBoxIndexs(){
            for (int row = 0; row < 9 ;row++){
                for (int col = 0; col < 9; col++){
                    if (this.board[row][col] == 0){
                        this.emptyBoxIndex.add(new ArrayList<>());
                        this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(row);
                        this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(col);
                    }
                }
            }
        }

        private boolean check(int row, int col){
            if(this.board[row][col] > 0){
                for (int i = 0; i < 9; i++){
                    if(this.board[i][col] == this.board[row][col] && row != i){
                        return false;
                    }
                    if(this.board[row][i] == this.board[row][col] && col != i){
                        return false;
                    }
                    int boxRow = row/3;
                    int boxCol = col/3;

                    for (int r = boxRow*3; r < boxRow*3+3;r++){
                        for(int c = boxCol*3; c< boxCol*3+3; c++){
                            if(this.board[r][c] == this.board[row][col] && row != r && col != c){
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

        public boolean solve(SudokuBoard display){
            int row = -1;
            int col = -1;

            for (int r = 0; r < 9; r++){
                for (int c = 0; c < 9; c++){
                    if(this.board[r][c] == 0){
                        row = r;
                        col = c;
                    }
                }
            }
            if(row == -1 || col == -1){
                return true;
            }

            for (int i = 1 ; i <10 ; i++){
                this.board[row][col] = i;
                display.invalidate();

                if(check(row,col)){
                    if(solve(display)){
                        return true;
                    }
                }

                this.board[row][col] = 0;
            }
            return false;
        }

        public void easy(int[][] metrix){


        }

        public void resetGame(int num){
            Random random1 = new Random();
            Random random2 = new Random();
            int run = this.board.length * this.board.length;
            for (int i = 0; i < num ; i++){
                int row = random1.nextInt(9);
                int col = random2.nextInt(9);
                if(this.board[row][col] != 0){
                    this.board[row][col] = 0;
                }else if(row+1 < board.length && this.board[row+1][col] != 0){
                    this.board[row+1][col] = 0;
                }else if(col+1 < board.length && this.board[row][col+1] != 0){
                    this.board[row][col+1] = 0;
                }else i--;

            }
//        for (int r=0; r<9; r++){
//            for (int c=0; c<9; c++){
//                this.board[r][c] = 0;
//            }
//        }
//
//        emptyBoxIndex = new ArrayList<>();
        }

        public void setNumberPos(int num){
            if(this.selected_row!= -1 && this.selected_column != -1 ){
                if (this.board[selected_row-1][selected_column-1] == num){
                    this.board[selected_row-1][selected_column-1] = 0;
                }else{
                    this.board[selected_row-1][selected_column-1] = num;
                }
            }
        }


        public int[][] getBoard(){
            return this.board;
        }

        public int getSelected_row() {
            return selected_row;
        }

        public void setSelected_row(int row) {
            this.selected_row = row;
        }

        public int getSelected_column() {
            return selected_column;
        }

        public void setSelected_column(int column) {
            this.selected_column = column;
        }

    }
