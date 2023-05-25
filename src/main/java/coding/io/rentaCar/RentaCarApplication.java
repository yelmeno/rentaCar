package coding.io.rentaCar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentaCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentaCarApplication.class, args);
	}
	//Bu nesneyi IOC ye ekler bean uygulama acılınca taranır. ve ileride bu nesneye ihtiyaç duyabilir.
	//ModelMapper üretilir.
	
	@Bean
    public ModelMapper getModelMapper() {
    	return new ModelMapper(); 
    }
}
