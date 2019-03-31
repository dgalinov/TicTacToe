package controller;

//import org.junit.Assert;
//import org.junit.Test;
import model.Player;
import model.Token;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game gameTest = new Game();

    Game game = new Game();

    @Test
    public void playerNameValidationIsCorrect(){
        String name = "Renzo";

        Assertions.assertEquals(gameTest.playerNameValidation(name), game.playerNameValidation(name));
    }

    @Test
    public void tableIsFullIsCorrect(){
        Assertions.assertEquals(gameTest.tableIsFull(), game.tableIsFull());
    }

    @Test
    public void verticalLineIsCorrect(){
        Assertions.assertEquals(gameTest.verticalLine(gameTest.getPlayerRound()), game.verticalLine(game.getPlayerRound()));
    }

    @Test
    public void horizontalLineIsCorrect(){
        Assertions.assertEquals(gameTest.horizontalLine(gameTest.getPlayerRound()), game.horizontalLine(game.getPlayerRound()));
    }

    @Test
    public void diagonalLineLeftToRightIsCorrect(){
        Assertions.assertEquals(gameTest.diagonalLineLeftToRight(gameTest.getPlayerRound()), game.diagonalLineLeftToRight(game.getPlayerRound()));
    }

    @Test
    public void diagonalLineRightToLeftIsCorrect(){
        Assertions.assertEquals(gameTest.diagonalLineRightToLeft(gameTest.getPlayerRound()), game.diagonalLineRightToLeft(game.getPlayerRound()));
    }



}
