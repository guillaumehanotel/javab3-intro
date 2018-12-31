package exercices.geometry;

public class Provided {


    public static interface PointItf {

        public int getX();
        public int getY();

        /**
         * @return Euclidean distance
         */
        default public double distance(PointItf p){
            return Math.sqrt(
                    Math.pow((this.getX() - p.getX()), 2) +
                            Math.pow(this.getY() - p.getY(), 2)
            );
        }
    }


    public static interface Colored {

        public String getColor();

    }


}
