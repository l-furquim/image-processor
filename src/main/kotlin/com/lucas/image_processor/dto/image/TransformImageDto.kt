package com.lucas.image_processor.dto.image

data class TransformImageDto(
    val id: String,
    val resizeData: ResizeDto,
    val cropData: CropDto,
    val rotate: Int
)
