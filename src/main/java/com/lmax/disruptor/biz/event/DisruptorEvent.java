/*
 * Copyright (c) 2010-2020, vindell (https://github.com/vindell).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.lmax.disruptor.biz.event;

import java.util.EventObject;

@SuppressWarnings("serial")
public abstract class DisruptorEvent extends EventObject {

	/** System time when the event happened */
	private final long timestamp;
	/** Route Expression*/
	private String routeExpression;
	
	/**
	 * Create a new ConsumeEvent.
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public DisruptorEvent(Object source) {
		super(source);
		this.timestamp = System.currentTimeMillis();
	}

	/**
	 * Return the system time in milliseconds when the event happened.
	 */
	public final long getTimestamp() {
		return this.timestamp;
	}

	public String getRouteExpression() {
		return routeExpression;
	}

	public void setRouteExpression(String routeExpression) {
		this.routeExpression = routeExpression;
	}
	
}
