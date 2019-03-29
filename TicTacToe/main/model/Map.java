package model;

public class Map {
    private Token[][] table = new Token[3][3];
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

    public boolean positionIsEmpty(int X, int Y){
        return table[X][Y].equals(Token.H);
    }

    public void setPositionTable(int positionX, int positionY, Token token){
        table[positionX][positionY] = Token.valueOf(token.name());
    }
}
