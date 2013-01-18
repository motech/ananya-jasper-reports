package org.motechproject.ananya.jasper.reports.domain;

import db.migration.domain.Role;

public enum Roles {
    ROLE_FLW("ROW_FLW"), ROLE_USER("ROW_USER");

    private Role role;

    private Roles(String role) {
        this.role = new Role(role);
    }

    public Role getRole() {
        return role;
    }
}
