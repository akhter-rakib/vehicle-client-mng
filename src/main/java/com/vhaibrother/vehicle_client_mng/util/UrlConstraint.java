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

    public static class RoleManagement {
        public static final String ROOT = VERSION + API + "/roles";
        public static final String DELETE = "/{roleId}";
        public static final String GET = "/{roleId}";
        public static final String PUT = "/{roleId}";
    }

    public static class DomainManagement {
        public static final String ROOT = VERSION + API + "/domains";
        public static final String DELETE = "/{domainId}";
        public static final String GET = "/{domainId}";
        public static final String PUT = "/{domainId}";
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

    public static class ProfessionManagement {
        public static final String ROOT = VERSION + API + "/professions";
        public static final String DELETE = "/{professionId}";
        public static final String GET = "/{professionId}";
        public static final String PUT = "/{professionId}";
    }

    public static class ClientManagement {
        public static final String ROOT = VERSION + API + "/clients";
        public static final String DELETE = "/{clientId}";
        public static final String GET = "/{clientId}";
        public static final String PUT = "/{clientId}";
    }

    public static class CarGradeManagement {
        public static final String ROOT = VERSION + API + "/carGrades";
        public static final String DELETE = "/{carGradeId}";
        public static final String GET = "/{carGradeId}";
        public static final String PUT = "/{carGradeId}";
    }

    public static class CarModelManagement {
        public static final String ROOT = VERSION + API + "/carModel";
        public static final String DELETE = "/{carModelId}";
        public static final String GET = "/{carModelId}";
        public static final String PUT = "/{carModelId}";
    }

    public static class CarCompanyManagement {
        public static final String ROOT = VERSION + API + "/carCompany";
        public static final String DELETE = "/{carCompanyId}";
        public static final String GET = "/{carCompanyId}";
        public static final String PUT = "/{carCompanyId}";
    }

    public static class CarStockManagement {
        public static final String ROOT = VERSION + API + "/carStock";
        public static final String DELETE = "/{carStockId}";
        public static final String GET = "/{carStockId}";
        public static final String PUT = "/{carStockId}";
        public static final String GETBYCARETYPE = ROOT + "/getBycarType/{carType}";
    }

    public static class MediaManagement {
        public static final String ROOT = VERSION + API + "/media";
        public static final String DELETE = "/{mediaId}";
        public static final String GET = "/{mediaId}";
        public static final String PUT = "/{mediaId}";
    }
}
