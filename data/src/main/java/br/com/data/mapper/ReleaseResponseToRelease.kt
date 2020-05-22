package br.com.data.mapper

import br.com.data.model.ReleaseResponse
import br.com.domain.entity.Release
import br.com.infrastructure.net.Mapper

class ReleaseResponseToRelease : Mapper<ReleaseResponse, Release>() {

    override fun transform(item: ReleaseResponse?): Release {
        return Release(
            description = item?.description ?: "",
            bandName = item?.bandName ?: "",
            highlight = (item?.highlight ?: 0 > 0),
            thumbnail = item?.thumbnail ?: "",
            title = item?.title ?: "",
            videos = item?.videos ?: "",
            id = null
        )
    }

}