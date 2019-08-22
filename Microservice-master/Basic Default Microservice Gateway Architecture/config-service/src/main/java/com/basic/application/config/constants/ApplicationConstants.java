package com.basic.application.config.constants;

public class ApplicationConstants {

	public static class HttpResponseCode {
		/** Ok Response */
		public final static Integer OK = 200;

		/** BAD_REQUEST Response */
		public final static Integer BAD_REQUEST = 400;

		/** UNAUTHORIZED Response */
		public final static Integer UNAUTHORIZED = 401;

		/** PAYMENT_REQUIRED Response */
		public final static Integer PAYMENT_REQUIRED = 402;

		/** FORBIDDEN Response */
		public final static Integer FORBIDDEN = 403;

		/** NOT_FOUND Response */
		public final static Integer NOT_FOUND = 404;

		/** METHOD_NOT_ALLOWED Response */
		public final static Integer METHOD_NOT_ALLOWED = 405;

		/** REQUEST_TIMEOUT Response */
		public final static Integer REQUEST_TIMEOUT = 408;

		/** CONFLICT Response */
		public final static Integer CONFLICT = 409;

		/** INTERNAL_SERVER_ERROR Response */
		public final static Integer INTERNAL_SERVER_ERROR = 500;

		/** BAD_GATEWAY Response */
		public final static Integer BAD_GATEWAY = 502;

		/** SERVICE_UNAVAILABLE Response */
		public final static Integer SERVICE_UNAVAILABLE = 503;

		/** GATEWAY_TIMEOUT Response */
		public final static Integer GATEWAY_TIMEOUT = 504;
	}

	public static class HttpMessage {

		public static final String SUCCESS = "SUCCESS";

		public static final String FAILURE = "FAILURE";

	}

	public static class ApplicationErrorCode {

		public static final Integer USER_DOES_NOT_EXIST = 10;

		public static final Integer USER_NOT_CREATED = 11;

		public static final Integer DATABASE_ERROR = 12;

		public static final Integer DATABASE_CONSTRAINT_CONFLICT = 13;

		public static final Integer DATABASE_CONNECTION_FAILED = 14;

		public static final Integer FOREIGN_SERVICE_FAILED = 15;

		public static final Integer IMPROPER_REQUEST = 16;

		public static final Integer SERVER_CALCULATION_ISSUE = null;

		public static final Integer DATABASE_DUPLICATE_KEY = 17;

		public static final Integer DATABASE_TIMEOUT = 18;

		public static final Integer DATABASE_ENTITY_DOES_NOT_EXIST = 19;

	}

	public static class ParsedRequestData {

		public static final String FEIGN_CLIENT_PROXY = "proxy";

		public static final String SUB_URL = "subUrl";
		
		public static final String SERVICE_TYPE = "serviceType";

		public static final String HEADER = "Authorization";
		
		public static final String ACTION_TYPE = "actionType";

		public static class SubUrl {

			public static final String LOGIN = "login";

			public static final String CREATE_AUTHENTICATION = "createAuthentication";

			public static final String EMPLOYEE = "employee";

			public static final String COUNTRY = "country";

			public static final String CITY = "city";

			public static final String STATE = "state";

			public static final String NATIONALITY = "nationality";

		}
		
		public static class SubUrlType {
			
			public static final String AUTHENTICATION = "authentication";
			
			public static final String COMMON = "common";
			
			public static final String EMPLOYEE = "employee";
		}

		public static class RequestParams {

			public static final String USERNAME = "username";

			public static final String PASSWORD = "password";
			
			public static final String OBJECT = "object";

			public static final String AUTHORIZATION_HEADER = "header";

		}

		public static class Action {

			public static final String GET = "get";

			public static final String GET_ALL = "getAll";

			public static final String SAVE_OR_UPDATE = "saveOrUpdate";

			public static final String REMOVE = "remove";

		}
	}
}
