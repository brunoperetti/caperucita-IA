package frsf.cidisi.faia.exercise.search.caperucita.GUI;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaPerception;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;

public class Mapa {
	
	    //matriz
		private static int[][] mapa = new int[9][14];
		private static int [] posicionAgente = new int [2];
		static int vidas;
		int dulces;
		
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void dibujarMapa (int[][]matriz, int[] posCaperucita, int vidasAgente) {
			
		mapa = setMatriz(matriz, posCaperucita, mapa);
		
		//seteo de variables de estado del ambiente
		posicionAgente[0]=posCaperucita[0];
		posicionAgente[1]=posCaperucita[1];
		vidas = vidasAgente;
		
        //la aplano
        int []matrizAplanada = aplanar(mapa);
				
        //seteo de imagenes
        ImageIcon arbol = new ImageIcon("C:/Users/Bruno/git/caperucita-IA/tp/images/arbolito.jpg");
        ImageIcon lobo = new ImageIcon("C:/Users/Bruno/git/caperucita-IA/tp/images/lobo.jpg");
        ImageIcon caperucita = new ImageIcon("C:/Users/Bruno/git/caperucita-IA/tp/images/caperucita.jpg");
        ImageIcon flores = new ImageIcon("C:/Users/Bruno/git/caperucita-IA/tp/images/flores.jpg");
        ImageIcon dulce = new ImageIcon("C:/Users/Bruno/git/caperucita-IA/tp/images/dulce.jpg");
        ImageIcon vacio = new ImageIcon("C:/Users/Bruno/git/caperucita-IA/tp/images/vacio.jpg");
        ImageIcon vacioPasado = new ImageIcon("C:/Users/Bruno/git/caperucita-IA/tp/images/caperucitaBefore.jpg");
		
		
		
		final JFrame f = new JFrame("El juego de caperucita");
		//f.setResizable(false);
		f.setSize(1024, 768);
		f.setVisible(true);
		
		JPanel panelGeneral = new JPanel();
		JPanel panelTitulo = new JPanel();
		JPanel panelInfo = new JPanel();
        JPanel panelMapa = new JPanel(new GridLayout(9, 14));
        panelMapa.setBounds(504, 5, 0, 0);
        
       // JPanel general = new JPanel((new BoxLayout());
        
        JLabel labelTitulo = new JLabel();
        labelTitulo.setBounds(-101, 5, 202, 32);
        labelTitulo.setVerticalAlignment(SwingConstants.TOP);
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel labelVidas = new JLabel();
		JLabel labelDulces = new JLabel();
		JLabel labelPosicion = new JLabel();
		labelTitulo.setText("CAPERUCITA - IA");
		labelPosicion.setText("Posición agente: ("+posicionAgente[0]+", "+posicionAgente[1]+") --");
		labelVidas.setText("Vidas restantes: "+ vidas +" --");
		labelDulces.setText("Dulces recolectados: ");
		FlowLayout fl_panelInfo = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panelInfo.setLayout(fl_panelInfo);
		panelTitulo.setLayout(null);
		
		panelTitulo.add(labelTitulo);
		
		JSeparator separator = new JSeparator();
		
		
		panelInfo.add(labelPosicion);
		panelInfo.add(labelVidas);
		panelInfo.add(labelDulces);
        
        
        /*for (int i = 0; i < 104; i++) {
            JLabel l = new JLabel();
            //JLabel l = new JLabel(new ImageIcon("image_file.png"), JLabel.CENTER);
            l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            //l.setFont(l.getFont().deriveFont(20f));
            l.setIcon(dulce);
            panel.add(l);
            
        }*/
        
		//DIBUJA
        for (int i=0; i<126; i++) {
			JLabel l = new JLabel();
			if (matrizAplanada[i] == CaperucitaPerception.ARBOL_PERCEPTION) l.setIcon(arbol);
			if (matrizAplanada[i] == CaperucitaPerception.DULCE_PERCEPTION) l.setIcon(dulce);
			if (matrizAplanada[i] == CaperucitaPerception.LOBO_PERCEPTION)  l.setIcon(lobo);
			if (matrizAplanada[i] == CaperucitaPerception.FLORES_PERCEPTION) l.setIcon(flores);
			if (matrizAplanada[i] == CaperucitaPerception.VACIO_PERCEPTION) l.setIcon(vacio);
			if (matrizAplanada[i] == 10) l.setIcon(caperucita);
			if (matrizAplanada[i] == 20) l.setIcon(vacioPasado);
			l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
			panelMapa.add(l);
			//panel2.add(labelInfo);
		}
        panelGeneral.setLayout(new BorderLayout(0, 0));
                
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 42, 0, 2);
        panelTitulo.add(separator_1);
        panelGeneral.add(panelTitulo, BorderLayout.SOUTH);
        panelGeneral.add(panelInfo, BorderLayout.NORTH);
        panelGeneral.add(panelMapa, BorderLayout.CENTER);
        f.setContentPane(panelGeneral);
        
        
        
        
        //panel1.add(panel1);
        //f.add(general);
        //f.setSize(200, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    
	}
	
	//convierto la matriz que recibo en un aregglo de 1 dimension
		public static int[] aplanar(int[][] arr) {
			    List<Integer> list = new ArrayList<Integer>();
			    for (int i = 0; i < arr.length; i++) {
			        // tiny change 1: proper dimensions
			        for (int j = 0; j < arr[i].length; j++) { 
			            // tiny change 2: actually store the values
			            list.add(arr[i][j]); 
			        }
			    }
			    
			    int[] vector = new int[list.size()];
			    for (int i = 0; i < vector.length; i++) {
			        vector[i] = list.get(i);
			}
				return vector;
			
			}
		
	//seteo la matriz cada vez que se modifica
	public static int[][] setMatriz (int [][]matriz, int[] posCaperucita, int[][] mapaAnterior) {
		int mapaAux[][] = new int[9][14];
		
		for(int i=0;i<matriz.length;i++) {
			for (int j=0; j<matriz[0].length;j++) {
				if ((mapaAnterior[i][j]==20)) 
					mapaAux[i][j] = 20;
				else 
					mapaAux[i][j] = matriz[i][j];
			}
		}
		
		int caperucitaI =posCaperucita[0];
		int caperucitaJ =posCaperucita[1];
		
		mapaAux[caperucitaI][caperucitaJ]=10;
		
		//PARA DIBUJAR CAMINO RECORRIDO
		for(int i=0;i<matriz.length;i++) {
			for (int j=0; j<matriz[0].length;j++) {
				if ((mapaAnterior[i][j] == 10) && (matriz[i][j] != 10) && (matriz[i][j]!=4)) 
					mapaAux[i][j]=20;//20 significa que caperucita estuvo ahi antes.
			}
		}
		
		return mapaAux;
	}
	
	
}