import java.util.Comparator;

public class InstrumentsPriceComparatorDescending implements Comparator<Instruments> {

	@Override
	public int compare(Instruments o1, Instruments o2) {
		return (int) (o2.getPrice() - o1.getPrice());
	}

}
