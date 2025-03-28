package com.lucas.image_processor.controller.image.impl

import com.lucas.image_processor.dto.image.ImageAndMetadataDto
import com.lucas.image_processor.dto.image.ImageMetadataDto
import com.lucas.image_processor.dto.image.SaveImageDto
import com.lucas.image_processor.service.image.IImageService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/images")
class ImageControllerImpl(
    private val imageService: IImageService
){

    @PostMapping(consumes = ["multipart/form-data"])
    fun create(
        @RequestPart("imageMetadata")metadata: ImageMetadataDto,
        @RequestPart("imageData") imageFile: MultipartFile
    ): ResponseEntity<ImageAndMetadataDto>{
        val image = imageService.create(metadata, imageFile)

        return ResponseEntity.status(201).body(image)
    }


}