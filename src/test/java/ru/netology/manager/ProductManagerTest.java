package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Book book1 = new Book(01,"Amber",66, "Zelazny");
    Book book2 = new Book(02, "A Farewell to Arms", 1,"Hemingway");
    Book book3 = new Book(03, "Cajita de música", 150,"Alfaro");
    Book book4 = new Book(04, "Россия", 400,"Перевезенцев");
    Book book5 = new Book(05, "Dream master", 199,"Zelazny");
    Product product1 = new Product(06, "Meat", 500);
    Smartphone smartphone1 = new Smartphone(01,"Iphone", 9999,"USA");
    Smartphone smartphone2 = new Smartphone(02,"Samsung", 139,"Korea");
    Smartphone smartphone3 = new Smartphone(03,"Xiaomi", 90,"China");
    Smartphone smartphone4 = new Smartphone(04,"Beeline", 899,"Россия");

@Test
    public void shouldFindNoProduct () {
    ProductRepository repo = new ProductRepository();
    repo.save(book1);
    repo.save(book2);
    repo.save(book3);
    repo.save(book4);
    repo.save(book5);
    repo.save(smartphone1);
    repo.save(smartphone2);
    repo.save(smartphone3);
    repo.save(smartphone4);
    ProductManager manager = new ProductManager(repo);
    Product[] expected = {};
    Product[] actual = manager.searchBy("Nokia");
    assertArrayEquals(expected, actual);
}

    @Test
    public void shouldFindOneBoook () {

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        ProductManager manager = new ProductManager(repo);
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Zelazny");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindTwoBoook () {

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(book5);
        ProductManager manager = new ProductManager(repo);
        Product[] expected = {book1,book5};
        Product[] actual = manager.searchBy("Zelazny");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByFabricator () {

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(book5);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        ProductManager manager = new ProductManager(repo);
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("USA");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName () {

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(book5);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        ProductManager manager = new ProductManager(repo);
        Product[] expected = {smartphone3};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void outFindOfTypeProduct () {

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(book5);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        repo.save(product1);
        ProductManager manager = new ProductManager(repo);
        Product[] expected = {};
        Product[] actual = manager.searchBy("Meat");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneAndBookSameData () {

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(book5);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        ProductManager manager = new ProductManager(repo);
        Product[] expected = {book4,smartphone4};
        Product[] actual = manager.searchBy("Россия");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFIndProductByPartOfName () {

        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(book4);
        repo.save(book5);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.save(smartphone4);
        ProductManager manager = new ProductManager(repo);
        Product[] expected = {book5};
        Product[] actual = manager.searchBy("master");
        assertArrayEquals(expected, actual);
    }
}