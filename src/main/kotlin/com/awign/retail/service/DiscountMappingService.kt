package com.awign.retail.service

import com.awign.retail.model.DiscountType
import com.awign.retail.model.UserType


class DiscountMappingService {
	
	
	val EMPLOYEE_PERCENTAGE: Double = 30.0 / 100;
	val AFFILIATE_PERCENTAGE : Double = 10.0 / 100;
	val LOYALTY_PERCENTAGE:  Double = 5.0 / 100;

    val userToDiscountMapping =  HashMap<UserType, DiscountType>()
	val discountToFunction =  HashMap<DiscountType,Double>()
  
    fun DiscountMappingServiceImpl() {
        initMaps();
    }

    /**
     * Get a DiscountType based on an UserType
     */
    fun  getDiscountByUserType(userType : UserType): DiscountType {
        return userToDiscountMapping.getOrDefault(userType, DiscountType.NONE);
    }

    /**
     * Get a Function instance, which calculates the discount based on the DiscountType
     */
    fun getFunctionByDiscount(discountType: DiscountType): Double {
        return discountToFunction.getOrDefault(discountType, 0.0);
    }

    fun initMaps() {
        userToDiscountMapping.put(UserType.EMPLOYEE, DiscountType.EMPLOYEE_DISCOUNT);
        userToDiscountMapping.put(UserType.AFFILIATE, DiscountType.AFFILIATE_DISCOUNT);
        userToDiscountMapping.put(UserType.LOYAL, DiscountType.LOYALTY_DISCOUNT);
        userToDiscountMapping.put(UserType.REGULAR, DiscountType.NONE);

        discountToFunction.put(DiscountType.EMPLOYEE_DISCOUNT, EMPLOYEE_PERCENTAGE);
        discountToFunction.put(DiscountType.AFFILIATE_DISCOUNT, AFFILIATE_PERCENTAGE);
        discountToFunction.put(DiscountType.LOYALTY_DISCOUNT, LOYALTY_PERCENTAGE);
        discountToFunction.put(DiscountType.NONE, 0.0);
    }
	
}