package up.edu.dimcalc;

import android.graphics.Point;

import org.junit.Test;

import java.util.Random;

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
    public void randomValue() throws Exception
    {
        TwoPoints testPoints = new TwoPoints();
        testPoints.randomValue(0);
        testPoints.randomValue(1);
        //Give the values to the points
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals("randomValue does not equal",testPoints.getPoint(0).x,p1.x);
        assertEquals("randomValue does not equal",testPoints.getPoint(0).y,p1.y);
        assertEquals("randomValue does not equal",testPoints.getPoint(1).x,p2.x);
        assertEquals("randomValue does not equal",testPoints.getPoint(1).y,p2.y);
    }

    @Test
    public void setOrigin() throws Exception
    {
        TwoPoints testPoints = new TwoPoints();
        //Start by creating a random
        testPoints.setOrigin(0);
        testPoints.setOrigin(1);
        //Get those points ya yeet
        Point p1 = testPoints.getPoint(0);
        Point p2 = testPoints.getPoint(1);
        assertEquals("setOrigin does not equal",testPoints.getPoint(0).x,p1.x);
        assertEquals("setOrigin does not equal",testPoints.getPoint(0).y,p1.y);
        assertEquals("setOrigin does not equal",testPoints.getPoint(1).x,p2.x);
        assertEquals("setOrigin does not equal",testPoints.getPoint(1).y,p2.y);

    }

    @Test
    public void copy() throws Exception
    {
        //CASE 1: 0 copies 1
        TwoPoints testPoint1 = new TwoPoints();
        testPoint1.randomValue(0);
        testPoint1.randomValue(1);
        testPoint1.copy(1,0);
        Point p1 = testPoint1.getPoint(0);
        Point p2 = testPoint1.getPoint(1);
        assertEquals("The copy machine is broken", p2.x,p1.x);
        assertEquals("The copy machine is broken", p2.y,p1.y);
        //CASE 2: 1 copies 0
        testPoint1.randomValue(0);
        testPoint1.randomValue(1);
        testPoint1.copy(0,1);
        p1 = testPoint1.getPoint(0);
        p2 = testPoint1.getPoint(1);
        assertEquals("The copy machine is broken", p1.x,p2.x);
        assertEquals("The copy machine is broken", p1.y,p2.y);
    }

    @Test
    public void distance()
    {
        TwoPoints testPoints1 = new TwoPoints();
        testPoints1.randomValue(0);
        testPoints1.randomValue(1);
        Point p1 = testPoints1.getPoint(0);
        Point p2 = testPoints1.getPoint(1);
        int xDiff = p2.x - p1.x;
        int yDiff = p2.y - p1.y;
        double expResult = Math.sqrt((double)(xDiff * xDiff) + (yDiff * yDiff));
        assertEquals("Is that the distance",expResult,testPoints1.distance(),0.0001);

    }

    @Test
    public void slope() throws Exception
    {
        //I wil make at least 3 cases
        //case 1: normal
        //case 2: same y, different x
        //case 3: slope is undefined, same x
        TwoPoints testPoints2 = new TwoPoints();
        TwoPoints testPoints3 = new TwoPoints();
        testPoints2.setPoint(0,1,7);
        testPoints2.setPoint(1,4,7);
        testPoints3.setPoint(0,5,1);
        testPoints3.setPoint(1,5,8);
        //for the tests, I will get the same method from TwoPoints.java
        //and get the expected answers from some professional thing
        //lol totally not wolfram alpha

        //2. Create set differences based on the points.
        double result2 = testPoints2.slope();
        double result3 = testPoints3.slope();

        //A bug has been found without assert. Exception: Divide by zero
        //Solution 1: Make this assertion: x2 = x1: slope is infinity, adjust or + and -
        //Solution 2: If y2 = y1 slope is 0.
        //I assume that there are more bugs to handle: Flipped slope formula
        assertEquals("The Slope equation is not working", 0,result2,0.0001);
        assertEquals("The Slope equation is not working", Double.POSITIVE_INFINITY,result3,0.0001);
        //Those cases are done, let's check out a random value

        TwoPoints testPoints1 = new TwoPoints();
        testPoints1.setPoint(0,7,3);
        testPoints1.setPoint(1,1,-5);
        Point p1 = testPoints1.getPoint(0);
        Point p2 = testPoints1.getPoint(1);
        int testXDiff = p2.x - p1.x;
        int testYDiff = p2.y - p1.y;
        double result1 = (double) testYDiff/testXDiff;
        assertEquals("The Slope equation is not working", result1,testPoints1.slope(),0.0001);
        //That confirms the flipped slope (x/y)


    }
}