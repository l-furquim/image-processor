package com.lucas.image_processor.dto.image

data class CropDto(
    val width: Int,
    val height: Int,
    val x: Int,
    val y: Int
)
