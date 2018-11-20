package com.weather.data;

/**
 * Day night distinction
 * 
 * @author burhanc
 *
 */
public enum DN {
	DAY {
		@Override
		public String toString() {
			return DNConstants.DAY;
		}
	},
	NIGHT {
		@Override
		public String toString() {
			return DNConstants.NIGHT;
		}
	}
}
