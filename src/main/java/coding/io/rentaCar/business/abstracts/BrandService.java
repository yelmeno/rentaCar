package coding.io.rentaCar.business.abstracts;

import java.util.List;

import coding.io.rentaCar.business.requests.CreateBrandRequest;
import coding.io.rentaCar.business.requests.UpdateBrandRequest;
import coding.io.rentaCar.business.responses.GetAllBrandsResponse;
import coding.io.rentaCar.business.responses.GetByIdBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
