package com.lucas.image_processor.model

import com.lucas.image_processor.dto.image.ImageMetadataDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.io.File

@Document(collection = "images")
data class Image (

    @Id
    val id: String,
    val userId: String,
    val width: Int,
    val height: Int,
    val path: String,
    val format: String,
    ){
        constructor(data: ImageMetadataDto, id: String): this(
            id = id,
            userId = data.userId,
            width = data.width,
            height = data.height,
            format = data.format,
            path = id + File.pathSeparator + data.name
        )

    }


