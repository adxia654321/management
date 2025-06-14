package com.practise.repository;

import com.practise.entity.Admin;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    boolean existsByUsername(String username);

    Admin findByUsername(String username);
}
