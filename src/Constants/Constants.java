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
            SUNFLOWER("You need da moneh? I got da money."),
            WALL("Unstoppable force against zombie"),
            CHOMPER("Mega-Hungry Zombie Devourer"),
            PEASHOOTER("Pew Pew? More like Pea Pea"),
            POTATOMINE("Explosive Vegetable"),
            REPEATER("Strong Pea"),
            SNOWPEA("Slow Pea");

            private final String desc;
            TYPE(String description) {
                this.desc = description;
            }
            public String DESC(){
                return desc;
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
        }

        public static class CHOMPER{
            public static int HEALTH = 500;
            public static int DAMAGE = 50;
            public static double RANGE = 0.5;
        }

        public static class SNOWPEA{
            public static int HEALTH = 500;
        }
    }

    public static class ZOMBIE{
        enum TYPE {REGULAR};
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
