package com.jhd.tita.portalbancario.repository;

import com.jhd.tita.portalbancario.entity.BancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancoRepository extends JpaRepository<BancoEntity,Integer > {

    @Query(value = "SELECT * FROM bancos WHERE banco_id IN (:bancosIds)", nativeQuery = true)
    List<BancoEntity> findAllBancoIdIn(@Param("bancosIds") List<Integer> bancosIds);

}
