package coding.io.rentaCar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.io.rentaCar.entities.concretes.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
