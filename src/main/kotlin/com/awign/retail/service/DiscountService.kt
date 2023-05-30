package com.awign.retail.service

import com.awign.retail.model.PaymentInfo
import com.awign.retail.model.DiscountInfo
import org.springframework.stereotype.Service
import com.awign.retail.model.DiscountType
import java.lang.Exception

@Service
class DiscountService(val mappingService: DiscountMappingService) {

	fun calculateDiscount(paymentInfo: PaymentInfo): DiscountInfo {
		checkForIllegalValues(paymentInfo)
		val discountType: DiscountType = checkDiscountType(paymentInfo)
		val amount: Double = paymentInfo.amount

		val percentageDiscount: Double = calculatePercentageDiscount(discountType);
		val voucherDiscount: Double = calculateAdditionalDiscount(amount);

		val discount = (percentageDiscount + voucherDiscount)
		val type  = discountType
		val totalBill  = amount
		return DiscountInfo(discount, totalBill, type)
	}

	fun checkDiscountType(paymentInfo: PaymentInfo): DiscountType {
		if (paymentInfo.containsGroceries) {
			return DiscountType.NONE
		}
		return mappingService.getDiscountByUserType(paymentInfo.userInfo.type)
	}

	fun calculatePercentageDiscount(discountType: DiscountType): Double {
		return mappingService.getFunctionByDiscount(discountType)
	}

	fun calculateAdditionalDiscount(amount: Double): Double {
		val vouchersCount: Double = Math.floor(amount / 100)
		return vouchersCount * 5
	}

	fun checkForIllegalValues(paymentInfo: PaymentInfo) {
		if (paymentInfo.userInfo != null) {
			throw Exception ("PaymentInfo is null or has null values")
		} else if (paymentInfo.amount < 0.0) {
			throw Exception ("Payment amount is null or is negative number")
		}
	}


}