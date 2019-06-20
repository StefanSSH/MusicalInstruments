import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoMagazin {
	public static void main(String[] args) {
		Magazin mag1 = new Magazin(1500);
		DostavchikNaInstrumenti dostavchik1 = new DostavchikNaInstrumenti(mag1, "Kiro");
		mag1.addDostavchik(dostavchik1);

		Instruments instr1 = new Instruments("Cigulka", 500, 26);
		Instruments instr2 = new Instruments("Flejta", 600, 24);
		Instruments instr3 = new Instruments("Organ", 1200, 64);
		Instruments instr4 = new Instruments("Barabani", 800, 24);
		Instruments instr5 = new Instruments("Baskitara", 1000, 12);

		mag1.addInstrument(instr1);
		mag1.addInstrument(instr2);
		mag1.addInstrument(instr3);
		mag1.addInstrument(instr4);
		mag1.addInstrument(instr5);
		
		mag1.createCatalog();
		
		mag1.sellInstrument(instr1, 46);
		mag1.sellInstrument(instr2, 43);
		mag1.sellInstrument(instr4, 31);
		mag1.sellInstrument(instr5, 8);
		System.out.println();
		
		
		mag1.izgotviSpravka();
	}
}
