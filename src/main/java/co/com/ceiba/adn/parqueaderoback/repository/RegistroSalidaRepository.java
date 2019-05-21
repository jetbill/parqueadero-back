package co.com.ceiba.adn.parqueaderoback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parqueaderoback.entity.RegistroEntradaEntity;
import co.com.ceiba.adn.parqueaderoback.entity.RegistroSalidaEntity;

@Repository
public interface RegistroSalidaRepository  extends CrudRepository<RegistroSalidaEntity, Long>{
	@Query(value="SELECT s FROM salidas s WHERE s.entrada.id =?1 AND s.entrada.estadoParqueo = true")
	List<RegistroSalidaEntity> buscarEntradaPorId(Long id);
}
