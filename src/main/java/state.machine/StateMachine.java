package state.machine;

import state.machine.exceptions.IllegalStatusTransitionException;
import state.machine.exceptions.ImpossibleTransitionException;
import state.machine.exceptions.InsufficientRightsTransitionException;
import state.machine.rights.RightsEnum;
import state.machine.states.StatesEnum;

final class StateMachine <T extends WorkflowObject> {

    T validate(T workflowObject, StatesEnum targetStatus, RightsEnum rigth) throws ImpossibleTransitionException, InsufficientRightsTransitionException, IllegalStatusTransitionException {
        if (!targetStatus.getAccessibleFrom().contains(workflowObject.getState()))
            throw new ImpossibleTransitionException();

        if (!targetStatus.getRights().contains(rigth))
            throw new InsufficientRightsTransitionException();

        BusinessTransitionResultDTO businessResult = targetStatus.isTransitionValidFromBusiness(workflowObject);
        if (!businessResult.isValid())
            throw new IllegalStatusTransitionException(businessResult.getCause());

        //Transition is valid
        workflowObject.setState(targetStatus);
        return workflowObject;
    }
}