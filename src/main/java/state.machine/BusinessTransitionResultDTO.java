package state.machine;

public class BusinessTransitionResultDTO {
    private boolean valid;
    private String cause;

    public BusinessTransitionResultDTO(boolean valid, String cause) {
        this.valid = valid;
        this.cause = cause;
    }

    private BusinessTransitionResultDTO(Builder builder) {
        setValid(builder.valid);
        setCause(builder.cause);
    }

    public static Builder newBuilder(BusinessTransitionResultDTO copy) {
        Builder builder = new Builder();
        builder.cause = copy.cause;
        builder.valid = copy.valid;
        return builder;
    }

    public static IValid builder() {
        return new Builder();
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }


    public interface IBuild {
        IBuild withCause(String val);

        BusinessTransitionResultDTO build();
    }

    public interface IValid {
        IBuild withValid(boolean val);
    }

    public static final class Builder implements IValid, IBuild {
        private String cause = "";
        private boolean valid;

        private Builder() {
        }

        @Override
        public IBuild withValid(boolean val) {
            valid = val;
            return this;
        }

        @Override
        public IBuild withCause(String val) {
            cause = val;
            return this;
        }

        public BusinessTransitionResultDTO build() {
            return new BusinessTransitionResultDTO(this);
        }
    }
}
