package com.umk.app.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @Test
    void readFile() {
        assertEquals(38, new MazeManager("maze.txt").getMapa().size());
    }
}