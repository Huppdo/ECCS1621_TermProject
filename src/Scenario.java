public class Scenario extends Block{

    private String scenario;
    private String option1;
    private int goTo1;
    private String option2;
    private int goTo2;

    public Scenario(String scenario, String option1, int goTo1, String option2, int goTo2) {
        this.scenario = scenario;
        this.option1 = option1;
        this.goTo1 = goTo1;
        this.option2 = option2;
        this.goTo2 = goTo2;
    }

    public int getFirstNext() {
        return goTo1;
    }

    public int getSecondNext() {
        return goTo2;
    }

    public String getMainText() {
        return scenario;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

}
