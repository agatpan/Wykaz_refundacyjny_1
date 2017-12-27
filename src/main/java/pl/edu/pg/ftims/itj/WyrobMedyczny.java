package pl.edu.pg.ftims.itj;

public class WyrobMedyczny extends AbstractLek {
	
	
	public String rodzajWyrobu;
	
	public WyrobMedyczny(String nazwaHandlowa, String symbolLeku, String rodzajWyrobu,
			 String zawartoscOpakowania, String kodEan, String odplatnosc, String wskazanieRefund,
			 char seniorBezpl, double doplataPacjenta, double cenaUrzedowa) {
		super (nazwaHandlowa, symbolLeku, zawartoscOpakowania, kodEan, odplatnosc, wskazanieRefund,seniorBezpl, doplataPacjenta, 
				cenaUrzedowa);
				this.rodzajWyrobu = rodzajWyrobu;
				
				
			}
				
		
	public String getNazwaHandlowa() {
		return nazwaHandlowa;
	}
	
	public String getPierwsze4LiteryNazwyHandlowej() {
		return symbolLeku;
	}
	
	public String getRodzajWyrobu() {
		return rodzajWyrobu;
	}

	public String getZawartoscOpakowania() {
		return zawartoscOpakowania;
	}
		
	public String getKodEan() {
		return kodEan;
	}
		
	@Override
	public String getOdplatnosc() {
		return odplatnosc;
	}

	@Override
	public String getWskazanieRefund() {
		return wskazanieRefund;
	}

	@Override
	public char getSeniorBezpl() {
		return seniorBezpl;
	}
	
	@Override
	public double getDoplataPacjenta() {
		return doplataPacjenta;
	}

	@Override
	public double getCenaUrzedowa() {
		return cenaUrzedowa;
	}
	public String toString() {
		return "Nazwa handlowa : " + nazwaHandlowa + ", Rodzaj wyrobu : " + rodzajWyrobu
				+ ", Zawartosc opakowania : " + zawartoscOpakowania + ", Kod EAN : " + kodEan + ", odplatnosc : "
				+ odplatnosc + ", Wskazania refundacyjne : " + wskazanieRefund + ", Senior bezplatnie : "
				+ seniorBezpl + ", Doplata pacjenta : " + doplataPacjenta + ", Cena urzedowa : " + cenaUrzedowa;
	}
}
	




