package state.machine;

import org.junit.Before;
import org.junit.Test;
import state.machine.exceptions.IllegalStatusTransitionException;
import state.machine.exceptions.ImpossibleTransitionException;
import state.machine.exceptions.InsufficientRightsTransitionException;
import state.machine.rights.RightsEnum;
import state.machine.states.StatesEnum;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Add tests on business rules (IllegalStatusTransitionException)
 * Add tests on rights rules (InsufficientRightsTransitionException)
 */
public class StateMachineTest {
    private StateMachine<WorkflowObject> stateMachine = new StateMachine<>();

    @Before
    public void setUp(){
        stateMachine = new StateMachine<>();
    }

    //region Impossible states to Draft
    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromWaitingValidationToDraft() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.WAITING_VALIDATION), StatesEnum.DRAFT, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromRefusedToDraft() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.REFUSED), StatesEnum.DRAFT, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromDeletedToDraft() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.DELETED), StatesEnum.DRAFT, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromArchivedToDraft() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.ARCHIVED), StatesEnum.DRAFT, RightsEnum.ANY);
    }
    //endregion

    //region Impossible states to Waiting Validation
    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromPublishedToWaitingValidation() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.PUBLISHED), StatesEnum.WAITING_VALIDATION, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromArchivedToWaitingValidation() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.ARCHIVED), StatesEnum.WAITING_VALIDATION, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromDeletedToWaitingValidation() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.DELETED), StatesEnum.WAITING_VALIDATION, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromRefusedToWaitingValidation() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.REFUSED), StatesEnum.WAITING_VALIDATION, RightsEnum.ANY);
    }
    //endregion

    //region Impossible states to Validation Processing
    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromDraftToValidationProcessing() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.DRAFT), StatesEnum.VALIDATION_PROCESSING, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromRefusedToValidationProcessing() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.REFUSED), StatesEnum.VALIDATION_PROCESSING, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromDeletedToValidationProcessing() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.DELETED), StatesEnum.VALIDATION_PROCESSING, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromPublishedToValidationProcessing() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.PUBLISHED), StatesEnum.VALIDATION_PROCESSING, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromArchivedToValidationProcessing() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.ARCHIVED), StatesEnum.VALIDATION_PROCESSING, RightsEnum.ANY);
    }
    //endregion

    //region Impossible states to Refused
    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromDraftToRefused() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.DRAFT), StatesEnum.REFUSED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromWaitingValidationToRefused() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.WAITING_VALIDATION), StatesEnum.REFUSED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromDeletedToRefused() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.DELETED), StatesEnum.REFUSED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromPublishedToRefused() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.PUBLISHED), StatesEnum.REFUSED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromArchivedToRefused() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.ARCHIVED), StatesEnum.REFUSED, RightsEnum.ANY);
    }
    //endregion

    //region Impossible states to Deleted
    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromWaitingValidationToDeleted() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.WAITING_VALIDATION), StatesEnum.DELETED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromValidationProcessingToDeleted() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.VALIDATION_PROCESSING), StatesEnum.DELETED, RightsEnum.ANY);
    }
    //endregion

    //region Impossible states to Published
    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromDraftToPublished() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.DRAFT), StatesEnum.PUBLISHED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromWaitingValidationToPublished() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.WAITING_VALIDATION), StatesEnum.PUBLISHED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromRefusedToPublished() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.REFUSED), StatesEnum.PUBLISHED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromDeletedToPublished() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.DELETED), StatesEnum.PUBLISHED, RightsEnum.ANY);
    }
    //endregion

    //region Impossible states to Archived
    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromDraftToArchived() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.DRAFT), StatesEnum.ARCHIVED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromWaitingValidationToArchived() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.WAITING_VALIDATION), StatesEnum.ARCHIVED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromValidationProcessingToArchived() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.VALIDATION_PROCESSING), StatesEnum.ARCHIVED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromDeletedToArchived() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.DELETED), StatesEnum.ARCHIVED, RightsEnum.ANY);
    }

    @Test(expected = ImpossibleTransitionException.class)
    public void impossibleStatesFromRefusedToArchived() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.REFUSED), StatesEnum.ARCHIVED, RightsEnum.ANY);
    }
    //endregion

    //region Possible states to Draft
    @Test
    public void possibleStatesFromPublishedToDraft() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.PUBLISHED), StatesEnum.DRAFT, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.DRAFT);
    }

    @Test
    public void possibleStatesFromValidationProcessingToDraft() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.VALIDATION_PROCESSING), StatesEnum.DRAFT, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.DRAFT);
    }
    //endregion

    //region Possible states to Waiting Validation
    @Test
    public void possibleStatesFromValidationProcessingToWaitingValidation() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.VALIDATION_PROCESSING), StatesEnum.WAITING_VALIDATION, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.WAITING_VALIDATION);
    }

    @Test
    public void possibleStatesFromDraftToWaitingValidation() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.VALIDATION_PROCESSING), StatesEnum.DRAFT, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.DRAFT);
    }
    //endregion

    //region Possible states to ValidationProcessing
    @Test
    public void possibleStatesFromWaitingValidationToValidationProcessing() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.WAITING_VALIDATION), StatesEnum.VALIDATION_PROCESSING, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.VALIDATION_PROCESSING);
    }
    //endregion

    //region Possible states to Refused
    @Test
    public void possibleStatesFromValidationProcessingToRefused() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.VALIDATION_PROCESSING), StatesEnum.REFUSED, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.REFUSED);
    }
    //endregion

    //region Possible states to Delete
    @Test
    public void possibleStatesFromRefusedToDelete() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.REFUSED), StatesEnum.DELETED, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.DELETED);
    }

    @Test
    public void possibleStatesFromDraftToDelete() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.DRAFT), StatesEnum.DELETED, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.DELETED);
    }

    @Test
    public void possibleStatesFromPublishedToDelete() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.PUBLISHED), StatesEnum.DELETED, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.DELETED);
    }

    @Test
    public void possibleStatesFromArchivedToDelete() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.ARCHIVED), StatesEnum.DELETED, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.DELETED);
    }
    //endregion

    //region Possible states to Published
    @Test
    public void possibleStatesFromValidationProcessingToPublished() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.VALIDATION_PROCESSING), StatesEnum.PUBLISHED, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.PUBLISHED);
    }

    @Test
    public void possibleStatesFromArchivedToPublished() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.ARCHIVED), StatesEnum.PUBLISHED, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.PUBLISHED);
    }
    //endregion

    //region possible states to Archived
    @Test
    public void possibleStatesFromPublishedToPublished() throws IllegalStatusTransitionException, ImpossibleTransitionException, InsufficientRightsTransitionException {
        WorkflowObject data = stateMachine.validate(givenAWorkflowObjectWithStatus(StatesEnum.PUBLISHED), StatesEnum.ARCHIVED, RightsEnum.ANY);

        assertThat(data).hasFieldOrPropertyWithValue("state", StatesEnum.ARCHIVED);
    }
    //endregion

    private WorkflowObject givenAWorkflowObjectWithStatus(StatesEnum status){
        return new TestingWorkflowObj(status);
    }


    private class TestingWorkflowObj implements WorkflowObject {
        private StatesEnum StatesEnum;

        TestingWorkflowObj(StatesEnum StatesEnum) {
            this.StatesEnum = StatesEnum;
        }

        @Override
        public void setState(StatesEnum StatesEnum) {
            this.StatesEnum = StatesEnum;
        }

        @Override
        public StatesEnum getState() {
            return StatesEnum;
        }
    }
}