package com.proyects.foro_hub.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRespuestaRepository extends JpaRepository<Respuesta, Integer> {

    boolean existsByMensajeRespuestaAndTemaIdId(String mensajeRespuesta, Integer temaId);

    boolean existsByMensajeRespuestaAndTemaIdIdAndIdNot(String mensajeRespuesta, Integer temaId, Integer id);
}
