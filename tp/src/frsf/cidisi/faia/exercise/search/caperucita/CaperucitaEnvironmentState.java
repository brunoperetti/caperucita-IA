package frsf.cidisi.faia.exercise.search.caperucita;

import java.util.ArrayList;
import java.util.Random;

import frsf.cidisi.faia.state.EnvironmentState;

public class CaperucitaEnvironmentState extends EnvironmentState {

	private int[][] mapa;
    private int[] posicionCaperucita;
    private int[] posicionDulces;
    private int[] posicionLobo;
    private int[] posicionFlores;
    private int[] posicionArboles;
	
    public CaperucitaEnvironmentState() {
    	mapa = new int[8][13];
        this.initState();
    }
    
    
	@Override
	public void initState() {
		
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
        this.setPosicionAgente(new int[]{5, 11});
		
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
			
			
			
		case 2: //escenario 2
			
			
		case 3: //escenario 3
			
		
		}
		
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
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
	
	
	public static ArrayList<Integer> getRandomItem(ArrayList<ArrayList<Integer>> lista) {
	    Random rand = new Random(); 
	    ArrayList<Integer> posicionRandom = lista.get(rand.nextInt(lista.size()));
	    return posicionRandom;
	}
	
	
	
	
	public void moverLobo() {
		ArrayList <Integer> aux = new ArrayList <Integer>();
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
	
		mapa[fil][col] = CaperucitaPerception.LOBO_PERCEPTION;  // se setea posicion nueva
		
		
	}
	
}
