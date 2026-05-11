package no.insurance.db;

import no.insurance.model.*;
import no.insurance.service.*;

import java.util.Calendar;

/**
 * Small smoke test that writes sample data through PersistenceService and loads it back.
 */
public final class SupabasePersistenceRoundtripTest {
    private SupabasePersistenceRoundtripTest() {
    }

    public static void main(String[] args) throws Exception {
        Lister source = new Lister();

        Kunde kunde = new Kunde("Database Test", "Testveien 1", Calendar.getInstance());
        source.leggTilKunde(kunde);

        Bilforsikring bil = new Bilforsikring(Calendar.getInstance(), kunde.getKundeNr(), "DBT123", "PERSONBIL", "Model S", 12000, 2022, "Elektrisk", 380, 0);
        bil.setBonus(10.0);
        source.leggTilbilForsikring(bil);
        kunde.leggTilbil(bil);
        kunde.setBil(bil);

        Reise reise = new Reise(String.valueOf(kunde.getKundeNr()), "Europa", 50000, 0, 5.0);
        source.leggTilRiese(reise);
        kunde.addReise(reise);

        PersistenceService persistence = new PersistenceService("lister.txt", "lister.ser");
        persistence.save(source, new SnapshotFormatter().buildListerTextSnapshot(source));

        Lister loaded = persistence.load();

        int kunder = loaded.getKundeListe().size();
        int biler = loaded.getBilForsikringsLIste().size();
        int reiser = loaded.getReisesliste().size();

        System.out.println("Loaded kunder=" + kunder + ", biler=" + biler + ", reiser=" + reiser);
        if (kunder < 1 || biler < 1 || reiser < 1) {
            throw new IllegalStateException("Roundtrip failed: missing rows after DB load.");
        }

        System.out.println("Supabase persistence roundtrip OK.");
    }
}

