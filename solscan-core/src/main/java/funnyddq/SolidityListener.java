// Generated from funnyddq/Solidity.g4 by ANTLR 4.7.1
package funnyddq;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SolidityParser}.
 */
public interface SolidityListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SolidityParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(SolidityParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link SolidityParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(SolidityParser.CompilationUnitContext ctx);
}