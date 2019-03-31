package model;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    Player playerTest = new Player();

    @Test
    public void getPlayerNameTest() throws Exception{
        playerTest.setName("Qwerty");

        Assert.assertEquals(playerTest.getName(), "Qwerty");
    }

}
