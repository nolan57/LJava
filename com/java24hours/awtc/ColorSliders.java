package com.java24hours.awtc;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ColorSliders extends JFrame implements ChangeListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    ColorPanel canvas;
    JSlider redJSlider;
    JSlider greenJSlider;
    JSlider blueJSlider;

    public ColorSliders() {
        super("Color Slider");
        setLookAndFeel();
        setSize(540, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas=new ColorPanel();
        canvas.setSize(270, 270);
        redJSlider = new JSlider(0, 255, 255);
        greenJSlider = new JSlider(0, 255, 255);
        blueJSlider = new JSlider(0, 255, 255);

        redJSlider.setMajorTickSpacing(50);
        redJSlider.setMinorTickSpacing(10);
        redJSlider.setPaintTicks(true);
        redJSlider.setPaintLabels(true);
        redJSlider.addChangeListener(this);
        greenJSlider.setMajorTickSpacing(50);
        greenJSlider.setMinorTickSpacing(10);
        greenJSlider.setPaintTicks(true);
        greenJSlider.setPaintLabels(true);
        greenJSlider.addChangeListener(this);
        blueJSlider.setMajorTickSpacing(50);
        blueJSlider.setMinorTickSpacing(10);
        blueJSlider.setPaintTicks(true);
        blueJSlider.setPaintLabels(true);
        blueJSlider.addChangeListener(this);

        JLabel redLabel = new JLabel("Red: ");
        JLabel greenLabel = new JLabel("Green: ");
        JLabel blueLabel = new JLabel("Blue: ");

        FlowLayout rightFlowLayout = new FlowLayout(FlowLayout.RIGHT);
        //GridLayout gridLayout = new GridLayout(4, 1);
        BorderLayout borderLayout=new BorderLayout();
        JPanel sliderJPanel=new JPanel();
        BoxLayout boxLayout=new BoxLayout(sliderJPanel, BoxLayout.Y_AXIS);
        sliderJPanel.setLayout(boxLayout);

        setLayout(borderLayout);

        JPanel redJPanel = new JPanel();
        redJPanel.setLayout(rightFlowLayout);
        redJPanel.add(redLabel);
        redJPanel.add(redJSlider);
        //add(redJPanel);
        JPanel greenJPanel = new JPanel();
        greenJPanel.setLayout(rightFlowLayout);
        greenJPanel.add(greenLabel);
        greenJPanel.add(greenJSlider);
        //add(greenJPanel);
        JPanel blueJPanel = new JPanel();
        blueJPanel.setLayout(rightFlowLayout);
        blueJPanel.add(blueLabel);
        blueJPanel.add(blueJSlider);
        sliderJPanel.setSize(270, 270);
        sliderJPanel.add(redJPanel);
        sliderJPanel.add(greenJPanel);
        sliderJPanel.add(blueJPanel);

        add(sliderJPanel,BorderLayout.WEST);
        add(canvas,BorderLayout.CENTER);

        setVisible(true);
    }
    private void setLookAndFeel() {
        try{
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception exception){
            //ignore error
        }
    }

    private class ColorPanel extends JPanel{
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        Color backgroudColor;
        public ColorPanel(){
            backgroudColor=Color.red;
        }
        public void paintComponent(Graphics comp) {
            Graphics2D compGraphics2d=(Graphics2D)comp;
            compGraphics2d.setColor(backgroudColor);
            compGraphics2d.fillRect(0, 0, getSize().width, getSize().height);
            //compGraphics2d.fillRect(0, 0, 270, 270);
        }
        public void changeColor(Color newBackgroudColor) {
            backgroudColor=newBackgroudColor;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        //TODO Auto-generated method stub
        //JSlider sourJSlider=(JSlider)e.getSource();
        //if(sourJSlider.getValueIsAdjusting()!=true){
            Color curColor=new Color(
                redJSlider.getValue(),
                greenJSlider.getValue(),
                blueJSlider.getValue()
                );
            canvas.changeColor(curColor);
            canvas.repaint();
        //}

    }
    public static void main(String[] args) {
        ColorSliders colorSliders=new ColorSliders();
    }

}