package com.mckinsey.retailsystem.common.dao;

import com.mckinsey.retailsystem.common.exception.ExceptionCodes;
import com.mckinsey.retailsystem.common.exception.SystemInitializationException;

public class DaoFactoryProvider {
	
	public static DaoFactory getDaoFactory(String daoFactoryType) throws SystemInitializationException {
		DaoFactory  daoFactory = null;
		if (DaoFactoryTypes.FILE.getType().equals(daoFactoryType)) {
			daoFactory = new FileDaoFactory();
		} else if (DaoFactoryTypes.DB.getType().equals(daoFactoryType)) {
			daoFactory = new DataBaseDaoFactory();
		} else {
			throw new SystemInitializationException(ExceptionCodes.FACTORY_NOT_FOUND.getType());
		}
		return daoFactory;
	}
}
