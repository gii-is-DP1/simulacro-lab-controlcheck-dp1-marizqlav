package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

	private ProductService productService;
	
	@Autowired
	public ProductTypeFormatter(ProductService productService) {
		this.productService=productService;
	}
	
    @Override
    public String print(ProductType object, Locale locale) {
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
    	List<ProductType> productTypes=productService.findAllProductTypes();
    	for (ProductType p:productTypes) {
			if (p.getName().equals(text)) {
				return p;
			}
		} throw new ParseException("ProductType not found"+ text, 0);
    }
    
}
