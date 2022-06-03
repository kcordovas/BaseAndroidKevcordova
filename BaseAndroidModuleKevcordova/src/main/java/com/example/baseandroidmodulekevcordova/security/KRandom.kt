package com.example.baseandroidmodulekevcordova.security

import java.security.SecureRandom
import java.util.*
import kotlin.random.Random

object KRandom {
    private val random by lazy {
        Random.Default
    }

    private val secureRandom by lazy {
        SecureRandom()
    }

    fun double(from: Double, until: Double) = random.nextDouble(from, until)

    fun double(until: Double) = random.nextDouble(until)

    fun double() = random.nextDouble()

    fun int(from: Int, until: Int) = random.nextInt(from, until)

    fun int(until: Int) = random.nextInt(until)

    fun int() = random.nextInt()
    
    fun long(from: Long, until: Long) = random.nextLong(from, until)

    fun long(until: Long) = random.nextLong(until)

    fun long() = random.nextLong()
    
    fun bits(size: Int) = random.nextBits(size)    
    
    fun boolean() = random.nextBoolean()

    fun floatBetweenOneAndZero() = random.nextFloat()
    
    fun bytes(size: Int) = random.nextBytes(size)

    fun bytes(byteArray: ByteArray) = random.nextBytes(byteArray)

    fun bytes(byteArray: ByteArray, fromIndex: Int, untilIndex: Int = byteArray.size) = random.nextBytes(byteArray, fromIndex, untilIndex)

    fun randUuid() = UUID.randomUUID().toString()

    fun secureInt() = secureRandom.nextInt()
    fun secureInt(bound: Int) = secureRandom.nextInt(bound)
    fun secureDouble() = secureRandom.nextDouble()
    fun secureBoolean() = secureRandom.nextBoolean()
    fun secureFloat() = secureRandom.nextFloat()
    fun secureDoubleGaussian() = secureRandom.nextGaussian()
    fun secureLong() = secureRandom.nextLong()
    fun secureByteArray(byteArray: ByteArray) = secureRandom.nextBytes(byteArray)
    fun generateSeed(numBytes: Int) = secureRandom.generateSeed(numBytes)
}