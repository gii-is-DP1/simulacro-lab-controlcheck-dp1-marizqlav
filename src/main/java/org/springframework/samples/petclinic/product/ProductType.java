package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_type")
public class ProductType extends BaseEntity {
   
	@NotBlank
	@Length(min = 3, max = 50)
	@Column(unique = true, name = "name")
    String name;
}
