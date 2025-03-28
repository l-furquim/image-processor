package com.lucas.image_processor.service.image

import com.lucas.image_processor.dto.image.*
import org.springframework.web.multipart.MultipartFile

interface IImageService {

    fun create(data: ImageMetadataDto, file: MultipartFile): ImageAndMetadataDto
    fun delete(id: String)
    fun findByUserId(userId: String): List<ImageAndMetadataDto>
    fun transform(data: TransformImageDto): ImageAndMetadataDto
    fun changeFormat(data: ChangeImageFormatDto): ImageAndMetadataDto
    fun compressImage(data: CompressImageDto): ImageAndMetadataDto

}