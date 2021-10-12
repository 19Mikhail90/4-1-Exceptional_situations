package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        findById(id); // вызываю метод поиска сразу в методе удаления
        if (findById(id) == null) { //если в поиске число ровно соответствует null то система переходит к выполнению след строки
            throw new NotFoundException("Element with id: " + id + " not found"); // будет выполнено если система при соответствии условию if
        }
        int length = items.length - 1; //если условие не выполнилось то система пропустит действия по условию if и пойдет на эту строку
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                try {
                    tmp[index] = item;
                } catch (ArrayIndexOutOfBoundsException e) {
                    e.printStackTrace();
                    System.out.println("Ошибка.");
                }
                index++;
            }
        }
        items = tmp;
    }
}
