package Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by matt on 04.04.2016.
 */
public class GUIcalc extends JFrame {
    private String primer;
    private JTextField textField1;
    private JButton sqrtButton;
    private JButton dotButton;
    private JButton a0Button;
    private JButton equals;
    private JButton plus;
    private JButton logButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton minus;
    private JButton cosButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton multiply;
    private JButton sinButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton divide;
    private JButton closeBracket;
    private JButton openBracket;
    private JPanel rootPanel;

    public GUIcalc() {
        super();
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primer = textField1.getText();
                textField1.setText(String.valueOf(perfomCalculations(primer)));
            }
        });

        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + a1Button.getText());
            }
        });

        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + a0Button.getText());
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + a7Button.getText());
            }
        });

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + plus.getText());
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + a7Button.getText());
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + a9Button.getText());
            }
        });
                minus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText(textField1.getText() + minus.getText());
                    }
                });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + a4Button.getText());
            }
        });
                a5Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText(textField1.getText() + a5Button.getText());
                    }
                });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + a6Button.getText());
            }
        });
                multiply.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText(textField1.getText() + multiply.getText());
                    }
                });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + a2Button.getText());
            }
        });
                a3Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText(textField1.getText() + a3Button.getText());
                    }
                });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + divide.getText());
            }
        });
                closeBracket.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText(textField1.getText() + closeBracket.getText());
                    }
                });
        openBracket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + openBracket.getText());
            }
        });

        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(textField1.getText() + logButton.getText() + '(');
            }
        });
    }

    public int perfomCalculations(String s)
    {
        InToPost q = new InToPost(s);
        q.doTrans();
        System.out.println(q.getResult());
        CaclActions a = new CaclActions(q.getResult());
        return a.doAction();
    }
}
