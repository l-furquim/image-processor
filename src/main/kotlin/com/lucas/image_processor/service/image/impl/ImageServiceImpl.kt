package com.lucas.image_processor.service.image.impl

import com.lucas.image_processor.dto.image.*
import com.lucas.image_processor.model.Image
import com.lucas.image_processor.repository.IImageRepository
import com.lucas.image_processor.service.image.IImageService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.PutObjectRequest
import kotlinx.coroutines.*
import org.springframework.web.multipart.MultipartFile
import java.util.*


@Service
class ImageServiceImpl(
    private val s3Client: S3Client,
    private val imageRepository: IImageRepository,
    @Value("\${aws.bucket.name}") private val BUCKET: String
): IImageService {



    override fun create(data: ImageMetadataDto, file: MultipartFile): ImageAndMetadataDto {
        val image = Image(
            data = data,
            UUID.randomUUID().toString()
        )
        val imageEntity = imageRepository.save(image)

        uploadImageToBucket(file, imageEntity.path)

        return ImageAndMetadataDto(
            imageEntity,
            file
        )
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override fun findByUserId(userId: String): List<ImageAndMetadataDto> {
        TODO("Not yet implemented")
    }

    override fun transform(data: TransformImageDto): ImageAndMetadataDto {
        TODO("Not yet implemented")
    }

    override fun changeFormat(data: ChangeImageFormatDto): ImageAndMetadataDto {
        TODO("Not yet implemented")
    }

    override fun compressImage(data: CompressImageDto): ImageAndMetadataDto {
        TODO("Not yet implemented")
    }

    private fun uploadImageToBucket(file: MultipartFile, path: String) = runBlocking{
        launch {
            val imageBytes = file.bytes

            val put: PutObjectRequest = PutObjectRequest.builder()
                .bucket(BUCKET)
                .key(path)
                .build()

            s3Client.putObject(
                put,
                RequestBody.fromBytes(
                    imageBytes
                )
            )
        }
    }
}