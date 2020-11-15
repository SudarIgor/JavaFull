package lesson_8;

import javax.swing.*;

public class Window extends JFrame {

    private  double aPow;
    private  double pPow;
    private  double dc;
    private  double attInLine;
    private static String str ="";
    private static String [] courses = {"uW","mW", "W"};
    private static String chBox = courses [0];
    private static String res;


    private String digit (String ch){

         pPow = aPow * dc * attInLine;

         while ((pPow > 999) && (ch != courses[courses.length-1]) ) {
             int index = 0;
             for (int i = 0; i < courses.length; i++) {
                 if (courses[i].equals(ch)) index = i;
             }
             pPow /=1000;
             ch = courses[index+ 1 ];
         }
         res = String.valueOf("Pulse Power: "+ String.format("%.2f", pPow) + " " + ch);
         return res;
     }


    private boolean checkDouble (String check){
        check = check.replace(',','.');
        return check.matches("(\\-*)\\d+\\.*+\\d*+");
     }

    public Window() /*throws HeadlessException*/ {

        JFrame fr = new JFrame();

        fr.setSize(350,300);
        fr.setTitle("Calculation of pulse power");
        fr.setLocationRelativeTo(null);
        fr.setLayout(null);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextField textAPow = new JTextField("0");
        textAPow.setBounds( 120,20,80,20);
        fr.add(textAPow);

        JLabel lAPow = new JLabel("Average Power");
        lAPow.setBounds(10,20,100,20);
        fr.add(lAPow);

        JComboBox comboBox = new JComboBox(courses);
        comboBox.setBounds(210,20,80,20);
        fr.add(comboBox);

        JTextField textDC = new JTextField("0");
        textDC.setBounds(120,60,80,20);
        fr.add(textDC);

        JLabel lDC = new JLabel("Duty Cycle");
        lDC.setBounds(10,60,100,20);
        fr.add(lDC);

        JTextField textAttInLine = new JTextField("0");
        textAttInLine.setBounds(120,100,80,20);
        fr.add(textAttInLine);

        JLabel lAttInLine = new JLabel("Att. in line, dB");
        lAttInLine.setBounds(10,100,170,20);
        fr.add(lAttInLine);

        JLabel lPPow = new JLabel("Pulse Power");
        lPPow.setBounds(10,170,200,30);
        fr.add(lPPow);

        JLabel lTrbl = new JLabel("Input error. Check the entered values.");
        lTrbl.setBounds(10,210,250,30);
        lTrbl.setVisible(false);
        fr.add(lTrbl);

        JButton bCalc = new JButton("Calculate");
        bCalc.setBounds(10,140,100,20);
        fr.add(bCalc);

        comboBox.addActionListener(e -> {
            chBox = (String) comboBox.getSelectedItem();
        });

        bCalc.addActionListener(e -> {

            boolean a = checkDouble(textAPow.getText());
            boolean b = checkDouble(textDC.getText());
            boolean c = checkDouble(textAttInLine.getText());
            if (a && b && c) {
                lTrbl.setVisible(false);
                aPow = Double.parseDouble(textAPow.getText().replace(',','.') );
                dc = Double.parseDouble(textDC.getText().replace(',','.') );
                attInLine = Math.pow(10.0, (Double.parseDouble(textAttInLine.getText().
                        replace(',','.') ) / 10));
                res = digit(chBox);
                lPPow.setText(res);
            }
            else {
                lPPow.setText("Pulse Power");
                lTrbl.setVisible(true);
            }
        });
    }
}



