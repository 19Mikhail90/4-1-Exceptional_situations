package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductTest {
    @Test
    public void shouldRemoveElementById() {
        ProductRepository repo = new ProductRepository();

        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(22, "Java I", 1000);
        Product third = new Product(333, "Java I", 1000);
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeById(22);

    }

    @Test
    public void shouldAMissingItemById() {
        ProductRepository repo = new ProductRepository();

        Product first = new Product(1, "Java I", 1000);
        Product second = new Product(22, "Java I", 1000);
        Product third = new Product(333, "Java I", 1000);
        repo.save(first);
        repo.save(second);
        repo.save(third);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(4444);
        });
    }
}
