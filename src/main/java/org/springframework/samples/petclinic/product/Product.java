package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends BaseEntity {
	
	@NotBlank//para q no sea ni null ni este vacio
	@Length(min = 3, max = 50)
	@Column(name = "name")
    String name;
    
	@NotNull
	@PositiveOrZero
	@Column(name = "price")
    double price;
	
	@ManyToOne(optional = false)//el optional indica si el objeto puede ser null, si es false no hay null
	@JoinColumn(name = "product_type")
	@NotNull
    ProductType productType;
}
