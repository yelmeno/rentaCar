package coding.io.rentaCar.webApi.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import coding.io.rentaCar.business.abstracts.ModelService;
import coding.io.rentaCar.business.requests.CreateModelRequest;
import coding.io.rentaCar.business.responses.GetAllModelsResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController //annotation
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
	private ModelService modelService;
	
	@GetMapping()
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
}
}
