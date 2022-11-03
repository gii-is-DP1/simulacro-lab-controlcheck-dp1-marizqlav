package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private ProductRepository productoRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productoRepository=productRepository;
	}
	
    public List<Product> getAllProducts(){
        return productoRepository.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productoRepository.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productoRepository.getProductType(typeName);
    }

    public List<ProductType> findAllProductTypes(){
		return productoRepository.findAllProductTypes();
    }
    
    public Product save(Product p){
        return productoRepository.save(p);       
    }

    
}
