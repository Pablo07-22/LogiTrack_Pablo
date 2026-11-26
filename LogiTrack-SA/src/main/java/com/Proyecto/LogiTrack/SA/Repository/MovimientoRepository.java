
package com.Proyecto.LogiTrack.SA.Repository;

import com.Proyecto.LogiTrack.SA.Model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    List<Movimiento> findByTipoMovimiento(Movimiento.TipoMovimiento tipoMovimiento
    );

    List<Movimiento> findByUsuarioResponsable_Id(Long usuarioId);

    List<Movimiento> findByBodegaOrigen_Id(Long bodegaId);

    List<Movimiento> findByBodegaDestino_Id(Long bodegaId);

    // Busca movimientos entre dos fechas.
    List<Movimiento> findByFechaBetween(
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin
    );

    // Busca movimientos de un tipo dentro de un intervalo de fechas.
    List<Movimiento> findByTipoMovimientoAndFechaBetween(
            Movimiento.TipoMovimiento tipoMovimiento,
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin
    );

    List<Movimiento> findByUsuarioResponsable_IdAndTipoMovimiento(
            Long usuarioId,
            Movimiento.TipoMovimiento tipoMovimiento
    );
}
