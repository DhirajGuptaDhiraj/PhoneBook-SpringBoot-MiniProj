package com.ashokit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.dto.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ContactInfoController{
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/")
 public String loadContactFrom(Model model) { // to load the form
		Contact contactObj = new Contact();
		model.addAttribute("contact", contactObj); 
		return "index";    
	
 }

	@PostMapping("/saveContact")
 public String handleSubmitBtn(@ModelAttribute("contact") Contact c, Model model) {
	 
		boolean isSaved	= contactService.saveContact(c);
		
		if(isSaved) {
			if(c.getCid()!=null) {
				model.addAttribute("succMsg","Record updated successfully");
			}else {
				model.addAttribute("succMsg","Record saved successfully");
			}
		}else {
			model.addAttribute("errMsg","Failed to save contact");
		}
		return "index"; // form submission
	
 }
 
	@GetMapping("/viewContacts")
 public String viewContacts(Model model) { //hyperlink
	List<Contact> allContacts = contactService.getAllContacts();
	model.addAttribute("contacts",allContacts);
		
	return "viewContacts";  
 }
}

