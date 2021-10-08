package com.itea.task2.dto

case class HealthDto(label: String, status: Boolean) {
  override def toString: String = s"""{ label: '$label', status: $status }"""
}
