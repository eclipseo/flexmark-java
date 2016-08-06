package com.vladsch.flexmark.test;

import com.vladsch.flexmark.ast.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AbstractVisitorTest {

    @Test
    public void replacingNodeInVisitorShouldNotDestroyVisitOrder() {
        NodeVisitor visitor = new NodeVisitor(
                new VisitHandler<>(Text.class, node -> {
                    node.insertAfter(new Code(node.getChars()));
                    node.unlink();
                })
        );

        Paragraph paragraph = new Paragraph();
        paragraph.appendChild(new Text("foo"));
        paragraph.appendChild(new Text("bar"));

        visitor.visit(paragraph);

        assertCode("foo", paragraph.getFirstChild());
        assertCode("bar", paragraph.getFirstChild().getNext());
        assertNull(paragraph.getFirstChild().getNext().getNext());
        assertCode("bar", paragraph.getLastChild());
    }

    private static void assertCode(String expectedLiteral, Node node) {
        assertEquals("Expected ast to be a Code ast: " + node, Code.class, node.getClass());
        Code code = (Code) node;
        assertEquals(expectedLiteral, code.getChars().toString());
    }
}
