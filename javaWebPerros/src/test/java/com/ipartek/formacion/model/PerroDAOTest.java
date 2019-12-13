package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.model.pojo.Perro;

public class PerroDAOTest {
	
	private static PerroDAO dao;
	private static Perro mock;
	private static final int MOCK_ID = 1;
	private static final String MOCK_NOMBRE = "Pulgas mock";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		dao = PerroDAO.getInstance();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		dao = null;
		
	}

	@Before
	public void setUp() throws Exception {
		mock = new Perro(MOCK_ID,MOCK_NOMBRE);
		dao.create(mock);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAll() throws Exception {
		
		assertEquals(1, dao.getAll().size());
		
		dao.delete(mock.getId());
		
		assertEquals(0, dao.getAll().size());
		
	}

	@Test
	public void testGetById() throws Exception {
		
		assertNull("Es imposible que exista este perro",dao.getById(-1));
		
		Perro p = dao.getById(MOCK_ID);
		
		assertSame("Deberia existir el perro", p, mock);
		
	}

	@Test
	public void testDelete() {
		
		try {
			
			Perro pEliminar = new Perro(333, "Perros 333");
			
			Perro p = dao.delete(MOCK_ID);
			
			assertSame(p, mock);
			assertEquals("No queda ningun perro",0, dao.getAll().size());
			
			dao.delete(-1);
			fail("Deberia haber lanzado una exception");
			
		} catch (Exception e) {
			
			assertTrue("Lanzada la exception correctamente al eliminar perro que no existe",true);
			
		}	
	
	}

	@Test
	public void testUpdate() {
		// TODO textUpdate
	}

	@Test
	public void testCreate() {
		// TODO textCreate
	}

}
