package state.machine;

import state.machine.states.StatesEnum;

public interface WorkflowObject {
    void setState(StatesEnum stateEnum);

    StatesEnum getState();
}
