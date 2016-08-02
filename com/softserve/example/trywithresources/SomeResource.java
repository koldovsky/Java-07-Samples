package com.softserve.example.trywithresources;

public class SomeResource implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("Closing");
    }
}
