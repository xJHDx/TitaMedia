package com.jhd.tita.portalbancario.repository;

import com.jhd.tita.portalbancario.entity.DetalleDeudaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleDeudaRepository extends JpaRepository<DetalleDeudaEntity,Integer> {

    @Query(value = "select * from detalle_deuda where banco_id = :bancoId and usuario_id = :usuarioId",nativeQuery = true)
    List<DetalleDeudaEntity> findByBancoIdAndUsuarioId(@Param("bancoId") int bancoId, @Param("usuarioId") Long usuarioId);

}
