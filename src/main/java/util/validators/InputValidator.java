package util.validators;

import domain.MoreCardIndex;

public class InputValidator {

    private static final String ERROR_BLANK = "[ERROR] 카드를 더 받을지를 입력해야합니다.";
    private static final String ERROR_VALUE = "[ERROR] y또는 n만 입력해주세요.";
    private static final String BLANK = "";
    String moreCard;

    public InputValidator(String moreCard) {
        this.moreCard = moreCard;
        validate(moreCard);
    }

    private void validate(String moreCard) {
        validateBlank(moreCard);
        validateValue(moreCard);
    }

    private void validateBlank(String moreCard) {
        if(moreCard.equals(BLANK)){
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private void validateValue(String moreCard) {
        if(!moreCard.equals(MoreCardIndex.YES.getIndex())&&!moreCard.equals(MoreCardIndex.NO.getIndex())){
            throw new IllegalArgumentException(ERROR_VALUE);
        }
    }
}
