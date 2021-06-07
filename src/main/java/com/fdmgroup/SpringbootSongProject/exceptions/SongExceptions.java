package com.fdmgroup.SpringbootSongProject.exceptions;

/**
 * Exception class which throws exception when no song is found
 * 
 * @author Charmi Patel
 *
 */
public class SongExceptions extends RuntimeException {

	private static final long serialVersionUID = 7718828512143293558L;

	public SongExceptions() {
		super();
	}

	public SongExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SongExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public SongExceptions(String message) {
		super(message);
	}

	public SongExceptions(Throwable cause) {
		super(cause);
	}

}
