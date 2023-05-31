package ru.netology.hwexceptions.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.hwexceptions.domain.Product;
import ru.netology.hwexceptions.myexceptions.AlreadyExistsException;
import ru.netology.hwexceptions.myexceptions.NotFoundException;

public class ShopRepositoryTest {

    ShopRepository shopRepository = new ShopRepository();
    Product product1 = new Product(1, "bread", 50);
    Product product2 = new Product(2, "milk", 70);
    Product product3 = new Product(3, "apple", 100);

    @Test
    public void shouldRemoveById() {
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        shopRepository.remove(2);

        Product[] expected = { product1, product3 };
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveById() {
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(4);
        });
    }

    @Test
    public void shouldAddProduct() {
        shopRepository.add(product1);

        Product[] expected = { product1};
        Product[] actual = shopRepository.findAll();
    }

    @Test
    public void shouldNotAddProduct() {
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepository.add(product1);
        });
    }
}
