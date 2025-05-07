package com.sintergica.ai.permissionmanager.v5;

/**
 * Permission is an enum that represents the different permissions that can be
 * granted to an entity. Each permission is represented by a bit in an integer.
 * The permissions are:
 * <ul>
 * <li>EXECUTE - 0001</li>
 * <li>WRITE - 0010</li>
 * <li>READ - 0100</li>
 * <li>DELETE - 1000</li>
 * </ul>
 * Each permission is represented by a power of 2, allowing for easy
 * combination of permissions using bitwise operations. For example, to grant
 * both READ and WRITE permissions, you can use the bitwise OR operator:
 * <pre>
 * int combinedPermissions = Permission.READ.BIT_REPRESENTATION | Permission.WRITE.BIT_REPRESENTATION;
 * </pre>
 * This will result in a value of 0110, which represents both READ and WRITE
 * permissions.
 * 
 * @author Panther
 */
public enum Permission {
    @SuppressWarnings("PointlessBitwiseExpression")
    EXECUTE(1 << 0), // 0001
    WRITE(1 << 1), // 0010
    READ(1 << 2), // 0100
    DELETE(1 << 3); // 1000

    public final int BIT_REPRESENTATION;

    Permission(int bit) {
        this.BIT_REPRESENTATION = bit;
    }
}
