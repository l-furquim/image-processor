package com.lucas.image_processor.dto.image

import com.lucas.image_processor.model.Image
import org.springframework.web.multipart.MultipartFile

data class ImageAndMetadataDto(
    val image: Image
)
