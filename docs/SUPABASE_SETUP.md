# Supabase Setup (Java Project)

This project supports two Supabase connection modes:

1. Direct Postgres via JDBC (`SUPABASE_DB_*` variables)
2. REST reachability check using `NEXT_PUBLIC_SUPABASE_*` variables

## Recommended (JDBC)

Use this when you want actual SQL database access from Java.

```zsh
export SUPABASE_DB_HOST="db.YOUR_PROJECT_REF.supabase.co"
export SUPABASE_DB_PORT="5432"
export SUPABASE_DB_NAME="postgres"
export SUPABASE_DB_USER="postgres"
export SUPABASE_DB_PASSWORD="YOUR_DB_PASSWORD"
```

Optional single URL form:

```zsh
export SUPABASE_DB_URL="jdbc:postgresql://db.YOUR_PROJECT_REF.supabase.co:5432/postgres?sslmode=require"
export SUPABASE_DB_USER="postgres"
export SUPABASE_DB_PASSWORD="YOUR_DB_PASSWORD"
```

## Quick reachability only (REST)

Use this if you only have Supabase URL + publishable key.

```zsh
export NEXT_PUBLIC_SUPABASE_URL="https://YOUR_PROJECT_REF.supabase.co"
export NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY="YOUR_PUBLISHABLE_KEY"
```

## Persist in zsh

Append variables to your shell profile:

```zsh
cat <<'EOF' >> ~/.zshrc
export SUPABASE_DB_HOST="db.YOUR_PROJECT_REF.supabase.co"
export SUPABASE_DB_PORT="5432"
export SUPABASE_DB_NAME="postgres"
export SUPABASE_DB_USER="postgres"
export SUPABASE_DB_PASSWORD="YOUR_DB_PASSWORD"
EOF
source ~/.zshrc
```

## Compile and run the connection test

```zsh
cd "/Users/majolalunga/Documents/IntelijWorkAndImprovments"
javac -cp "lib/postgresql.jar:src" src/projektoppgave3_2015/SupabaseDatabase.java src/projektoppgave3_2015/SupabaseConnectionTest.java
java -cp "lib/postgresql.jar:src" projektoppgave3_2015.SupabaseConnectionTest
```

## Notes

- Do not commit secrets to Git.
- `NEXT_PUBLIC_SUPABASE_PUBLISHABLE_KEY` is not a DB password.
- JDBC mode is required for real SQL read/write operations.

