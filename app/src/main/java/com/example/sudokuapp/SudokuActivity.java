package com.example.sudokuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SudokuActivity extends AppCompatActivity {
    private SudokuBoard gameBoard;
    private SudokuAnitilazer gameBoardNumber;
    static int diffclty;

    private Button solveBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);
        Intent intent = getIntent();
        diffclty = intent.getIntExtra(BoardGameractivity.MSG_KEY,BoardGameractivity.num);
        gameBoard = findViewById(R.id.SudokuBoard);
        gameBoardNumber = gameBoard.getNumbers();
        SolveBoardThread solveBoardThread = new SolveBoardThread();

        new Thread(solveBoardThread).start();
        gameBoard.invalidate();

        //solveBTN = findViewById(R.id.solveButton);
    }


    @SuppressLint("SetTextI18n")
    public void solve(View view) {
        if (solveBTN.getText().toString().equals("Solve")) {
            solveBTN.setText("Clear");


        } else {
            solveBTN.setText("Solve");

        }
    }


    public void BTNOnePress(View view) {
        gameBoardNumber.setNumberPos(1);
        gameBoard.invalidate();

    }

    public void BTNTwoPress(View view) {
        gameBoardNumber.setNumberPos(2);
        gameBoard.invalidate();

    }

    public void BTNThreePress(View view) {
        gameBoardNumber.setNumberPos(3);
        gameBoard.invalidate();

    }

    public void BTNFourPress(View view) {
        gameBoardNumber.setNumberPos(4);
        gameBoard.invalidate();

    }

    public void BTNFivePress(View view) {
        gameBoardNumber.setNumberPos(5);
        gameBoard.invalidate();

    }

    public void BTNSixPress(View view) {
        gameBoardNumber.setNumberPos(6);
        gameBoard.invalidate();

    }

    public void BTNSevenPress(View view) {
        gameBoardNumber.setNumberPos(7);
        gameBoard.invalidate();

    }

    public void BTNEightPress(View view) {
        gameBoardNumber.setNumberPos(8);
        gameBoard.invalidate();

    }

    public void BTNNinePress(View view) {
        gameBoardNumber.setNumberPos(9);
        gameBoard.invalidate();

    }


    class SolveBoardThread implements Runnable {
        @Override
        public void run() {
            gameBoardNumber.solve(gameBoard);
            gameBoardNumber.resetGame(diffclty);

        }
    }
}