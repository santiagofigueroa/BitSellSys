package com.company.Test;

import com.company.FileHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void FileHandlerNotNUll()
    {
        FileHandler result = new FileHandler();
        assertNotNull(result,"Not NUll");
    }

}