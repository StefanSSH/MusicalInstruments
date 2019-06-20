import java.util.Comparator;

public class InstrumentsTypeComparator  implements Comparator<Instruments>{

	@Override
	public int compare(Instruments o1, Instruments o2) {
		return o1.getInstrumentType().compareTo(o2.getInstrumentType());
	}
	
}
