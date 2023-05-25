package coding.io.rentaCar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import coding.io.rentaCar.business.abstracts.BrandService;
import coding.io.rentaCar.business.requests.CreateBrandRequest;
import coding.io.rentaCar.business.requests.UpdateBrandRequest;
import coding.io.rentaCar.business.responses.GetAllBrandsResponse;
import coding.io.rentaCar.business.responses.GetByIdBrandResponse;
import coding.io.rentaCar.business.rules.BrandBusinessRules;
import coding.io.rentaCar.core.utilities.mappers.ModelMapperService;
import coding.io.rentaCar.dataAccess.abstracts.BrandRepository;
import coding.io.rentaCar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service// Bu sınıf bir business nesnesidir.
@AllArgsConstructor
public class BrandManager implements BrandService  {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	
	

	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		List<Brand> brands = ((JpaRepository<Brand, Integer>) brandRepository).findAll();
		
		//List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
		//Boş liste oluşturulur. For döngüsü ile tüm id ve name ler üzerinde gezilir. Ve GetAllBrandsResponse' içine set edilir.
		//for (Brand brand : brands) {
			//GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			//responseItem.setId(brand.getId());
			//responseItem.setName(brand.getName());
			//brandsResponse.add(responseItem);  	 	 	
		//}
		//Sürekli parametreleri set etmemek için aşağıda kod bloğu kullanıldı.
		
		List<GetAllBrandsResponse> brandsResponse = brands.stream().map(brand->this.modelMapperService.forResponse()
				.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		return brandsResponse; 
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
	    //Brand brand = new Brand();
	    //brand.setName(createBrandRequest.getName());
	    
	    //Ekleme yapılırken o markadan sadece bir adet olması gerektiği belirtilir.
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		this.brandRepository.save(brand);
	}


	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response 
		= this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
		return response;
	}


	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}


	@Override
	public void delete(int id) {
		
		this.brandRepository.deleteById(id);
		
	}

}
