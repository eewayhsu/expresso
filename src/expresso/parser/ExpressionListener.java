// Generated from Expression.g4 by ANTLR 4.5

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
	 * Enter a parse tree produced by {@link ExpressionParser#root_expression}.
	 * @param ctx the parse tree
	 */
	void enterRoot_expression(ExpressionParser.Root_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#root_expression}.
	 * @param ctx the parse tree
	 */
	void exitRoot_expression(ExpressionParser.Root_expressionContext ctx);
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
	 * Enter a parse tree produced by {@link ExpressionParser#paren_expression}.
	 * @param ctx the parse tree
	 */
	void enterParen_expression(ExpressionParser.Paren_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#paren_expression}.
	 * @param ctx the parse tree
	 */
	void exitParen_expression(ExpressionParser.Paren_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#mult_expression}.
	 * @param ctx the parse tree
	 */
	void enterMult_expression(ExpressionParser.Mult_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#mult_expression}.
	 * @param ctx the parse tree
	 */
	void exitMult_expression(ExpressionParser.Mult_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#add_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd_expression(ExpressionParser.Add_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#add_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd_expression(ExpressionParser.Add_expressionContext ctx);
}