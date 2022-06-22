package up.deconto.tf2.delivery.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import up.deconto.tf2.delivery.entities.EntregaEntity;

@Repository
public interface EntregaRepository extends JpaRepository<EntregaEntity, UUID> {

}
