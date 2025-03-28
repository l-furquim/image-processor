package com.lucas.image_processor.dto.image

data class ImageMetadataDto(
    val width: Int,
    val height: Int,
    val format: String,
    val userId: String,
    val name: String,
)