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
    public static class ProfessionManagement{
        public static final String ROOT = VERSION + API + "/professions";
        public static final String DELETE = "/{professionId}";
        public static final String GET = "/{professionId}";
        public static final String PUT = "/{professionId}";
    }
    public static class ClientManagement{
        public static final String ROOT = VERSION + API + "/clients";
        public static final String DELETE = "/{clientId}";
        public static final String GET = "/{clientId}";
        public static final String PUT = "/{clientId}";
    }

}
