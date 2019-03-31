package model;

import org.junit.Assert;
import org.junit.Test;

public class MapTest {

    Map mapTest = new Map();

    Map map = new Map();

    @Test
    public void positionIsEmptyIsCorrect() throws Exception{
        int x = 1;
        int y = 1;
        mapTest.setPositionTable(x, y, Token.H);

        map.setPositionTable(x, y, Token.H);

        Assert.assertEquals(mapTest.positionIsEmpty(x, y), map.positionIsEmpty(x, y));
    }
}
