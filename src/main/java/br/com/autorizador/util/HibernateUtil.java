package br.com.autorizador.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.com.autorizador.domain.Procedimentos;
import br.com.autorizador.domain.SolicitacaoProcedimento;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			// Carrega as configurações do hibernate.cfg.xml
			Configuration configuration = new Configuration().configure();

		    configuration.addAnnotatedClass(Procedimentos.class);
		    configuration.addAnnotatedClass(SolicitacaoProcedimento.class);

		    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		    System.out.println("Hibernate Java Config serviceRegistry created");
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Falha ao inicializar o SessionFactory: " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}