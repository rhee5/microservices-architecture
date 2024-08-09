package com.fenics.restdemo.repository;

import com.fenics.restdemo.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {

    @Query("SELECT h FROM Holiday h WHERE h.id.ccy = :ccy AND h.id.holidayDate = :holidayDate")
    Optional<Holiday> findAllByCcyAndHolidayDate(@Param("ccy") String ccy, @Param("holidayDate") LocalDate holidayDate);

    @Query("SELECT h FROM Holiday h WHERE h.id.ccy = :ccy")
    List<Holiday> findAllByCcy(@Param("ccy") String ccy);

    @Query("SELECT h FROM Holiday h WHERE h.id.holidayDate = :date")
    List<Holiday> findAllByDate(@Param("date") LocalDate date);

    @Modifying
    @Transactional
    @Query("DELETE FROM Holiday h WHERE h.id.holidayDate = :date AND h.id.ccy = :ccy")
    void deleteByCcyDate(@Param("ccy") String ccy, @Param("date") LocalDate holidayDate);

}

