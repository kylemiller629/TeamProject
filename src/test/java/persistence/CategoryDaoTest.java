package persistence;

import entity.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the CRUD and search operations for Category.
 */
public class CategoryDaoTest {

    private GenericDao<Category> categoryDao;

    /**
     * Resets the test database before each test.
     */
    @BeforeEach
    public void setUp() {
        categoryDao = new GenericDao<>(Category.class);

        Database database = Database.getInstance();
        database.runSQL("CleanDB.sql");
    }

    /**
     * Verifies that a category can be retrieved by its ID.
     */
    @Test
    void getCategoryByIdSuccess() {
        Category category = categoryDao.getById(1);

        assertNotNull(category);
        assertEquals("Motivation", category.getCategory());
    }

    /**
     * Verifies that a new category can be inserted.
     */
    @Test
    void insertCategorySuccess() {
        Category category = new Category("Wisdom");

        int id = categoryDao.insert(category);
        Category savedCategory = categoryDao.getById(id);

        assertNotNull(savedCategory);
        assertEquals("Wisdom", savedCategory.getCategory());
    }

    /**
     * Verifies that an existing category can be updated.
     */
    @Test
    void updateCategorySuccess() {
        Category category = categoryDao.getById(1);

        assertNotNull(category);

        category.setCategory("Inspiration");
        categoryDao.update(category);

        Category savedCategory = categoryDao.getById(1);

        assertNotNull(savedCategory);
        assertEquals("Inspiration", savedCategory.getCategory());
    }

    /**
     * Verifies that a category can be deleted.
     */
    @Test
    void deleteCategorySuccess() {
        Category category = new Category("Temporary");

        int id = categoryDao.insert(category);
        categoryDao.delete(category);

        assertNull(categoryDao.getById(id));
    }

    /**
     * Verifies that all sample categories are retrieved.
     */
    @Test
    void getAllCategoriesSuccess() {
        List<Category> categories = categoryDao.getAll();

        assertNotNull(categories);
        assertEquals(3, categories.size());
    }

    /**
     *  Verifies that a category can be found by its exact name.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Category> categories = categoryDao.getByPropertyEqual("category", "Success");

        assertNotNull(categories);
        assertEquals(1, categories.size());
        assertEquals("Success", categories.get(0).getCategory());
    }

    /**
     * Verifies that a category can be found by part of its name.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Category> categories = categoryDao.getByPropertyLike("category", "Motiv");

        assertNotNull(categories);
        assertEquals(1, categories.size());
        assertEquals("Motivation", categories.get(0).getCategory());
    }
}