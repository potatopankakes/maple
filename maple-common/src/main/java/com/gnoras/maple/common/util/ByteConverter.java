package com.gnoras.maple.common.util;

public class ByteConverter {
	
	/*
	public static byte[] Convert(Byte[] b1) {
		byte[] bf = new byte[b1.length];
		int i;
		for ( i=0; i<b1.length; i++ ) {
			bf[i] = b1[i];
		}
		return bf;
	}
	*/

	public static byte[] Join(byte[] salt, byte[] b2) {
		byte[] bf = new byte[salt.length + b2.length];
		int i;
		for ( i=0; i<salt.length; i++ ) {
			bf[i] = salt[i];
		}
		int j;
		for ( j=0; j<b2.length; j++,i++ ) {
			bf[i] = b2[j];
		}
		return bf;
	}

	public static byte[] Join(Byte[] b1, byte[] b2) {
		byte[] bf = new byte[b1.length + b2.length];
		int i;
		for ( i=0; i<b1.length; i++ ) {
			bf[i] = b1[i];
		}
		int j;
		for ( j=0; j<b2.length; j++,i++ ) {
			bf[i] = b2[j];
		}
		return bf;
	}

	public static byte[] Join(byte[] b1, Byte[] b2) {
		byte[] bf = new byte[b1.length + b2.length];
		int i;
		for ( i=0; i<b1.length; i++ ) {
			bf[i] = b1[i];
		}
		int j;
		for ( j=0; j<b2.length; j++,i++ ) {
			bf[i] = b2[j];
		}
		return bf;
	}

	public static byte[] Join(Byte[] b1, Byte[] b2) {
		byte[] bf = new byte[b1.length + b2.length];
		int i;
		for ( i=0; i<b1.length; i++ ) {
			bf[i] = b1[i];
		}
		int j;
		for ( j=0; j<b2.length; j++,i++ ) {
			bf[i] = b2[j];
		}
		return bf;
	}

	public static byte[] Join(Byte[] b1, Byte[] b2, Byte[] b3) {
		byte[] bf = new byte[b1.length + b2.length + b3.length];
		int i;
		for ( i=0; i<b1.length; i++ ) {
			bf[i] = b1[i];
		}
		int j;
		for ( j=0; j<b2.length; j++,i++ ) {
			bf[i] = b2[j];
		}
		for ( j=0; j<b3.length; j++,i++ ) {
			bf[i] = b3[j];
		}
		return bf;
	}

	public static byte[] Join(byte[] b1, byte[] b2, byte[] b3) {
		byte[] bf = new byte[b1.length + b2.length + b3.length];
		int i;
		for ( i=0; i<b1.length; i++ ) {
			bf[i] = b1[i];
		}
		int j;
		for ( j=0; j<b2.length; j++,i++ ) {
			bf[i] = b2[j];
		}
		for ( j=0; j<b3.length; j++,i++ ) {
			bf[i] = b3[j];
		}
		return bf;
	}

}
