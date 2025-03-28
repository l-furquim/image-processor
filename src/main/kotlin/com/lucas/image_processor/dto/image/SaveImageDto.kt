package com.lucas.image_processor.dto.image

import org.springframework.web.multipart.MultipartFile
import java.util.*

data class SaveImageDto(
    val imageData: MultipartFile,
    val width: Int,
    val height: Int,
    val format: String,
    val userId: String,
    val name: String,
    val id: String = UUID.randomUUID().toString()
)
