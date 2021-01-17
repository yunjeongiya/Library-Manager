package Library;

import GUI.UIMediator;
import GUI.UIMediatorImpl;

public class Main {
    public static void main(String[] args) {
        UIMediator mediator = new UIMediatorImpl();
        mediator.openMainUI();
    }
}