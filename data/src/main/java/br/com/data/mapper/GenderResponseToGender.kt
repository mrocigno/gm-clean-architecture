package br.com.data.mapper

import br.com.data.model.GenderResponse
import br.com.domain.entity.Gender
import br.com.infrastructure.net.Mapper

class GenderResponseToGender : Mapper<GenderResponse, Gender>() {

    override fun transform(item: GenderResponse?): Gender {
        return Gender(
            id = item?.id ?: -1,
            gender = item?.gender ?: "",
            slug = item?.slug ?: ""
        )
    }

}