package com.awign.retail.model

data class PaymentInfo(var containsGroceries: Boolean, var userInfo: UserInfo, var amount: Double, var otherData: Any)