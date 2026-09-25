package com.smartshop;

import org.junit.Test;
import static org.junit.Assert.*;

public class SearchTest {

    @Test
    public void testSearchProduct() {

        Search search = new Search();

        assertEquals(
                "Searching for: Smart Watch",
                search.searchProduct("Smart Watch")
        );
    }

    @Test
    public void testEmptySearch() {

        Search search = new Search();

        assertEquals(
                "Please enter a product name",
                search.searchProduct("")
        );
    }
}