package funnyddq;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class MyParse {
    public static void main(String[] args) {
        ANTLRInputStream input;
        try {
            input = new ANTLRInputStream(System.in);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        SolidityLexer lexer = new SolidityLexer(input);

        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // create a parser that feeds off the tokens buffer
        SolidityParser parser = new SolidityParser(tokens);

        ParseTree tree = parser.compilationUnit(); // begin parsing at init rule
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree

    }
}
