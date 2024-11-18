package com.umk.app.io;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @org.junit.jupiter.api.Test
    void ReadFile() {
        assertEquals(10,new MazeManager("MazeToTest.txt").getMatrix().length);
    }
}