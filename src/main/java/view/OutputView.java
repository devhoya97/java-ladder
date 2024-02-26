package view;

import domain.Bridge;
import domain.Bridges;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String NAME_DELIMITER = " ";
    private static final String FIRST_COLUMN = "    |";
    private static final String COLUMN = "|";

    public void printResultMessage() {
        System.out.println(System.lineSeparator() + "실행결과");
    }

    public void printPlayers(List<String> names) {
        StringJoiner nameJoiner = new StringJoiner(NAME_DELIMITER);
        for (final String name : names) {
            nameJoiner.add(String.format("%5s", name));
        }
        System.out.println(System.lineSeparator() + nameJoiner);
    }

    public void printLadder(List<Bridges> ladder) {
        StringJoiner ladderShapeJoiner = new StringJoiner(System.lineSeparator());
        for (final Bridges bridges : ladder) {
            ladderShapeJoiner.add(getBridgesShape(bridges));
        }
        System.out.println(ladderShapeJoiner);
    }

    private static String getBridgesShape(final Bridges bridges) {
        StringJoiner bridgesShapeJoiner = new StringJoiner(COLUMN, FIRST_COLUMN, COLUMN);
        for (Bridge bridge : bridges.getBridges()) {
            bridgesShapeJoiner.add(BridgeShape.convertForView(bridge));
        }
        return bridgesShapeJoiner.toString();
    }
}
