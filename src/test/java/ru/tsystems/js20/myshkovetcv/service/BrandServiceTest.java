package ru.tsystems.js20.myshkovetcv.service;


import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import ru.tsystems.js20.myshkovetcv.dao.BrandDao;
import ru.tsystems.js20.myshkovetcv.dto.BrandDto;
import ru.tsystems.js20.myshkovetcv.model.Brand;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BrandServiceTest {

    private List<Brand> brandList;
    private Brand brandSwatch;
    private Brand brandCasio;

    @Mock
    private BrandDao brandDao;

    @InjectMocks
    private BrandService brandService = new BrandServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        brandSwatch = new Brand(1L, "Swatch");
        brandCasio = new Brand(2L, "Casio");

        brandList = new ArrayList<>();
        brandList.add(brandSwatch);
        brandList.add(brandCasio);

        when(brandDao.findByName("Swatch")).thenReturn(brandSwatch);
        when(brandDao.findByName("Casio")).thenReturn(brandCasio);
        when(brandDao.findById(1L)).thenReturn(brandSwatch);
        when(brandDao.findById(2L)).thenReturn(brandCasio);
        when(brandDao.findAllBrands()).thenReturn(brandList);
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @After
    public void tearDown() throws Exception {
        brandList = new ArrayList<>();
    }

    @Test
    public void testMockCreation() {
        assertNotNull(brandDao);
    }

    @Test
    public void findByNameBrandTestTrue1() throws Exception {
        Assert.assertEquals(brandSwatch, brandService.findByName("Swatch"));
    }

    public void findByNameBrandTestTrue2() throws Exception {
        Assert.assertEquals(brandCasio, brandService.findByName("Casio"));
    }

    @Test
    public void findByNameBrandTestFalse1() throws Exception {
        Assert.assertNotEquals(brandSwatch, brandService.findByName("Casio"));
    }

    @Test
    public void findByNameBrandTestFalse2() throws Exception {
        Assert.assertNotEquals(brandCasio, brandService.findByName("Swatch"));
    }

    @Test
    public void findByIdBrandTestTrue1() throws Exception {
        Assert.assertEquals(brandSwatch, brandService.findById(1L));
    }

    @Test
    public void findByIdBrandTestTrue2() throws Exception {
        Assert.assertEquals(brandCasio, brandService.findById(2L));
    }

    @Test
    public void findByIdBrandTestFalse1() throws Exception {
        Assert.assertNotEquals(brandSwatch, brandService.findById(2L));
    }

    @Test
    public void findByIdBrandTestFalse2() throws Exception {
        Assert.assertNotEquals(brandCasio, brandService.findById(1L));
    }

    @Test
    public void getAllBrandsDtoTestNotEmpty() throws Exception {
        List<BrandDto> brandDtoList = brandService.getAllBrandDto();
        Assert.assertTrue(brandDtoList.size() > 0);
    }

    @Test
    public void findDtoByIdBrandTestTrue1() throws Exception {
        Assert.assertEquals(new BrandDto(brandSwatch), brandService.findDtoById(1L));
    }

    @Test
    public void findDtoByIdBrandTestTrue2() throws Exception {
        Assert.assertEquals(new BrandDto(brandCasio), brandService.findDtoById(2L));
    }

    @Test
    public void findDtoByIdBrandTestFalse1() throws Exception {
        Assert.assertNotEquals(new BrandDto(brandSwatch), brandService.findDtoById(2L));
    }

    @Test
    public void findDtoByIdBrandTestFalse2() throws Exception {
        Assert.assertNotEquals(new BrandDto(brandCasio), brandService.findDtoById(1L));
    }

    @Test
    public void brandNotUniqueTrue() throws Exception {
        Assert.assertTrue(brandService.brandNotUnique("Swatch"));
    }

    @Test
    public void brandNotUniqueFalse() throws Exception {
        Assert.assertFalse(brandService.brandNotUnique("Adidas"));
    }

}
