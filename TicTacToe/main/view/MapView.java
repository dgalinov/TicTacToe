package view;

import model.Map;

public class MapView {

    public MapView(){
    }

    public void printMap(Map map){
        for (int i = 0; i < map.getTable().length; i++){
            for (int j = 0; j < map.getTable().length; j++){
                System.out.print(map.getTable()[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
