package ru.tsystems.js20.myshkovetcv.service;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ru.tsystems.js20.myshkovetcv.dao.CategoryDao;
import ru.tsystems.js20.myshkovetcv.dto.CategoryDto;
import ru.tsystems.js20.myshkovetcv.model.Category;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    private List<Category> categoryList;
    private Category categorySports;
    private Category categoryEveryday;

    @Mock
    private CategoryDao categoryDao;

    @InjectMocks
    private CategoryService categoryService = new CategoryServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        categorySports = new Category(1L, "Sports");
        categoryEveryday = new Category(2L, "Everyday");

        categoryList = new ArrayList<>();
        categoryList.add(categorySports);
        categoryList.add(categoryEveryday);

        when(categoryDao.findByName("Sports")).thenReturn(categorySports);
        when(categoryDao.findByName("Everyday")).thenReturn(categoryEveryday);
        when(categoryDao.findById(1L)).thenReturn(categorySports);
        when(categoryDao.findById(2L)).thenReturn(categoryEveryday);
        when(categoryDao.findAllCategories()).thenReturn(categoryList);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @After
    public void tearDown() throws Exception {
        categoryList = new ArrayList<>();
    }

    @Test
    public void testMockCreation() {
        assertNotNull(categoryDao);
    }

    @Test
    public void findByNameCategoryTestTrue1() throws Exception {
        Assert.assertEquals(categorySports, categoryService.findByName("Sports"));
    }

    @Test
    public void findByNameCategoryTestTrue2() throws Exception {
        Assert.assertEquals(categoryEveryday, categoryService.findByName("Everyday"));
    }

    @Test
    public void findByNameCategoryTestFalse1() throws Exception {
        Assert.assertNotEquals(categoryEveryday, categoryService.findByName("Sports"));
    }

    @Test
    public void findByNameCategoryTestFalse2() throws Exception {
        Assert.assertNotEquals(categorySports, categoryService.findByName("Everyday"));
    }

    @Test
    public void findByIdCategoryTestTrue1() throws Exception {
        Assert.assertEquals(categorySports, categoryService.findById(1L));
    }

    @Test
    public void findByIdCategoryTestTrue2() throws Exception {
        Assert.assertEquals(categoryEveryday, categoryService.findById(2L));
    }

    @Test
    public void findByIdCategoryTestFalse1() throws Exception {
        Assert.assertNotEquals(categoryEveryday, categoryService.findById(1L));
    }

    @Test
    public void findByIdCategoryTestFalse2() throws Exception {
        Assert.assertNotEquals(categorySports, categoryService.findById(2L));
    }

    @Test
    public void getAllCategoriesDtoTestNotEmpty() throws Exception {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategoriesDto();
        Assert.assertTrue(categoryDtoList.size() > 0);
    }

    @Test
    public void categoryNotUniqueTrue() throws Exception {
        Assert.assertTrue(categoryService.categoryNotUnique("Sports"));
    }

    @Test
    public void categoryNotUniqueFalse() throws Exception {
        Assert.assertFalse(categoryService.categoryNotUnique("Luxury"));
    }

    @Test
    public void findDtoByIdCategoryTestTrue1() throws Exception {
        Assert.assertEquals(new CategoryDto(categoryEveryday), categoryService.findDtoById(2L));
    }

    @Test
    public void findDtoByIdCategoryTestTrue2() throws Exception {
        Assert.assertEquals(new CategoryDto(categorySports), categoryService.findDtoById(1L));
    }

    @Test
    public void findDtoByIdCategoryTestFalse1() throws Exception {
        Assert.assertNotEquals(new CategoryDto(categoryEveryday), categoryService.findDtoById(1L));
    }

    @Test
    public void findDtoByIdCategoryTestFalse2() throws Exception {
        Assert.assertNotEquals(new CategoryDto(categorySports), categoryService.findDtoById(2L));
    }

    @Test
    public void findDtoByNameCategoryTestTrue1() throws Exception {
        Assert.assertEquals(new CategoryDto(categoryEveryday), categoryService.findDtoByName("Everyday"));
    }

    @Test
    public void findDtoByNameCategoryTestTrue2() throws Exception {
        Assert.assertEquals(new CategoryDto(categorySports), categoryService.findDtoByName("Sports"));
    }

    @Test
    public void findDtoByNameCategoryTestFalse1() throws Exception {
        Assert.assertNotEquals(new CategoryDto(categoryEveryday), categoryService.findDtoByName("Sports"));
    }

    @Test
    public void findDtoByNameCategoryTestFalse2() throws Exception {
        Assert.assertNotEquals(new CategoryDto(categorySports), categoryService.findDtoByName("Everyday"));
    }
}
