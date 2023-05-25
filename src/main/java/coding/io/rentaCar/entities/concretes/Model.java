package coding.io.rentaCar.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="models")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Id'yi otomatik olarak artırma
	@Column(name="id")
    private int id;
	
	@Column(name="name")//kolon ve ismi
    private String name;
	
	@ManyToOne
	@JoinColumn(name="brand_id")//model tablosu için veritabanında bir adet brand_id alanı oluşturulur.
	private Brand brand;
	
	@OneToMany(mappedBy = "model")
	private List<Car> cars;
}
