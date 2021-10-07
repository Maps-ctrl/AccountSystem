package flow.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MilesTest {
    private Modulo mod;

    @Before
    public void setUp() throws Exception{
        mod = new Modulo();
    }


    @Test
    public void testMod(){
        Integer result = mod.doMod(1,2);
        assertNotNull("Should not be null", result);
        assertEquals("Should be value of 500 miles", 500,result.intValue());

    }
    @Test(expected = RuntimeException.class)
    public void testModBy0(){
        try {
            Integer result = mod.doMod(2,0);
            fail("SHOULD THROW AND EXCEPTION");

        }catch (Exception e){
            assertEquals("Error! Result not as expected",e.getMessage().equalsIgnoreCase("Miles cannot be minused"));
        }
        }
    }
