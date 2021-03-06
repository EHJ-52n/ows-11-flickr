/**
 * ﻿Copyright (C) 2015 - 2015 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * license version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.flickr.model;

import org.n52.socialmedia.model.Location;

import com.flickr4java.flickr.places.Place;

/**
 * TODO implement flickr specifics
 * 
 * @author <a href="mailto:e.h.juerrens@52north.org">Eike Hinderk J&uuml;rrens</a>
 *
 */
public class FlickrLocation implements Location {
	
	private float longitude;
	private float latitude;
	private int accuracy;
	private Place place;

	public FlickrLocation(float longitude, float latitude, int accuracy, Place place) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.accuracy = accuracy;
		this.place = place;
	}

	@Override
	public Double getLatitude() {
		return (double) latitude;
	}

	@Override
	public Double getLongitude() {
		return (double) longitude;
	}
	
	public int getAccuracy() {
		return accuracy;
	}

	@Override
	public String getId() {
		if (place != null && place.getPlaceId() != null && !place.getPlaceId().isEmpty()) {
			return place.getPlaceId();
		}
		return String.format("%s_place-id-not-set",hashCode());
	}

	@Override
	public String getName() {
		if (place != null && place.getName() != null && !place.getName().isEmpty()) {
			return place.getName();
		}
		return "place-name-not-set";
	}

	@Override
	public String toString() {
		return new StringBuilder(350).append("FlickrLocation [latitude=").append(getLatitude())
				.append(", longitude=").append(getLongitude())
				.append(", accuracy=").append(getAccuracy())
				.append(", id=").append(getId())
				.append(", name=").append(getName()).append("]").toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accuracy;
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlickrLocation other = (FlickrLocation) obj;
		if (accuracy != other.accuracy)
			return false;
		if (Float.floatToIntBits(latitude) != Float
				.floatToIntBits(other.latitude))
			return false;
		if (Float.floatToIntBits(longitude) != Float
				.floatToIntBits(other.longitude))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}

	
	
}
