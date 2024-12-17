package com.jdc.earthdistance.api.output;

import java.util.UUID;

public interface ShopDistance {
	UUID getId();
	String getName();
	Double getLat();
	Double getLon();
	Double getDistance();
}
