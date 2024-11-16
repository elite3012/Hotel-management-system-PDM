package com.code.hms.daoImpl;

import com.code.hms.dao.ReservationDAO;
import com.code.hms.utils.LoggingEngine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ReservationDaoImpl implements ReservationDAO {
    @PersistenceContext
    private EntityManager entityManager;
    private LoggingEngine logging;

    public ReservationDaoImpl() {
        logging = LoggingEngine.getInstance();
    }
}
