package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite{
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testProductItems(){
        /* Given */
        Product product=new Product("Onion");

        Item item1=new Item(product,new BigDecimal(10),10,new BigDecimal(100));
        Item item2=new Item(product,new BigDecimal(5),12,new BigDecimal(60));

        Invoice invoice1=new Invoice("1");
        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);

        //When
        invoiceDao.save(invoice1);
        //System.out.println("BeforeClass size: $$$$$$$$$$$$$" + invoiceDao.count());
        /* Then */
        Assert.assertEquals(4, invoiceDao.count());
        //Cleanup through @AfterClass
        invoiceDao.delete(invoice1);
        //System.out.println("AfterClass size: $$$$$$$$$$$$$" + invoiceDao.count());
    }
}
