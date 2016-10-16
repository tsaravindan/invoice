package com.invoice.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.invoice.dataaccess.InvoiceDAO;
import com.invoice.model.Invoice;
import com.invoice.service.InvoiceService;
import com.invoice.service.InvoiceServiceImpl;
import com.invoice.util.InvoiceException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class InvoiceServiceImplTest {
	
	private InvoiceService invoiceService;
	
	@Autowired(required=true)
	@Qualifier(value="invoiceService")
	public void setInvoiceService(InvoiceService ps){
		this.invoiceService = ps;
	}
	
	@Autowired
	InvoiceDAO invoiceDAO;

	@Test
	public void testListInvoice() throws InvoiceException {
		List<Invoice> invoiceList = invoiceService.listInvoice();
		Assert.assertNotNull(invoiceList);
		
	}

	@Test
	public void testFindInvoice() throws InvoiceException {
		List<Invoice> invoiceList = invoiceService.findInvoice(1);
		Assert.assertNotNull(invoiceList);
		invoiceList = invoiceService.findInvoice(89);
		Assert.assertNotNull(invoiceList);
	}

	@Test
	public void testFindInvoiceByType() throws InvoiceException {
		List<Invoice> invoiceList = invoiceService.findInvoiceByType("Cash");
		Assert.assertNotNull(invoiceList);
		List<Invoice> invoiceListSec = invoiceService.findInvoiceByType("Security");
		Assert.assertNotNull(invoiceListSec);
		List<Invoice> invoiceListSome = invoiceService.findInvoiceByType("Something");
		Assert.assertNotNull(invoiceListSome);
	}

}
