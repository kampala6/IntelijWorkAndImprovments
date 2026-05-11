package no.insurance.db;

import no.insurance.model.*;
import no.insurance.service.*;

public final class SupabaseConnectionTest {
    private SupabaseConnectionTest() {
    }

    public static void main(String[] args) {
        boolean connected = SupabaseDatabase.testConnection();

        if (connected) {
            System.out.println("Successfully reached Supabase (database or REST API).");
        } else {
            System.out.println("Failed to reach Supabase. Check SUPABASE_DB_* or NEXT_PUBLIC_SUPABASE_* variables.");
        }
    }
}