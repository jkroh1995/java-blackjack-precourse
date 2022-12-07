package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String REQUIRE_PLAYERS = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String ASK_BET = "%s의 배팅 금액은?\n";
    private static final String ASK_MORE_CARD = "%s는 한 장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n";

    Scanner sc = new Scanner(System.in);
    OutputView outputView = new OutputView();

    public String readPlayersName() {
        System.out.println(REQUIRE_PLAYERS);
        return sc.nextLine();
    }

    public String readPlayersBet(String name) {
        outputView.printBlankLine();
        System.out.printf(ASK_BET, name);
        return sc.nextLine();
    }

    public String readMoreCard(String name) {
        outputView.printBlankLine();
        System.out.printf(ASK_MORE_CARD, name);
        return sc.nextLine();
    }
}
