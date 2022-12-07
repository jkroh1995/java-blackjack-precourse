package util.validators;

public class MoneyValidator {

    private static final String ERROR_MONEY = "[ERROR] 금액이 올바르지 않습니다.";
    String money;

    public MoneyValidator(String money) {
        this.money = money;
        validate(money);
    }

    private void validate(String money) {
        try{
            Integer.parseInt(money);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR_MONEY);
        }
    }
}
