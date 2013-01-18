package org.motechproject.ananya.jasper.reports.domain;

import db.migration.domain.Role;

public enum Roles {
    ROLE_FLW("ROLE_FLW"), ROLE_USER("ROLE_USER");

    private Role role;

    private Roles(String role) {
        this.role = new Role(role);
    }

    public Role getRole() {
        return role;
    }
}
