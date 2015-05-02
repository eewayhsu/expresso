// Generated from src/expresso/parser/Expression.g4 by ANTLR 4.5

package expresso.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(ExpressionParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(ExpressionParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#warmup}.
	 * @param ctx the parse tree
	 */
	void enterWarmup(ExpressionParser.WarmupContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#warmup}.
	 * @param ctx the parse tree
	 */
	void exitWarmup(ExpressionParser.WarmupContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(ExpressionParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(ExpressionParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(ExpressionParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(ExpressionParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExpressionParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExpressionParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#bead}.
	 * @param ctx the parse tree
	 */
	void enterBead(ExpressionParser.BeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#bead}.
	 * @param ctx the parse tree
	 */
	void exitBead(ExpressionParser.BeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#chain}.
	 * @param ctx the parse tree
	 */
	void enterChain(ExpressionParser.ChainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#chain}.
	 * @param ctx the parse tree
	 */
	void exitChain(ExpressionParser.ChainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(ExpressionParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(ExpressionParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ExpressionParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ExpressionParser.LiteralContext ctx);
}