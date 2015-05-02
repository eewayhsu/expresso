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
	 * Enter a parse tree produced by {@link ExpressionParser#operation_expression}.
	 * @param ctx the parse tree
	 */
	void enterOperation_expression(ExpressionParser.Operation_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#operation_expression}.
	 * @param ctx the parse tree
	 */
	void exitOperation_expression(ExpressionParser.Operation_expressionContext ctx);
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
	 * Enter a parse tree produced by {@link ExpressionParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(ExpressionParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(ExpressionParser.TokenContext ctx);
}