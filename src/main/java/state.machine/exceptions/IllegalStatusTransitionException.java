package state.machine.exceptions;

public class IllegalStatusTransitionException extends Exception {
    public IllegalStatusTransitionException(String message) {
        super(message);
    }
}
