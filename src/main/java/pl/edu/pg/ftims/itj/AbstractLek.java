package pl.edu.pg.ftims.itj;

public abstract class AbstractLek implements ProduktLeczniczy {

	public String nazwaHandlowa;
	public String symbolLeku;
	public String zawartoscOpakowania;
	public String kodEan;
	public String odplatnosc;
	public String wskazanieRefund;
	public char seniorBezpl;
	public double doplataPacjenta;
	public double cenaUrzedowa;
	
	public AbstractLek (String nazwaHandlowa, String symbolLeku, String zawartoscOpakowania, 
			String kodEan, String odplatnosc, String wskazanieRefund,
			 char seniorBezpl, double doplataPacjenta, double cenaUrzedowa) {
				this.nazwaHandlowa = nazwaHandlowa;
				this.symbolLeku = symbolLeku;
				this.zawartoscOpakowania =  zawartoscOpakowania;
				this.kodEan = kodEan;
				this.odplatnosc = odplatnosc;
				this.wskazanieRefund = wskazanieRefund;
				this.seniorBezpl = seniorBezpl;
				this.doplataPacjenta = doplataPacjenta;
				this.cenaUrzedowa = cenaUrzedowa;
				
			}
	
		
	public abstract String getOdplatnosc();

	public abstract String getWskazanieRefund();

	public abstract char getSeniorBezpl();

	public abstract double getDoplataPacjenta();

	public abstract double getCenaUrzedowa();

	
}
