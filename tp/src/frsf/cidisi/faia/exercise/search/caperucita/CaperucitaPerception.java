package frsf.cidisi.faia.exercise.search.caperucita;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.exercise.search.caperucita.CaperucitaAgent;
import frsf.cidisi.faia.state.EnvironmentState;


public class CaperucitaPerception extends Perception {
	
	//valores de las percepciones
	public static int DESCONOCIDO_PERCEPTION = -1; //AGREGADO
    public static int VACIO_PERCEPTION=  0;
    public static int DULCE_PERCEPTION = 1;
    public static int FLORES_PERCEPTION = 2;
    public static int ARBOL_PERCEPTION = 3; //AGREGADO
	public static int LOBO_PERCEPTION = 4;
    

    //percepciones. Arreglos de enteros que contienen los valores de cada celda del mapa según percibe el agente.
    private int detectarArriba[];
    private int detectarAbajo[];
    private int detectarDerecha[];
    private int detectarIzquierda[];
    
    public CaperucitaPerception() {
    	
    	//inicializamos las percepciones
    	/*for (int i = 0; i < detectarArriba.length; i++) {
    		detectarArriba[i] = DESCONOCIDO_PERCEPTION;
    	}
    	
    	for (int i = 0; i < detectarAbajo.length; i++) {
    		detectarAbajo[i] = DESCONOCIDO_PERCEPTION;
    	}
    	
    	for (int i = 0; i < detectarDerecha.length; i++) {
    		detectarDerecha[i] = DESCONOCIDO_PERCEPTION;
    	}
    	
    	for (int i = 0; i < detectarIzquierda.length; i++) {
    		detectarIzquierda[i] = DESCONOCIDO_PERCEPTION;
    	}
    	*/
    }
    
	@Override
	public void initPerception(Agent agent, Environment environment) {
		
		//percepción inicial. Luego usa getPercept del ambiente para las demas percepciones?
		
		
		CaperucitaAgent caperucitaAgent = (CaperucitaAgent) agent;
		CaperucitaEnvironment caperucitaEnvironment = (CaperucitaEnvironment) environment;
        CaperucitaEnvironmentState environmentState = caperucitaEnvironment.getEnvironmentState();

        int fil = environmentState.getPosicionCaperucita()[0];
        int col = environmentState.getPosicionCaperucita()[1];

        
      // ---- MOVIMIENTO DEL LOBO 
      		int i=1;
      		boolean flag = false;
      		
      		while (environmentState.getPosicionMapaCaperucita(fil-i,col)!=CaperucitaPerception.ARBOL_PERCEPTION) {
              	//mientras la celda de arriba no sea arbol
      			environmentState.setPosicionFilaCaperucita(fil-i);
              	//caperucitaAgentState.setPosicionFila(fil-i); //esto No sabemos si va, porque ya está en el otro execute.

              	i++;
              	flag=true;
              }

              if (flag=true) {
              	environmentState.moverLobo();
              }
        // -- TERMINA MOVIMIENTO DEL LOBO
        
        //EL AGENTE PERCIBE::
        this.setSensorArriba(caperucitaEnvironment.getCeldasArriba(fil, col));
        this.setSensorIzquierda(caperucitaEnvironment.getCeldasIzquierda(fil, col));
        this.setSensorDerecha(caperucitaEnvironment.getCeldasDerecha(fil, col));
        this.setSensorAbajo(caperucitaEnvironment.getCeldasAbajo(fil, col));
                
    }
	
	
	
	public void setSensorArriba(int[] upSensor) {
        this.detectarArriba = upSensor;       
    }
	
	public void setSensorIzquierda(int[] leftSensor) {
        this.detectarIzquierda = leftSensor;
    }
	
	public void setSensorAbajo(int[] downSensor) {
        this.detectarAbajo = downSensor;
    }
	
	public void setSensorDerecha(int[] rightSensor) {
        this.detectarDerecha = rightSensor;
    }
	
	public int[] getSensorArriba() {
        return this.detectarArriba;     
    }
	
	public int[] getSensorIzquierda() {
        return this.detectarIzquierda;     
    }
	
	public int[] getSensorAbajo() {
        return this.detectarAbajo;     
    }
	
	public int[] getSensorDerecha() {
        return this.detectarDerecha;     
    }
	
	@Override
    public String toString() {
        StringBuffer str = new StringBuffer();
       
        //arriba
        str.append("Arriba: [ ");
        for (int pos = 0; pos < detectarArriba.length; pos++) {
        	
            str.append(this.detectarArriba[pos]);
            str.append(" ");
        }
        str.append("] -- ");
        

      //abajo
        str.append("Abajo: [ ");
        for (int pos = 0; pos < detectarAbajo.length; pos++) {
        	
            str.append(this.detectarAbajo[pos]);
            str.append(" ");
        }
        str.append("] -- ");
        
      //Der
        str.append("Derecha: [ ");
        for (int pos = 0; pos < detectarDerecha.length; pos++) {
        	
            str.append(this.detectarDerecha[pos]);
            str.append(" ");
        }
        str.append("] -- ");
        
      //izq
        str.append("Izquierda: [ ");
        for (int pos = 0; pos < detectarIzquierda.length; pos++) {
        	
            str.append(this.detectarIzquierda[pos]);
            str.append(" ");
        }
        str.append("] ");

        return str.toString();
    }
	
	}


