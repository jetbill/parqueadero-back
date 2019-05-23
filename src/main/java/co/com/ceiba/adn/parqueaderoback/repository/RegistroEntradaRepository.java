package co.com.ceiba.adn.parqueaderoback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parqueaderoback.entity.RegistroEntradaEntity;

@Repository
public interface RegistroEntradaRepository  extends CrudRepository<RegistroEntradaEntity, Long>{
	@Query(value="SELECT COUNT(e) FROM entradas e WHERE e.tipoVehiculo = ?1 AND e.estadoParqueo = true")
	Integer numeroDeVehiculosRegistradosPorTipo(String tipoVehiculo);
	
	@Query(value="SELECT e FROM entradas e WHERE  e.estadoParqueo = true")
	List<RegistroEntradaEntity> obtenerParqueosActivos();
	
	@Query(value="SELECT e FROM entradas e WHERE e.tipoVehiculo = ?1 AND e.estadoParqueo = true")
	List<RegistroEntradaEntity> vehiculosRegistradosPorTipo(String tipoVehiculo);
	
	@Query(value="SELECT e FROM entradas e WHERE e.vehiculoEntity.matricula = ?1 AND e.estadoParqueo = true")
	List<RegistroEntradaEntity> vehiculosRegistradosPorMatricula(String matricula);
	
	
	
	
	
	
	
	

}
