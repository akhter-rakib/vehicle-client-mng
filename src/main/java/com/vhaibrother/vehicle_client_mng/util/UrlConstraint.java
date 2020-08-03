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
}
