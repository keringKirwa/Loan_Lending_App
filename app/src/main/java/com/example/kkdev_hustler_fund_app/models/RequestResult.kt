package com.example.kkdev_hustler_fund_app.models

sealed class RequestResult<D,M>(val data: D? =null, val message: String ? =null) {

    class Success<D, M>(data: D?, message:String? =null) : RequestResult<D, M>(data, message)
    class Failure<D, M>(data: D?  = null, message:String? =null) : RequestResult<D, M>(data, message)
    class Loading<D, M>(data: D?, message:String? =null) : RequestResult<D, M>(data, message)


}

