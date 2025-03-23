package com.lucas.image_processor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ImageProcessorApplication

fun main(args: Array<String>) {
	runApplication<ImageProcessorApplication>(*args)
}
