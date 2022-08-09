package me.blessedsibanda.repository;

import java.util.Optional;

import me.blessedsibanda.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization,String>  {
    public Optional<Organization> findById(String organizationId);
}
