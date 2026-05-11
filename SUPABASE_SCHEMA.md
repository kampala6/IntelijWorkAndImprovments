# Supabase Schema Initialization

This project now includes `src/projektoppgave3_2015/SupabaseSchemaInitializer.java`.
The same DDL is also available in `supabase_schema.sql` for manual execution in Supabase SQL Editor.

It creates/updates tables for these model classes and related base state:

- `Adresse` -> `adresse`
- `Kunde` -> `kunde`
- static `Kunde.nesteNr` -> `kunde_sequence_state`
- `Forsikring` base -> `forsikring`
- `Bilforsikring` -> `bilforsikring`
- `BaatForsikring` -> `baatforsikring`
- `Husoginnboforsikring` -> `husoginnboforsikring`
- `FritidsboligForsikiring` -> `fritidsbolig_forsikiring`
- `Reise` -> `reise`
- `SkadeMelding` -> `skade_melding`

## Run schema creation

```zsh
cd "/Users/majolalunga/Documents/IntelijWorkAndImprovments"
javac -cp "lib/postgresql.jar:src" src/projektoppgave3_2015/SupabaseDatabase.java src/projektoppgave3_2015/SupabaseSchemaInitializer.java
java -cp "lib/postgresql.jar:src" projektoppgave3_2015.SupabaseSchemaInitializer
```

## Run schema smoke test

After schema creation, verify all required tables exist:

```zsh
cd "/Users/majolalunga/Documents/IntelijWorkAndImprovments"
javac -cp "lib/postgresql.jar:src" src/projektoppgave3_2015/SupabaseDatabase.java src/projektoppgave3_2015/SupabaseSchemaSmokeTest.java
java -cp "lib/postgresql.jar:src" projektoppgave3_2015.SupabaseSchemaSmokeTest
```

## Verify in Supabase

```zsh
cd "/Users/majolalunga/Documents/IntelijWorkAndImprovments"
java -cp "lib/postgresql.jar:src" projektoppgave3_2015.SupabaseSchemaInitializer
```

If it prints `Supabase schema created/verified successfully.`, the tables are present and migrations are idempotent.

## Alternative: run in Supabase SQL Editor

1. Open Supabase dashboard -> SQL Editor.
2. Paste the contents of `supabase_schema.sql`.
3. Run the script.

