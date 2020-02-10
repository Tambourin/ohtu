package ohtu;

public class TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    private final String[] scoreStrings = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame(String player1Name, String player2Name) {
        this.playerOneName = player1Name;
        this.playerTwoName = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == playerOneName)
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    private String scoreToString(int score) {        
        return scoreStrings[score];        
    }


    private String tieGame(int score) {
        if(score == 4) {
            return "Deuce";
        } else {
            return scoreToString(score) + "-All"; 
        }   
    }

    private String winOrAdvantage(int playerOneScore, int playerTwoScore) {
        int scoreDifference = playerOneScore-playerTwoScore;
        if (scoreDifference == 1) return "Advantage player1";
        else if (scoreDifference == -1) return "Advantage player2";
        else if (scoreDifference >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private String defaultGame(int playerOneScore, int playerTwoScore) {
        return scoreToString(playerOneScore) + "-" + scoreToString(playerTwoScore);
    }

    public String getScore() {        
        if (playerOneScore == playerTwoScore) {
            return tieGame(playerOneScore);      
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            return winOrAdvantage(playerOneScore, playerTwoScore);
        } else {
            return defaultGame(playerOneScore, playerTwoScore);
        }            
    }
}