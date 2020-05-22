package br.com.infrastructure.base

import br.com.infrastructure.net.*
import retrofit2.Response
import java.net.SocketTimeoutException

abstract class AbstractDataSource {

    protected suspend fun <I, O> getResult(mapper: Mapper<I, O>, run: suspend () -> Response<I>) : ApiResult<O> {
        return try{
            run().converter(mapper)
        } catch (e: Exception) {
            when (e){
                is SocketTimeoutException -> {
                    ApiResultError(RequestError(500, "Timeout"))
                }
                else -> {
                    e.printStackTrace()
                    ApiResultError(RequestError(500, "error"))
                }
            }

        }
    }

}