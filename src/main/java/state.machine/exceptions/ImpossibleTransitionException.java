package state.machine.exceptions;

public class ImpossibleTransitionException extends Exception {
    public ImpossibleTransitionException() {
        super("This transition isn't possible");
    }
}
