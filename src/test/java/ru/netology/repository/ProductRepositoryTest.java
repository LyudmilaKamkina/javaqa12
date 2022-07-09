package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {

    @Test
    public void shouldRemoveById(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product book = new Book("B123", 15000, "E.Onegin", "A.S.Pushkin");
        Product smartphone = new Smartphone("S123", 30000, "iPhone13", "Apple");
        manager.addProduct(book);
        manager.addProduct(smartphone);
        Product[] expected = {book};
        manager.productRepository.removeById("S123");
        Product[] actual = manager.productRepository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdNoProduct(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product book = new Book("B123", 15000, "E.Onegin", "A.S.Pushkin");
        Product smartphone = new Smartphone("S123", 30000, "iPhone13", "Apple");
        manager.addProduct(book);
        manager.addProduct(smartphone);
        Product[] expected = {book, smartphone};
        manager.productRepository.removeById("S1234");
        Product[] actual = manager.productRepository.findAll();
        assertArrayEquals(expected, actual);
    }
}
