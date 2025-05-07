package com.sintergica.ai.permissionmanager.v5;

public enum Permission {
    EXECUTE(1 << 0), // 0001
    WRITE(1 << 1), // 0010
    READ(1 << 2), // 0100
    DELETE(1 << 3); // 1000

    public final int BIT_REPRESENTATION;

    Permission(int bit) {
        this.BIT_REPRESENTATION = bit;
    }
}
