package state.machine.exceptions;

public class InsufficientRightsTransitionException extends Exception {
    public InsufficientRightsTransitionException() {
        super("You don't have enough rights to access this state");
    }
}
