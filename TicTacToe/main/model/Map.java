package model;

public class Map {
    private String[][] table = new String[3][3];
    public Map(){}

    public void initialTable(){
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){
                table[i][j] = "|_|";
            }
        }
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){
                System.out.print(table[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public boolean isEmpty(){
        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table.length; j++){
                if ( table[i][j].contains("|_|")){
                    return true;
                } else {
                 return false;
                }
            }
        }
    }
}
