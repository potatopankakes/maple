package com.gnoras.maple.dal.model.dao.impl;

import java.io.Serializable;
import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import com.gnoras.maple.dal.model.Language;
import org.springframework.stereotype.Repository;
import com.gnoras.maple.dal.model.dao.LanguageDao;

/**
 * DAO for table: Language.
 * @author autogenerated
 */
@Repository
public class LanguageDaoImpl extends GenericHibernateDaoImpl<Language, Serializable> implements LanguageDao {
	
	/** Constructor method. */
		public LanguageDaoImpl() {
			super(Language.class);
		}
	}

