package com.vhaibrother.vehicle_client_mng.util;

public final class UrlConstraint {
    private UrlConstraint() {
    }

    private static final String VERSION = "/v1";
    private static final String API = "/api";

    public static class ColorManagement {
        public static final String ROOT = API + VERSION + "/colors";
        public static final String DELETE = "/{colorId}";
        public static final String GET = "/{colorId}";
        public static final String PUT = "/{colorId}";
    }

    public static class DomainManagement {
        public static final String ROOT =  API + VERSION + "/domains";
        public static final String DELETE = "/{domainId}";
        public static final String GET = "/{domainId}";
        public static final String PUT = "/{domainId}";
    }
}
