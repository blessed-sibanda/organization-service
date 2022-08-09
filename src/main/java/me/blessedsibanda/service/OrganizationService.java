package me.blessedsibanda.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.blessedsibanda.model.Organization;
import me.blessedsibanda.repository.OrganizationRepository;

@Service
public class OrganizationService {
	
    @Autowired
    private OrganizationRepository repository;

    public Organization findById(String organizationId) {
    	Optional<Organization> opt = repository.findById(organizationId);
        return (opt.isPresent()) ? opt.get() : null;
    }

    public Organization create(Organization organization){
    	organization.setId( UUID.randomUUID().toString());
        organization = repository.save(organization);
        return organization;

    }

    public void update(String id, Organization organization){
    	var org = repository.findById(id);
        if (org.isPresent()) {
            var o = org.get();
            o.setName(organization.getName());
            o.setContactEmail(organization.getContactEmail());
            o.setContactName(organization.getContactName());
            o.setContactPhone(organization.getContactPhone());
            repository.save(o);
        }
    }

    public void delete(String id){
    	repository.deleteById(id);
    }
}