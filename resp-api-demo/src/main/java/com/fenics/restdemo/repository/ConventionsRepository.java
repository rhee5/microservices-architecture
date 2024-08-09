package com.fenics.restdemo.repository;

import com.fenics.restdemo.model.Conventions;
import com.fenics.restdemo.model.ConventionsKey;
import com.fenics.restdemo.model.Prefs;
import com.fenics.restdemo.model.PrefsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ConventionsRepository extends JpaRepository<Conventions, ConventionsKey> {

    @Query("SELECT c FROM Conventions c WHERE c.conventionsKey.ccy = :ccy")
    List<Conventions> findAllByCcy(@Param("ccy") String ccy);

    @Query("SELECT c FROM Conventions c WHERE c.conventionsKey.ctr = :ctr")
    List<Conventions> findAllByCtr(@Param("ctr") String ctr);

    @Query("SELECT c FROM Conventions c WHERE c.conventionsKey.ccy = :ccy AND c.conventionsKey.ctr = :ctr")
    List<Conventions> findAllByCcyCtr(@Param("ccy") String ccy, @Param("ctr") String ctr);

    @Modifying
    @Transactional
    @Query("DELETE FROM Conventions c WHERE c.conventionsKey.ccy = :ccy AND c.conventionsKey.ctr = :ctr")
    void deleteConvention(@Param("ccy") String ccy, @Param("ctr") String ctr);

}