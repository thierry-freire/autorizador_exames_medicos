package br.com.autorizador.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.autorizador.domain.SolicitacaoProcedimento;
import br.com.autorizador.util.HibernateUtil;

public class SolicitacaoProcedimentoDao {
	private SessionFactory sessionFactory;
	
	public SolicitacaoProcedimentoDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public List<SolicitacaoProcedimento> getSolicitacoes() {
		Transaction transaction = null;
        List < SolicitacaoProcedimento > solicitacaoProcedimentos = null;
        Session session = null;
        try {
        	session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            solicitacaoProcedimentos = session.createQuery("from SolicitacaoProcedimento").getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
        	session.close();
		}
        return solicitacaoProcedimentos;
	}
	
	public void saveSolicitacao(SolicitacaoProcedimento solicitacaoProcedimento) {
		Transaction transaction = null;
		Session session = null;
        try {
        	session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            
            session.save(solicitacaoProcedimento);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
			session.close();
		}
	}

}
