package org.animations.demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform