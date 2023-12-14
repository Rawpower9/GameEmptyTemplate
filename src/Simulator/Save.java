package Simulator;

import Constants.Constants;
import Entity.Plant.Plant;
import Entity.Plant.PlantType;
import processing.core.PApplet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Save {
    static String saveFileName = "save.txt";
    public static void saveState(Plant [][] plants) throws FileNotFoundException {
        PrintWriter p = new PrintWriter(saveFileName);
        for(int c=  0; c < plants.length; c++) {
            for (int r = 0; r < plants[c].length; r++) {
                if(plants[c][r] != null) {
                    p.print(plants[c][r].getType()+",");
                } else {
                    p.print("null,");
                }
            }
            p.print("\n");
        }
        p.close();
    }

    public static Plant[][] loadState() throws IOException, ClassNotFoundException {
        Plant[][] plants = new Plant[Constants.FIELD.NUMROW][Constants.FIELD.NUMCOL];

        String[] data = new String(Files.readAllBytes(Paths.get(saveFileName))).split("\n");

        for(int r = 0; r < data.length; r++){
            String [] plantData = data[r].split(",");
            for(int c = 0; c < plantData.length; c++) {
                plants[r][c] = PlantType.getInstance(r,c,plantData[c]);
            }
        }

        return plants;
    }
}
