// Generated from /Users/fanghr/Developer/OTPLogin/src/main/java/site/urandom/otplogin/commands/grammars/OTPLoginRules.g4 by ANTLR 4.9.1
package site.urandom.otplogin.commands.grammars;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link OTPLoginRulesVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class OTPLoginRulesBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements OTPLoginRulesVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSetup(OTPLoginRulesParser.SetupContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitLogin(OTPLoginRulesParser.LoginContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitVerify(OTPLoginRulesParser.VerifyContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSubcommand(OTPLoginRulesParser.SubcommandContext ctx) { return visitChildren(ctx); }
}