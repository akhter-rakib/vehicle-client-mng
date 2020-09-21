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
    public static class ProfessionManagement{
        public static final String ROOT =  API + VERSION + "/professions";
        public static final String DELETE = "/{professionId}";
        public static final String GET = "/{professionId}";
        public static final String PUT = "/{professionId}";
    }
    public static class ClientManagement{
        public static final String ROOT = API + VERSION + "/clients";
        public static final String DELETE = "/{clientId}";
        public static final String GET = "/{clientId}";
        public static final String PUT = "/{clientId}";
    }
    public static class CarGradeManagement{
        public static final String ROOT = API + VERSION + "/carGrades";
        public static final String DELETE = "/{carGradeId}";
        public static final String GET = "/{carGradeId}";
        public static final String PUT = "/{carGradeId}";
    }

}
