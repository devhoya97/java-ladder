package domain.ladder;

import java.util.Arrays;
import java.util.List;

public enum Bridge {

    BRIDGE(true),
    NO_BRIDGE(false);

    private static final int MATCHED_BRIDGE_COUNT = 1;
    private final boolean exist;

    Bridge(final boolean exist) {
        this.exist = exist;
    }

    public static Bridge getBy(final boolean exist) {
        final List<Bridge> matchedBridge = Arrays.stream(values())
                .filter(bridge -> bridge.exist == exist)
                .toList();

        if (matchedBridge.size() != MATCHED_BRIDGE_COUNT) {
            throw new IllegalStateException("Bridge를 찾을 수 없거나 중복되는 값이 존재합니다.");
        }

        return matchedBridge.get(0);
    }
}