package _08_clean_code_and_refactoring.exercise.refactoring;

public class TennisGame {
    public static final int ADVANTAGE = 1;
    public static final int WIN = 2;
    public static final int TIEBREAK_CONDITION = 4;
    public static String result;
    public static int tempScore;

    public static String getResult(int player1Score, int player2Score) {
        if (player1Score == player2Score) {
            result = equalCompare(player1Score);
        } else if (player1Score >= TIEBREAK_CONDITION || player2Score >= TIEBREAK_CONDITION) {
            result = tieBreakWinCompare(player1Score, player2Score);
        } else {
            result = winCompare(player1Score, player2Score);
        }
        return result;
    }

    public static String equalCompare(int score) {
        switch (score) {
            case 0:
                result = "Love-All";
                break;
            case 1:
                result = "Fifteen-All";
                break;
            case 2:
                result = "Thirty-All";
                break;
            case 3:
                result = "Forty-All";
                break;
            default:
                result = "Deuce";
                break;
        }
        return result;
    }

    public static String tieBreakWinCompare(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == ADVANTAGE) result = "Advantage player1";
        else if (minusResult == -ADVANTAGE) result = "Advantage player2";
        else if (minusResult >= WIN) result = "Win for player1";
        else result = "Win for player2";
        return result;
    }

    public static String winCompare(int player1Score, int player2Score) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                result += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case 0:
                    result += "Love";
                    break;
                case 1:
                    result += "Fifteen";
                    break;
                case 2:
                    result += "Thirty";
                    break;
                case 3:
                    result += "Forty";
                    break;
            }
        }
        return result;
    }
}
