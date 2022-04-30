package com.fiap.brq.exceptions;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDefault {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
    private Instant timestamp;

    private Integer status;
    private String error;
    private String message;
    private String path;

    public ErrorDefault() {
    }

    public ErrorDefault(Instant timestamp, Integer status, String error, String message, String path) {
	super();
	this.timestamp = timestamp;
	this.status = status;
	this.error = error;
	this.message = message;
	this.path = path;
    }

    public String getError() {
	return error;
    }

    public String getMessage() {
	return message;
    }

    public String getPath() {
	return path;
    }

    public Integer getStatus() {
	return status;
    }

    public Instant getTimestamp() {
	return timestamp;
    }

    public void setError(String error) {
	this.error = error;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public void setPath(String path) {
	this.path = path;
    }

    public void setStatus(Integer status) {
	this.status = status;
    }

    public void setTimestamp(Instant timestamp) {
	this.timestamp = timestamp;
    }
}
