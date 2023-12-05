package Simulator;

import Entity.Plant.Plant;
import processing.core.PApplet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Save {
    static String saveFileName = "save.txt";
    public static void saveState(ArrayList<Plant> plants) throws FileNotFoundException {
        PrintWriter p = new PrintWriter(saveFileName);
        p.println("TYPE,X,Y");
        for(Plant plant:plants){
            p.println(plant.getType() + ","+plant.getPosition().getX() + "," + plant.getPosition().getX());
        }
        p.close();
    }

//    public static ArrayList<Plant> loadState() throws IOException {
//        String[] data = new String(Files.readAllBytes(Paths.get(saveFileName))).split("\n");
//        ArrayList<Plant> plants = new ArrayList<>();
//        for(int i = 1; i < data.length; i++){
//            String [] plantData = data[i].split(",");
//            plants.add(new Plant(Integer.parseInt(plantData[1]),Integer.parseInt(plantData[2])));
//        }
//        return plants;
//    }
}
