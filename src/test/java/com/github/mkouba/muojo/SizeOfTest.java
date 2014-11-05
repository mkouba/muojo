package com.github.mkouba.muojo;

import net.sourceforge.sizeof.SizeOf;

import org.junit.BeforeClass;

/**
 *
 * @author Martin Kouba
 */
public class SizeOfTest extends AbstractTest {

    @BeforeClass
    public static void init() {
        printStart("SizeOf agent - skip static fields");
        SizeOf.skipStaticField(true);
    }

    @Override
    long getShallowSize(Object reference) {
        return SizeOf.sizeOf(reference);
    }

    @Override
    long getDeepSize(Object reference) {
        return SizeOf.deepSizeOf(reference);
    }

    @Override
    String getOutputFilename() {
        return "sizeof.txt";
    }

}
