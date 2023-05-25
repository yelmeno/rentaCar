package coding.io.rentaCar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import coding.io.rentaCar.business.abstracts.ModelService;
import coding.io.rentaCar.business.requests.CreateModelRequest;
import coding.io.rentaCar.business.responses.GetAllModelsResponse;
import coding.io.rentaCar.core.utilities.mappers.ModelMapperService;
import coding.io.rentaCar.dataAccess.abstracts.ModelRepository;
import coding.io.rentaCar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll(){
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelResponse = models.stream()
		        .map(model->this.modelMapperService.forResponse()
		        		.map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
		
		return modelResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {

		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		
		this.modelRepository.save(model);
		
	}
		
	

}
