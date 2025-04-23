package com.nursalim.spring.boot.restful.api.repository;

import com.nursalim.spring.boot.restful.api.entity.Contact;
import com.nursalim.spring.boot.restful.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, String>, JpaSpecificationExecutor<Contact> {

    Optional<Contact> findFirstByUserAndId(User user, String id);
}
