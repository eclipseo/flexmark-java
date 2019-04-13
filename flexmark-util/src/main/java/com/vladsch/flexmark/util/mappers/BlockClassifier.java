package com.vladsch.flexmark.util.mappers;

import com.vladsch.flexmark.util.Computable;
import com.vladsch.flexmark.util.ast.Block;

public class BlockClassifier implements Computable<Class<? extends Block>, Block> {
    public static final BlockClassifier INSTANCE = new BlockClassifier();

    private BlockClassifier() {
    }

    @Override
    public Class<? extends Block> compute(Block value) {
        return value.getClass();
    }
}
