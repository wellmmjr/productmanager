package com.github.wellmmjr.productmanager.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.wellmmjr.productmanager.converter.mocks.MockProduct;
import com.github.wellmmjr.productmanager.data.model.Product;
import com.github.wellmmjr.productmanager.data.vo.v1.ProductVO;

public class DozerConverterTest {

	MockProduct inputObject;

    @Before
    public void setUp() {
        inputObject = new MockProduct();
    }

    @Test
    public void parseEntityToVOTest() {
        ProductVO output = DozerConverter.parseObject(inputObject.mockEntity(), ProductVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("Product Name Test0", output.getProductName());
        Assert.assertEquals(0, output.getProductHeight());
        Assert.assertEquals(0, output.getProductDepth());
        Assert.assertEquals(0, output.getProductWidth());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<ProductVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), ProductVO.class);
        ProductVO outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("Product Name Test0", outputZero.getProductName());
        Assert.assertEquals(0, outputZero.getProductHeight());
        Assert.assertEquals(0, outputZero.getProductDepth());
        Assert.assertEquals(0, outputZero.getProductWidth());
        
        ProductVO outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("Product Name Test7", outputSeven.getProductName());
        Assert.assertEquals(7, outputSeven.getProductHeight());
        Assert.assertEquals(7, outputSeven.getProductDepth());
        Assert.assertEquals(7, outputSeven.getProductWidth());
        
        ProductVO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("Product Name Test12", outputTwelve.getProductName());
        Assert.assertEquals(12, outputTwelve.getProductHeight());
        Assert.assertEquals(12, outputTwelve.getProductDepth());
        Assert.assertEquals(12, outputTwelve.getProductWidth());
    }

    @Test
    public void parseVOToEntityTest() {
        Product output = DozerConverter.parseObject(inputObject.mockVO(), Product.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("Product Name Test0", output.getProductName());
        Assert.assertEquals(0, output.getProductHeight());
        Assert.assertEquals(0, output.getProductDepth());
        Assert.assertEquals(0, output.getProductWidth());
    }
    

    @Test
    public void parserVOListToEntityListTest() {
        List<Product> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Product.class);
        Product outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("Product Name Test0", outputZero.getProductName());
        Assert.assertEquals(0, outputZero.getProductHeight());
        Assert.assertEquals(0, outputZero.getProductDepth());
        Assert.assertEquals(0, outputZero.getProductWidth());
        
        Product outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("Product Name Test7", outputSeven.getProductName());
        Assert.assertEquals(7, outputSeven.getProductHeight());
        Assert.assertEquals(7, outputSeven.getProductDepth());
        Assert.assertEquals(7, outputSeven.getProductWidth());
        
        Product outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("Product Name Test12", outputTwelve.getProductName());
        Assert.assertEquals(12, outputTwelve.getProductHeight());
        Assert.assertEquals(12, outputTwelve.getProductDepth());
        Assert.assertEquals(12, outputTwelve.getProductWidth());
    }
}
