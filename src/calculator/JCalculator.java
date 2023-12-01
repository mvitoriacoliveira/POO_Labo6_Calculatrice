package calculator;

import calculator.Operation.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

//import java.awt.event.*;

public class JCalculator extends JFrame {
    // Tableau representant une pile vide
    private static final String[] empty = {"< empty stack >"};

    // Zone de texte contenant la valeur introduite ou resultat courant
    private final JTextField jNumber = new JTextField("0");

    // Composant liste representant le contenu de la pile
    private final JList<String> jStack = new JList<>(empty);

    // Contraintes pour le placement des composants graphiques
    private final GridBagConstraints constraints = new GridBagConstraints();

    //private String currentInput = "0";

    private State currentState = new State("0");

    // Mise a jour de l'interface apres une operation (jList et jStack)
    private void update() {
        // Modifier une zone de texte, JTextField.setText(string nom)
        // Modifier un composant liste, JList.setListData(Object[] tableau)

      /*String result = currentState.getCurrentInput();
      if (currentInput.equals("0")) {
          currentInput = result;
      } else {
          currentInput += result;
      }*/

        jNumber.setText(currentState.getCurrentInput());

        //String[] stackData = { currentInput };
    }

    private void updateCurrentState(String input) {
        currentState.setCurrentInput(input);
    }

    // Ajout d'un bouton dans l'interface et de l'operation associee,
    // instance de la classe Operation, possedeant une methode execute()
    private void addOperatorButton(String name, int x, int y, Color color,
                                   final Operator operator) {
        JButton b = new JButton(name);
        b.setForeground(color);
        constraints.gridx = x;
        constraints.gridy = y;
        getContentPane().add(b, constraints);
        b.addActionListener((e) -> {
            if (operator instanceof NumericKeypad) {
                NumericKeypad numericKeypad = (NumericKeypad) operator;
                operator.execute();
                updateCurrentState(String.valueOf(operator.state.getCurrentInput()));
            } else if (operator != null) {
                operator.execute();
                updateCurrentState(String.valueOf(operator.state.getCurrentInput()));
            }
            update();

        });
    }

    public JCalculator() {
        super("JCalculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        // Contraintes des composants graphiques
        constraints.insets = new Insets(3, 3, 3, 3);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // Nombre courant
        jNumber.setEditable(false);
        jNumber.setBackground(Color.WHITE);
        jNumber.setHorizontalAlignment(JTextField.RIGHT);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        getContentPane().add(jNumber, constraints);
        constraints.gridwidth = 1; // reset width

        // Rappel de la valeur en memoire
        addOperatorButton("MR", 0, 1, Color.RED, null);

        // Stockage d'une valeur en memoire
        addOperatorButton("MS", 1, 1, Color.RED, null);

        // Backspace
        Backspace backspace = new Backspace(currentState);
        addOperatorButton("<=", 2, 1, Color.RED, backspace);

        // Mise a zero de la valeur courante + suppression des erreurs
        ClearError clearError = new ClearError(currentState);
        addOperatorButton("CE", 3, 1, Color.RED, clearError);

        // Comme CE + vide la pile
        addOperatorButton("C", 4, 1, Color.RED, null);

        // Boutons 1-9
        for (int i = 1; i < 10; i++) {
            NumericKeypad numericKeypad = new NumericKeypad(i, currentState);
            addOperatorButton(String.valueOf(i), (i - 1) % 3, 4 - (i - 1) / 3,
                    Color.BLUE, numericKeypad);
        }
        // Bouton 0
        NumericKeypad numericKeypadZero = new NumericKeypad(0, currentState);
        addOperatorButton("0", 0, 5, Color.BLUE, numericKeypadZero);


    /*// Changement de signe de la valeur courante
    addOperatorButton("+/-", 1, 5, Color.BLUE, unop);*/

        // Operateur point (chiffres apres la virgule ensuite)
        Dot dot = new Dot(currentState);
        addOperatorButton(".", 2, 5, Color.BLUE, dot);

    /*// Operateurs arithmetiques a deux operandes: /, *, -, +
    addOperatorButton("/", 3, 2, Color.RED, div);
    addOperatorButton("*", 3, 3, Color.RED, mult);
    addOperatorButton("-", 3, 4, Color.RED, sub);
    addOperatorButton("+", 3, 5, Color.RED, add);*/

    // Operateurs arithmetiques a un operande: 1/x, x^2, Sqrt
        Inverse inv = new Inverse(currentState);
        addOperatorButton("1/x", 4, 2, Color.RED, inv);
        Squared sq = new Squared(currentState);
        addOperatorButton("x^2", 4, 3, Color.RED, sq);
        SquareRoot sqrt = new SquareRoot(currentState);
        addOperatorButton("Sqrt", 4, 4, Color.RED, sqrt);

        // Entree: met la valeur courante sur le sommet de la pile
        /*Enter<> enter = new Enter(currentState, )
        addOperatorButton("Ent", 4, 5, Color.RED, enter);*/

        // Affichage de la pile
        JLabel jLabel = new JLabel("Stack");
        jLabel.setFont(new Font("Dialog", 0, 12));
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        constraints.gridx = 5;
        constraints.gridy = 0;
        getContentPane().add(jLabel, constraints);

        jStack.setFont(new Font("Dialog", 0, 12));
        jStack.setVisibleRowCount(8);
        JScrollPane scrollPane = new JScrollPane(jStack);
        constraints.gridx = 5;
        constraints.gridy = 1;
        constraints.gridheight = 5;
        getContentPane().add(scrollPane, constraints);
        constraints.gridheight = 1; // reset height

        setResizable(false);
        pack();
        setVisible(true);
    }
}
