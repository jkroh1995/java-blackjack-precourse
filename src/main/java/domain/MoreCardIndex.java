package domain;

public enum MoreCardIndex {

    YES("y"),
    NO("n");

    String index;

    MoreCardIndex(String index){
        this. index = index;
    }

    public String getIndex(){
        return index;
    }
}
