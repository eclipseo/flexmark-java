package com.vladsch.flexmark.internal;

import com.vladsch.flexmark.ast.Block;
import com.vladsch.flexmark.ast.Document;
import com.vladsch.flexmark.parser.block.AbstractBlockParser;
import com.vladsch.flexmark.parser.block.BlockContinue;
import com.vladsch.flexmark.parser.block.ParserState;
import com.vladsch.flexmark.util.options.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;

public class DocumentBlockParser extends AbstractBlockParser {

    private Document document;

    public DocumentBlockParser() {
    }

    public void initializeDocument(DataHolder options, BasedSequence charSequence) {
        document = new Document(options, charSequence);
    }

    @Override
    public boolean isContainer() {
        return true;
    }

    @Override
    public boolean canContain(Block block) {
        return true;
    }

    @Override
    public Document getBlock() {
        return document;
    }

    @Override
    public BlockContinue tryContinue(ParserState state) {
        return BlockContinue.atIndex(state.getIndex());
    }

    @Override
    public void addLine(ParserState state, BasedSequence line) {
    }

    @Override
    public void closeBlock(ParserState parserState) {
    }

}
