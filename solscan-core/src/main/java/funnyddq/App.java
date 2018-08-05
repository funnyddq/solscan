package funnyddq;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class App {
    public static final String APPLICATION_NAME = "solscan-core";
    public static final String APPLICATION_VERSION = "0.0.1-SNAPSHOT";

    @Option(name = "-h", aliases = "--help", usage = "display help information")
    private boolean help = false;

    @Option(name = "-v", aliases = "--version", usage = "display version information")
    private boolean version = false;

    @Option(name = "-o", aliases = "--output", usage = "specify output file name", metaVar = "output file")
    private String output = null;

    @Option(name = "--ast", usage = "output a solidity source file AST")
    private boolean ast = false;

    @Argument
    private ArrayList<String> arguments = new ArrayList<>();

    public static void main(String[] args) {
        App app;
        CmdLineParser parser;
        File file;
        PrintWriter pw;

        app = new App();
        parser = new CmdLineParser(app);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        if (app.help) {
            showHelp(parser);
            return;
        }

        if (app.version) {
            showVersion();
            return;
        }

        if (app.arguments.size() == 0) {
            System.err.println("Please input a solidity source file.");
            System.exit(1);
        }

        if (app.ast && app.arguments.size() > 1) {
            System.err.println("Cannot input multiple solidity source files at the same time when outputting AST.");
            System.exit(1);
        }

        if (app.ast) {
            pw = null;
            if (app.output != null) {
                file = new File(app.output);
                try {
                    pw = new PrintWriter(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
            else
                pw = new PrintWriter(System.out);
            outputAst(pw);
            pw.close();
        }
    }

    public static void showHelp(CmdLineParser parser) {
        if (parser == null)
            return;

        System.out.println("Usage: java -jar " + APPLICATION_NAME + "-" + APPLICATION_VERSION + ".jar [options] [arguments...]");
        parser.printUsage(System.out);
        return;
    }

    public static void showVersion() {
        System.out.println(APPLICATION_NAME + " " + APPLICATION_VERSION);
        return;
    }

    public static void outputAst(PrintWriter pw) {
        pw.println("AST");
        return;
    }
}
