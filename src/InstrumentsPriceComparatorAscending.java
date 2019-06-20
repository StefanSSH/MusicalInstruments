import java.util.Comparator;

public class InstrumentsPriceComparatorAscending implements Comparator<Instruments> {

	@Override
	public int compare(Instruments o1, Instruments o2) {
		return (int) (o1.getPrice() - o2.getPrice());
	}

}
