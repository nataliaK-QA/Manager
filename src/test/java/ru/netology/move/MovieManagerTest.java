package ru.netology.move;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void testAddMovie() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");

        String[] expected = {"Film 1", "Film 2"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void testFindAll() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");

        String[] expected = {"Film 1", "Film 2", "Film 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void testFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");
        manager.addMovie("Film 5");
        manager.addMovie("Film 6");

        String[] expected = {"Film 6", "Film 5", "Film 4", "Film 3", "Film 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void testFindLastCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");
        manager.addMovie("Film 3");
        manager.addMovie("Film 4");

        String[] expected = {"Film 4", "Film 3", "Film 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void testFindLastWhenMoviesLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie("Film 1");
        manager.addMovie("Film 2");

        String[] expected = {"Film 2", "Film 1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void testFindLastWhenNoMovies() {
        MovieManager manager = new MovieManager();
        String[] expected = {};
        assertArrayEquals(expected, manager.findLast());
    }
}