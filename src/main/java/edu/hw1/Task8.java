package edu.hw1;

public final class Task8 {
    private Task8() {
    }

    static final int MIN_COORD_X = 0;
    static final int MIN_COORD_Y = 0;
    static final int MAX_COORD_X = 7;
    static final int MAX_COORD_Y = 7;

    static final KnightsCoords[] KNIGHTS_MOVES = {
        new KnightsCoords(2, 1),
        new KnightsCoords(-2, 1),
        new KnightsCoords(2, -1),
        new KnightsCoords(-2, -1),
        new KnightsCoords(1, 2),
        new KnightsCoords(-1, 2),
        new KnightsCoords(1, -2),
        new KnightsCoords(-1, -2),
    };

    private static boolean canMove(KnightsCoords from, KnightsCoords move) {
        return from.getX() + move.getX() <= MAX_COORD_X
                && from.getX() + move.getX() >= MIN_COORD_X
                && from.getY() + move.getY() <= MAX_COORD_Y
                && from.getY() + move.getY() >= MIN_COORD_Y;
    }

    private static boolean isCorrectBoard(int[][] chessboard) {
        if (chessboard.length != MAX_COORD_X + 1) {
            return false;
        }

        for (int[] row : chessboard) {
            if (row.length != MAX_COORD_Y + 1) {
                return false;
            }
        }

        for (int[] row : chessboard) {
            for (int haveKnight : row) {
                if (haveKnight < 0 || haveKnight > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean knightBoardCapture(int[][] chessboard) {
        if (!isCorrectBoard(chessboard)) {
            throw new IncorrectChessBoard();
        }

        for (int i = 0; i < chessboard.length; ++i) {
            for (int j = 0; j < chessboard[i].length; ++j) {
                if (chessboard[i][j] != 1) {
                    continue;
                }

                var curCoords = new KnightsCoords(i, j);

                if (isKnightCapturer(curCoords, chessboard)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isKnightCapturer(KnightsCoords knightsCoords, int[][] chessBoard) {
        for (var moveCoords : KNIGHTS_MOVES) {
            if (canMove(knightsCoords, moveCoords)) {
                var afterMove = knightsCoords.move(moveCoords);

                if (chessBoard[afterMove.getX()][afterMove.getY()] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    record KnightsCoords(int x, int y) {
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public KnightsCoords move(KnightsCoords moveCoords) {
            return new KnightsCoords(x + moveCoords.getX(), y + moveCoords.getY());
        }
    }

    public final static class IncorrectChessBoard extends RuntimeException {
    }
}
