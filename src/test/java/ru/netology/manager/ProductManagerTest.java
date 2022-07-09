package ru.netology.manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    @Test
    public void shouldAddProducts(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product book = new Book("B123", 15000, "E.Onegin", "A.S.Pushkin");
        Product smartphone = new Smartphone("S123", 30000, "iPhone13", "Apple");
        manager.addProduct(book);
        manager.addProduct(smartphone);
        Product[] expected = {book, smartphone};
        Assertions.assertArrayEquals(expected, manager.productRepository.repository);
    }
@Test
public void shouldSearchBy(){
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book ("B123", 15000, "E.Onegin", "A.S.Pushkin");
    Product smartphone = new Smartphone("S123", 30000, "iPhone13", "Apple");
    manager.addProduct(book);
    manager.addProduct(smartphone);
    Product[] expected = {book, smartphone};
    Product[] actual = manager.searchBy("e");
    Assertions.assertArrayEquals(expected, actual);
}
    @Test
    public void shouldSearchByNoMatches(){
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product book = new Book ("B123", 15000, "E.Onegin", "A.S.Pushkin");
        Product smartphone = new Smartphone("S123", 30000, "iPhone13", "Apple");
        manager.addProduct(book);
        manager.addProduct(smartphone);
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("w");
        Assertions.assertArrayEquals(expected, actual);
    }
}

