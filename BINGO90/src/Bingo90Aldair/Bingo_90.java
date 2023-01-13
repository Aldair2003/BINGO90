package Bingo90Aldair;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

public class Bingo_90 extends JFrame {

    private ArrayList<Integer> bolaList; 
    private Tablero tablero;    
    private JLabel lblNumeroAleatorio;    
    private JButton btnSacarBola;
    
    public Bingo_90() {
    	getContentPane().setBackground(new Color(240, 248, 255));
        setTitle("Bingo");    
        setSize(833, 676);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        getContentPane().setLayout(null);

        bolaList = new ArrayList<Integer>();
        for (int i = 1; i <= 90; i++) {
        	bolaList.add(i);
        }
        Collections.shuffle(bolaList);
        tablero = new Tablero();
        tablero.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        tablero.setForeground(new Color(50, 205, 50));
        tablero.setBackground(new Color(240, 248, 255));
        tablero.setBounds(109, 0, 508, 529);
        tablero.setSacados(bolaList);
        getContentPane().add(tablero);

        lblNumeroAleatorio = new JLabel();
        lblNumeroAleatorio.setBorder(new MatteBorder(2, 0, 0, 2, (Color) new Color(192, 192, 192)));
        lblNumeroAleatorio.setForeground(new Color(0, 0, 0));
        lblNumeroAleatorio.setFont(new Font("Dialog", Font.PLAIN, 36));
        lblNumeroAleatorio.setBounds(10, 26, 89, 87);
        getContentPane().add(lblNumeroAleatorio);

        btnSacarBola = new JButton("Sacar bola");
        btnSacarBola.setForeground(new Color(255, 255, 255));
        btnSacarBola.setBorder(new MatteBorder(2, 0, 0, 2, (Color) new Color(192, 192, 192)));
        btnSacarBola.setBackground(new Color(255, 192, 203));
        btnSacarBola.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnSacarBola.setBounds(145, 538, 185, 87);
        btnSacarBola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bolaList.size() > 0 && !tablero.tablaLlena()) {
                    int numero = bolaList.remove(0);

                    lblNumeroAleatorio.setText(Integer.toString(numero));
                    tablero.marcarNumero(numero);
                } else {
                btnSacarBola.setEnabled(false);             
                }
                }
                });
                getContentPane().add(btnSacarBola);
                JButton btnTerminarJuego = new JButton("Salir del Juego");
                btnTerminarJuego.setForeground(new Color(255, 255, 255));
                btnTerminarJuego.setBorder(new MatteBorder(2, 0, 0, 3, (Color) new Color(192, 192, 192)));
                btnTerminarJuego.setBackground(new Color(255, 192, 203));
                btnTerminarJuego.setFont(new Font("Tahoma", Font.PLAIN, 22));
                btnTerminarJuego.setBounds(395, 536, 185, 90);
                btnTerminarJuego.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                getContentPane().add(btnTerminarJuego);

                JLabel lblBingo90 = new JLabel("Bingo90");
                lblBingo90.setHorizontalAlignment(SwingConstants.RIGHT);
                lblBingo90.setVerticalAlignment(SwingConstants.TOP);
                lblBingo90.setBackground(new Color(255, 192, 203));
                lblBingo90.setForeground(new Color(0, 0, 255));
                lblBingo90.setFont(new Font("Times New Roman", Font.BOLD, 56));
                lblBingo90.setBounds(617, 11, 200, 65);
                getContentPane().add(lblBingo90);
            }

            public static void main(String[] args) {
            	Bingo_90 bingo = new Bingo_90();
            	bingo.setVisible(true);
            	}
         }