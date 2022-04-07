package up.deconto.tf1.delivery.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import up.deconto.tf1.delivery.entities.EntregaEntity;

@Repository
public interface EntregaRepository extends JpaRepository<EntregaEntity, UUID> {

}
