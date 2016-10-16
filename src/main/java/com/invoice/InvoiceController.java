package com.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.invoice.model.Invoice;
import com.invoice.service.InvoiceService;
import com.invoice.util.InvoiceException;

@Controller
public class InvoiceController {
	
	private InvoiceService invoiceService;
	
	@Autowired(required=true)
	@Qualifier(value="invoiceService")
	public void setInvoiceService(InvoiceService ps){
		this.invoiceService = ps;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String listInvoice(Model model) throws InvoiceException {
		model.addAttribute("invoice", new Invoice());
		model.addAttribute("listInvoice", this.invoiceService.listInvoice());
		return "invoice";
	}
	
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public String findInvoice(Model model, @PathVariable("id") int id) throws InvoiceException {
		model.addAttribute("invoice", new Invoice());
		model.addAttribute("listInvoice", this.invoiceService.findInvoice(id));
		return "invoice";
	}
	
	@RequestMapping(value = "/findtype/{type}", method = RequestMethod.GET)
	public String findInvoiceByType(Model model, @PathVariable("type") String type) throws InvoiceException {
		model.addAttribute("invoice", new Invoice());
		model.addAttribute("listInvoice", this.invoiceService.findInvoiceByType(type));
		return "invoice";
	}
	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addInvoice(@ModelAttribute("invoice") Invoice p) throws InvoiceException {
		
		if(p.getId() == 0){
			this.invoiceService.addInvoice(p);
		}
		
		return "redirect:/get";
		
	}
	
}
