package frsf.cidisi.faia.exercise.search.caperucita;

import java.util.ArrayList;
import java.util.Random;

import frsf.cidisi.faia.exercise.search.caperucita.GUI.Mapa;
import frsf.cidisi.faia.state.EnvironmentState;

public class CaperucitaEnvironmentState extends EnvironmentState {

	private int[][] mapa;
    private int[] posicionCaperucita;
    private int[] posicionDulces;
    private int[] posicionLobo;
    private int[] posicionFlores;
    private int[] posicionArboles;
    private int vidasAgente;
	
    public CaperucitaEnvironmentState() {
    	mapa = new int[9][14];
        this.initState();
    }
    
    

	@Override
	public void initState() {
		
		vidasAgente = 3;
		// Primero llenamos todas las casillas como vacio, y despues reemplazamos algunas posiciones con otras percepciones.
        for (int fil = 0; fil < mapa.length; fil++) {
            for (int col = 0; col < mapa[0].length; col++) {
                mapa[fil][col] = CaperucitaPerception.VACIO_PERCEPTION;
            }
        }

       
        /* Seteamos otras percepciones */
        
        // https://imgur.com/a/BtXTWP4  >>>> imagen con posiciones, representando el escenario 1 del enunciado
        
        //ARBOLES
        mapa[0][0] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][1] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][2] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][3] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][4] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][5] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][6] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][7] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][8] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][9] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][10] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][11] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][12] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[0][13] = CaperucitaPerception.ARBOL_PERCEPTION;
        
        mapa[1][0] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[1][1] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[1][7] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[1][11] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[1][12] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[1][13] = CaperucitaPerception.ARBOL_PERCEPTION;
        
        mapa[2][0] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[2][1] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[2][2] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[2][4] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[2][12] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[2][13] = CaperucitaPerception.ARBOL_PERCEPTION;
        
        mapa[3][0] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[3][1] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[3][9] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[3][12] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[3][13] = CaperucitaPerception.ARBOL_PERCEPTION;
        
        mapa[4][0] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[4][1] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[4][2] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[4][3] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[4][4] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[4][8] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[4][12] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[4][13] = CaperucitaPerception.ARBOL_PERCEPTION;
        
        mapa[5][0] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[5][1] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[5][2] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[5][4] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[5][5] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[5][12] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[5][13] = CaperucitaPerception.ARBOL_PERCEPTION;
        
        mapa[6][0] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[6][1] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[6][2] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[6][5] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[6][6] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[6][7] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[6][9] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[6][11] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[6][12] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[6][13] = CaperucitaPerception.ARBOL_PERCEPTION;
        
        mapa[7][0] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[7][1] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[7][2] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[7][6] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[7][11] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[7][12] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[7][13] = CaperucitaPerception.ARBOL_PERCEPTION;
        
        mapa[8][0] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][1] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][2] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][3] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][4] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][5] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][6] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][8] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][9] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][10] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][11] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][12] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[8][13] = CaperucitaPerception.ARBOL_PERCEPTION;
        
        //DULCES 
        mapa[1][3] = CaperucitaPerception.DULCE_PERCEPTION;
        mapa[1][10] = CaperucitaPerception.DULCE_PERCEPTION;
        mapa[3][8] = CaperucitaPerception.DULCE_PERCEPTION;

        //CAMPO DE FLORES
        mapa[7][7] = CaperucitaPerception.FLORES_PERCEPTION;
        mapa[8][7] = CaperucitaPerception.FLORES_PERCEPTION;
        mapa[0][3] = CaperucitaPerception.ARBOL_PERCEPTION;
        mapa[1][2] = CaperucitaPerception.ARBOL_PERCEPTION;

        //LOBO
        mapa[6][4] = CaperucitaPerception.LOBO_PERCEPTION; //Posicion inicial del lobo la seteamos? luego random
        
        
        //CAPERUCITA
        this.setPosicionAgente(new int[]{5, 8});
		
	}
	
	public void inicializarMapa (int n) {
		
		switch(n) {
		case 1: 
			
			//escenario1
			
			//ARBOLES
	        mapa[0][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][6] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][8] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[1][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[2][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[3][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[4][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][8] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[5][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[6][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][6] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[7][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][6] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[8][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][6] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][8] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        //DULCES 
	        mapa[1][3] = CaperucitaPerception.DULCE_PERCEPTION;
	        mapa[1][10] = CaperucitaPerception.DULCE_PERCEPTION;
	        mapa[3][8] = CaperucitaPerception.DULCE_PERCEPTION;

	        //CAMPO DE FLORES
	        mapa[7][7] = CaperucitaPerception.FLORES_PERCEPTION;
	        mapa[8][7] = CaperucitaPerception.FLORES_PERCEPTION;
	        mapa[0][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][2] = CaperucitaPerception.ARBOL_PERCEPTION;

	        //LOBO
	        mapa[6][4] = CaperucitaPerception.LOBO_PERCEPTION; //Posicion inicial del lobo la seteamos? luego random
	        
	        //CAPERUCITA
	        this.setPosicionAgente(new int[]{5, 11});
			
			
			
		case 2:
			//escenario 2
			
			
			//ARBOLES
	        mapa[0][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][6] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][8] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[1][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][8] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        
	        
	        
	        mapa[2][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][8] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[3][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        
	        mapa[4][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[5][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[6][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	      
	        
	        mapa[7][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[8][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][8] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        //DULCES 
	        mapa[1][5] = CaperucitaPerception.DULCE_PERCEPTION;
	        mapa[3][8] = CaperucitaPerception.DULCE_PERCEPTION;
	        mapa[4][10] = CaperucitaPerception.DULCE_PERCEPTION;

	        //CAMPO DE FLORES
	        mapa[7][6] = CaperucitaPerception.FLORES_PERCEPTION;
	        mapa[8][6] = CaperucitaPerception.FLORES_PERCEPTION;
	     

	        //LOBO
	        mapa[7][10] = CaperucitaPerception.LOBO_PERCEPTION; //Posicion inicial del lobo la seteamos? luego random
	        
	        //CAPERUCITA
	        this.setPosicionAgente(new int[]{6, 3});
				
			
			
			
			
	
			
			
			
			
		case 3: //escenario 3
			
			
			
			//ARBOLES
	        mapa[0][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][6] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][8] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[0][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[1][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][8] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[1][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        
	        mapa[2][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][6] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][8] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[2][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[3][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[3][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        
	        mapa[4][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[4][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[5][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[5][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[6][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[6][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	      
	        
	        mapa[7][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[7][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        mapa[8][0] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][1] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][2] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][3] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][4] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][5] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][6] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][7] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][8] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][9] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][10] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][11] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][12] = CaperucitaPerception.ARBOL_PERCEPTION;
	        mapa[8][13] = CaperucitaPerception.ARBOL_PERCEPTION;
	        
	        //DULCES 
	        mapa[2][7] = CaperucitaPerception.DULCE_PERCEPTION;
	        mapa[6][4] = CaperucitaPerception.DULCE_PERCEPTION;
	        mapa[6][8] = CaperucitaPerception.DULCE_PERCEPTION;

	        //CAMPO DE FLORES
	        mapa[0][3] = CaperucitaPerception.FLORES_PERCEPTION;
	        mapa[1][3] = CaperucitaPerception.FLORES_PERCEPTION;
	     

	        //LOBO
	        mapa[7][6] = CaperucitaPerception.LOBO_PERCEPTION; //Posicion inicial del lobo la seteamos? luego random
	        
	        //CAPERUCITA
	        this.setPosicionAgente(new int[] {5,11 });//cambiar desp
				
			
					
			
		
		}
		
	}
	

	@Override
	public String toString() {
		String str = "";

        str = str + "[ \n";
        for (int row = 0; row < mapa.length; row++) {
            str = str + "[ ";
            for (int col = 0; col < mapa[0].length; col++) {
                str = str + mapa[row][col] + " ";
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        //MANDO la matriz a la interfaz gráfica.
        Mapa.dibujarMapa(mapa, posicionCaperucita);
        
        return str;
        
        
        
        
        
	}
	
	public int[] getPosicionCaperucita() {
        return posicionCaperucita;
    }
	
	 public int getPosicionMapaCaperucita(int row, int col) {
	        return mapa[row][col];
	    }
	    
	public void setPosicionFilaCaperucita(int value) {
	    	this.posicionCaperucita[0] = value;
	    }
	    
	public void setPosicionColumnaCaperucita(int value) {
	    	this.posicionCaperucita[1] = value;
	    }
	
	
	public void setPosicionMapa(int fil, int col, int value) {
        this.mapa[fil][col] = value;
    }
	
	public int[][] getMapa() {
        return mapa;
    }
	
	public void setPosicionAgente(int[] posicionAgente) {
        this.posicionCaperucita = posicionAgente;
	}
	
	public int getVidasAgente() {
		return vidasAgente;
	}


	public void setVidasAgente(int vidasAgente) {
		this.vidasAgente = vidasAgente;
	}
	
	
	public static ArrayList<Integer> getRandomItem(ArrayList<ArrayList<Integer>> lista) {
	    Random rand = new Random(); 
	    ArrayList<Integer> posicionRandom = lista.get(rand.nextInt(lista.size()));
	    return posicionRandom;
	}
	
	
	
	
	public void moverLobo() {
		/*ArrayList <Integer> aux = new ArrayList <Integer>();
		ArrayList<ArrayList<Integer>> posiblesLugaresAMoverse = new ArrayList<ArrayList<Integer>>();
		ArrayList <Integer> nuevaPosicion = new ArrayList <Integer>();
		
		for (int i=0; i<9;i++) {
			for (int j=0; j<14; j++) {
				if(mapa[i][j]==CaperucitaPerception.VACIO_PERCEPTION) {
					aux.add(i);
					aux.add(j);
					posiblesLugaresAMoverse.add(aux);
				}
					
			}
			
		}
		
		nuevaPosicion = this.getRandomItem(posiblesLugaresAMoverse);
		int fil = nuevaPosicion.get(0);
		int col = nuevaPosicion.get(1);

		mapa[posicionLobo[0]][posicionLobo[1]]=CaperucitaPerception.VACIO_PERCEPTION; //Se actualiza valor anterior del lobo
	
		mapa[fil][col] = CaperucitaPerception.LOBO_PERCEPTION;  // se setea posicion nueva*/
		
		mapa[6][4] = CaperucitaPerception.LOBO_PERCEPTION;
		
	}


	public int[] getCeldasAbajo(int fil, int col) {
		
		int arrayValoresAbajo[];
		arrayValoresAbajo = new int[8-fil];  //El numero de valores que tendrá el arreglo será igual a (8 - n° de fil)
		int pos=0;
		
		for (int i=fil+1;i<=8;i++) {
			arrayValoresAbajo[pos] = mapa[i][col];
			pos++;
		}
		
		////Retorna los valores de las celdas de la abajo de la posicion pasada como parametro. 
		//La posicion 0 del arrayValoresAbajo representa el valor de la posicion mas cernana hacia abajo
		
		return arrayValoresAbajo;
		
	}


	public int[] getCeldasDerecha(int fil, int col) {

		int arrayValoresDerecha[];
		arrayValoresDerecha = new int[13-col];  //El numero de valores que tendrá el arreglo será igual a 13 - n° de col donde está.
		int pos=0;
		
		for (int j=col+1;j<=13;j++) {
			arrayValoresDerecha[pos] = mapa[fil][j];
			pos++;
		}
		
		//
		
		return arrayValoresDerecha;
		
		//Retorna los valores de las celdas de la derecha de la posicion pasada como parametro. 
		//La posicion 0 del arrayValoresDer representa el valor de la posicion mas cernana hacia der
		
	}


	public int[] getCeldasIzquierda(int fil, int col) {
		int arrayValoresIzquierda[];
		arrayValoresIzquierda = new int[col];  //El numero de valores que tendrá el arreglo será igual al n° de col donde está.
		int pos=0;
		
		for (int j=col-1;j>=0;j--) {
			arrayValoresIzquierda[pos] = mapa[fil][j];
			pos++;
		}
		
		//
		
		return arrayValoresIzquierda;
		
		//Retorna los valores de las celdas de la izquierda de la posicion pasada como parametro. 
		//La posicion 0 del arrayValoresIzquierda representa el valor de la posicion mas cernana hacia izq
	}


	public int[] getCeldasArriba(int fil, int col) {
		int arrayValoresArriba[];
		arrayValoresArriba = new int[fil];  //El numero de valores que tendrá el arreglo será igual al n° de fila donde está.
		int pos=0;
		
		for (int i=fil-1;i>=0;i--) {
			arrayValoresArriba[pos] = mapa[i][col];
			pos++;
		}
		
		//
		
		return arrayValoresArriba;
		
		//Retorna los valores de las celdas de arriba de la posicion pasada como parametro. 
		//La posicion 0 del arrayValoresArriba representa el valor de la posicion mas cernana hacia arriba
	}
	
}
