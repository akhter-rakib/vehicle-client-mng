package com.vhaibrother.vehicle_client_mng.util;

public final class UrlConstraint {
    private UrlConstraint() {
    }

    private static final String VERSION = "/v1";
    private static final String API = "/api";

    public static class ColorManagement {
        public static final String ROOT = VERSION + API + "/colors";
        public static final String DELETE = "/{colorId}";
        public static final String GET = "/{colorId}";
        public static final String PUT = "/{colorId}";

    }

    public static class CarNameManagement {
        public static final String ROOT = VERSION + API + "/carNames";
        public static final String DELETE = "/{carNameId}";
        public static final String GET = "/{carNameId}";
        public static final String PUT = "/{carNameId}";
    }

    public static class UserManagement {
        public static final String ROOT = VERSION + API + "/users";
        public static final String DELETE = "/{id}";
        public static final String GET = "/{id}";
        public static final String PUT = "/{id}";
    }

    public static class AuthManagement {
        public static final String ROOT = VERSION + API + "/auth";
        public static final String LOGIN = "/login";
    }
}
