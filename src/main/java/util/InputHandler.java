package util;

import domain.MoreCardIndex;
import java.util.ArrayList;
import java.util.List;
import util.validators.InputValidator;
import util.validators.MoneyValidator;
import util.validators.NamesValidator;
import view.InputView;
import view.OutputView;

public class InputHandler {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public List<String> getPlayersName() {
        try {
            String inputNames = inputView.readPlayersName();
            new NamesValidator(inputNames);
            return makeNamesList(inputNames);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getPlayersName();
        }
    }

    public int getPlayersBet(String playersName) {
        try {
            String inputBets = inputView.readPlayersBet(playersName);
            new MoneyValidator(inputBets);
            return Integer.parseInt(inputBets);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getPlayersBet(playersName);
        }
    }

    public boolean getMoreCardIndex(String name) {
        try {
            String moreCard = inputView.readMoreCard(name);
            new InputValidator(moreCard);
            return moreCard.equals(MoreCardIndex.YES.getIndex());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getMoreCardIndex(name);
        }
    }

    private List<String> makeNamesList(String inputNames) {
        String[] tmpNames = inputNames.split(",");
        List<String> names = new ArrayList<>();
        for (int i = 0; i < tmpNames.length; i++) {
            tmpNames[i] = tmpNames[i].replace(" ", "");
            names.add(tmpNames[i]);
        }
        return names;
    }
}
