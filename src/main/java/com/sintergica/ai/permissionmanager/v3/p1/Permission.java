package com.sintergica.ai.permissionmanager.v3.p1;

public enum Permission {
    LEER(1 << 0), // 0001
    ESCRIBIR(1 << 1), // 0010
    EJECUTAR(1 << 2), // 0100
    ELIMINAR(1 << 3); // 1000

    public final int valor;

    Permission(int valor) {
        this.valor = valor;
    }
}
