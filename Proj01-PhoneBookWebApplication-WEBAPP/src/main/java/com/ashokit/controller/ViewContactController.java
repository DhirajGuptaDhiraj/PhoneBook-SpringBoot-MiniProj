package com.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.dto.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ViewContactController{
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model model){
		Contact contact=contactService.getContactById(contactId);
		model.addAttribute("contact", contact);
	return "index";
	}

@GetMapping("/deleteContact")
public String deleteContact(@RequestParam("cid") Integer contactId){ 
	contactService.deleteContactById(contactId);

	return "redirect:viewContacts";
	
	}
}

