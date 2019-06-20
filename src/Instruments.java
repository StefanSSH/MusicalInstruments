import java.util.Comparator;

public class Instruments {
	private String instrumentType;
	private double price;
	private int nalichniBroiki;
	private boolean isNalichno;
	private int broiProdadeni;
	private boolean wasItSold;
	private double prihodOtInstrumenta;

	public double getPrihodOtInstrumenta() {
		return prihodOtInstrumenta;
	}

	public void setPrihodOtInstrumenta(double prihodOtInstrumenta) {
		this.prihodOtInstrumenta = prihodOtInstrumenta;
	}

	public boolean isWasItSold() {
		return wasItSold;
	}

	public void setWasItSold(boolean wasItSold) {
		this.wasItSold = wasItSold;
	}

	public int getBroiProdadeni() {
		return broiProdadeni;
	}

	public void setBroiProdadeni(int broiProdadeni) {
		this.broiProdadeni = broiProdadeni;
	}

	public void setNalichniBroiki(int nalichniBroiki) {
		this.nalichniBroiki = nalichniBroiki;
	}

	public void setNalichno(boolean isNalichno) {
		this.isNalichno = isNalichno;
	}

	public String getInstrumentType() {
		return instrumentType;
	}

	public Instruments(String instrument, double price, int nalichniBroiki) {
		this.instrumentType = instrument;
		this.price = price;
		this.nalichniBroiki = nalichniBroiki;
	}

	public double getPrice() {
		return price;
	}

	public int getNalichniBroiki() {
		return nalichniBroiki;
	}

	public boolean isNalichno() {
		return isNalichno;
	}

	@Override
	public String toString() {
		return "Instruments [instrumentType=" + instrumentType + "]";
	}

	public void addPrihod(int broi) {
		this.prihodOtInstrumenta += this.price * broi;
	}

}
