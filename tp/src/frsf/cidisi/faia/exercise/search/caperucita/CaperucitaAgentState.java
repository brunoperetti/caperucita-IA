package frsf.cidisi.faia.exercise.search.caperucita;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;



public class CaperucitaAgentState extends SearchBasedAgentState {

	// :::: VARIABLES DE INIT STATE DEL AGENTE
	public static final int POS_INI_FILA=6;
	public static final int POS_INI_COL=3;
		
	
	private int[] posicionActual;
	private int[] posicionInicial;
    private int cantDulcesRecolectados;
   	private int vidasRestantes;
	private int[][] mapa;
	private int celdasVisitadas;

	
	
	public CaperucitaAgentState(int[][] m, int filAct, int colAct, int filIni, int colIni, int dulces, int vidas, int celdas) {
        mapa = m;
        posicionActual = new int[2];
        posicionActual[0] = filAct;
        posicionActual[1] = colAct;
        posicionInicial = new int[2];
        posicionInicial[0] = filIni;
        posicionInicial[1] = colIni;
        cantDulcesRecolectados = dulces;
        vidasRestantes = vidas;
        celdasVisitadas =0;
    }
	
	public CaperucitaAgentState() { //constructor
		posicionActual = new int[2];
		posicionInicial = new int[2];
        cantDulcesRecolectados = 0;
        vidasRestantes = 3;
        mapa = new int[9][14];
        this.initState();
    }
	
	@Override
	public boolean equals(Object obj) { //ojo, está hecho analogamente como el del pacman

		if (!(obj instanceof CaperucitaAgentState))
            return false;

        //int[][] mapaObj = ((CaperucitaAgentState) obj).getMapa();
        int[] positionObj = ((CaperucitaAgentState) obj).getPosicionActual();
        int[] positionIniObj = ((CaperucitaAgentState) obj).getPosicionInicial();
        //int dulcesObj =  ((CaperucitaAgentState) obj).getCantDulcesRecolectados();
        int vidasObj = ((CaperucitaAgentState) obj).getVidasRestantes();
        int celdasObj =  ((CaperucitaAgentState) obj).getCeldasVisitadas();

       /*for (int row = 0; row < mapa.length; row++) {
            for (int col = 0; col < mapa[0].length; col++) {
                if (mapa[row][col] != mapaObj[row][col]) {
                    return false;
                }
            }
        }*/

        if (this.getPosicionActual()[0] != positionObj[0] || this.getPosicionActual()[1] != positionObj[1]) {
            return false;
        }
        
       /* if (posicionInicial[0] != positionIniObj[0] || posicionInicial[1] != positionIniObj[1]) {
            return false;
        }*/
        
       /* if (cantDulcesRecolectados != dulcesObj ) {
            return false;
        }*/
        
        if (this.getVidasRestantes() != vidasObj ) {
            return false;
        }
        
        if (this.getCeldasVisitadas() != celdasObj) {
        	return false;
        }
                
        return true;
		

	}

	@Override
	public SearchBasedAgentState clone() {
		int[][] nuevoMapa = new int[9][14];

        for (int row = 0; row < mapa.length; row++) {
            for (int col = 0; col < mapa[0].length; col++) {
            	nuevoMapa[row][col] = mapa[row][col];
            }
        }

        int[] nuevaPosicionActual = new int[2];
        nuevaPosicionActual[0] = posicionActual[0];
        nuevaPosicionActual[1] = posicionActual[1];
        
        int[] nuevaPosicionInicial = new int[2];
        nuevaPosicionInicial[0] = posicionInicial[0];
        nuevaPosicionInicial[1] = posicionInicial[1];

        CaperucitaAgentState nuevoEstado = new CaperucitaAgentState(nuevoMapa,
        		nuevaPosicionActual[0], nuevaPosicionActual[1], nuevaPosicionInicial[0], nuevaPosicionInicial[1],
        		this.cantDulcesRecolectados, this.vidasRestantes, this.celdasVisitadas);

        return nuevoEstado;
	}

	@Override
	public void updateState(Perception p) {
		
		//actualizar mapa del agente acá
	
		CaperucitaPerception caperucitaPerception = (CaperucitaPerception) p;		
		
		int fil = this.getPosicionFila();
	    int col = this.getPosicionColumna();
		
		/*mapa[fil][col] = caperucitaPerception.getSensorIzquierda();
		mapa[fil][col] = caperucitaPerception.getSensorDerecha();
		mapa[fil][col] = caperucitaPerception.getSensorAbajo();
		mapa[fil][col] = caperucitaPerception.getSensorArriba();*/
		
		//for para cada asignacion, ojo con la ubicacion de las celdas, segun mapa de bruno
		
	    
	 
	    
	    // ---- ACTUALIZAR MAPA DEL AGENTE ----
	    
	    //actualiza mapa segun percepción detectarArriba
		int posArr=0;
	    for (int i=fil-1;i>=0;i--) {
		mapa[i][col] = caperucitaPerception.getSensorArriba()[posArr];
		posArr++;
		}
		
		//actualiza mapa segun percepción detectarAbajo
		int posAba=0;
		for (int i=fil+1;i<=8;i++) {
			mapa[i][col] = caperucitaPerception.getSensorAbajo()[posAba];
			posAba++;
		}
		
		//actualiza mapa segun percepción detectarDerecha
		int posDer=0;
		for (int j=col+1;j<=13;j++) {
			mapa[fil][j] = caperucitaPerception.getSensorDerecha()[posDer];
			posDer++;
		}
		
		//actualiza mapa segun percepción detectarIzq
		int posIzq=0;
		for (int j=col-1;j>=0;j--) {
			mapa[fil][j] = caperucitaPerception.getSensorIzquierda()[posIzq];
			posIzq++;
		}
		
		
		
		
		
	}

	@Override
	public String toString() {
			
		String str = "";

        str = str + " Posicion=(" + getPosicionFila() + "," + "" + getPosicionColumna() + ")";
        str = str + " -- Dulces: " + cantDulcesRecolectados + "";
        str = str + " -- Vidas: " + vidasRestantes + "\n";

        str = str + "Mapa del agente=[ \n";
        for (int row = 0; row < mapa.length; row++) {
            str = str + "[ ";
            for (int col = 0; col < mapa[0].length; col++) {
                if (mapa[row][col] == -1) {
                    str = str + "* ";
                } else {
                    str = str + mapa[row][col] + " ";
                }
            }
            str = str + " ]\n";
        }
        str = str + " ]";

        return str;
		
	}

	@Override
	public void initState() {		
		//Situación inicial de caperucita
		
		CaperucitaEnvironmentState estadoAmbiente = new CaperucitaEnvironmentState();
		estadoAmbiente.initState();
		int mapaAmbiente[][];
		mapaAmbiente=estadoAmbiente.getMapa();
				
		// :::::::: EL AGENTE SOLO CONOCE LA UBICACION DE LOS ÁRBOLES Y LAS FLORES.
		
		//PRIMERO SETEAMOS TODAS LAS CELDAS EN DESCONOCIDO.
		for (int fil = 0; fil < mapa.length; fil++) {
            for (int col = 0; col < mapa[0].length; col++) {
                mapa[fil][col] = CaperucitaPerception.DESCONOCIDO_PERCEPTION;
            }
        }
		//SETEO DE LOS ÁRBOLES EN MAPA DEL AGENTE
		for (int fil = 0; fil < mapa.length; fil++) {
            for (int col = 0; col < mapa[0].length; col++) {
            	if (mapaAmbiente[fil][col]==CaperucitaPerception.ARBOL_PERCEPTION)
                mapa[fil][col] = CaperucitaPerception.ARBOL_PERCEPTION;
            }
        }

        //SETEO DE CAMPO DE FLORES EN MAPA DEL AGENTE
		for (int fil = 0; fil < mapa.length; fil++) {
            for (int col = 0; col < mapa[0].length; col++) {
            	if (mapaAmbiente[fil][col]==CaperucitaPerception.FLORES_PERCEPTION)
                mapa[fil][col] = CaperucitaPerception.FLORES_PERCEPTION;
            }
        }
   
		this.setCeldasVisitadas(0);
        this.setPosicionInicialFila(POS_INI_FILA);
        this.setPosicionInicialColumna(POS_INI_COL);
        this.setPosicionFila(POS_INI_FILA);
        this.setPosicionColumna(POS_INI_COL);

        this.setDulcesRecolectados(0);
        this.setVidasRestantes(3);
        
		
	}
	
	public int getPosicionFila() {
        return posicionActual[0];
    }

    public int getPosicionColumna() {
        return posicionActual[1];
    }
    
    public void setPosicionFila(int value) {
    	this.posicionActual[0] = value;
    }
    
    public void setPosicionColumna(int value) {
    	this.posicionActual[1] = value;
    }
    
    public void setPosicionInicialFila(int value) {
    	this.posicionInicial[0] = value;
    }
    
    public void setPosicionInicialColumna(int value) {
    	this.posicionInicial[1] = value;
    }
    
    
    public void setDulcesRecolectados (int value) {
    	this.cantDulcesRecolectados = value;
    }
    
    public void setVidasRestantes (int value) {
    	this.vidasRestantes = value;
    }
    
    public void restarVida () {
    	this.vidasRestantes = vidasRestantes -1 ;
    }
    
    public int getCantDulcesRecolectados() {
		return cantDulcesRecolectados;
	}

	public void setCantDulcesRecolectados(int cantDulcesRecolectados) {
		this.cantDulcesRecolectados = cantDulcesRecolectados;
	}

	public int getCeldasVisitadas() {
        return celdasVisitadas;
    }
	public int getVidasRestantes() {
		return vidasRestantes;
	}
	
	   public void setCeldasVisitadas (int value) {
	    	this.celdasVisitadas = value;
	    }
	
	public void sumarCeldaVisitada() {
		celdasVisitadas = celdasVisitadas+1;
	}
    
    
    public int[][] getMapa() {
        return mapa;
    }
    
    public void setMapa(int[][] w) {
    	this.mapa = w;
    }
    
    public int getPosicionMapa(int row, int col) {
        return mapa[row][col];
    }
    
    public int [] getPosicionActual () {
    	return posicionActual;
    }
    
    public int[] getPosicionInicial () {
    	return posicionInicial;
    }
    
    public void setPosicionMapa(int fil, int col, int value) {
        this.mapa[fil][col] = value;
    }
    
    
    public void sumarDulceRecolectado () {
    	this.cantDulcesRecolectados= this.cantDulcesRecolectados+1;
    }
    
    public boolean hayDulceEnPosicion (int fil, int col) {
		if (mapa[fil][col]==CaperucitaPerception.DULCE_PERCEPTION) {
			return true;
		}
		else return false;
    	
    }
       
    public boolean hayLoboEnPosicion (int fil, int col) {
		if (mapa[fil][col]==CaperucitaPerception.LOBO_PERCEPTION) {
			return true;
		}
		else return false;
    	
    }
    
    
    
    public boolean tieneVidas () {
		if (vidasRestantes > 0) {
			return true;
		}
    	
		else return false;
    }
    
    public void reiniciarPartida() {
		/*
		 * descontar vida caperucita
			reiniciar contador de dulces a cero
			volver caperucita a estado inicial 
			volver ambiente a estado inicial

		 */
    	
    	vidasRestantes= vidasRestantes-1;
    	cantDulcesRecolectados = 0;
    	posicionActual = posicionInicial;
    	
    }
    
    public boolean estaEnCampoDeFlores() {

    	int fil = getPosicionFila();
    	int col = getPosicionColumna();
    	
    	if (mapa [fil][col] == CaperucitaPerception.FLORES_PERCEPTION) {
    		return true;
    	}
    	return false;
    }

	public void restarCosto() {
		celdasVisitadas=celdasVisitadas-100;
		
	}

	public double getDistanciaACampo() {
		double resultado=0;
	    int filaFlores=0;
	    int colFlores=0;
	    
	    double resultadoX=0;
	    double resultadoY=0;
	    
	    for (int fila = 0; fila < mapa.length; fila++) {
	        for (int col = 0; col < mapa[0].length; col++) {
	        	
	        	// aca la duda q tengo es xq tenemos 2 celdas con flores
	            if (mapa[fila][col] == CaperucitaPerception.FLORES_PERCEPTION) {
	               filaFlores=fila;
	               colFlores=col;
	            }
	        }
	    }
	    
	    
	    // aca la posicion 0 es igual a las columnas ya q es lo q se mueve en el eje X o no??
	    resultadoX=Math.pow(2,filaFlores - posicionActual[0]);
	    resultadoY=Math.pow(2,colFlores - posicionActual[1]);
	    
	    resultado=Math.sqrt(resultadoX+resultadoY);
	  
	    
	    
	    return resultado;
	}
    
  

	
}
