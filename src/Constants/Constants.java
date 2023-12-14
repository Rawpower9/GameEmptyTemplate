package Constants;

import Entity.Plant.Wall;

public class Constants {
    public static class FIELD{
        public static int WIDTH = 1250;
        public static int HEIGHT = 800;

        public static int NUMCOL = 5;
        public static int NUMROW = 9;
        public static int BOXSIDELENGTH = 100;
        public static int STARTX = 300;
        public static int STARTY = 25;


    }

    public static class PLANT{
        public static enum TYPE {
            SUNFLOWER("You need da moneh? I got da money.", 100),
            WALL("Unstoppable force against zombie",100),
            CHOMPER("Mega-Hungry Zombie Devourer",150),
            PEASHOOTER("Pew Pew? More like Pea Pea",50),
            POTATOMINE("Explosive Vegetable",25),
            REPEATER("Strong Pea",150),
            SNOWPEA("Slow Pea",150);

            private final String desc;
            private final int cost;

            TYPE(String description,int cost) {
                this.desc = description;
                this.cost=cost;
            }
            public String DESC(){
                return desc;
            }
            public int COST(){
                return cost;
            }
        };

        public static int RANGE = -1;

        public static class WALL{
            public static int HEALTH = 500;
        }

        public static class PEASHOOTER{
            public static int HEALTH = 500;
            public static int DAMAGE = 10;
            public static double RANGE = -1;
            public static int COOLDOWN = 100;//frames
        }

        public static class CHOMPER{
            public static int HEALTH = 500;
            public static int DAMAGE = 50;
            public static double RANGE = 0.5;
        }

        public static class SNOWPEA{
            public static int HEALTH = 200;
        }

        public static class REPEATER{
            public static int HEALTH = 150;
            public static int COOLDOWN = 50;


        }

        public static class SUNFLOWER{
            public static int COOLDOWN=100;
        }
    }

    public static class ZOMBIE{
        public static enum TYPE {
            NORMAL(),
            BUCKET(),
            CONE(),
            DANCE(),
            FLAG();


            TYPE() {

            }
        };
        public static class NORMAL{
            public static int HEALTH = 50;
            public static double VELOCITY=0.01;
            public static int DAMAGE=10;
        }
    }

    public static class SIDEBAR{
        public static int STARTX = 25;
        public static int HEIGHT = FIELD.BOXSIDELENGTH*FIELD.NUMCOL;
        public static int WIDTH = 250;
        public static int STARTY = 25;
        public static int MAXCARDS = 5;

        public static class CARD{
            public static int HEIGHT = FIELD.BOXSIDELENGTH;
            public static int WIDTH = CARD.HEIGHT;
            public static int TEXTTOIMAGESPACE = 20;
            public static int TEXTWIDTH = SIDEBAR.WIDTH - CARD.WIDTH - TEXTTOIMAGESPACE;
        }
    }
}
