package com.invoice.dataaccess;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.invoice.model.Invoice;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(InvoiceDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addInvoice(Invoice p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Invoice saved successfully, Invoice Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> listInvoice() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Invoice> invoiceList = session.createQuery("from Invoice").list();
		for(Invoice p : invoiceList){
			logger.info("Invoice List by type::"+p);
		}
		return invoiceList;
	}

	@Override
	public List<Invoice> findInvoice(int id) {
		try{
			Session session = this.sessionFactory.getCurrentSession();		
			Invoice p = (Invoice) session.load(Invoice.class, new Integer(id));
			logger.info("Invoice loaded successfully, Invoice details="+p);
			List<Invoice> invoiceList = new ArrayList<Invoice>();
			invoiceList.add(p);
			return invoiceList;
		} catch (ObjectNotFoundException e){
			return new ArrayList<Invoice>();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> findInvoiceByType(String type){
		try{
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Invoice where type=:type");
			query.setParameter("type", type);
			List<Invoice> invoiceList = query.list();
			for(Invoice p : invoiceList){
				logger.info("Invoice List::"+p);
			}
			return invoiceList;
			
		} catch (ObjectNotFoundException e){
			return new ArrayList<Invoice>();
		}
		
	}


}
