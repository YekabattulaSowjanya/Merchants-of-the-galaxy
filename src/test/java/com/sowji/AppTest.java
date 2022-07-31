package com.sowji;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import com.merchants.IRoman;
import com.merchants.RomanToRealImp;
import com.merchants.TestStart;

public class AppTest extends TestStart {
            TestStart ts=new TestStart();
	
	@Test
	public void App() throws Exception {
		
		IRoman iroman=new RomanToRealImp();
		
		String input="I";
		
		assertEquals(iroman.calculateDemo(input), 1);
		
//        //1. Test equal, ignore order
//        assertThat(initMap, is(expected));
//
//        //2. Test size
//        assertThat(map.size(), is(4));

	}

    @Test
    
    public void AppTest() throws Exception {
		
		IRoman iroman=new RomanToRealImp();
		
		String input="MCMXLIV";
		
		assertEquals(iroman.calculateDemo(input), 1944);
    
     }
    
    @Test
    
    public void AppTest1() throws Exception {
		
		IRoman iroman=new RomanToRealImp();
		
		String input="XXXIX";
		
		assertEquals(iroman.calculateDemo(input), 39);
    
     }
    
@Test
    
    public void AppTest2() throws Exception {
		
		IRoman iroman=new RomanToRealImp();
		
		String input="M";
		
		assertEquals(iroman.calculateDemo(input), 1000);
    
     }
}