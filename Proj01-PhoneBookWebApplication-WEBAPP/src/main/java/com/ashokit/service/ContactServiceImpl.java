package com.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.dto.Contact;
import com.ashokit.persistenceLayer.ContactDtlsEntity;
import com.ashokit.persistenceLayer.ContactDtlsRepository;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactDtlsRepository contactDtlsRepo;

	@Override
	public boolean saveContact(Contact c) {

		ContactDtlsEntity entity = new ContactDtlsEntity();
		
		BeanUtils.copyProperties(c, entity);
		ContactDtlsEntity savedEntity = contactDtlsRepo.save(entity);
		
		return savedEntity.getCid()!=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contactList=new ArrayList<Contact>();
		List<ContactDtlsEntity> entityList = contactDtlsRepo.findAll();
		entityList.forEach(entity-> {
		Contact c=new Contact();
		BeanUtils.copyProperties(entity,c);
		contactList.add(c);
		});
		return contactList;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactDtlsEntity> optional=contactDtlsRepo.findById(cid);
		if(optional.isPresent()) {
			ContactDtlsEntity entity=optional.get();
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
		}	
		return null;
	}

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContactById(Integer cid) {
		contactDtlsRepo.deleteById(cid);
		return true;
	}
	
	

}
