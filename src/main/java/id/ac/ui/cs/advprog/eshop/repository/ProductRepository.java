package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        if (product.getProductId() == null) {
            product.setProductId(UUID.randomUUID().toString());
        }
        productData.add(product);
        return product;
    }

    public Product findById(String id) {
        return productData.stream()
                .filter(p -> p.getProductId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product update(Product updatedProduct) {
        Product product = findById(updatedProduct.getProductId());
        if (product != null) {
            product.setProductName(updatedProduct.getProductName());
            product.setProductQuantity(updatedProduct.getProductQuantity());
            return product;
        }
        return null;
    }

    public void delete(String id) {
        productData.removeIf(p -> p.getProductId().equals(id));
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}
