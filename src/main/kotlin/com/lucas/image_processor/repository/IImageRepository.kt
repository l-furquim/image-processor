package com.lucas.image_processor.repository

import com.lucas.image_processor.model.Image
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface IImageRepository: MongoRepository<Image, String>{

    fun findByUserId(userId: String): Optional<Image>

}