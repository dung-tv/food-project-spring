package com.main.food.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permissions {
    USER_GET_ALL(Names.USER_GET_ALL), USER_GET_ONE(Names.USER_GET_ONE), USER_CREATE(Names.USER_CREATE), USER_UPDATE(Names.USER_UPDATE), USER_DELETE(Names.USER_DELETE),
    UROLE_GET_ALL(Names.UROLE_GET_ALL), UROLE_GET_ONE(Names.UROLE_GET_ONE), UROLE_CREATE(Names.UROLE_CREATE), UROLE_UPDATE(Names.UROLE_UPDATE), UROLE_DELETE(Names.UROLE_DELETE),
    PRIVILEGE_GET_ALL(Names.PRIVILEGE_GET_ALL), PRIVILEGE_GET_ONE(Names.PRIVILEGE_GET_ONE), PRIVILEGE_CREATE(Names.PRIVILEGE_CREATE), PRIVILEGE_UPDATE(Names.PRIVILEGE_UPDATE), PRIVILEGE_DELETE(Names.PRIVILEGE_DELETE),
    CATEGORY_GET_ALL(Names.CATEGORY_GET_ALL), CATEGORY_GET_ONE(Names.CATEGORY_GET_ONE), CATEGORY_CREATE(Names.CATEGORY_CREATE), CATEGORY_UPDATE(Names.CATEGORY_UPDATE), CATEGORY_DELETE(Names.CATEGORY_DELETE),
    INGREDIENT_GET_ALL(Names.INGREDIENT_GET_ALL), INGREDIENT_GET_ONE(Names.INGREDIENT_GET_ONE), INGREDIENT_CREATE(Names.INGREDIENT_CREATE), INGREDIENT_UPDATE(Names.INGREDIENT_UPDATE), INGREDIENT_DELETE(Names.INGREDIENT_DELETE),
    MENU_GET_ALL(Names.MENU_GET_ALL), MENU_GET_ONE(Names.MENU_GET_ONE), MENU_CREATE(Names.MENU_CREATE), MENU_UPDATE(Names.MENU_UPDATE), MENU_DELETE(Names.MENU_DELETE),
    ORDER_GET_ALL(Names.ORDER_GET_ALL), ORDER_GET_ONE(Names.ORDER_GET_ONE), ORDER_CREATE(Names.ORDER_CREATE), ORDER_UPDATE(Names.ORDER_UPDATE), ORDER_DELETE(Names.ORDER_DELETE),
    RESTAURANT_GET_ALL(Names.RESTAURANT_GET_ALL), RESTAURANT_GET_ONE(Names.RESTAURANT_GET_ONE), RESTAURANT_CREATE(Names.RESTAURANT_CREATE), RESTAURANT_UPDATE(Names.RESTAURANT_UPDATE), RESTAURANT_DELETE(Names.RESTAURANT_DELETE);

    private String privilege;

    public static class Names {
        public final static String USER_GET_ALL = "USER_GET_ALL";
        public final static String USER_GET_ONE = "USER_GET_ONE";
        public final static String USER_CREATE = "USER_CREATE";
        public final static String USER_UPDATE = "USER_UPDATE";
        public final static String USER_DELETE = "USER_DELETE";

        public final static String UROLE_GET_ALL = "UROLE_GET_ALL";
        public final static String UROLE_GET_ONE = "UROLE_GET_ONE";
        public final static String UROLE_CREATE = "UROLE_CREATE";
        public final static String UROLE_UPDATE = "UROLE_UPDATE";
        public final static String UROLE_DELETE = "UROLE_DELETE";

        public final static String PRIVILEGE_GET_ALL = "PRIVILEGE_GET_ALL";
        public final static String PRIVILEGE_GET_ONE = "PRIVILEGE_GET_ONE";
        public final static String PRIVILEGE_CREATE = "PRIVILEGE_CREATE";
        public final static String PRIVILEGE_UPDATE = "PRIVILEGE_UPDATE";
        public final static String PRIVILEGE_DELETE = "PRIVILEGE_DELETE";

        public final static String CATEGORY_GET_ALL = "CATEGORY_GET_ALL";
        public final static String CATEGORY_GET_ONE = "CATEGORY_GET_ONE";
        public final static String CATEGORY_CREATE = "CATEGORY_CREATE";
        public final static String CATEGORY_UPDATE = "CATEGORY_UPDATE";
        public final static String CATEGORY_DELETE = "CATEGORY_DELETE";

        public final static String INGREDIENT_GET_ALL = "INGREDIENT_GET_ALL";
        public final static String INGREDIENT_GET_ONE = "INGREDIENT_GET_ONE";
        public final static String INGREDIENT_CREATE = "INGREDIENT_CREATE";
        public final static String INGREDIENT_UPDATE = "INGREDIENT_UPDATE";
        public final static String INGREDIENT_DELETE = "INGREDIENT_DELETE";

        public final static String MENU_GET_ALL = "MENU_GET_ALL";
        public final static String MENU_GET_ONE = "MENU_GET_ONE";
        public final static String MENU_CREATE = "MENU_CREATE";
        public final static String MENU_UPDATE = "MENU_UPDATE";
        public final static String MENU_DELETE = "MENU_DELETE";

        public final static String ORDER_GET_ALL = "ORDER_GET_ALL";
        public final static String ORDER_GET_ONE = "ORDER_GET_ONE";
        public final static String ORDER_CREATE = "ORDER_CREATE";
        public final static String ORDER_UPDATE = "ORDER_UPDATE";
        public final static String ORDER_DELETE = "ORDER_DELETE";

        public final static String RESTAURANT_GET_ALL = "RESTAURANT_GET_ALL";
        public final static String RESTAURANT_GET_ONE = "RESTAURANT_GET_ONE";
        public final static String RESTAURANT_CREATE = "RESTAURANT_CREATE";
        public final static String RESTAURANT_UPDATE = "RESTAURANT_UPDATE";
        public final static String RESTAURANT_DELETE = "RESTAURANT_DELETE";
    }
}
