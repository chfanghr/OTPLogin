// Generated from /Users/fanghr/Developer/OTPLogin/src/main/java/site/urandom/otplogin/commands/grammars/OTPLoginRules.g4 by ANTLR 4.9.1
package site.urandom.otplogin.commands.grammars;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OTPLoginRulesParser}.
 */
public interface OTPLoginRulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OTPLoginRulesParser#setup}.
	 * @param ctx the parse tree
	 */
	void enterSetup(OTPLoginRulesParser.SetupContext ctx);
	/**
	 * Exit a parse tree produced by {@link OTPLoginRulesParser#setup}.
	 * @param ctx the parse tree
	 */
	void exitSetup(OTPLoginRulesParser.SetupContext ctx);
	/**
	 * Enter a parse tree produced by {@link OTPLoginRulesParser#login}.
	 * @param ctx the parse tree
	 */
	void enterLogin(OTPLoginRulesParser.LoginContext ctx);
	/**
	 * Exit a parse tree produced by {@link OTPLoginRulesParser#login}.
	 * @param ctx the parse tree
	 */
	void exitLogin(OTPLoginRulesParser.LoginContext ctx);
	/**
	 * Enter a parse tree produced by {@link OTPLoginRulesParser#verify}.
	 * @param ctx the parse tree
	 */
	void enterVerify(OTPLoginRulesParser.VerifyContext ctx);
	/**
	 * Exit a parse tree produced by {@link OTPLoginRulesParser#verify}.
	 * @param ctx the parse tree
	 */
	void exitVerify(OTPLoginRulesParser.VerifyContext ctx);
	/**
	 * Enter a parse tree produced by {@link OTPLoginRulesParser#subcommand}.
	 * @param ctx the parse tree
	 */
	void enterSubcommand(OTPLoginRulesParser.SubcommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link OTPLoginRulesParser#subcommand}.
	 * @param ctx the parse tree
	 */
	void exitSubcommand(OTPLoginRulesParser.SubcommandContext ctx);
}