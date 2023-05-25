package coding.io.rentaCar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import coding.io.rentaCar.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand,Integer>{

	boolean existsByName(String name);
	//Jpa exist'i gördüğü an sorguyu oluşturur (name alanına göre varsa true yoksa false döndürür)
	//Spring JPA Keywords araştır.
}
