public class Explanations extends Block{

    private int next;
    private String string;

    public Explanations(int next, String string) {
        this.next = next;
        this.string = string;
    }

    public String getMainText() {
        return string;
    }

    public int getFirstNext() {
        return next;
    }

    public int getSecondNext() {
        return next;
    }
}
