package domain.ladder;

import domain.Players;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Floor> ladder;

    private Ladder(List<Floor> ladder) {
        this.ladder = ladder;
    }

    public static Ladder createByStrategy(BridgeGenerator bridgeGenerator, Height height, Width width) {
        final List<Floor> ladder = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            ladder.add(Floor.createByStrategy(bridgeGenerator, width));
        }
        return new Ladder(ladder);
    }

    public List<Floor> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}