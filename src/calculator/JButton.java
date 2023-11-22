package calculator;
import calculator.Operation.*;

import java.awt.event.ActionEvent;


public class JButton {

    //operations
    Addition add = new Addition();
    Substraction sub = new Substraction();
    Multiplication mult = new Multiplication();
    Divide div = new Divide();
    Inverse inv = new Inverse();
    Squared squ = new Squared();
    SquareRoot sqrt = new SquareRoot();
    UnaryOp unop = new UnaryOp();

    // buttons
    JButton addButton = new JButton();
    JButton subButton = new JButton();
    JButton mulButton = new JButton();
    JButton divButton = new JButton();
    JButton sqaButton = new JButton();
    JButton sqrtButton = new JButton();
    JButton unOpButton = new JButton();


    addButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            add.execute()
        }
    });
}
