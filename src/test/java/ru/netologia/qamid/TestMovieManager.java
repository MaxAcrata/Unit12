package ru.netologia.qamid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMovieManager {

    private MovieManager manager;  // Общий объект для всех тестов
    // Метод будет выполняться перед каждым тестом
    @BeforeEach
    public void setUp() {
        manager = new MovieManager(); // Создаем новый объект manager перед каждым тестом
    }

    @Test
        // Тест на добавление фильма
    void testAddMovie() {
        // Добавляем 2 фильма в менеджер
        manager.addMovie("Bloodshot");
        manager.addMovie("Forward");

        // Ожидаемый результат: список из 2 фильмов
        String[] expected = {"Bloodshot", "Forward"};
        assertArrayEquals(expected, manager.findAll()); // Проверяем, что фильмы добавлены корректно
    }

    @Test
    void testFindAll() {
        // Добавляем 3 фильма в менеджер
        manager.addMovie("Bloodshot");
        manager.addMovie("Forward");
        manager.addMovie("Hotel 'Belgrade'");

        // Ожидаемый результат: список из 3 фильмов
        String[] expected = {"Bloodshot", "Forward", "Hotel 'Belgrade'"};
        assertArrayEquals(expected, manager.findAll()); // Проверяем возврат фильмов в правильном порядке
    }

    @Test
    void testFindLastWithDefaultLimit() {
        // Добавляем 6 фильмов в менеджер
        manager.addMovie("Bloodshot");
        manager.addMovie("Forward");
        manager.addMovie("Hotel 'Belgrade'");
        manager.addMovie("Number One");
        manager.addMovie("Invisible man");
        manager.addMovie("Sharp collars");

        // Ожидаемый результат: последние 5 фильмов (по умолчанию лимит = 5)
        String[] expected = {"Sharp collars", "Invisible man", "Number One", "Hotel 'Belgrade'", "Forward"};
        assertArrayEquals(expected, manager.findLast()); // Проверяем возврат фильмов в обратном порядке
    }

    @Test
    void testFindLastWithCustomLimit() {
        // Создаем менеджер с лимитом (3 фильма)
        manager = new MovieManager(3);

        // Добавляем 4 фильма в менеджер
        manager.addMovie("Bloodshot");
        manager.addMovie("Forward");
        manager.addMovie("Hotel 'Belgrade'");
        manager.addMovie("Number One");

        // Ожидаемый результат: последние 3 фильма
        String[] expected = {"Number One", "Hotel 'Belgrade'", "Forward"};
        assertArrayEquals(expected, manager.findLast()); // Проверяем, что findLast() учитывает установленный лимит
    }

    @Test
    void testFindLastWhenLessThanLimit() {
        // Добавляем 2 фильма в менеджер
        manager.addMovie("Bloodshot");
        manager.addMovie("Forward");

        // Ожидаемый результат: все фильмы (их меньше, чем лимит)
        String[] expected = {"Forward", "Bloodshot"};
        assertArrayEquals(expected, manager.findLast()); // Проверяем, что количество фильмов меньше лимита
    }

    @Test
    void testFindLastWhenNoMovies() {
        // Не добавляем фильмы в менеджер

        // Ожидаемый результат: пустой массив
        String[] expected = {};
        assertArrayEquals(expected, manager.findLast()); // Проверяем возврат пустого массива, если нет фильмов
    }
}
