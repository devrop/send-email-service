package com.eintrusty.sendemail.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eintrusty.sendemail.entity.TrackedEmail;


@Repository
public interface TrackedEmailRepository extends CrudRepository<TrackedEmail,String>  {

}
