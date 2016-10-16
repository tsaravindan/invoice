package com.invoice.dataaccess;

import java.util.List;

import com.invoice.model.Invoice;
import com.invoice.util.InvoiceException;

public interface InvoiceDAO {

	public void addInvoice(Invoice p) throws InvoiceException;
	public List<Invoice> listInvoice() throws InvoiceException;
	public List<Invoice> findInvoice(int id) throws InvoiceException;
	public List<Invoice> findInvoiceByType(String type) throws InvoiceException;
}
