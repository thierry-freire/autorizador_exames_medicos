package br.com.autorizador.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.autorizador.domain.Procedimentos;
import br.com.autorizador.util.HibernateUtil;

public class ProcedimentosDAO {
	private SessionFactory sessionFactory;
	
	public ProcedimentosDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public List<Procedimentos> getProcedimentos() {
		Transaction transaction = null;
        List < Procedimentos > procedimentos = null;
        Session session = null;
        try {
        	session = sessionFactory.openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            procedimentos = session.createQuery("from Procedimentos").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
        	session.close();
		}
        return procedimentos;
	}

}
