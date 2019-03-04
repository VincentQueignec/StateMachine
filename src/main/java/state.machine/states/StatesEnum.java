package state.machine.states;


import state.machine.BusinessTransitionResultDTO;
import state.machine.rights.RightsEnum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * /!\ Schema to explain the basic state graph /!\
 * <p>
 * +-------------------------------------------------------------------------+
 * |                                                                         |
 * |                                             +-------+                   |
 * |                                             |REFUSED+---------------+   |
 * |                       +----------------+    +--+----+               |   |
 * |                       |                |       ^                    |   |
 * |                       v                |       |                    v   v
 * +-----+        +--------+---------+      +------------+--------+    +-+---+-+
 * |Draft+------->+WAITING_VALIDATION+----->+VALIDATION_PROCESSING+    +DELETED|
 * +----++        +------------------+      +-+---------+---------+    ++---+--+
 * ^   ^                                      |         |               ^   ^
 * |   |                                      |         v               |   |
 * |   +--------------------------------------+  +------+--+            |   |
 * +---------------------------------------------+PUBLISHED+------------+   |
 *                                               +---+-----+                |
 *                                               |   ^                      |
 *                                               |   +-----------+------+---+
 *                                               |               | ARCHIVED |
 *                                               +-------------->+----------+
 *
 * @see state.machine.StateMachine for the "implementation"
 * <p>
 * - rights => rights needed to access the state
 * - getAccessibleFrom => State from where you can access the state
 */
public enum StatesEnum {
    DRAFT(Collections.singletonList(RightsEnum.ANY)) {
        @Override
        public List<StatesEnum> getAccessibleFrom() {
            return Arrays.asList(StatesEnum.VALIDATION_PROCESSING, StatesEnum.PUBLISHED);
        }
    },
    WAITING_VALIDATION(Collections.singletonList(RightsEnum.ANY)) {
        @Override
        public List<StatesEnum> getAccessibleFrom() {
            return Arrays.asList(StatesEnum.DRAFT, StatesEnum.VALIDATION_PROCESSING);
        }
    },
    VALIDATION_PROCESSING(Collections.singletonList(RightsEnum.ANY)) {
        @Override
        public List<StatesEnum> getAccessibleFrom() {
            return Collections.singletonList(StatesEnum.WAITING_VALIDATION);
        }
    },
    REFUSED(Collections.singletonList(RightsEnum.ANY)) {
        @Override
        public List<StatesEnum> getAccessibleFrom() {
            return Collections.singletonList(StatesEnum.VALIDATION_PROCESSING);
        }
    },
    PUBLISHED(Collections.singletonList(RightsEnum.ANY)) {
        @Override
        public List<StatesEnum> getAccessibleFrom() {
            return Arrays.asList(StatesEnum.VALIDATION_PROCESSING, StatesEnum.ARCHIVED);
        }
    },
    DELETED(Collections.singletonList(RightsEnum.ANY)) {
        @Override
        public List<StatesEnum> getAccessibleFrom() {
            return Arrays.asList(StatesEnum.DRAFT, StatesEnum.REFUSED, StatesEnum.PUBLISHED, StatesEnum.ARCHIVED);
        }
    },
    ARCHIVED(Collections.singletonList(RightsEnum.ANY)) {
        @Override
        public List<StatesEnum> getAccessibleFrom() {
            return Collections.singletonList(StatesEnum.PUBLISHED);
        }
    };

    private final List<RightsEnum> rights;

    StatesEnum(List<RightsEnum> fileRights) {
        this.rights = fileRights;
    }

    /**
     * @return the default status(when a file is created)
     */
    public static StatesEnum getDefaultStatus() {
        return StatesEnum.DRAFT;
    }

    /**
     * @return true if the transition is valid from a business view
     */
    public BusinessTransitionResultDTO isTransitionValidFromBusiness(Object businessObject) {
        return BusinessTransitionResultDTO.builder().withValid(true).build();
    }

    public List<RightsEnum> getRights() {
        return rights;
    }

    /**
     * @return the collection of source state allowed to access the targeted state
     */
    public abstract List<StatesEnum> getAccessibleFrom();
}

