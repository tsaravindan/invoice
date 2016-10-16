package com.invoice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invoice.dataaccess.InvoiceDAO;
import com.invoice.model.Invoice;
import com.invoice.util.InvoiceException;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	private InvoiceDAO invoiceDAO;

	public void setInvoiceDAO(InvoiceDAO invoiceDAO) {
		this.invoiceDAO = invoiceDAO;
	}

	@Override
	@Transactional
	public void addInvoice(Invoice p) throws InvoiceException {
		this.invoiceDAO.addInvoice(p);
	}

	@Override
	@Transactional
	public List<Invoice> listInvoice() throws InvoiceException {
		return this.invoiceDAO.listInvoice();
	}

	@Override
	@Transactional
	public List<Invoice> findInvoice(int id) throws InvoiceException {
		return this.invoiceDAO.findInvoice(id);
	}
	
	@Override
	@Transactional
	public List<Invoice> findInvoiceByType(String type) throws InvoiceException {
		return this.invoiceDAO.findInvoiceByType(type);
	}

}
