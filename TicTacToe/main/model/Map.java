package model;

import controller.Game;

public class Map {
    private Token[][] table = new Token[3][3];
    private int cont = 0;
    public Map(){
        initialTable();
    }

    public Token[][] getTable() { return table; }

    public void initialTable(){
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){
                table[i][j] = Token.H;
            }
        }
    }

    public boolean isEmpty(int X, int Y){
        if (table[X][Y].equals(Token.H)){
            return true;
        }
        return false;
    }

    public void setPosTable(int posX, int posY, Token token){
        table[posX][posY] = Token.valueOf(token.name());
    }
}
