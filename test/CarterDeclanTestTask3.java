//package cm;

import cm.CarParkKind;
import cm.Period;
import cm.Rate;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CarterDeclanTestTask3 {
    ArrayList<Period> reducePeriods;
    ArrayList<Period> reducePeriodsCC1;
    ArrayList<Period> reducePeriodsCC2;
    ArrayList<Period> reducePeriodsCC3;

    ArrayList<Period> normalPeriods;
    ArrayList<Period> normalPeriodsCC1;
    ArrayList<Period> normalPeriodsCC2;
    ArrayList<Period> normalPeriodsCC3;

    ArrayList<Period> normalPeriodsCC4;
    ArrayList<Period> reducePeriodsCC4;

    BigDecimal b;


    @Before
    public void instantiatePeriods() {
        reducePeriods = new ArrayList<>();
        reducePeriods.add(new Period(6,7));
        normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2,5));
        normalPeriods.add(new Period(17,20));

        // ArrayList
        reducePeriodsCC1 = new ArrayList<Period>() {{ add(new Period(2,4)); add(new Period(18,19)); }};
        normalPeriodsCC1 = new ArrayList<Period>() {{ add(new Period(0,2)); add(new Period(13,17)); add(new Period(23,24)); }};

        // ArrayList
        reducePeriodsCC2 = new ArrayList<Period>() {{ add(new Period(0,4)); add(new Period(23,24)); }};
        normalPeriodsCC2 = new ArrayList<Period>() {{ add(new Period(6,23)); }};

        // ArrayList
        reducePeriodsCC3 = new ArrayList<Period>() {{ add(new Period(0,2)); add(new Period(13,17)); add(new Period(23,24)); }};
        normalPeriodsCC3 = new ArrayList<Period>() {{ add(new Period(2,4)); add(new Period(5,12)); add(new Period(17,19)); }};

        // ArrayList (null pointers)
        normalPeriodsCC4 = null;
        reducePeriodsCC4 = null;

        b = null;
    }

    /*
    ----------------------------------------------- rate(...) Unit Tests -----------------------------------------------
     */

    /*
    TEST 1: Kind is valid.
     */
    @org.junit.Test
    public void kindIsValid() {
        Rate rt = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 2: normal rate > 0
     */
    @org.junit.Test
    public void normalRateGreaterThanZero() {
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(2.5), BigDecimal.valueOf(1), reducePeriods, normalPeriods);
    }

    /*
    TEST 3: normalRate == maxInt
     */
    @org.junit.Test
    public void normalRateMaxInt() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(Integer.MAX_VALUE), BigDecimal.valueOf(42), reducePeriods, normalPeriods);
    }

    /*
    TEST 4: normalRate > reduceRate
     */
    @org.junit.Test
    public void normalRateGreaterThanreduceRate() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(4), reducePeriods, normalPeriods);
    }

    /*
    TEST 5: normalRate < 0
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateLessThan0() throws Exception {
        Rate rt = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(-1), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 6: normalRate == 1
     */
    @org.junit.Test
    public void normalRateEqualOne() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(1), BigDecimal.valueOf(.5), reducePeriods, normalPeriods);
    }

    /*
    TEST 7: normalRate == 0
     */
    @org.junit.Test
    public void normalRateEqualZero() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(0), BigDecimal.valueOf(0), reducePeriods, normalPeriods);
    }

    /*
    TEST 8: normalRate, reduceRate invalid argument
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateInvalidArgument() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf('J'), BigDecimal.valueOf('f'), reducePeriods, normalPeriods);
    }

    /*
    TEST 9: normalRate < reduceRate
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateLessThanreduceRate() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(7), reducePeriods, normalPeriods);
    }

    /*
    TEST 10: reduceRate > normalRate
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reduceRateGreaterThanNormalRate() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(1), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 11: reduceRate == 1
     */
    @org.junit.Test
    public void reduceRateEqualToOne() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(2), BigDecimal.valueOf(1.57), reducePeriods, normalPeriods);
    }

    /*
    TEST 12: reduceRate == maxInt - 1
     */
    @org.junit.Test
    public void reduceRateMaxInt() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(Integer.MAX_VALUE), BigDecimal.valueOf(Integer.MAX_VALUE -1 ), reducePeriods, normalPeriods);
    }

    /*
    TEST 13: reduceRate < 0
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reduceRateLessThan0() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(-1), reducePeriods, normalPeriods);
    }

    /*
    TEST 14: reduceRate == 0
     */
    @org.junit.Test
    public void reduceRateEqualZero() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(0), reducePeriods, normalPeriods);
    }

    /*
    TEST 15: reduceRate == normalRate
     */
    @org.junit.Test
    public void reduceRateEqualToNormal() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(2), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 16: reducePeriod min period
     */
    @org.junit.Test
    public void reducePeriodMin() {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{add(new Period(0, 1));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 17: reducePeriod max
     */
    @org.junit.Test
    public void reducePeriodMax() {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{add(new Period(0, 24));}};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 18: reducePeriod within bounds
     */
    @org.junit.Test
    public void reducePeriodValidPeriod() {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{add(new Period(11, 17));}};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 19: reducePeriod no period specified
     */
    @org.junit.Test
    public void reducePeriodNoPeriodSpecified() {
        ArrayList<Period> reducePeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 20: reducePeriods max number periods
     */
    @org.junit.Test
    public void reducePeriodsMaxPeriods() {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{
            for (int i = 0; i < 24; i++) {
                add(new Period(i, i + 1));
            }
        }};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 21: reducePeriod start > reducePeriod end
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducePeriodStartGreaterThanEnd() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{add(new Period(10, 1));}};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 22: reducePeriod out of bounds
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducePeriodOutOfBounds() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{add(new Period(0, 48));}};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 23: reducePeriod out of bounds (boundary check)
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducePeriodOutOfBoundsOnBoundary() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{add(new Period(0, 25));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 24: reducePeriod overlap
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducePeriodOverlap() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{add(new Period(6,7)); add(new Period(6,8));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 25: reducePeriod overlap with normalPeriod
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducePeriodOverlapWithNormal() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{add(new Period(2, 7));}};
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(new Period(6, 10));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 26: reducePeriod overlap with normalPeriod
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducePeriodOverlapWithNormalAlt() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{add(new Period(2, 7)); add(new Period(10, 23));}};
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(new Period(7, 10)); add(new Period(10, 11));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 27: reducePeriods too many periods
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducePeriodsTooManyPeriods() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{
            for (int i = 0; i < 25; i++) {
                add(new Period(i, i + 1));
            }
        }};
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 28: normalPeriod min range period
     */
    @org.junit.Test
    public void normalPeriodMin() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(new Period(0, 1));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 29: normalPeriod max range period
     */
    @org.junit.Test
    public void normalPeriodMax() {
        ArrayList<Period> reducePeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(new Period(0, 24));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 30: normalPeriod within bounds
     */
    @org.junit.Test
    public void normalPeriodValidPeriod() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{ add(new Period(11, 17));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 31: normalPeriods max number periods
     */
    @org.junit.Test
    public void normalPeriodsMaxPeriods() {
        ArrayList<Period> reducePeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{
            for (int i = 0; i < 24; i++) {
                add(new Period(i, i + 1));
            }
        }};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 32: normalPeriod start > normalPeriod end
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodStartGreaterThanEnd() throws Exception {
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(new Period(10, 1));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 33: normalPeriod out of bounds
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodOutOfBounds() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(new Period(0, 48));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 34: normalPeriod out of bounds (boundary check)
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodOutOfBoundsOnBoundary() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(new Period(0, 25));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 35: normalPeriod overlap
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodOverlap() throws Exception {
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(new Period(2, 4)); add(new Period(3, 5));}};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 36: normalPeriods too many periods
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodsTooManyPeriods() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{
            for (int i = 0; i < 25; i++) {
                add(new Period(i, i + 1));
            }
        }};
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 37: only free periods
     */
    @org.junit.Test
    public void onlyfreePeriod() {
        ArrayList<Period> reducePeriods = new ArrayList<>();
        ArrayList<Period> normalPeriods = new ArrayList<>();
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 38: normalPeriods null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodsNullPointer() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriodsCC4);
    }

    /*
    TEST 39: reducePeriods null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducePeriodsNullPointer() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriodsCC4, normalPeriods);
    }

    /*
    TEST 40: normal periods and reduce periods null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void periodsNullPointer() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriodsCC4, normalPeriodsCC4);
    }

    /*
    TEST 41: normalRate is null
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalRateNull() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, b, BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 42: reduceRate is null
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reduceRateNull() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), b, reducePeriods, normalPeriods);
    }

    /*
    TEST 43: normalRate and reduceRate is null
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void ratesNull() throws Exception {
        Rate rt = new Rate(CarParkKind.STUDENT, b, b, reducePeriods, normalPeriods);
    }

    /*
    TEST 44: reducePeriods contain null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void reducePeriodsContainNull() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{add(null);}};
        Rate rt = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 45: normalPeriods contain null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void normalPeriodsContainNull() throws Exception {
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(null);}};
        Rate rt = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    TEST 46: normalPeriods and reducePeriods contain null pointer
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void periodsListsContainNull() throws Exception {
        ArrayList<Period> reducePeriods = new ArrayList<Period>(){{add(null);}};
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{add(null);}};
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
    }

    /*
    ------------------------------------------- calculate() Unit Tests -------------------------------------------
     */

    /*
    TEST 1: first period, normal period boundary
     */
    @org.junit.Test
    public void firstPeriodNormalPeriodBound() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriodsCC1, normalPeriodsCC1);
        Period periodStay = new Period(0,1);
        assertTrue(BigDecimal.valueOf(3).compareTo(rt.calculate(periodStay)) == 0);

    }

    /*
    TEST 2: last period, normal period boundary
     */
    @org.junit.Test
    public void lastPeriodNormalPeriodBound() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriodsCC1, normalPeriodsCC1);
        Period periodStay = new Period(23,24);
        assertTrue(BigDecimal.valueOf(3).compareTo(rt.calculate(periodStay)) == 0);
    }

    /*
    TEST 3: first period, reduce period boundary
     */
    @org.junit.Test
    public void firstPeriodreducePeriodBound() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriodsCC2, normalPeriodsCC2);
        Period periodStay = new Period(0,1);
        assertTrue(BigDecimal.valueOf(2).compareTo(rt.calculate(periodStay)) ==0);

    }

    /*
    TEST 4: last period, reduce period boundary
     */
    @org.junit.Test
    public void lastPeriodreducePeriodBound() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriodsCC2, normalPeriodsCC2);
        Period periodStay = new Period(23,24);
        assertTrue(BigDecimal.valueOf(2).compareTo(rt.calculate(periodStay)) == 0);

    }

    /*
    TEST 5: arbitrary period - normal rate
     */
    @org.junit.Test
    public void arbitraryPeriodNormalRate() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(14,17);
        assertTrue(BigDecimal.valueOf(5.70).compareTo(rt.calculate(periodStay)) == 0);
    }

    /*
    TEST 6: first period in normal period
     */
    @org.junit.Test
    public void firstNormalPeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(4), BigDecimal.valueOf(1), reducePeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(2,4);
        assertTrue(BigDecimal.valueOf(7.1).compareTo(rt.calculate(periodStay)) == 0);
    }

    /*
    TEST 7: last period in normal period
     */
    @org.junit.Test
    public void lastNormalPeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(1), reducePeriods, normalPeriods);
        Period periodStay = new Period(17,19);
        assertTrue(BigDecimal.valueOf(8.5).compareTo(rt.calculate(periodStay)) == 0);
    }

    /*
    TEST 8: arbitrary period - reduce rate
     */
    @org.junit.Test
    public void arbitraryPeriodreduceRate() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(4), BigDecimal.valueOf(1), reducePeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(14,17);
        assertTrue(BigDecimal.valueOf(3).compareTo(rt.calculate(periodStay)) == 0);
    }

    /*
    TEST 9: normal period and free period
     */
    @org.junit.Test
    public void normalPeriodAndFreePeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(18,20);
        assertTrue(BigDecimal.valueOf(3).compareTo(rt.calculate(periodStay)) == 0);
    }

    /*
    TEST 10: normal period and reduce period
     */
    @org.junit.Test
    public void normalPeriodAndreducePeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(1,3);
        assertTrue(BigDecimal.valueOf(5).compareTo(rt.calculate(periodStay)) == 0);
    }

    /*
    TEST 11: reduce period and free period
     */
    @org.junit.Test
    public void reducePeriodAndFreePeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(3), BigDecimal.valueOf(2), reducePeriodsCC3, normalPeriodsCC3);
        Period periodStay = new Period(12,14);
        assertTrue(BigDecimal.valueOf(2).compareTo(rt.calculate(periodStay)) == 0);
    }

    /*
    TEST 12: normal, reduce and free period
     */
    @org.junit.Test
    public void normalreduceFreePeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(16,20);
        assertTrue(BigDecimal.valueOf(12).compareTo(rt.calculate(periodStay)) == 0);

    }

    /*
    TEST 13: Free period (no charge)
     */
    @org.junit.Test
    public void freePeriod() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(8,9);
        assertTrue(BigDecimal.valueOf(0).compareTo(rt.calculate(periodStay)) == 0);
    }

    /*
    TEST 14: Visitor Rate
     */
    @org.junit.Test
    public void visitorRate() {
        Rate rt = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(2,5);
        assertTrue(BigDecimal.valueOf(2.5).compareTo(rt.calculate(periodStay)) == 0);

    }

    /*
    TEST 15: Staff Rate
     */
    @org.junit.Test
    public void staffRateMaxCharge() {
        Rate rt = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(2,20);
        assertTrue(BigDecimal.valueOf(15).compareTo(rt.calculate(periodStay)) == 0);

    }

    /*
    TEST 16: Management Rate
     */
    @org.junit.Test
    public void managementRate() {
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(5,8);
        assertTrue(BigDecimal.valueOf(2).compareTo(rt.calculate(periodStay)) == 0);
    }

    /*
    TEST 17: Student Rate - first 5.00 no reduce
     */
    @org.junit.Test
    public void studentRate() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(7,18);
        assertTrue(BigDecimal.valueOf(5).compareTo(rt.calculate(periodStay)) == 0);
    }

    /*
    TEST 18: Staff Rate - max charge
     */
    @org.junit.Test
    public void staffRate() {
        Rate rt = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(4,19);
        assertTrue(BigDecimal.valueOf(15).compareTo(rt.calculate(periodStay)) == 0);

    }

    /*
    TEST 19: Visitor Free Rate (no charge)
     */
    @org.junit.Test
    public void visitorFreeRate() {
        Rate rt = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(20,21);
        assertTrue(BigDecimal.valueOf(0).compareTo(rt.calculate(periodStay)) == 0);

    }

    /*
    TEST 20: Management Free Rate (no charge)
     */
    @org.junit.Test
    public void managementFreeRate() {
        Rate rt = new Rate(CarParkKind.MANAGEMENT, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(20,22);
        assertTrue(BigDecimal.valueOf(0).compareTo(rt.calculate(periodStay)) == 0);

    }

    /*
    TEST 21: Staff Free Rate (no charge)
     */
    @org.junit.Test
    public void staffFreeRate() {
        Rate rt = new Rate(CarParkKind.STAFF, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(21,23);
        assertTrue(BigDecimal.valueOf(0).compareTo(rt.calculate(periodStay)) == 0);

    }

    /*
   TEST 22: Student rate - boundary
    */
    @org.junit.Test
    public void studentRateBoundary() {
        Rate rt = new Rate(CarParkKind.STUDENT, BigDecimal.valueOf(2.51), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(2,4);
        assertTrue(BigDecimal.valueOf(5.02).compareTo(rt.calculate(periodStay)) == 0);

    }

    /*
   TEST 23: Visitor Rate charge less than 10.00
    */
    @org.junit.Test
    public void visitorRateLess10() {
        Rate rt = new Rate(CarParkKind.VISITOR, BigDecimal.valueOf(5), BigDecimal.valueOf(2), reducePeriods, normalPeriods);
        Period periodStay = new Period(2,4);
        assertTrue(BigDecimal.valueOf(0).compareTo(rt.calculate(periodStay)) == 0);
    }
}