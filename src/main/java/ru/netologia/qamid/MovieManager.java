package ru.netologia.qamid;
public class MovieManager {
    private String[] movies;  // Массив для хранения фильмов
    private int limit;        // Лимит для вывода последних фильмов

    // Конструктор по умолчанию, устанавливает лимит на 5 фильмов
    public MovieManager() {
        this.movies = new String[0];
        this.limit = 5;
    }

    // Конструктор с параметром, позволяет задать лимит для вывода последних фильмов
    public MovieManager(int limit) {
        this.movies = new String[0];
        this.limit = limit;
    }

    // Метод для добавления нового фильма
    public void addMovie(String movie) {
        // Создаем новый массив на 1 элемент больше текущего
        String[] newMovies = new String[movies.length + 1];
        // Копируем все существующие фильмы в новый массив
        for (int i = 0; i < movies.length; i++) {
            newMovies[i] = movies[i];
        }
        // Добавляем новый фильм в конец массива
        newMovies[movies.length] = movie;
        // Обновляем массив фильмов
        movies = newMovies;
    }

    // Метод для вывода всех фильмов в порядке их добавления
    public String[] findAll() {
        return movies;
    }

    // Метод для вывода последних добавленных фильмов в обратном порядке
    public String[] findLast() {
        int resultLength;
        // Определяем длину актуального массива
        if (movies.length < limit) {
            resultLength = movies.length;  // Если фильмов меньше лимита, берем все
        } else {
            resultLength = limit;         // Иначе берем только лимит
        }

        // Создаем массив для хранения результата
        String[] result = new String[resultLength];
        // Заполняем массив последними фильмами в обратном порядке
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}
