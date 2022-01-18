package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager productManager = new ProductManager(repository);
    Book book1 = new Book(01, "Amber", 66, "Zelazny");
    Book book2 = new Book(02, "A Farewell to Arms", 1, "Hemingway");
    Book book3 = new Book(03, "Cajita de música", 150, "Alfaro");
    Book book4 = new Book(04, "Россия", 400, "Перевезенцев");
    Book book5 = new Book(05, "Dream master", 199, "Zelazny");
    Product product1 = new Product(06, "Meat", 500);
    Smartphone smartphone1 = new Smartphone(01, "Iphone", 9999, "USA");
    Smartphone smartphone2 = new Smartphone(02, "Samsung", 139, "Korea");
    Smartphone smartphone3 = new Smartphone(03, "Xiaomi", 90, "China");
    Smartphone smartphone4 = new Smartphone(04, "Beeline", 899, "Россия");

    @BeforeEach
    public void setUp() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(book4);
        productManager.add(book5);
        productManager.add(product1);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
        productManager.add(smartphone4);
    }

    @Test
    public void shouldFindNoProduct() {
        Product[] expected = new Product[0];
        Product[] actual = productManager.searchBy("Nokia");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneBoook() {
        Product[] expected = {book2};
        Product[] actual = productManager.searchBy("Hemingway");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTwoBoook() {
        Product[] expected = {book1, book5};
        Product[] actual = productManager.searchBy("Zelazny");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByFabricator() {
        Product[] expected = {smartphone1};
        Product[] actual = productManager.searchBy("USA");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName() {
        Product[] expected = {smartphone3};
        Product[] actual = productManager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void outFindOfTypeProduct() {
        Product[] expected = {};
        Product[] actual = productManager.searchBy("Meat");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneAndBookSameData() {
        Product[] expected = {book4, smartphone4};
        Product[] actual = productManager.searchBy("Россия");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFIndProductByPartOfName() {
        Product[] expected = {book5};
        Product[] actual = productManager.searchBy("master");
        assertArrayEquals(expected, actual);
    }
}