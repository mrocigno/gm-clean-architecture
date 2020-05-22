package br.com.data.mapper

import br.com.data.model.BandResponse
import br.com.domain.entity.Band
import br.com.infrastructure.net.Mapper

class BandResponseToBand : Mapper<BandResponse, Band>() {

    override fun transform(item: BandResponse?): Band {
        return Band(
            name = item?.name ?: "",
            banner = item?.banner ?: "",
            genderId = item?.genderId ?: -1,
            id = item?.id ?: -1,
            logo = item?.logo ?: "",
            shows = item?.shows ?: -1,
            views = item?.views ?: -1L
        )
    }

}