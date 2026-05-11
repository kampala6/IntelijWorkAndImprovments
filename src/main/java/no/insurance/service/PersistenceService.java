//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package no.insurance.service;
import no.insurance.model.*;
import no.insurance.db.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class PersistenceService {
    private final SnapshotFormatter snapshotFormatter = new SnapshotFormatter();

    /**
     * Creates a persistence service using the provided text and serialized file paths.
     *
     * @param var1 path to the text snapshot file
     * @param var2 path to the serialized data file
     */
    public PersistenceService(String var1, String var2) {
        // Legacy constructor kept for compatibility; persistence is now database-backed.
    }

    /**
     * Saves registry data both as a serialized object and as a text snapshot.
     *
     * @param var1 registry data to save
     * @param var2 text snapshot content
     * @throws IOException if writing either file fails
     */
    public void save(Lister var1, String var2) throws IOException {
        try {
            SupabaseSchemaInitializer.createSchema();
            this.ensureUniqueInsuranceIds(var1);
            try (Connection connection = SupabaseDatabase.getConnection()) {
                connection.setAutoCommit(false);
                try {
                    this.clearAllTables(connection);
                    this.insertKunder(connection, var1.getKundeListe());
                    this.insertBilForsikringer(connection, var1.getBilForsikringsLIste());
                    this.insertBaatForsikringer(connection, var1.getBaatForsikringsliste());
                    this.insertHusForsikringer(connection, var1.getHusoginnboforsikrings());
                    this.insertFritidsForsikringer(connection, var1.getFritidsboligForsikirings());
                    this.insertReiseForsikringer(connection, var1.getReisesliste());
                    this.updateKundePrimaryBil(connection, var1.getKundeListe());
                    this.insertSkadeMeldinger(connection, var1.getSkadeMeldinger());
                    this.saveNextCustomerNumber(connection, var1.getKundeListe());
                    connection.commit();
                } catch (SQLException exception) {
                    connection.rollback();
                    throw exception;
                } finally {
                    connection.setAutoCommit(true);
                }
            }
        } catch (SQLException | IllegalStateException exception) {
            throw new IOException("Kunne ikke lagre til database: " + exception.getMessage(), exception);
        }
    }

    /**
     * Loads the serialized registry data when available.
     *
     * @return the loaded registry, or a new empty registry when no serialized file exists
     * @throws IOException if the file cannot be read
     * @throws ClassNotFoundException if serialized classes cannot be resolved
     */
    public Lister load() throws IOException, ClassNotFoundException {
        try {
            SupabaseSchemaInitializer.createSchema();
            Lister lister = new Lister();
            try (Connection connection = SupabaseDatabase.getConnection()) {
                Map<Integer, Kunde> kunder = this.loadKunder(connection, lister);
                this.loadBilForsikringer(connection, lister, kunder);
                this.loadBaatForsikringer(connection, lister, kunder);
                this.loadHusForsikringer(connection, lister, kunder);
                this.loadFritidsForsikringer(connection, lister);
                this.loadReiseForsikringer(connection, lister, kunder);
                this.loadSkadeMeldinger(connection, lister);
                this.restoreNextCustomerNumber(connection, lister.getKundeListe());
            }
            return lister;
        } catch (SQLException | IllegalStateException exception) {
            throw new IOException("Kunne ikke laste fra database: " + exception.getMessage(), exception);
        }
    }

    /**
     * Indicates whether either serialized data or a non-empty text snapshot exists.
     *
     * @return {@code true} if persisted data is available
     */
    public boolean hasPersistedData() {
        try {
            SupabaseSchemaInitializer.createSchema();
            try (Connection connection = SupabaseDatabase.getConnection();
                 Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery("SELECT (SELECT COUNT(*) FROM kunde) + (SELECT COUNT(*) FROM skade_melding) + (SELECT COUNT(*) FROM bilforsikring) + (SELECT COUNT(*) FROM baatforsikring) + (SELECT COUNT(*) FROM husoginnboforsikring) + (SELECT COUNT(*) FROM fritidsbolig_forsikiring) + (SELECT COUNT(*) FROM reise)")) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException | IllegalStateException exception) {
            return false;
        }
    }

    /**
     * Reads the text snapshot file.
     *
     * @return the text snapshot contents
     * @throws IOException if the file cannot be read
     */
    public String readTextSnapshot() throws IOException {
        try {
            return this.snapshotFormatter.buildListerTextSnapshot(this.load());
        } catch (ClassNotFoundException exception) {
            throw new IOException("Kunne ikke bygge snapshot fra database", exception);
        }
    }

    /**
     * Writes the text snapshot file.
     *
     * @param var1 text snapshot content
     * @throws IOException if the file cannot be written
     */
    public void writeTextSnapshot(String var1) throws IOException {
        // Legacy API retained for compatibility. Snapshot text is now generated from DB data.
    }

    /**
     * Checks whether a text snapshot appears to contain binary control characters.
     *
     * @param var1 text to inspect
     * @return {@code true} if binary control characters are detected
     */
    public boolean containsBinaryCharacters(String var1) {
        for(int var2 = 0; var2 < var1.length(); ++var2) {
            char var3 = var1.charAt(var2);
            if (Character.isISOControl(var3) && var3 != '\n' && var3 != '\r' && var3 != '\t') {
                return true;
            }
        }

        return false;
    }

    private void clearAllTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("TRUNCATE TABLE skade_melding, bilforsikring, baatforsikring, husoginnboforsikring, fritidsbolig_forsikiring, reise, forsikring, kunde, kunde_sequence_state CASCADE");
        }
    }

    private void insertKunder(Connection connection, Set<Kunde> kunder) throws SQLException {
        String sql = "INSERT INTO kunde (kunde_nr, navn, faktura_adresse, dato, has_boat_insurance, has_car_insurance, insurance_count, premie_ratio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Kunde kunde : kunder) {
                ps.setInt(1, kunde.getKundeNr());
                ps.setString(2, kunde.getNavn());
                ps.setString(3, kunde.getFakturaAdresse());
                ps.setDate(4, toSqlDate(kunde.getDatoObjekt()));
                ps.setBoolean(5, kunde.hasBoatInsurance());
                ps.setBoolean(6, kunde.hasCarInsurance());
                ps.setInt(7, kunde.getInsuranceCount());
                ps.setDouble(8, kunde.getPremieRatio());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void insertForsikringBase(Connection connection, Forsikring forsikring) throws SQLException {
        String sql = "INSERT INTO forsikring (forsikring_id, total_kunderabatt, f_type) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, forsikring.getForsikringId());
            ps.setInt(2, forsikring.getTotalKunderabatt());
            ps.setInt(3, forsikring.getFType());
            ps.executeUpdate();
        }
    }

    private void insertBilForsikringer(Connection connection, Set<Bilforsikring> biler) throws SQLException {
        String sql = "INSERT INTO bilforsikring (forsikring_id, kunde_nr, dato, registreringsnummer, biltype, modell, lengde, arsmodell, motortype, motorstyrke, bonus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Bilforsikring bil : biler) {
                this.insertForsikringBase(connection, bil);
                ps.setInt(1, bil.getForsikringId());
                ps.setInt(2, bil.getKunder());
                ps.setDate(3, toSqlDate(bil.getDatoObjekt()));
                ps.setString(4, bil.getRegistreringsnummer());
                ps.setString(5, bil.getBiltype());
                ps.setString(6, bil.getModell());
                ps.setInt(7, bil.getLengde());
                ps.setInt(8, bil.getÅrsmodell());
                ps.setString(9, bil.getMotortype());
                ps.setInt(10, bil.getMotorstyrke());
                ps.setDouble(11, bil.getBonus());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void insertBaatForsikringer(Connection connection, Set<BaatForsikring> baater) throws SQLException {
        String sql = "INSERT INTO baatforsikring (forsikring_id, kunder, dato, registreringsnummer, baattype, modell, lengde, arsmodell, motortype, motorstyrke, bonus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (BaatForsikring baat : baater) {
                this.insertForsikringBase(connection, baat);
                ps.setInt(1, baat.getForsikringId());
                ps.setInt(2, baat.getKunder());
                ps.setDate(3, toSqlDate(baat.getDatoObjekt()));
                ps.setString(4, baat.getRegistreringsnummer());
                ps.setString(5, baat.getBaattype());
                ps.setString(6, baat.getModell());
                ps.setInt(7, baat.getLengde());
                ps.setInt(8, baat.getÅrsmodell());
                ps.setString(9, baat.getMotortype());
                ps.setInt(10, baat.getMotorstyrke());
                ps.setDouble(11, baat.getBonus());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void insertHusForsikringer(Connection connection, Set<Husoginnboforsikring> husSet) throws SQLException {
        String sql = "INSERT INTO husoginnboforsikring (forsikring_id, kunde, boligens_adresse, byggeaar, boligtype, byggemateriale, standard, antall_kvadratmeter, belop_b, belop_i, bonus, dato) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Husoginnboforsikring hus : husSet) {
                this.insertForsikringBase(connection, hus);
                ps.setInt(1, hus.getForsikringId());
                ps.setInt(2, hus.getKunde());
                ps.setString(3, hus.getBoligensAdresse());
                ps.setInt(4, hus.getByggeaar());
                ps.setString(5, hus.getBoligtype());
                ps.setString(6, hus.getByggemateriale());
                ps.setString(7, hus.getStandard());
                ps.setInt(8, hus.getAntallKvadratmeter());
                ps.setInt(9, hus.getBelopB());
                ps.setInt(10, hus.getBelopI());
                ps.setDouble(11, hus.getBonus());
                ps.setDate(12, toSqlDate(hus.getDatoObjekt()));
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void insertFritidsForsikringer(Connection connection, Set<FritidsboligForsikiring> fritidsSet) throws SQLException {
        String sql = "INSERT INTO fritidsbolig_forsikiring (forsikring_id, boligens_adresse, byggeaar, boligtype, byggemateriale, standard, antall_kvadratmeter, belop_b, belop_i, bonus, dato) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (FritidsboligForsikiring fritid : fritidsSet) {
                this.insertForsikringBase(connection, fritid);
                ps.setInt(1, fritid.getForsikringId());
                ps.setString(2, fritid.getBoligensAdresse());
                ps.setInt(3, fritid.getByggeaar());
                ps.setString(4, fritid.getBoligtype());
                ps.setString(5, fritid.getByggemateriale());
                ps.setString(6, fritid.getStandard());
                ps.setInt(7, fritid.getAntallKvadratmeter());
                ps.setInt(8, fritid.getBelopB());
                ps.setInt(9, fritid.getBelopI());
                ps.setDouble(10, fritid.getBonus());
                ps.setDate(11, toSqlDate(fritid.getDatoObjekt()));
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void insertReiseForsikringer(Connection connection, Set<Reise> reiser) throws SQLException {
        String sql = "INSERT INTO reise (forsikring_id, kunder, omrade, sumf, dato, bouns) VALUES (?, ?, ?, ?, CURRENT_DATE, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Reise reise : reiser) {
                this.insertForsikringBase(connection, reise);
                ps.setInt(1, reise.getForsikringId());
                ps.setString(2, reise.kunder);
                ps.setString(3, reise.getOmråde());
                ps.setInt(4, reise.getSumf());
                ps.setDouble(5, extractReiseBonus(reise));
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void updateKundePrimaryBil(Connection connection, Set<Kunde> kunder) throws SQLException {
        String sql = "UPDATE kunde SET primary_bil_forsikring_id = ? WHERE kunde_nr = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (Kunde kunde : kunder) {
                Bilforsikring bil = kunde.getBil();
                if (bil == null) {
                    continue;
                }
                ps.setInt(1, bil.getForsikringId());
                ps.setInt(2, kunde.getKundeNr());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private void insertSkadeMeldinger(Connection connection, Set<SkadeMelding> skader) throws SQLException {
        String sql = "INSERT INTO skade_melding (skade_nummer, dato, kunde_nr, skade_object_type, type_skade, beskrivelse, vitner_kontakt_info, taksering_belop, utbetalt_erstatnings_belop, koblet_hus_adresse, koblet_baat_registreringsnummer, koblet_bil_registreringsnummer) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            for (SkadeMelding skade : skader) {
                ps.setInt(1, skade.getSkadeNummer());
                if (skade.getDato() != null) {
                    ps.setTimestamp(2, new java.sql.Timestamp(skade.getDato().getTime()));
                } else {
                    ps.setTimestamp(2, null);
                }
                ps.setInt(3, skade.getKundeNr());
                ps.setString(4, skade.getSkadeObjectType() != null ? skade.getSkadeObjectType().name() : null);
                ps.setString(5, skade.getTypeSkade() != null ? skade.getTypeSkade().name() : null);
                ps.setString(6, skade.getBeskrivelse());
                ps.setString(7, skade.getVitnerKontaktInfo());
                ps.setDouble(8, skade.getTakseringBeløp());
                ps.setDouble(9, skade.getUtbetaltErstatningsBeløp());
                ps.setString(10, skade.getKobletHusAdresse());
                ps.setString(11, skade.getKobletBaatRegistreringsnummer());
                ps.setString(12, skade.getKobletBilRegistreringsnummer());
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }

    private Map<Integer, Kunde> loadKunder(Connection connection, Lister lister) throws SQLException {
        Map<Integer, Kunde> kunder = new HashMap<Integer, Kunde>();
        String sql = "SELECT kunde_nr, navn, faktura_adresse, dato, has_boat_insurance, has_car_insurance, insurance_count, premie_ratio FROM kunde ORDER BY kunde_nr";
        try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                int kundeNr = rs.getInt("kunde_nr");
                this.setStaticNesteNr(kundeNr);
                Kunde kunde = new Kunde(rs.getString("navn"), rs.getString("faktura_adresse"), toCalendar(rs.getDate("dato")));
                kunde.setHasBoatInsurance(rs.getBoolean("has_boat_insurance"));
                kunde.setHasCarInsurance(rs.getBoolean("has_car_insurance"));
                kunde.setInsuranceCount(rs.getInt("insurance_count"));
                kunde.setPremieRatio(rs.getDouble("premie_ratio"));
                lister.leggTilKunde(kunde);
                kunder.put(kunde.getKundeNr(), kunde);
            }
        }
        return kunder;
    }

    private Map<Integer, int[]> loadForsikringMeta(Connection connection) throws SQLException {
        Map<Integer, int[]> meta = new HashMap<Integer, int[]>();
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT forsikring_id, total_kunderabatt, f_type FROM forsikring")) {
            while (rs.next()) {
                meta.put(rs.getInt(1), new int[]{rs.getInt(2), rs.getInt(3)});
            }
        }
        return meta;
    }

    private void applyForsikringMeta(Forsikring forsikring, Map<Integer, int[]> meta) {
        int[] values = meta.get(forsikring.getForsikringId());
        if (values != null) {
            forsikring.setTotalKunderabatt(values[0]);
            forsikring.setFType(values[1]);
        }
    }

    private void loadBilForsikringer(Connection connection, Lister lister, Map<Integer, Kunde> kunder) throws SQLException {
        Map<Integer, int[]> meta = this.loadForsikringMeta(connection);
        String sql = "SELECT * FROM bilforsikring ORDER BY forsikring_id";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Bilforsikring bil = new Bilforsikring(
                        toCalendar(rs.getDate("dato")),
                        rs.getInt("kunde_nr"),
                        rs.getString("registreringsnummer"),
                        rs.getString("biltype"),
                        rs.getString("modell"),
                        rs.getInt("lengde"),
                        rs.getInt("arsmodell"),
                        rs.getString("motortype"),
                        rs.getInt("motorstyrke"),
                        rs.getInt("forsikring_id")
                );
                bil.setBonus(rs.getDouble("bonus"));
                this.applyForsikringMeta(bil, meta);
                lister.getBilForsikringsLIste().add(bil);
                Kunde kunde = kunder.get(bil.getKunder());
                if (kunde != null) {
                    kunde.leggTilbil(bil);
                    if (kunde.getBil() == null) {
                        kunde.setBil(bil);
                    }
                }
            }
        }
    }

    private void loadBaatForsikringer(Connection connection, Lister lister, Map<Integer, Kunde> kunder) throws SQLException {
        Map<Integer, int[]> meta = this.loadForsikringMeta(connection);
        String sql = "SELECT * FROM baatforsikring ORDER BY forsikring_id";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                BaatForsikring baat = new BaatForsikring(
                        toCalendar(rs.getDate("dato")),
                        rs.getString("registreringsnummer"),
                        rs.getString("baattype"),
                        rs.getString("modell"),
                        rs.getInt("lengde"),
                        rs.getInt("arsmodell"),
                        rs.getString("motortype"),
                        rs.getInt("motorstyrke"),
                        rs.getDouble("bonus"),
                        rs.getInt("forsikring_id"),
                        0.0
                );
                baat.setKunder(rs.getInt("kunder"));
                this.applyForsikringMeta(baat, meta);
                lister.getBaatForsikringsliste().add(baat);
                Kunde kunde = kunder.get(baat.getKunder());
                if (kunde != null) {
                    kunde.addBaat(baat);
                }
            }
        }
    }

    private void loadHusForsikringer(Connection connection, Lister lister, Map<Integer, Kunde> kunder) throws SQLException {
        Map<Integer, int[]> meta = this.loadForsikringMeta(connection);
        String sql = "SELECT * FROM husoginnboforsikring ORDER BY forsikring_id";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Husoginnboforsikring hus = new Husoginnboforsikring(
                        rs.getInt("kunde"),
                        rs.getString("boligens_adresse"),
                        rs.getString("boligtype"),
                        toCalendar(rs.getDate("dato")),
                        rs.getString("byggemateriale"),
                        rs.getInt("antall_kvadratmeter"),
                        rs.getInt("belop_b"),
                        rs.getInt("belop_i"),
                        rs.getInt("byggeaar"),
                        rs.getString("standard"),
                        rs.getInt("forsikring_id")
                );
                hus.setBonus(rs.getDouble("bonus"));
                this.applyForsikringMeta(hus, meta);
                lister.getHusoginnboforsikrings().add(hus);
                Kunde kunde = kunder.get(hus.getKunde());
                if (kunde != null) {
                    kunde.addHusForsikring(hus);
                }
            }
        }
    }

    private void loadFritidsForsikringer(Connection connection, Lister lister) throws SQLException {
        Map<Integer, int[]> meta = this.loadForsikringMeta(connection);
        String sql = "SELECT * FROM fritidsbolig_forsikiring ORDER BY forsikring_id";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                FritidsboligForsikiring fritid = new FritidsboligForsikiring(
                        rs.getString("boligens_adresse"),
                        toCalendar(rs.getDate("dato")),
                        rs.getString("boligtype"),
                        rs.getString("byggemateriale"),
                        rs.getString("standard"),
                        rs.getInt("belop_i"),
                        rs.getInt("belop_b"),
                        rs.getInt("byggeaar"),
                        rs.getInt("antall_kvadratmeter"),
                        rs.getDouble("bonus"),
                        rs.getInt("forsikring_id")
                );
                this.applyForsikringMeta(fritid, meta);
                lister.getFritidsboligForsikirings().add(fritid);
            }
        }
    }

    private void loadReiseForsikringer(Connection connection, Lister lister, Map<Integer, Kunde> kunder) throws SQLException {
        Map<Integer, int[]> meta = this.loadForsikringMeta(connection);
        String sql = "SELECT * FROM reise ORDER BY forsikring_id";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Reise reise = new Reise(
                        rs.getString("kunder"),
                        rs.getString("omrade"),
                        rs.getInt("sumf"),
                        rs.getInt("forsikring_id"),
                        rs.getDouble("bouns")
                );
                this.applyForsikringMeta(reise, meta);
                lister.getReisesliste().add(reise);
                try {
                    int kundeNr = Integer.parseInt(reise.kunder);
                    Kunde kunde = kunder.get(kundeNr);
                    if (kunde != null) {
                        kunde.addReise(reise);
                    }
                } catch (NumberFormatException ignored) {
                }
            }
        }
    }

    private void loadSkadeMeldinger(Connection connection, Lister lister) throws SQLException {
        String sql = "SELECT * FROM skade_melding ORDER BY skade_nummer";
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String typeName = rs.getString("type_skade");
                SkadeMelding.TypeSkade type = typeName != null ? SkadeMelding.TypeSkade.valueOf(typeName) : null;
                java.sql.Timestamp timestamp = rs.getTimestamp("dato");
                SkadeMelding skade = new SkadeMelding(timestamp != null ? new java.util.Date(timestamp.getTime()) : null, type);
                skade.setSkadeNummer(rs.getInt("skade_nummer"));
                skade.setKundeNr(rs.getInt("kunde_nr"));
                String objectType = rs.getString("skade_object_type");
                if (objectType != null) {
                    skade.setSkadeObjectType(SkadeMelding.SkadeObjectType.valueOf(objectType));
                }
                skade.setBeskrivelse(rs.getString("beskrivelse"));
                skade.setVitnerKontaktInfo(rs.getString("vitner_kontakt_info"));
                skade.setTakseringBeløp(rs.getDouble("taksering_belop"));
                skade.setUtbetaltErstatningsBeløp(rs.getDouble("utbetalt_erstatnings_belop"));
                skade.setKobletHusAdresse(rs.getString("koblet_hus_adresse"));
                skade.setKobletBaatRegistreringsnummer(rs.getString("koblet_baat_registreringsnummer"));
                skade.setKobletBilRegistreringsnummer(rs.getString("koblet_bil_registreringsnummer"));
                lister.nySkadeMelding(skade);
            }
        }
    }

    private void saveNextCustomerNumber(Connection connection, Set<Kunde> kunder) throws SQLException {
        int next = 1000;
        for (Kunde kunde : kunder) {
            next = Math.max(next, kunde.getKundeNr() + 1);
        }
        String sql = "INSERT INTO kunde_sequence_state (singleton_id, neste_nr) VALUES (1, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, next);
            ps.executeUpdate();
        }
    }

    private void restoreNextCustomerNumber(Connection connection, Set<Kunde> kunder) throws SQLException {
        int next = 1000;
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT neste_nr FROM kunde_sequence_state WHERE singleton_id = 1")) {
            if (rs.next()) {
                next = rs.getInt(1);
            }
        }
        for (Kunde kunde : kunder) {
            next = Math.max(next, kunde.getKundeNr() + 1);
        }
        this.setStaticNesteNr(next);
    }

    private void ensureUniqueInsuranceIds(Lister lister) {
        Set<Integer> usedIds = new HashSet<Integer>();
        int nextId = 1;
        for (Forsikring forsikring : this.collectAllInsurances(lister)) {
            int id = forsikring.getForsikringId();
            if (id <= 0 || usedIds.contains(id)) {
                while (usedIds.contains(nextId)) {
                    nextId++;
                }
                forsikring.setForsikringId(nextId);
                id = nextId;
                nextId++;
            }
            usedIds.add(id);
        }
    }

    private List<Forsikring> collectAllInsurances(Lister lister) {
        List<Forsikring> list = new ArrayList<Forsikring>();
        list.addAll(lister.getBilForsikringsLIste());
        list.addAll(lister.getBaatForsikringsliste());
        list.addAll(lister.getHusoginnboforsikrings());
        list.addAll(lister.getFritidsboligForsikirings());
        list.addAll(lister.getReisesliste());
        return list;
    }

    private static Date toSqlDate(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return new Date(calendar.getTimeInMillis());
    }

    private static Calendar toCalendar(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    private void setStaticNesteNr(int nesteNr) {
        try {
            Field field = Kunde.class.getDeclaredField("nesteNr");
            field.setAccessible(true);
            field.setInt(null, nesteNr);
        } catch (ReflectiveOperationException ignored) {
        }
    }

    private static double extractReiseBonus(Reise reise) {
        try {
            Field field = Reise.class.getDeclaredField("bouns");
            field.setAccessible(true);
            return field.getDouble(reise);
        } catch (ReflectiveOperationException ignored) {
            return 0.0;
        }
    }
}
