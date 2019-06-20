import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DostavchikNaInstrumenti {
	private Instruments instrument;
	private int timeinDays;
	public Instruments getInstrument() {
		return instrument;
	}

	public int getTimeinDays() {
		return timeinDays;
	}

	public String getName() {
		return name;
	}

	public Magazin getMagazin() {
		return magazin;
	}

	Map<Instruments, Integer> instrumentList;
	private String name;
	private Magazin magazin;

	public DostavchikNaInstrumenti(Magazin magazin, String name) {
		this.name = name;
		this.magazin = magazin;
		this.instrumentList = new HashMap<Instruments, Integer>();
	}

	public Map<Instruments, Integer> getInstrumentList() {
		return instrumentList;
	}

	public void addInstrumentForSale(Instruments instrument, int time) {
		this.instrumentList.put(instrument, time);
	}
	
	public void dostaviInstrument(Instruments instrument, int broi) {
		instrument.setNalichniBroiki(broi);
		this.magazin.addInstrument(instrument);
	}

}
