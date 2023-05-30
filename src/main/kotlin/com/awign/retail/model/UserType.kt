package com.awign.retail.model

enum class UserType {

    /**
     * Employee user.
     */
    EMPLOYEE,

    /**
     * Affiliate user.
     */
    AFFILIATE,

    /**
     * User that has been customer for more than 2 years.
     */
    LOYAL,

    /**
     * UserType, to which no discount applies.
     */
    REGULAR
}