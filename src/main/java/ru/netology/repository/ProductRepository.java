package ru.netology.repository;

import ru.netology.domain.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductRepository {
    public Product[] repository = new Product[0];

    public void saveProducts(Product[] products) {
        this.repository = products;
    }

    public Product[] findAll() {
        return this.repository;
    }

    public void removeById(String id) {
        Product[] result = findAll();
        Product[] tmp = new Product[result.length];
        Product[] tmp1 = new Product[tmp.length - 1];
        int i = 0;
        for (Product product : result) {
            if (!product.getId().contains(id)) {
                tmp[i] = result[i];
                i++;
            }
            this.repository = tmp;  //если ничего не удалено, например id неверный, все остается тем же
        }
        if (Objects.equals(tmp[result.length - 1], null)) {
            for (int j = 0; j < tmp1.length; j++) {
                tmp1[j] = tmp[j];
            }
            this.repository = tmp1; // если что-то удалили, умешьшить размер копированием массива в массив длиной -1
        }
    }
}


