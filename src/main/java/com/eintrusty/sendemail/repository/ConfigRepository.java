package com.eintrusty.sendemail.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eintrusty.sendemail.entity.ConfigEntity;

@Repository
public interface ConfigRepository extends CrudRepository<ConfigEntity,String> {
	
	@Query("SELECT a FROM ConfigEntity a WHERE a.condition=:condition")
	public ConfigEntity findOneByCondition(@Param("condition") String condtion);

}
