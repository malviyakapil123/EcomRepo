package com.ecom.repo;

import com.ecom.Entity.Userdto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Userdto,Long> {

    @Query("select u from Userdto u where u.loginId=?1")
    Userdto findByLoginId(String loginId);
}
