package com.sintergica.ai.permissionmanager.v3;

public class BitFlagsExample {
    public static void main(String[] args) {
        final int FLAG_A = 1 << 0; // 0001
        final int FLAG_B = 1 << 1; // 0010
        final int FLAG_C = 1 << 2; // 0100
        final int FLAG_D = 1 << 3; // 1000

        int flags = 0;

        // Activar FLAG_A y FLAG_B
        flags |= FLAG_C;//FLAG_A | FLAG_B;
        System.out.println("FLAGS after setting A and B: " + Integer.toBinaryString(flags));

        // Comprobar FLAGS
        boolean isFlagASet = (flags & FLAG_A) != 0;
        boolean isFlagCSet = (flags & FLAG_C) != 0;
        System.out.println("Is FLAG_A set? " + isFlagASet);
        System.out.println("Is FLAG_C set? " + isFlagCSet);

        // Desactivar FLAG_B
        flags &= ~FLAG_B;
        System.out.println("FLAGS after clearing B: " + Integer.toBinaryString(flags));

        // Alternar FLAG_C
        flags ^= FLAG_C;
        System.out.println("FLAGS after toggling C: " + Integer.toBinaryString(flags));
    }
}