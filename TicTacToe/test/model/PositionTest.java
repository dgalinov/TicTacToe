package model;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

    Position posTest = new Position(1,1);

    @Test
    public void getXPos() throws Exception{
        Assert.assertEquals(posTest.getX(), 1);
    }

    @Test
    public void getYPos() throws Exception{
        Assert.assertEquals(posTest.getY(), 1);
    }

}
