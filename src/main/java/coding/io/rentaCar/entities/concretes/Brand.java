package coding.io.rentaCar.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Id'yi otomatik olarak artırma
	@Column(name="id")
    private int id;
	
	@Column(name="name")
    private String name;
			
	@OneToMany(mappedBy = "brand")		 
	private List<Model>	models;	 
			
             
}
