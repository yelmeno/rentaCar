package coding.io.rentaCar.business.abstracts;

import java.util.List;

import coding.io.rentaCar.business.requests.CreateModelRequest;
import coding.io.rentaCar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
