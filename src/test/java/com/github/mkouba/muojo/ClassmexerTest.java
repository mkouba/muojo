package com.github.mkouba.muojo;

import org.junit.BeforeClass;

import com.javamex.classmexer.MemoryUtil;

/**
 *
 * @author Martin Kouba
 */
public class ClassmexerTest extends AbstractTest {

    @BeforeClass
    public static void init() {
        printStart("Classmexer agent");
    }

    @Override
    long getShallowSize(Object reference) {
        return MemoryUtil.memoryUsageOf(reference);
    }

    @Override
    long getDeepSize(Object reference) {
        return MemoryUtil.deepMemoryUsageOf(reference);
    }

    @Override
    String getOutputFilename() {
        return "classmexer.txt";
    }

}
