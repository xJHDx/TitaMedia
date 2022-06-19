package com.jhd.tita.portalbancario.repository;

import com.jhd.tita.portalbancario.entity.DeudasUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeudasUsuarioRepository extends JpaRepository<DeudasUsuarioEntity,Integer> {

    List<DeudasUsuarioEntity> findByUsuarioId(int usuarioId);

    DeudasUsuarioEntity findByBancoIdAndUsuarioId(Integer bancoId, Integer usuarioId);

}
