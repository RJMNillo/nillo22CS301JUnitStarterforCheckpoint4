package up.edu.dimcalc;

import android.graphics.Point;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPointsTest {

    /** when created, getPoint() should show both points at the origin */
    @Test
    public void getPoint() throws Exception
    {
        TwoPoints testPoints = new TwoPoints();
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(0, p1.x);
        assertEquals(0, p1.y);
        assertEquals(0, p2.x);
        assertEquals(0, p2.y);
    }

    /** verify that arbitrary values are properly stored via setPoint() */
    @Test
    public void setPoint() throws Exception
    {
        TwoPoints testPoints = new TwoPoints();
        testPoints.setPoint(0, 5, -3);
        testPoints.setPoint(1, -3, 5);
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals(5, p1.x);
        assertEquals(-3, p1.y);
        assertEquals(-3, p2.x);
        assertEquals(5, p2.y);
    }

    @Test
    public void randomValue() {
    }

    @Test
    public void setOrigin() {
    }

    @Test
    public void copy() {
    }

    //I will do distance and slope

    @Test
    public void distance()
    {

    }

    @Test
    public void slope() throws Exception
    {
        //I wil make at least 3 cases
        //case 1: normal
        //case 2: same y, different x
        //case 3: slope is undefined, same x
        TwoPoints testPoints1 = new TwoPoints();
        TwoPoints testPoints2 = new TwoPoints();
        TwoPoints testPoints3 = new TwoPoints();
        testPoints1.setPoint(0,1,7);
        testPoints1.setPoint(1,4,3);
        testPoints2.setPoint(0,1,7);
        testPoints2.setPoint(1,4,7);
        testPoints3.setPoint(0,5,1);
        testPoints3.setPoint(1,5,8);
        //for the tests, I will get the same method from TwoPoints.java
        //and get the expected answers from some professional thing
        //lol totally not wolfram alpha
        //1. Make points and get the points from the testpoints
        //p1 and p2 rep test 1, p3 and p4 test 2, p5 and p6 test 3
        Point p1 = testPoints1.getPoint(0);
        Point p2 = testPoints1.getPoint(1);
        Point p3 = testPoints2.getPoint(0);
        Point p4 = testPoints2.getPoint(1);
        Point p5 = testPoints3.getPoint(0);
        Point p6 = testPoints3.getPoint(1);
        //2. Create set differences based on the points.
        int diffX1 = p2.x - p1.x;
        int diffY1 = p2.y - p1.y;
        int diffX2 = p4.x - p3.x;
        int diffY2 = p4.y - p3.y;
        int diffX3 = p6.x - p5.x;
        int diffY3 = p6.y - p5.y;
    }
}