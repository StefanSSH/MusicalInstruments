import java.util.Comparator;

public class InstrumentsSoldComparator implements Comparator<Instruments> {

	@Override
	public int compare(Instruments o1, Instruments o2) {
		return (int) (o1.getBroiProdadeni() - o2.getBroiProdadeni());
	}

}
