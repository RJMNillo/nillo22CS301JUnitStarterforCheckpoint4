package up.edu.dimcalc;

import android.graphics.Point;

import java.util.Random;

/**
 * This class is designed to perform operations on two points in 2D space
 */
public class TwoPoints {

    private Point[] points = new Point[2];
    private Random rand = new Random();

    /** ctor */
    public TwoPoints() {
        points[0] = new Point(0,0);
        points[1] = new Point(0,0);
    }

    /** get a point */
    public Point getPoint(int index) {
        return points[index];
    }

    /** set a point */
    public void setPoint(int index, int x, int y) {
        points[index].x = x;
        points[index].y = y;
    }

    /** assign a random value to a point */
    public void randomValue(int index) {
        int x = rand.nextInt(20) - 10;
        int y = rand.nextInt(20) - 10;
        setPoint(index, x, y);
    }

    /** sets a point to the origin */
    public void setOrigin(int index) {
        setPoint(index, 0, 0);
    }

    /** copy the values in one points to the other */
    public void copy(int srcIndex, int destIndex) {
        points[destIndex] = points[srcIndex];
    }

    /** calculates the distance between the two points rounded to the nearest integer */
    public double distance() {
        double result = 0.0;
        int xDiff = points[0].x - points[1].x;
        int yDiff = points[0].y - points[1].y;
        result = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
        return result;
    }

    /** calculates the slope of a line passing through the two points
     *
     * @return the slope or 0 if the points are equal */
    public double slope() {
        double result = 0.0;
        //if (points[0] == points[1]) {
            //return result;
        //}

        //int xDiff = points[0].x - points[1].x;
        //int yDiff = points[0].y - points[1].y;

        //result = xDiff / yDiff;
        //--------------------------------------------------------------
        //NEW CODE
        //--------------------------------------------------------------

        //1. find xDiff and yDiff
        int xDiff = points[1].x - points[0].x;
        int yDiff = points[1].y - points[0].y;
        //2. Make first assertions
        //CASE 1: yDiff is zero
        if (yDiff == 0)
        {
            return result;
        }
        //CASE 2: xDiff is zero
        if (xDiff == 0)
        {
            if(yDiff > 0)
            {
                return Double.POSITIVE_INFINITY;
            }
            else
            {
                return Double.NEGATIVE_INFINITY;
            }
        }
        else
        {
            //Copied from previous block: BUG
            //Solution: switch the numerator and denominator
            result = (double) yDiff/xDiff;
        }

        return result;
    }


}//TwoPoints
