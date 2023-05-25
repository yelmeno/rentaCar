package coding.io.rentaCar.webApi.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import coding.io.rentaCar.business.abstracts.BrandService;
import coding.io.rentaCar.business.requests.CreateBrandRequest;
import coding.io.rentaCar.business.requests.UpdateBrandRequest;
import coding.io.rentaCar.business.responses.GetAllBrandsResponse;
import coding.io.rentaCar.business.responses.GetByIdBrandResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController //annotation
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;
	//@Autowired//parametrelerine bakar ve uygulamayı tarayarak implemente edilen classı bulur.
	//public BrandsController(BrandService brandService) {
		//super();
		//this.brandService = brandService;
	//}
//İstek controller'a yapılır.İstek uygun bulunursa business'a gider
//İş geliştirme sistemindeki kurallardan geçerse data access'e gider
//data'yı verebileceğini belirtir ve data varilir.
	
	
	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id){
		return brandService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}
}

