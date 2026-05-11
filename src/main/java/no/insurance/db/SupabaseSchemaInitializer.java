package no.insurance.db;

import no.insurance.model.*;
import no.insurance.service.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Creates all Supabase/Postgres tables needed by the domain model classes.
 */
public final class SupabaseSchemaInitializer {
    private static final String[] DDL_STATEMENTS = new String[] {
        "CREATE TABLE IF NOT EXISTS adresse ("
                + "id BIGSERIAL PRIMARY KEY, "
                + "gate_adresse TEXT NOT NULL, "
                + "gate_nummer TEXT, "
                + "post_nummer INTEGER NOT NULL, "
                + "by TEXT NOT NULL, "
                + "land TEXT NOT NULL"
                + ")",

        "CREATE TABLE IF NOT EXISTS kunde ("
                + "kunde_nr INTEGER PRIMARY KEY, "
                + "navn TEXT NOT NULL, "
                + "faktura_adresse TEXT, "
                + "dato DATE, "
                + "has_boat_insurance BOOLEAN NOT NULL DEFAULT FALSE, "
                + "has_car_insurance BOOLEAN NOT NULL DEFAULT FALSE, "
                + "insurance_count INTEGER NOT NULL DEFAULT 0, "
                + "premie_ratio DOUBLE PRECISION NOT NULL DEFAULT 0"
                + ")",

        "CREATE TABLE IF NOT EXISTS kunde_sequence_state ("
                + "singleton_id SMALLINT PRIMARY KEY DEFAULT 1, "
                + "neste_nr INTEGER NOT NULL"
                + ")",

        "CREATE TABLE IF NOT EXISTS forsikring ("
                + "forsikring_id INTEGER PRIMARY KEY, "
                + "total_kunderabatt INTEGER NOT NULL DEFAULT 3, "
                + "f_type INTEGER NOT NULL DEFAULT 0"
                + ")",

        "CREATE TABLE IF NOT EXISTS bilforsikring ("
                + "forsikring_id INTEGER PRIMARY KEY REFERENCES forsikring(forsikring_id) ON DELETE CASCADE, "
                + "kunde_nr INTEGER REFERENCES kunde(kunde_nr) ON DELETE SET NULL, "
                + "dato DATE, "
                + "registreringsnummer TEXT, "
                + "biltype TEXT, "
                + "modell TEXT, "
                + "lengde INTEGER, "
                + "arsmodell INTEGER, "
                + "motortype TEXT, "
                + "motorstyrke INTEGER, "
                + "bonus DOUBLE PRECISION NOT NULL DEFAULT 0"
                + ")",

        "CREATE UNIQUE INDEX IF NOT EXISTS ux_bilforsikring_registreringsnummer ON bilforsikring(registreringsnummer)",
        "CREATE INDEX IF NOT EXISTS ix_bilforsikring_kunde_nr ON bilforsikring(kunde_nr)",

        "CREATE TABLE IF NOT EXISTS baatforsikring ("
                + "forsikring_id INTEGER PRIMARY KEY REFERENCES forsikring(forsikring_id) ON DELETE CASCADE, "
                + "kunder INTEGER REFERENCES kunde(kunde_nr) ON DELETE SET NULL, "
                + "dato DATE, "
                + "registreringsnummer TEXT, "
                + "baattype TEXT, "
                + "modell TEXT, "
                + "lengde INTEGER, "
                + "arsmodell INTEGER, "
                + "motortype TEXT, "
                + "motorstyrke INTEGER, "
                + "bonus DOUBLE PRECISION NOT NULL DEFAULT 0"
                + ")",

        "CREATE UNIQUE INDEX IF NOT EXISTS ux_baatforsikring_registreringsnummer ON baatforsikring(registreringsnummer)",
        "CREATE INDEX IF NOT EXISTS ix_baatforsikring_kunder ON baatforsikring(kunder)",

        "CREATE TABLE IF NOT EXISTS husoginnboforsikring ("
                + "forsikring_id INTEGER PRIMARY KEY REFERENCES forsikring(forsikring_id) ON DELETE CASCADE, "
                + "kunde INTEGER REFERENCES kunde(kunde_nr) ON DELETE SET NULL, "
                + "boligens_adresse TEXT, "
                + "byggeaar INTEGER, "
                + "boligtype TEXT, "
                + "byggemateriale TEXT, "
                + "standard TEXT, "
                + "antall_kvadratmeter INTEGER, "
                + "belop_b INTEGER, "
                + "belop_i INTEGER, "
                + "bonus DOUBLE PRECISION NOT NULL DEFAULT 0, "
                + "dato DATE"
                + ")",

        "CREATE INDEX IF NOT EXISTS ix_husoginnboforsikring_kunde ON husoginnboforsikring(kunde)",

        "CREATE TABLE IF NOT EXISTS fritidsbolig_forsikiring ("
                + "forsikring_id INTEGER PRIMARY KEY REFERENCES forsikring(forsikring_id) ON DELETE CASCADE, "
                + "boligens_adresse TEXT, "
                + "byggeaar INTEGER, "
                + "boligtype TEXT, "
                + "byggemateriale TEXT, "
                + "standard TEXT, "
                + "antall_kvadratmeter INTEGER, "
                + "belop_b INTEGER, "
                + "belop_i INTEGER, "
                + "bonus DOUBLE PRECISION NOT NULL DEFAULT 0, "
                + "dato DATE"
                + ")",

        "CREATE TABLE IF NOT EXISTS reise ("
                + "forsikring_id INTEGER PRIMARY KEY REFERENCES forsikring(forsikring_id) ON DELETE CASCADE, "
                + "kunder TEXT, "
                + "omrade TEXT, "
                + "sumf INTEGER, "
                + "dato DATE, "
                + "bouns DOUBLE PRECISION NOT NULL DEFAULT 0"
                + ")",

        "CREATE TABLE IF NOT EXISTS skade_melding ("
                + "skade_nummer INTEGER PRIMARY KEY, "
                + "dato TIMESTAMPTZ, "
                + "kunde_nr INTEGER REFERENCES kunde(kunde_nr) ON DELETE SET NULL, "
                + "skade_object_type TEXT CHECK (skade_object_type IN ('HUS', 'BAAT', 'BIL')), "
                + "type_skade TEXT CHECK (type_skade IN ('VANN_SKEDE', 'BRANN_SKADE')), "
                + "beskrivelse TEXT, "
                + "vitner_kontakt_info TEXT, "
                + "taksering_belop DOUBLE PRECISION, "
                + "utbetalt_erstatnings_belop DOUBLE PRECISION, "
                + "koblet_hus_adresse TEXT, "
                + "koblet_baat_registreringsnummer TEXT, "
                + "koblet_bil_registreringsnummer TEXT"
                + ")",

        "CREATE INDEX IF NOT EXISTS ix_skade_melding_kunde_nr ON skade_melding(kunde_nr)",

        "ALTER TABLE kunde ADD COLUMN IF NOT EXISTS primary_bil_forsikring_id INTEGER",
        "ALTER TABLE kunde DROP CONSTRAINT IF EXISTS fk_kunde_primary_bil",
        "ALTER TABLE kunde ADD CONSTRAINT fk_kunde_primary_bil "
                + "FOREIGN KEY (primary_bil_forsikring_id) REFERENCES bilforsikring(forsikring_id) ON DELETE SET NULL"
    };

    private SupabaseSchemaInitializer() {
    }

    public static void main(String[] args) {
        try {
            createSchema();
            System.out.println("Supabase schema created/verified successfully.");
        } catch (SQLException exception) {
            System.err.println("Failed to create Supabase schema: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    public static void createSchema() throws SQLException {
        try (Connection connection = SupabaseDatabase.getConnection();
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            try {
                for (String ddl : DDL_STATEMENTS) {
                    statement.execute(ddl);
                }
                connection.commit();
            } catch (SQLException exception) {
                connection.rollback();
                throw exception;
            } finally {
                connection.setAutoCommit(true);
            }
        }
    }
}

