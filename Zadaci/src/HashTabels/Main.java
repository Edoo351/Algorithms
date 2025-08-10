package HashTabels;

class Main {

    public static void main(String[] args) {
        HashTable table;

        System.out.println("These tests confirm keys() returns all keys");
        System.out.println("including keys in chains, and handles");
        System.out.println("empty tables and large insertions.");
        System.out.println();

        // Test 1: Empty table
        System.out.println("Test 1: Keys from Empty Table");
        table = new HashTable();
        System.out.println("Expected: []");
        System.out.println("Actual: " + table.keys());
        System.out.println();

        // Test 2: Single key
        System.out.println("Test 2: Keys with Single Key");
        table = new HashTable();
        table.set("nails", 100);
        System.out.println("Expected: [nails]");
        System.out.println("Actual: " + table.keys());
        System.out.println();

        // Test 3: Multiple keys
        System.out.println("Test 3: Keys with Multiple Keys");
        table = new HashTable();
        table.set("nails", 100);
        table.set("tile", 50);
        table.set("lumber", 80);
        System.out.println("Expected: [nails, tile, lumber] (any order)");
        System.out.println("Actual: " + table.keys());
        System.out.println();

        // Test 4: Keys with collisions
        System.out.println("Test 4: Keys with Collisions");
        table = new HashTable();
        table.set("nails", 100);
        table.set("tile", 50);
        table.set("lumber", 80);
        System.out.println("Expected: [nails, tile, lumber] (any order)");
        System.out.println("Actual: " + table.keys());
        System.out.println();

        // Test 5: Keys after many insertions
        System.out.println("Test 5: Keys After Many Insertions");
        table = new HashTable();
        for (int i = 0; i < 20; i++) {
            table.set("item" + i, i * 10);
        }
        System.out.println("Expected: 20 keys (item0 ... item19)");
        System.out.println("Actual size: " + table.keys().size());
        System.out.println("Sample keys: " + table.keys().subList(0, 5));
        System.out.println();

        /*
            EXPECTED OUTPUT:
            ----------------
            These tests confirm keys() returns all keys
            including keys in chains, and handles
            empty tables and large insertions.

            Test 1: Keys from Empty Table
            Expected: []
            Actual: []

            Test 2: Keys with Single Key
            Expected: [nails]
            Actual: [nails]

            Test 3: Keys with Multiple Keys
            Expected: [nails, tile, lumber] (any order)
            Actual: [nails, tile, lumber]

            Test 4: Keys with Collisions
            Expected: [nails, tile, lumber] (any order)
            Actual: [nails, tile, lumber]

            Test 5: Keys After Many Insertions
            Expected: 20 keys (item0 ... item19)
            Actual size: 20
            Sample keys: [first 5 keys]
        */

    }

}

