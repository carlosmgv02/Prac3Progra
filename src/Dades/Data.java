package Dades;
public class Data {
	private int dia;
	private int mes;
	private int any;

	/**
	 * Constructor per defecte, sense parÃ metres inicialitza a una data de
	 * referÃ¨ncia
	 */
	public Data() {
		this.dia = 1;
		this.mes = 1;
		this.any = 2000;
	}

	/**
	 * Constructor que rep la data per parÃ metre
	 * Ha de validar que la data Ã©s correcta. Si rep una data incorrecta inicialitza la instÃ ncia
	 * amb la data de referÃ¨ncia.
	 * @param dia
	 * @param mes
	 * @param any
	 */
	public Data(int dia, int mes, int any) {
		if (esDataCorrecta(dia, mes, any)) { // ens asegurem que hi ha una data valida
			this.dia = dia;
			this.mes = mes;
			this.any = any;
		} else { // posem la data de referÃ¨ncia com a senyal d'error
			this.dia = 1;
			this.mes = 1;
			this.any = 2000;
		}
	}

	/**
	 * Getter
	 * @return dia de la data
	 */
	public int getDia() {
		return dia;
	}
	
	/**
	 * Getter
	 * @return mes de la data
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * Getter
	 * @return any de la data
	 */
	public int getAny() {
		return any;
	}

	/**
	 * Setter conjunt per a poder validar la correctesa de la data rebuda.
	 * NomÃ©s es fa la modificaciÃ³ de la data si que es rep per parÃ metre Ã©s correcte.
	 * @param dia
	 * @param mes
	 * @param any
	 */
	public void setData(int dia, int mes, int any) {
		if (esDataCorrecta(dia, mes, any)) { // ens asegurem que hi ha una data vÃ lida
			this.dia = dia;
			this.mes = mes;
			this.any = any;
		}
	}

	
	/**
	 * MÃ¨tode que calcula sobre la instÃ ncia actual el valor del dia segÃ¼ent
	 */
	public void diaSeguent() {
		this.dia++;
		if (this.dia > diesMes(this.mes, this.any)) {
			this.dia = 1;
			this.mes++;
			if (this.mes > 12) {
				this.mes = 1;
				this.any++;
			}
		}
	}

	/**
	 * MÃ¨tode que calcula sobre la instÃ ncia actual el valor del dia anterior
	 */
	public void diaAnterior() {
		this.dia--;
		if (this.dia < 1) {
			this.mes--;
			if (this.mes < 1) {
				this.mes = 12;
				this.any--;
			}
			this.dia = diesMes(this.mes, this.any);
		}
	}

	/**
	 * MÃ¨tode que comprova si la data actual Ã©s la mateixa a la que es rep per parÃ metre
	 * @param data - valor de data a comparar amb l'actual
	 * @return si sÃ³n iguals
	 */
	public boolean esIgual(Data data) {
		if (this.dia == data.getDia() && this.mes == data.getMes() && this.any == data.getAny()) {
			return true;
		}
		return false;
	}

	/**
	 * MÃ¨tode que calcula quants dies falten per arribar des de la data actual a la
	 * que rebem per parÃ metre
	 * 
	 * @param data - valor de data a la que calcular el nÃºmero de dies que falten
	 * @return si la data que es rep per parÃ metre Ã©s superior o igual a la data de
	 *         la instÃ ncia sobre la que es crida el mÃ¨tode es retorna el nÃºmero de
	 *         dies. Si la data que es rep per parÃ metre Ã©s inferior es retorna -1.
	 */
	public int numDiesAData(Data data) { // compta el nombre de dies entre dos dates
		Data dataTemp;
		int contador;
		// Ã©s necessari una nova instancia per no modificar la data actual
		dataTemp = new Data(dia, mes, any);
		if (dataTemp.esDataInferiorOigual(data)) {
			contador = 0;
			// la data rebuda Ã©s major que l'actual
			while (!dataTemp.esIgual(data)) {
				dataTemp.diaSeguent(); // augmenta la data actual fins coincidir amb la rebuda per parÃ metre
				contador++;
			}
		} else
			contador = -1;
		return contador;
	}

	/**
	 * MÃ¨tode per comprova si la data actual Ã©s inferior a la passada per parÃ metre
	 * 
	 * @param nova
	 * @return
	 */
	public boolean esDataInferiorOigual(Data nova) {
	      boolean esInferior; 
	      if (any<nova.any) esInferior=true;
	      else if (any>nova.any) esInferior=false;
	      else {
	    	  // cas anys iguals
	    	 if (mes<nova.mes) esInferior=true;
	    	 else if (mes>nova.mes) esInferior=false;
	    	 else {
	    		 // anys i mes iguals
	    		 if (dia<=nova.dia) esInferior=true;
	    		 else esInferior=false;
	    	 }		
	      }
		  return esInferior; 

	  }
	
	/**
	 * MÃ¨tode que comprova si la data actual correspon a un any de traspas
	 * @return si Ã©s any de traspas
	 */
	public boolean esDataAnyTraspas() {
		if (esAnyTraspas(this.any)) { // nomÃ©s amb l'any hi ha prou
			return true;
		} else {
			return false;
		}
	}

	// MÃ¨todes de classe (STATIC).
	// no s'apliquen sobre el contingut d'una instÃ ncia de data sinÃ³ sobre valors
	// que es reben per parÃ metre.
	// sÃ³n mÃ¨todes auxiliars

	private static boolean esDataCorrecta(int dia, int mes, int any) {
		boolean hoEs=true;
		if (dia < 1 || dia > 31) { // dia incorrecte
			hoEs= false;
		}
		if (mes < 1 || mes > 12) { // mes incorrecte
			hoEs= false;
		}
		if (dia > diesMes(mes, any)) { // dia del mes incorrecte
			hoEs= false;
		}
		return hoEs;
	}

	private static boolean esAnyTraspas(int any) { // ens estalviem crear una instancia de data
		if ((any % 4 == 0) && ((any % 100 != 0) || (any % 400 == 0))) {
			return true;
		} else {
			return false;
		}
	}

	private static int diesMes(int mes, int any) { // per saber quants dies te un mes d'un any
		int diesMes;
		if (mes == 2) {
			if (esAnyTraspas(any)) {
				diesMes = 29;
			} else {
				diesMes = 28;
			}
		} else {
			if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				diesMes = 30;
			} else {
				diesMes = 31;
			}
		}
		return diesMes;
	}
	
	public String toString() {
		return("FECHA => dia "+dia+" mes "+mes+" any "+any);
	}

	public Data copia() {
		return new Data(dia, mes, any);
	}
}