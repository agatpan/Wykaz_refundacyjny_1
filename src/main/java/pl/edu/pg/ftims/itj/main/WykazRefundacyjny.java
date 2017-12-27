package pl.edu.pg.ftims.itj.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.edu.pg.ftims.itj.LekRefundowany;
import pl.edu.pg.ftims.itj.NieZnalezionoLekuExeption;
import pl.edu.pg.ftims.itj.ProduktLeczniczy;
import pl.edu.pg.ftims.itj.SrodekSpozywczy;
import pl.edu.pg.ftims.itj.WyrobMedyczny;

public class WykazRefundacyjny {

public static void main(String[] args) throws NumberFormatException, IOException {
		
		List<ProduktLeczniczy> wszystkieLekiRefund = stworzWszystkieProd();
		
		Map<String, ProduktLeczniczy> nazwaProdukt = stworzNazwaProdukt(wszystkieLekiRefund);
		
		String nazwaPodana;
		String symbolPodany;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj nazwę leku: ");
        nazwaPodana = br.readLine() ;
        
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj symbol leku (4 pierwsze litery nazwy leku) : ");
        symbolPodany = br1.readLine() ;
        
        try {
			List<ProduktLeczniczy> znalezione = znajdzProduktyLecznicze(nazwaPodana, wszystkieLekiRefund);
			for (ProduktLeczniczy p : znalezione) {
				System.out.println("Znaleziono po nazwie leku : " + p);
			}
			
		} catch (NieZnalezionoLekuExeption e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		ProduktLeczniczy znalezionyProdukt = nazwaProdukt.get(symbolPodany);
		System.out.println("Znaleziony po symbolu (4 pierwszych literach nazwy leku) : " + znalezionyProdukt);

	}

	public static List<ProduktLeczniczy> stworzWszystkieProd() {
		List<ProduktLeczniczy> wszystkieLekiRefund = new ArrayList<ProduktLeczniczy>();
		wszystkieLekiRefund.add(new LekRefundowany("Agen 10, tabl. 10 mg", "Agen", "Amlodipinum", "30 szt.", "5909991226909",
				"30%", "We wszystkich zarejestrowanych wskazaniach na dzień wydania decyzji", 'T', 4.74, 13.74));

		wszystkieLekiRefund.add(new LekRefundowany("Abilify, tabl., 15 mg","Abil", "Aripiprazolum", "28 szt.", "5909990002306",
				"ryczałt", "Schizofrenia; Choroba afektywna dwubiegunowa", 'N', 3.20, 137.09));

		wszystkieLekiRefund.add(new LekRefundowany("Augmentin, tabl. powl., 875+125 mg", "Augm",
				"Amoxicillinum + Acidum clavulanicum", "14 szt.", "5909990717521", "50%",
				"We wszystkich zarejestrowanych wskazaniach na dzień wydania decyzji, zakażenia u pacjentów z niedoborami odporności - profilaktyka",
				'N', 16.49, 31.57));
		wszystkieLekiRefund.add(new LekRefundowany("Alendrogen, tabl., 70 mg", "Alen", "Acidum alendronicum", "4 szt.",
				"5909990623112", "30%", "Osteoporoza", 'T', 2.87, 9.55));
		wszystkieLekiRefund.add(
				new LekRefundowany("Heviran, tabl. powl., 400 mg", "Hevi", "Aciclovirum", "30 szt.", "5909990840113", "50%",
						"We wszystkich zarejestrowanych wskazaniach na dzień wydania decyzji", 'N', 15.30, 27.65));
		wszystkieLekiRefund.add(
				new LekRefundowany("Xarelto, tabl. powl., 15 mg", "Xare", "Rivaroxabanum", "14 szt.", "5909990910601", "30%",
						"Leczenie zakrzepicy żył głębokich oraz profilaktyka nawrotowej zakrzepicy żył głębokich i zatorowości płucnej po ostrej zakrzepicy żył głębokich u osób powyżej 18 roku życia",
						'T', 87.96, 147.00));
		wszystkieLekiRefund.add(
				new LekRefundowany("Lithium Carbonicum GSK, tabl., 250 mg", "Lith", "Lithium", "60 szt. (1 poj.po 60 szt.)",
						"5909990148714", "bezpłatny", "Choroby psychiczne lub upośledzenia umysłowe", 'N', 0, 15.11));
		wszystkieLekiRefund.add(new LekRefundowany("Lantus, roztwór do wstrzykiwań, 100 j/ml", "Insulinum glargine", "Lant",
				"5 wstrzykiwaczy SoloStar po 3 ml", "5909990617555", "30%",
				"Cukrzyca typu I u dorosłych, młodzieży i dzieci od 6 roku życia; Cukrzyca typu 2 u pacjentów leczonych insuliną NPH od co najmniej 6 miesięcy i z HbA1c ≥8% oraz "
						+ "cukrzyca typu 2 u pacjentów leczonych insuliną NPH od co najmniej 6 miesięcy i z udokumentowanymi nawracającymi epizodami ciężkiej lub nocnej hipoglikemii oraz cukrzyca typu 1 u dzieci w wieku od 2 do 6 lat oraz cukrzyca o znanej przyczynie (zgodnie z definicją wg WHO)",
				'T', 72.95, 198.15));
		wszystkieLekiRefund.add(new LekRefundowany("Valcyte, tabl. powl., 450 mg", "Valganciclovirum", "60 szt.", "Valc",
				"5909990727407", "ryczałt",
				"Zakażenie wirusem cytomegalii u pacjentów poddawanych przeszczepom narządów miąższowych - profilaktyka po zakończeniu hospitalizacji związanej z transplantacją do 110 dni po przeszczepie",
				'N', 3.20, 4204.99));
		wszystkieLekiRefund.add(
				new LekRefundowany("Duomox, tabl., 1000 mg", "Duom", "Amoxicillinum", "20 szt.", "5909990063413", "ryczałt",
						"We wszystkich zarejestrowanych wskazaniach na dzień wydania decyzji", 'N', 3.20, 17.76));

		wszystkieLekiRefund.add(new SrodekSpozywczy("Neocate LCP, proszek", "Neoc", "400 g", "5016533646740", "ryczałt",
				"Postępowanie dietetyczne u niemowląt w ciężkiej alergii na białka mleka krowiego oraz złożonej nietolerancji białek pokarmowych",
				'N', 3.20, 155.52));
		wszystkieLekiRefund.add(new SrodekSpozywczy("Bebilon pepti 2 DHA, proszek", "Bebi", "450 g", "8718117603275", "30%",
				"Zespoły wrodzonych defektów metabolicznych, alergie pokarmowe i biegunki przewlekłe", 'N', 10.39,
				34.62));
		wszystkieLekiRefund.add(new SrodekSpozywczy("Phenyl-Free 2, proszek do sporządzania roztworu", "Phen", "454 g",
				"0300875100066", "ryczałt", "Fenyloketonuria", 'N', 3.20, 148.5));
		wszystkieLekiRefund.add(new SrodekSpozywczy("Nutramigen 2 LGG, proszek do sporządzania roztworu", "Nutr", "400 g",
				"8712045027547", "30%",
				"Alergia na białko mleka krowiego, objawy związane z alergią pokarmową związane z nadwrażliwością na białka mleka krowiego, nietolerancja laktozy związana z nadwrażliwością na białka mleka krowiego,"
						+ " wtórna nietolerancja sacharozy związana z nadwrażliwością na białka mleka krowiego, inne alergie związane z nadwrażliwością na białka mleka krowiego, alergia na białko sojowe z nadwrażliwością na białka mleka krowiego",
				'N', 17.13, 48.80));
		wszystkieLekiRefund.add(new SrodekSpozywczy("Milupa PKU 2 mix, proszek", "Milu", "400 g", "4008976340287", "ryczałt",
				"Fenyloketonuria", 'N', 3.20, 399.91));

		wszystkieLekiRefund
				.add(new WyrobMedyczny("Accu-Chek Active, test paskowy", "Accu", "Paski do oznaczania glukozy we krwi",
						"50 pasków", "4015630056316", "30%", "Cukrzyca", 'N', 11.89, 38.97));
		wszystkieLekiRefund.add(new WyrobMedyczny("Accu-Chek Active, test paskowy", "Accu",
				"Paski do  glukozy we krwi", "50 pasków", "4015630056316", "ryczałt",
				"Cukrzyca typu I; Pozostałe typy cukrzycy wymagające co najmniej 3 wstrzyknięć insuliny na dobę oraz terapia cukrzycy za pomocą pompy insulinowej",
				'N', 3.48, 38.97));
		wszystkieLekiRefund.add(new WyrobMedyczny("Suprasorb A, opatrunek z alginianu wapnia, sterylny, 10x10 cm", "Supr",
				"Emplastri alginatosa et hydrofibrica", "1 szt.", "4021447013466", "30%", "Przewlekłe owrzodzenia", 'N',
				2.89, 9.63));
		wszystkieLekiRefund.add(new WyrobMedyczny("Sorbact gel, opatrunek żelowy adsorbujący bakterie, 7,5x15 cm2", "Sorb",
				"Emplastri  cellulosae", "1 szt.", "7392130181371", "bezpłatny", "Epidermolysis bullosa",
				'N', 3.20, 17.57));
		wszystkieLekiRefund.add(new WyrobMedyczny("Optium Xido, test paskowy", "Opti", "Paski do oznaczania glukozy we krwi",
				"50 szt.", "5021791707249", "30%", "Cukrzyca", 'N', 11.61, 38.69));

		return wszystkieLekiRefund;
	}

	

	 public static Map<String, ProduktLeczniczy> stworzNazwaProdukt(List<ProduktLeczniczy> wszystkieLekiRefund) {
			Map<String, ProduktLeczniczy> nazwaProdukt = new HashMap<String, ProduktLeczniczy>();
			
			for (ProduktLeczniczy p : wszystkieLekiRefund) {
				nazwaProdukt.put(p.getPierwsze4LiteryNazwyHandlowej().toLowerCase(), p);
			}
			
			return nazwaProdukt;
	
	}
	 
	 
	 
	public static List<ProduktLeczniczy> znajdzProduktyLecznicze(String nazwaPodana, List<ProduktLeczniczy> wszystkieLeki)
			throws NieZnalezionoLekuExeption {
		List<ProduktLeczniczy> znalezione = new ArrayList<ProduktLeczniczy>();
		boolean znalezionoProduktLeczniczy = false;

		for (ProduktLeczniczy p : wszystkieLeki) {
			if (p.getNazwaHandlowa().toLowerCase().startsWith(nazwaPodana.toLowerCase())) {
				znalezionoProduktLeczniczy = true;
				znalezione.add(p);
			}
		}

		if (!znalezionoProduktLeczniczy) {
			throw new NieZnalezionoLekuExeption("Nie znaleziono produktow leczniczych zaczynających sie od nazwy : " + nazwaPodana 
					+ "Podany produkt leczniczy jest pelnoplatny");
		}

		return znalezione;

	}


}
