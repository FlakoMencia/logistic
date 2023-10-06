package com.logistic.repository;

import com.logistic.domain.SecRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SecRoleRepository extends JpaRepository<SecRole, Long> {


}
