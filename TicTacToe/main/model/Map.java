package model;

import controller.Game;

public class Map {
    private Token[][] table = new Token[3][3];
    private int cont = 0;
    public Map(){}

    public Token[][] getTable() {
        return table;
    }

    public void setTable(Token[][] table) {
        this.table = table;
    }

    public void initialTable(){
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){
                table[i][j] = null;
            }
        }
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){
                System.out.print(table[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public boolean isEmpty(int X, int Y){
        if (table[X][Y] == null){
            return true;
        }
        return false;
        /*
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){
                if ( table[i][j].contains("|_|")){
                    empty = true;
                    //return true;
                } else {
                    empty = false;
                    //return false;
                }
            }
        }
        return empty;*/
    }

    public void setPosTable(int posX, int posY, Token token){
        table[posX][posY] = Token.valueOf(token.name());
    }
}
