package com.ipartek;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class SetTest {

	@Test
	public void test() {
		assertTrue(true);
		
		HashSet<String> paises = new HashSet<String>();
		
		assertNotNull(paises);
		
		paises.add("eh");
		paises.add("cat");
		paises.add("esp");
		paises.add("fra");
		
		assertEquals("mensaje personalizado por si falla", 4, paises.size());
		
		paises.add("eh");
		paises.add("cat");
		paises.add("esp");
		paises.add("fra");
		
		assertEquals("no deberia haber duplicados", 4, paises.size());
	}

}
