package com.invoice.service;

import java.util.List;

import com.invoice.model.Invoice;
import com.invoice.util.InvoiceException;

public interface InvoiceService {

	public void addInvoice(Invoice p) throws InvoiceException;
	public List<Invoice> listInvoice() throws InvoiceException;
	public List<Invoice> findInvoice(int id) throws InvoiceException;
	public List<Invoice> findInvoiceByType(String type) throws InvoiceException;
}
