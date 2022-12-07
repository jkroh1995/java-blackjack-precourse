package util.validators;

public class NamesValidator {

    private static final String ERROR_BLANK = "[ERROR] 참가자들의 이름을 입력해야합니다.";
    private static final String ERROR_DIVIDE = "[ERROR] 이름을 ','로 분류해주세요";
    private static final String DIVIDE = ",";
    private static final String BLANK = "";
    String names;

    public NamesValidator(String names){
        this.names = names;
        validate(names);
    }

    private void validate(String names) {
        validateBlank(names);
        validateDivide(names);
    }

    private void validateDivide(String names) {
        String[] tmpArray = names.split(DIVIDE);
        if (countChar(names, ',')+1 != tmpArray.length) {
            throw new IllegalArgumentException(ERROR_DIVIDE);
        }
    }

    private void validateBlank(String names) {
        if(names.equals(BLANK)){
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
