package ru.netology.manager;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    public ProductRepository productRepository = new ProductRepository();

    public ProductManager(ProductRepository repository) {
    }

    public void addProduct(Product newProduct) { //добавляем продукт в репозиторий

        Product[] products = productRepository.repository;
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = newProduct;
        productRepository.repository = tmp;
        productRepository.saveProducts(tmp);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        // тут будем хранить подошедшие запросу продукты
        for (Product product : productRepository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

}