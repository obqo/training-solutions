package week12.week12d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {
    Street street;
    Site s1, s2, s3, s4, s5, s6;

    @BeforeEach
    void setUp() {
        street = new Street();
        s1 = new Site(Side.values()[0], 10, Fence.PERFECT);
        s2 = new Site(Side.values()[0], 7, Fence.NEED_UPGRADE);
        s3 = new Site(Side.values()[1], 12, Fence.PERFECT);
        s4 = new Site(Side.values()[0], 9, Fence.PERFECT);
        s5 = new Site(Side.values()[0], 11, Fence.NO_FENCE);
        s6 = new Site(Side.values()[1], 13, Fence.PERFECT);
        street.sellSite(s1);
        street.sellSite(s2);
        street.sellSite(s3);
        street.sellSite(s4);
        street.sellSite(s5);
        street.sellSite(s6);
    }

    @Test
    void sellSiteTest() {
        assertEquals(8, street.getSites().get(4).getHouseNumber());
        assertEquals(3, street.getSites().get(5).getHouseNumber());
    }

    @Test
    void lastSiteHouseNumberTest() {
        assertEquals(3, street.lastSiteHouseNumber());
    }
    @Test
    void reportTest(){
        assertEquals(4,street.report().get(0).getCount());
        assertEquals(1,street.report().get(1).getCount());
        assertEquals(1,street.report().get(2).getCount());
    }
}