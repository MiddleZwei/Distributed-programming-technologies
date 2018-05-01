package com.webappdatabase.dao;

import com.webappdatabase.model.Resource;
import com.webappdatabase.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResourceDao extends JpaRepository<Resource, Long> {

//    @Query(value = "select r from Resource r where r.id = :user");
//    Page<User> finByUser (@Param("user") User user, Pageable pageable);



}
