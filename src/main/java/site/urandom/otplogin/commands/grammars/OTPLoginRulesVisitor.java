// Generated from /Users/fanghr/Developer/OTPLogin/src/main/java/site/urandom/otplogin/commands/grammars/OTPLoginRules.g4 by ANTLR 4.9.1
package site.urandom.otplogin.commands.grammars;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OTPLoginRulesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OTPLoginRulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OTPLoginRulesParser#setup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetup(OTPLoginRulesParser.SetupContext ctx);
	/**
	 * Visit a parse tree produced by {@link OTPLoginRulesParser#login}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogin(OTPLoginRulesParser.LoginContext ctx);
	/**
	 * Visit a parse tree produced by {@link OTPLoginRulesParser#verify}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVerify(OTPLoginRulesParser.VerifyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OTPLoginRulesParser#subcommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubcommand(OTPLoginRulesParser.SubcommandContext ctx);
}