package com.jhd.tita.portalbancario.repository;

import com.jhd.tita.portalbancario.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {

    UsuarioEntity findByUserName(String userName);

    UsuarioEntity findByUsuariosId(Long id);

}
