import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Magazin {
	private double kasaNalichnost;
	private Map<Instruments, Integer> instrumenti;
	private double kasaNachalnaNalichnost;
	private DostavchikNaInstrumenti dostavchik;
	
	public double getKasaNalichnost() {
		return kasaNalichnost;
	}

	public Map<Instruments, Integer> getInstrumenti() {
		return instrumenti;
	}

	public Magazin(double kasaNalichnost) {
		this.kasaNalichnost = kasaNalichnost;
		this.instrumenti = new HashMap<Instruments, Integer>();
		this.kasaNachalnaNalichnost = this.kasaNalichnost;
	}

	public void addDostavchik(DostavchikNaInstrumenti dostavchik) {
		if (dostavchik != null)
			this.dostavchik = dostavchik;
		System.out.println(dostavchik.getName() + " Is the new dostavchik");
	}

	public void addInstrument(Instruments instrument) {
		if (instrument != null)
			this.instrumenti.put(instrument, instrument.getNalichniBroiki());
	}

	public void sellInstrument(Instruments instrument, int broi) {
		int nalichenBroi = instrument.getNalichniBroiki() + (broi - instrument.getNalichniBroiki());
		if (instrument.getNalichniBroiki() < broi) {
			napraviZaqvka(instrument, nalichenBroi-instrument.getNalichniBroiki());
			instrument.setNalichniBroiki(broi + nalichenBroi);
		}
		int obshtBroi = instrument.getNalichniBroiki();
		if (broi > 0 && broi <= instrument.getNalichniBroiki() && instrument != null) {
			if (this.instrumenti.containsKey(instrument) && instrument.getNalichniBroiki() > 0) {
				instrument.setNalichniBroiki(instrument.getNalichniBroiki() - broi);
				this.instrumenti.replace(instrument, instrument.getNalichniBroiki() - broi);
				instrument.setWasItSold(true);
				instrument.addPrihod(broi + nalichenBroi);

				System.out.println("Bqha prodadeni " + broi + " broq ot " + instrument.getInstrumentType());
				instrument.setBroiProdadeni(instrument.getBroiProdadeni() + broi);
				this.kasaNalichnost += instrument.getPrice() * broi;
				System.out.println("Ostavashta nalichnost : " + instrument.getNalichniBroiki());
			} 
		} else {
			System.out.println("Ne moje da se osushtesvi prodajbata zashtoto nqma dostatuchno broiki. V momenta "
					+ "ima samo " + instrument.getNalichniBroiki());
		}
	}

	public void createCatalog() {
		List<Instruments> sortingList = new ArrayList<Instruments>(this.instrumenti.keySet());
//		Ascending price 
		System.out.println("Instruments by ascending price : ");
		Collections.sort(sortingList, new InstrumentsPriceComparatorAscending());
		for (int index = 0; index < sortingList.size(); index++) {
			System.out.println(sortingList.get(index).getInstrumentType() + " : " + sortingList.get(index).getPrice());
		}
		System.out.println();
//		Descending price
		Collections.sort(sortingList, new InstrumentsPriceComparatorDescending());
		System.out.println("Instruments by descending price : ");
		for (int index = 0; index < sortingList.size(); index++) {
			System.out.println(sortingList.get(index).getInstrumentType() + " : " + sortingList.get(index).getPrice());
		}
		System.out.println();
//		Name sorting
		Collections.sort(sortingList, new InstrumentsTypeComparator());
		System.out.println("Instruments by name : ");
		for (int index = 0; index < sortingList.size(); index++) {
			System.out.println(sortingList.get(index).getInstrumentType());
		}
	}

	public void izgotviSpravka() {
//		Spisyk po broi prodadeni
		List<Instruments> sortingList = new ArrayList<Instruments>(this.instrumenti.keySet());
		System.out.println("Instruments by sold number : ");
		Collections.sort(sortingList, new InstrumentsSoldComparator());
		for (int index = 0; index < sortingList.size(); index++) {
			if (sortingList.get(index).isWasItSold() == true) {
				System.out.println(
						sortingList.get(index).getInstrumentType() + " : " + sortingList.get(index).getBroiProdadeni());
			}
		}
		System.out.println();
//		Generirane obshta suma ot prodajbi
		double realiziranaPechalba = this.kasaNalichnost - this.kasaNachalnaNalichnost;
		System.out.println("Pechalbata realizirana ot prodajbite e " + realiziranaPechalba);
//		Naj-prodavan element
		int max = Integer.MIN_VALUE;
		String name = "Instrument";
		for (int i = 0; i < sortingList.size(); i++) {
			if (sortingList.get(i).getBroiProdadeni() > max) {
				max = sortingList.get(i).getBroiProdadeni();
				name = sortingList.get(i).getInstrumentType();
			}
		}
		System.out.println("Naj - prodavan element e : " + name);
//		Naj-golqm prihod ot instrument
		double cashMaxPrihod = Double.MIN_VALUE;
		String nameMaxPrihod = "Instrument";
		for (int i = 0; i < sortingList.size(); i++) {
			if (sortingList.get(i).getPrihodOtInstrumenta() > cashMaxPrihod) {
				cashMaxPrihod = sortingList.get(i).getPrihodOtInstrumenta();
				nameMaxPrihod = sortingList.get(i).getInstrumentType();
			}
		}
		System.out.println(
				"Naj-golemiq prihod e poluchen ot " + nameMaxPrihod + " kato prihoda e v razmer na " + cashMaxPrihod/2);
	}

	public void napraviZaqvka(Instruments instrument, int broi) {
		if (instrument != null) {
			this.dostavchik.dostaviInstrument(instrument, broi);
			System.out.println("Napravena e zaqvka za " + broi + " broq " + instrument.getInstrumentType() + "\n"
					+ "Ochakva se dostavka sled " + this.dostavchik.getTimeinDays() + " dni");
		}
		addInstrument(instrument);
	}
}
