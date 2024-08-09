package com.fenics.restdemo.repository;

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
public interface PrefsRepository extends JpaRepository<Prefs, PrefsKey> {

    @Query("SELECT p FROM Prefs p WHERE p.prefsKey.userName = :UN")
    List<Prefs> findAllByUN(@Param("UN") String UN);

    @Query("SELECT p FROM Prefs p WHERE p.prefsKey.prefName = :PN")
    List<Prefs> findAllByPN(@Param("PN") String PN);

    @Query("SELECT p FROM Prefs p WHERE p.prefValue = :PV")
    List<Prefs> findAllByPV(@Param("PV") String PV);

    @Query("SELECT p FROM Prefs p WHERE p.prefsKey.userName = :UN AND p.prefsKey.prefName = :PN")
    List<Prefs> findAllByUNPN(@Param("UN") String UN, @Param("PN") String PN);

    @Query("SELECT p FROM Prefs p WHERE p.prefsKey.prefName = :PN AND p.prefValue = :PV")
    List<Prefs> findAllByPNPV(@Param("PN") String PN, @Param("PV") String PV);

    @Query("SELECT p FROM Prefs p WHERE p.prefValue = :PV AND p.prefsKey.userName = :UN")
    List<Prefs> findAllByUNPV(@Param("UN") String UN, @Param("PV") String PV);

    @Query("SELECT p FROM Prefs p WHERE p.prefValue = :PV AND p.prefsKey.userName = :UN AND p.prefsKey.prefName = :PN")
    List<Prefs> findAllByUNPNPV(@Param("UN") String UN, @Param("PV") String PV, @Param("PN") String PN);

    @Modifying
    @Transactional
    @Query("DELETE FROM Prefs p WHERE p.prefValue = :PV AND p.prefsKey.userName = :UN AND p.prefsKey.prefName = :PN")
    void deletePrefsData(@Param("UN") String UN, @Param("PV") String PV, @Param("PN") String PN);

}