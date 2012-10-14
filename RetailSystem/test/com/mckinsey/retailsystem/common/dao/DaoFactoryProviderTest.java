package com.mckinsey.retailsystem.common.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mckinsey.retailsystem.common.exception.ExceptionCodes;
import com.mckinsey.retailsystem.common.exception.SystemInitializationException;

public class DaoFactoryProviderTest {

	@Test
	public void testGetDaoFactoryFile() throws SystemInitializationException {
		DaoFactory result = DaoFactoryProvider.getDaoFactory(DaoFactoryTypes.FILE.getType());
		assertTrue(result instanceof FileDaoFactory);
	}
	
	@Test
	public void testGetDaoFactoryDB() throws SystemInitializationException {
		DaoFactory result = DaoFactoryProvider.getDaoFactory(DaoFactoryTypes.DB.getType());
		assertTrue(result instanceof DataBaseDaoFactory);
	}
	
	@Test(expected=SystemInitializationException.class)
	public void testGetDaoFactoryDBUnknown1() throws SystemInitializationException {
		DaoFactory result = DaoFactoryProvider.getDaoFactory("unknown");
		assertTrue(result instanceof FileDaoFactory);
	}
	
	@Test
	public void testGetDaoFactoryUnknown2() {
		DaoFactory result;
		try {
			result = DaoFactoryProvider.getDaoFactory("unknown");
		} catch (SystemInitializationException e) {
			assertEquals(ExceptionCodes.FACTORY_NOT_FOUND.getType(), e.getMessage());
		}
	}

}
